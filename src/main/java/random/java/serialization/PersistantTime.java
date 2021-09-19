package random.java.serialization;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class PersistantTime implements Serializable {
    private Date time;

    PersistantTime(){
        time = Calendar.getInstance().getTime();
    }

    public Date getTime() {
        return time;
    }
}
