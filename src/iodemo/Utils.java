package iodemo;

import java.io.*;

public class Utils {
    private static Utils instance;

    private Utils(){};

    public static Utils getInstance() {
        if(instance == null)
            instance = new Utils();
        return instance;
    }

    public String readFromFile(String fileName) throws IOException {
        File file = new File(fileName);
        if(!file.exists()) return null;
        FileReader fin = new FileReader(file);
        BufferedReader in = new BufferedReader(fin);
        StringBuilder stringBuffer = new StringBuilder();
        String str = null;
        while ((str = in.readLine()) != null) {
            stringBuffer.append(str);
        }
        return stringBuffer.toString();
    }

    public void writeToFile(String fileName, String value) throws IOException {
        File file = new File(fileName);
        if(!file.exists()) {
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(fileName);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(value);
    }
}
