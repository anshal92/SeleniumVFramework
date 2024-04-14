package org.ansh.utils;


import org.ansh.enums.RunType;
import org.tinylog.Logger;

import java.io.*;
import java.util.Optional;
import java.util.Properties;

public class BaseFileHelper {


    public static boolean writeStringToFile(String data, boolean isCSV){
        String fileNameToPass = isCSV ? "output.csv" : "output.txt";
        data = isCSV ? data.substring(1, data.length()-1) : data;
        File file = new File(fileNameToPass);
        FileWriter fileWriter ;
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
             fileWriter = new FileWriter(file);
             fileWriter.write(data);
             fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return file.exists();

    }


    //ToDo: Text reader -> Json Reader -> Type reader
    public static String getFileInputAsString(String fileName) throws Exception {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = Optional.ofNullable(classLoader.getResourceAsStream(fileName)).orElseThrow(Exception::new);
        return readFromInputStream(inputStream);
    }



    public static Properties getDataAsProperties(RunType runType) {
        Properties proprs = new Properties();
        String toRunType = runType.getResourceToPick();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        InputStream resource = classLoader.getResourceAsStream(toRunType);

        try {
            proprs.load(resource);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Logger.debug("System properties are ->"+ proprs);
        return proprs;
    }

    public static void setSystemProperty(Properties props){
        props.forEach((k,v) -> System.setProperty(k.toString(),v.toString()));
    }

    private static String readFromInputStream(InputStream inputStream) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line).append(", ");
        }
        return stringBuilder.toString();

    }

}
