package college.edu.ness.tomer;

import java.io.File;

public class Main {

    public static void main(String[] args) {
	IOUtils.writeToFile("Hello, World!\n", "1.txt");
        File f = new File("C:\\AndroidD\\demos\\d1");
        if (f.mkdirs())
            System.out.println("Did it!");
    }
}
