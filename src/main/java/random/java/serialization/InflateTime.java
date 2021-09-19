package random.java.serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Calendar;

public class InflateTime {
    public static void main(String[] args) {
        FileInputStream fis = null;
        PersistantTime persistantTime = null;
        ObjectInputStream ois = null;
        String fileName = "persistantTime.ser";
        try{
            fis = new FileInputStream(fileName);
            ois = new ObjectInputStream(fis);
            persistantTime = (PersistantTime) ois.readObject();
            ois.close();
            fis.close();
        }catch (IOException e){

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Inflated Time: "+persistantTime.getTime());
        System.out.println("Current Time: "+ Calendar.getInstance().getTime());

    }
}
