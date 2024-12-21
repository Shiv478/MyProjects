import java.util.*;
public class ClockTime {
    private int hour;
    private int minute;
    private String amPm;

    // Constructs a new time for
    // the given hour/minute
    public ClockTime(int h, int m, String ap) {
        this.hour = h;
        this.minute = m;
        this.amPm = ap;
    }

    // returns the field values
    public int getHour() {
        return  hour;
    }

    public int getMinute() {
        return minute;
    }

    public String getAmPm() {
        return amPm;
    }

    // returns String for time;
    // example: "6:27 PM"
    public String toString() {
        String timeString = hour + ":";
        if (minute < 10) {
            timeString += "0";
        }
        return timeString + minute + " " + amPm;
    }


    /* TODO */
    // implement the advance() method below
    public void advance(int minutes){
        int advanceMinute  = minutes % 60;
        int hourAdvanceMent = minutes / 60;
        if((this.minute + advanceMinute) > 59){
            hourAdvanceMent += 1;
            this.minute  = (this.minute + advanceMinute) % 60;
        }else{
            this.minute += advanceMinute;
        }
        if(hourAdvanceMent >= 24){
            hourAdvanceMent = hourAdvanceMent%24;
        }if((this.hour + hourAdvanceMent) > 23){
            this.hour = (this.hour + hourAdvanceMent) % 24;
            return;
        }else{
            this.hour += hourAdvanceMent;
        }

        if(this.hour > 12){
            this.hour = this.hour - 12;
            if(this.amPm.equals("AM")){
                this.amPm = "PM";
            }else{
                this.amPm = "AM";
            }
        }else{
            this.amPm = getAmPm();
        }

    }



    public static void main(String[] args) {
        ClockTime time = new ClockTime(6, 27, "PM"); // 6:27 PM
        System.out.println(time);
        time.advance(1); // 6:28 PM
        System.out.println(time);
        time.advance(30); // 6:58 PM
        System.out.println(time);
        time.advance(5); // 7:03 PM
        System.out.println(time);
        time.advance(60); // 8:03 PM
        System.out.println(time);
        time.advance(128); // 10:11 PM
        System.out.println(time);
        time.advance(180); // 1:11 AM
        System.out.println(time);
        time.advance(1440); // 1:11 AM (1 day later)
        System.out.println(time);
        time.advance(21075); // 4:26 PM (2 weeks later)
        System.out.println(time);
    }

}

