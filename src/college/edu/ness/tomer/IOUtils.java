package college.edu.ness.tomer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

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
          if (outputStream!=null)
              try {
                  outputStream.close();
              } catch (IOException e) {
                  e.printStackTrace();
              }
        }
    }
}
