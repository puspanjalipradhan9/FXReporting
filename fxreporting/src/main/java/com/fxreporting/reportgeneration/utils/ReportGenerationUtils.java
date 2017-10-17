package com.fxreporting.reportgeneration.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ReportGenerationUtils {
    
    static DateFormat FORMATTER = new SimpleDateFormat("MM/dd/yyyy");
    static Date CURRENT_DATE = new Date();
    
    static Calendar CURRENT_DATE_CALENDAR = Calendar.getInstance();
    
    static {
        CURRENT_DATE_CALENDAR.setTime(CURRENT_DATE);
    }
    
    private ReportGenerationUtils(){
    }
    
    public static Date convertStringToDate(String inputDate){
        Date date = null;
        try{
            date = FORMATTER.parse(inputDate);
        }catch(Exception e){
            //Loggers can be added here
            System.out.println("Caught Exception while parsing Date");
        }
        return date;
    }
    
    public static boolean isDateCurrent(Date date){
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        
        
        calendar.setTime(date);
        
        if(calendar.get(Calendar.MONTH)==CURRENT_DATE_CALENDAR.get(CURRENT_DATE_CALENDAR.MONTH)
                || calendar.get(Calendar.DAY_OF_MONTH)==CURRENT_DATE_CALENDAR.get(CURRENT_DATE_CALENDAR.DAY_OF_MONTH)
                || calendar.get(Calendar.YEAR)==CURRENT_DATE_CALENDAR.get(CURRENT_DATE_CALENDAR.YEAR)){
            return true;
        }
        
        return false;
    }
    public static boolean isWeekend(Date date,String currency){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        
        if("AED".equals(currency) || "SAR".equals(currency)){
            if(dayOfWeek==Calendar.FRIDAY || dayOfWeek==Calendar.SATURDAY){
                return true;
            }
        }else{
            if(dayOfWeek==Calendar.SUNDAY || dayOfWeek==Calendar.SATURDAY){
                return true;
            }
        }
        return false;
    }
}
