import jdk.jshell.execution.Util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class MainApp {

    private static AtomicInteger readFileComplete = new AtomicInteger();
    private static final int NUMBER_FILE = 100;
    private static final boolean USING_THREAD = false;

    public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();
        Tuantu t1 = new Tuantu();
        t1.start();
        t1.join();
        long elapsedTime = System.currentTimeMillis() - start;


        /* Create example files */

        StringBuilder stringBuilder = new StringBuilder();
        for (int idx = 1; idx <= NUMBER_FILE; idx++){
            for(int i = 0; i < 10000; i++)
                stringBuilder.append("A B C D E F G H ");
            Ultis.getInstance().writeToFile("data" + idx + ".txt", stringBuilder.toString());
        }


        /* Read files */
        readFileComplete.set(0);

        for(int i = 1; i <= NUMBER_FILE; i++){
            final String fileName = "data" + i + ".txt";
            if(USING_THREAD){
                new Thread(() -> readFromFile(fileName)).start();
            } else {
                readFromFile(fileName);
            }
        }

        while (readFileComplete.get() < NUMBER_FILE && USING_THREAD){
            Thread.sleep(5);
        }

        long end = System.currentTimeMillis();
        long elapsedTime = end - start;
        System.out.println("Read files with " + elapsedTime + "ms");
    }

    static void readFromFile(String fileName){
        String value = Ultis.getInstance().readFromFile(fileName);
        /* Heavy task*/
//        ArrayList<String> arrayList = new ArrayList<>();
//        for (String str : value.split(" ")){
//            arrayList.add(str);
//        }

        /* Marked completed */
        readFileComplete.getAndIncrement();
    };
}
