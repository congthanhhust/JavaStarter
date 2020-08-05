import java.io.FileInputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tuantu extends Thread {
    long start = System.currentTimeMillis();
    long end =System.currentTimeMillis();
    long elapsedTime= end-start;

    @Override
    public void run() {

        FileInputStream fis=null;
        try {
            fis=new FileInputStream("D:\\student.dat");
            int ch;
            while((ch=fis.read())!= -1) {
                System.out.print((char) ch);

            }
        } catch (Exception e) {
        }finally {
            try {
                if(fis != null)
                    fis.close();
            } catch (Exception e2) {
            }
        }
    }

    public class display  extends Thread{
        public void displayTime() {
            System.out.println(elapsedTime);
        }
    }
}