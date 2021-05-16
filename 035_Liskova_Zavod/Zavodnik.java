/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Zavod;

import java.time.LocalTime;

/**
 *
 * @author sarka
 */
public class Zavodnik {
    private String name;
    private String surname;
    private int bib;
    private int yearBorn;
    private char gender; //M/F
    private LocalTime start;
    private LocalTime finish;
    private LocalTime finalTime;
    private boolean canceled=false;
    private boolean unfinished=true;
    private boolean started=false;

    public Zavodnik(String name, String surname){
        this.name=name;
        this.surname=surname;
    }

    public Zavodnik(String name, String surname,int bib){
        this.name=name;
        this.surname=surname;
        this.bib=bib;
    }

    public void setBib(int bib) {
        this.bib = bib;
    }

    public void setYearBorn(int yearBorn) {
        this.yearBorn = yearBorn;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setStart(LocalTime start) {
        this.start = start;
        if (finish!=null){
            long finTime=finish.toSecondOfDay()-start.toSecondOfDay();
            finalTime= LocalTime.ofSecondOfDay(finTime);
        }
        started=true;
    }

    public void setFinish(LocalTime finish) {
        this.finish = finish;
        if (start!=null){
            long finTime=finish.toSecondOfDay()-start.toSecondOfDay();
            finalTime= LocalTime.ofSecondOfDay(finTime);
        }
        unfinished=false;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getBib() {
        return bib;
    }

    public int getYearBorn() {
        return yearBorn;
    }

    public char getGender() {
        return gender;
    }

    public LocalTime getStart() {
        return start;
    }

    public LocalTime getFinish() {
        return finish;
    }

    public LocalTime getFinalTime() {
        return finalTime;
    }

    public boolean isCanceled() {
        return canceled;
    }

    public boolean isUnfinished() {
        return unfinished;
    }

    public boolean isStarted() {
        return started;
    }


    public void cancelRegistration(){
        canceled=true;
    }

    @Override
    public String toString() {
        String str= String.format("%8d %15s %15s %15s %15s %15s",bib, name,surname,start,finish,finalTime);
        if(!started){
            str+=String.format("%15s","X");
        }
        else{
            str+=String.format("%15s","");
        }
        if(unfinished){
            str+=String.format("%15s","X");
        }
        else{
            str+=String.format("%15s","");
        }
        if(canceled){
            str+=String.format("%15s","X");
        }
        else{
            str+=String.format("%15s","");
        }

        return str;
  }




}
