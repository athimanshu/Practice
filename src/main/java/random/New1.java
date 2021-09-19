package random;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

public class New1 {
    public static void main(String[] args) {
        //{"roll":"OFF_ROLL","category":"Cable and Broadband"}
        String rule = "{\"roll\":\"OFF_ROLL\",\"category\":\"Cable and Broadband\"}";

        HashMap<String,String> map = new Gson().fromJson(rule, new TypeToken<HashMap<String, String>>(){}.getType());
        for(Map.Entry<String, String> enry: map.entrySet()){
            System.out.println(enry.getKey() + ": " + enry.getValue());
        }



//        Timestamp time = new Timestamp(new Date().getTime());
//        Date date = new Date(time.getTime());
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(date);
//        System.out.println(cal);
//        System.out.println(cal.get(3));
//        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)+1);
//        System.out.println(new SimpleDateFormat("MMM").format(cal.getTime()));

    }
}
