package random;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Anubhav {
    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
    }
}
