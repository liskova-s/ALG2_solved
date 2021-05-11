/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Race;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author sarka
 */
public class Runner implements Comparable<Runner> {
    private String firstname;
    private String lastname;
    private char sex;
    private LocalDate born;
    private String club;
    private String nationality;
    
    //potencialni samostatna trida "bezec na zavode"
    private Runner r;
    private int bib;
    private LocalTime start;
    private LocalTime finish;
    
  
    Runner(String firstname, String lastname, char gender, LocalDate born, String club, String nationality, int bib) {
        this.firstname=firstname;
        this.lastname=lastname;
        this.sex=gender;
        this.born=born;
        this.club=club;
        this.nationality=nationality;
    }

    @Override
    public String toString() {
        return "Runner{" + "firstname=" + firstname + ", lastname=" + lastname + ", sex=" + sex + ", born=" + born + ", club=" + club + ", nationality=" + nationality + ", bib=" + bib + '}';
    }

    

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getBorn() {
        return born;
    }

    public String getClub() {
        return club;
    }

    public String getNationality() {
        return nationality;
    }

    public int getBib() {
        return bib;
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }

    public void setFinish(LocalTime finish) {
        this.finish = finish;
    }

    @Override
    public int compareTo(Runner o) {
        return this.bib-o.bib;
    }


}


