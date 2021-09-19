package random.java.serialization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FlattenTime {
    public static void main(String[] args) {

        String fileName = "persistantTime.ser";

        try {
            FileOutputStream fos= new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            PersistantTime persistantTime = new PersistantTime();
            oos.writeObject(persistantTime);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
