/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calender;

/**
 *
 * @author sarka
 */
public class Calender {

    private int day;
    private int month;
    private int year;
    private int[] daysM = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; //array of days in each month
    private int pageM;
    private int pageY;

    //constructor
    public Calender(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
        if (isLeap(year)) {
            daysM[1] = 29;
        }
        pageM=month;
        pageY=year;
    }

    //nonstatic
    public void pageMonthSet(int direction){
        if(direction>0){
            pageM++;
        }
        if (direction<0){
            pageM--;
        }
        if (pageM>12){
            pageM-=12;
            pageY++;
        }
        if (pageM<1){
            pageM+=12;
            pageY--;
        }
    }

    public String showCalender() {
        StringBuilder sb = new StringBuilder();
        sb.append(System.getProperty("line.separator"));
        sb.append(String.format("%s %d", monthText(pageM),pageY));
        sb.append(System.getProperty("line.separator"));
        sb.append(System.getProperty("line.separator"));
        int fDay=gimmeDayZeller(1,pageM,pageY);
        for (int i = 1; i < fDay; i++) {
            sb.append(String.format("%4s"," "));
        }
        int date=1;
        for (int i = fDay; i<8; i++) {
            sb.append(String.format("%4d",date));
            date++;
        }
        sb.append(System.getProperty("line.separator"));
        int firstSunday=date-1;
        for (int i = firstSunday+1 ; i <=daysM[pageM-1]; i++) {
            sb.append(String.format("%4d",i));
            if((i-firstSunday)%7==0){
                sb.append(System.getProperty("line.separator"));
            }
        }
        sb.append(System.getProperty("line.separator"));
        sb.append(System.getProperty("line.separator"));
        sb.append("   <<                      >>");

        return sb.toString();
    }

    //static methods
    public static int gimmeDayZeller(int day, int month, int year) {
        int m=month;
        if (month < 3) {
            m = month + 12;
            year--;
        } else {
            m = month;
        }
        int q = day;
        int k = year % 100;
        int j = year / 100;
        int h = q + 13 * (m + 1) / 5 + k + k / 4 + j / 4 + 5 * j;
        h = h % 7;
        switch (h) {
            case 0:
                return 6;
            case 1:
                return 7;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 4;
            case 6:
                return 5;
        }
        return -1;
    }

    public static boolean isLeap(int year) {
        return ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0));
    }

    public static int nDaysInY(int year) {
        if (isLeap(year)) {
            return 366;
        }
        return 365;
    }

    public static String monthText(int month) {
        switch (month) {
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
            default:
                return null;

        }
    }
}
