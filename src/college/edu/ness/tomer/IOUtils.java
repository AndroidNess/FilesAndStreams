package college.edu.ness.tomer;

import java.io.*;

public class IOUtils {

    public static void writeToFile(String contentToWriteToFile, String path){
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(path,true);
            outputStream.write(contentToWriteToFile.getBytes());
            outputStream.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
         close(outputStream);
        }
    }


    public static String readFromFile(String path){
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = null;
        try {
            String lineSep = "\n";
             reader =
                    new BufferedReader(new FileReader(path));
            String line;
            while ((line = reader.readLine())!= null){
                builder.append(line).append(lineSep);
            }
            return builder.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            close(reader);
        }

        return null;
    }

    private static void close(Closeable c){
        try {
            if (c!=null)
                c.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
