package iodemo;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class TestDemoIO {
    private static AtomicInteger numTaskCompleted = new AtomicInteger();
    private static final int NUMBER_FILE = 100;
    private static final boolean USING_THREAD = true;

    public static void runTest(){
        /* Create example files */
        createFiles();

        /* Read files */
        testReadMultiFiles(USING_THREAD);
    }

    private static void createFiles(){
        /* Create sample data */
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < 10000; i++){
            stringBuilder.append("A B C D E F G H ");
        }

        /* Create files */
        for (int idx = 1; idx <= NUMBER_FILE; idx++){
            try {
                Utils.getInstance().writeToFile("assets/data" + idx + ".txt", stringBuilder.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void testReadMultiFiles(boolean isMultiThread){
        long start = System.currentTimeMillis();
        numTaskCompleted.set(0);
        for(int i = 1; i <= NUMBER_FILE; i++){
            final String fileName = "data" + i + ".txt";
            if(isMultiThread){
                new Thread(() -> readFromFile(fileName)).start();
            } else {
                readFromFile(fileName);
            }
        }

        while (numTaskCompleted.get() < NUMBER_FILE && isMultiThread){
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long elapsedTime = System.currentTimeMillis() - start;
        System.out.println("Read files with " + elapsedTime + "ms");
    }

    static void readFromFile(String fileName){
        try {
            String value = Utils.getInstance().readFromFile(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        /* Heavy task*/
//        ArrayList<String> arrayList = new ArrayList<>();
//        for (String str : value.split(" ")){
//            arrayList.add(str);
//        }

        /* Marked completed */
        numTaskCompleted.getAndIncrement();
    };
}
