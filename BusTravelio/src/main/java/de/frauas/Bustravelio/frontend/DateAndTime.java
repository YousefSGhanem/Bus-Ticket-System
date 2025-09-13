/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.frauas.Bustravelio.frontend;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author haith
 */
public class DateAndTime {

    //public static String date, time;
    public String getDate(){
        Date currentDate = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy.MM.dd");
        String date = dateFormat. format(currentDate);
        return date;
    }
    
    public String getTime(){
        Date currentTime = new Date();
        SimpleDateFormat timeFormat= new SimpleDateFormat("kk:mm:ss");  //in 24 kk and in 12 hh 
        String time = timeFormat. format(currentTime);
        return time;
    }
}
