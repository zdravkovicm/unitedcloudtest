package main.java.Utils;

import java.time.LocalDateTime;

public class DateUtils {

    /**
     * Get Current Year
     *
     * @return text value of year
     */
    public String getYear(){
        LocalDateTime now = LocalDateTime.now();
        return String.valueOf(now.getYear());
    }

    /**
     * Get Current Year
     *
     * @return int value of year
     */
    public int getCurrentYear(){
        return Integer.parseInt(getYear());
    }

    /**
     * Get Current Year
     *
     * @return int value of year
     */
    public String correctYear(){

        return String.valueOf(getCurrentYear()-18);
    }
}
