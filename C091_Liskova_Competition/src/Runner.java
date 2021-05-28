package competition;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author JV
 */
public class Runner implements Comparable<Runner> {

    private String firstName;
    private String lastName;
    private char gender;
    private LocalDate born;
    private String club;
    private String nationality;

    private int number;
    private LocalTime startTime;
    private LocalTime finishTime;

    public Runner(String firstName, String lastName, char gender, LocalDate born, String club, String nationality, int number) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.born = born;
        this.club = club;
        this.nationality = nationality;
        this.number = number;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public char getGender() {
        return gender;
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

    public int getNumber() {
        return number;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getFinishTime() {
        return finishTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setFinishTime(LocalTime finishTime) {
        this.finishTime = finishTime;
    }
    
    public LocalTime runningTime(){
        if(startTime==null){
            throw new UnsetTimeException("Start time not set yet.");
        }
        if(finishTime==null){
            throw new UnsetTimeException("Finish time not set yet.");
        }
        long runningTime=finishTime.toSecondOfDay()-startTime.toSecondOfDay();
        return LocalTime.ofSecondOfDay(runningTime);
    }
    
    @Override
    public String toString() {
        String s = String.format("%10s %15s %5s %5s %15s %15s %5d", firstName, lastName, gender, born.format(DateTimeFormatter.ISO_LOCAL_DATE), club, nationality, number);
        if (startTime != null) {
            s += String.format("%12s", startTime);
        } else {
            s += String.format("%12s", "xxx");
        }
        if (finishTime != null) {
            s += String.format("%12s", finishTime);
        } else {
            s += String.format("%12s", "xxx");
        }
        if(finishTime!=null&&startTime!=null){
            s+= String.format("%12s",runningTime());
        }else {
            s += String.format("%12s", "xxx");
        }
        return s;
    }

    @Override
    public int compareTo(Runner o) {
        return this.number - o.number;
    }

}
