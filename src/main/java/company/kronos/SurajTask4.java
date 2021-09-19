package company.kronos;

import java.util.Date;

class TimeConflict {
    long startTime;
    long endTime;
     TimeConflict(Date startTime, Date endTime){
        this.startTime = startTime.getTime();
        this.endTime = endTime.getTime();
     }
     public  boolean isConflicting(Date startTime, Date endTime){
         if ((startTime.getTime() > this.startTime && startTime.getTime()<this.endTime)
         || (endTime.getTime() < this.endTime && endTime.getTime()> this.startTime) ){
             return true;
         }
         return false;
     }

    public static void main(String[] args) {
         Date startTime = new Date(2021, 5, 7,8,30);
        Date endTime = new Date(2021, 5, 7,11,30);
        TimeConflict timeConflict = new TimeConflict(startTime,endTime);
        Date testStartTime = new Date(2021, 5, 7,11,00);
        Date testEndTime = new Date(2021, 5, 7,11,50);
        System.out.println(timeConflict.isConflicting(testStartTime,testEndTime));
    }
}


