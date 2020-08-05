import java.io.*;

public class Ultis {
    private static Ultis instance;

    private Ultis(){};

    public static Ultis getInstance() {
        if(instance == null)
            instance = new Ultis();
        return instance;
    }

    public String readFromFile(String fileName){
        StringBuilder stringBuffer = new StringBuilder();
        FileReader fin = null;
        try {
            fin = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader in = new BufferedReader(fin);
        String str = null;
        while (true) {
            try {
                if (!((str = in.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            stringBuffer.append(str);
        }
        return stringBuffer.toString();
    }

    public void writeToFile(String fileName, String value){
        File file = new File(fileName);
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        try {
            bufferedWriter.write(value);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
