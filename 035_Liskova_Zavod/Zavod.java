/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Zavod;

import java.util.List;
import Zavod.Zavodnik;
import java.time.LocalTime;
import java.util.ArrayList;
/**
 *
 * @author sarka
 */
public class Zavod {
    private String raceCode;
    private List<Zavodnik> runners;
    private int bib = 1;

    public Zavod(String code){
        raceCode=code;
        runners=new ArrayList<Zavodnik>();
    }

    public void newRegistration(String name, String surname){
        Zavodnik a = new Zavodnik(name,surname,bib);
        bib++;
        runners.add(a);
    }

    public void cancelRegistration(String name, String surname){
        for (Zavodnik runner : runners) {
            if(runner.getName().equals(name)&&runner.getSurname().equals(surname)){
                runner.cancelRegistration();
            }
        }
    }

    public void cancelRegistration(int bib){
        for (Zavodnik runner : runners) {
            if(runner.getBib()==bib){
                runner.cancelRegistration();
            }
        }
    }

    public void setStart(String name, String surname, String time){
        LocalTime t = LocalTime.parse(time);
        for (Zavodnik runner : runners) {
            if(runner.getName().equals(name)&&runner.getSurname().equals(surname)){
                runner.setStart(t);
            }
        }
    }

    public void setStart(int bib,String time){
        LocalTime t = LocalTime.parse(time);
        for (Zavodnik runner : runners) {
            if(runner.getBib()==bib){
                runner.setStart(t);
            }
        }
    }

    public void setFinish(String name, String surname, String time){
        LocalTime t = LocalTime.parse(time);
        for (Zavodnik runner : runners) {
            if(runner.getName().equals(name)&&runner.getSurname().equals(surname)){
                runner.setFinish(t);
            }
        }
    }

    public void setFinish(int bib,String time){
        LocalTime t = LocalTime.parse(time);
        for (Zavodnik runner : runners) {
            if(runner.getBib()==bib){
                runner.setFinish(t);
            }
        }
    }

    public String runnerListRepr(){
        StringBuilder sb=new StringBuilder();
        for (Zavodnik runner : runners) {
            sb.append(runner.getName()+" "+runner.getSurname()+"\n");
        }
        return sb.toString();
    }

    public String toPrintResults(){
        StringBuilder sb= new StringBuilder();
        sb.append(String.format("%8s %15s %15s %15s %15s %15s %15s %15s %15s %n", "Číslo","Jméno","Příjmení","Čas startu","Čas v cíli","Výsledný čas","Neodstartoval","Nedokončil","Registrace zrušena"));
        for (Zavodnik runner : runners) {
            sb.append(runner.toString()+"\n");
        }
        return sb.toString();
    }

}
