package college.edu.ness.tomer;

import java.io.*;

public class IOUtils {

    /**
     * Write A String @contentToWriteToFile to A File given a Path
     * @param contentToWriteToFile The Content to write to the file
     * @param path The Path of the file to write to.
     */
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

    /**
     * Read from a file at a given @path And return A String.
     * @param path the path of the file to be read
     * @return A String representation of the data from the file
     */
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

    public static String read(InputStream in){
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = null;
        try {
            String lineSep = "\n";
            reader =
                    new BufferedReader(new InputStreamReader(in));
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

    /**
     * Copy a file from the source to the destination
     * @param from
     * @param to
     */
    public static void copy(String from, String to){
        FileInputStream fin = null;
        FileOutputStream fout = null;
        try {
            fin =  new FileInputStream(from);
            fout = new FileOutputStream(to);
            byte[] buffer = new byte[8192];

            int length = 0;


            while ((length =  fin.read(buffer)) > 0){
                fout.write(buffer);
            }
            fout.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
        close(fin, fout);
        }
    }

    /**
     * Close all the closable objects in one place
     * @param c The Closable to close
     */
    private static void close(Closeable... c){
        try {
            if (c!=null)
                for (Closeable closeable : c) {
                    closeable.close();
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
