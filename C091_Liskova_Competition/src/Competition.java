package competition;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author JV
 */
public class Competition {

    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M/d/yyyy");
    static DateTimeFormatter dtftime = DateTimeFormatter.ofPattern("H:mm:ss");
    private final List<Runner> runners;

    public Competition() {
        runners = new ArrayList<>();
    }

    public void loadRegistration(File registrationFile) throws FileNotFoundException, IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(registrationFile))) {
            String line;
            int number;
            LocalDate born;
            String firstName, lastName, club, nationality;
            char gender;
            Runner r;
            br.readLine(); //zahlavi preskoceni
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(","); //32,Mala Alice,F,3/21/1999,Silvini,CZE
                number = Integer.parseInt(parts[0]);
                gender = parts[2].charAt(0);
                born = LocalDate.parse(parts[3], dtf);
                club = parts[4];
                nationality = parts[5];
                String[] firstLast = parts[1].split(" ");
                firstName = firstLast[1];
                lastName = firstLast[0];
                r = new Runner(firstName, lastName, gender, born, club, nationality, number);
                runners.add(r);
            }
        }
    }

    public void loadStart(File filename) throws FileNotFoundException, IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            int bib;
            LocalTime startTime;
            String line;
            br.readLine();// - zahlavi
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                bib = Integer.parseInt(parts[0]);
                startTime = LocalTime.parse(parts[1], dtftime);
                Runner currentR = findByNumber(bib);
                currentR.setStartTime(startTime);
            }
        }
    }

    public void loadFinish(File finishFile) throws FileNotFoundException, IOException {
        //load data by lines, find the right runner, set finnish time
        try (BufferedReader br = new BufferedReader(new FileReader(finishFile))) {
            int bib;
            LocalTime finishTime;
            String line;
            br.readLine();// - zahlavi
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                bib = Integer.parseInt(parts[0]);
                finishTime = LocalTime.parse(parts[1], dtftime);
                Runner currentR = findByNumber(bib);
                currentR.setFinishTime(finishTime);
            }
        }
    }

    public void loadFinnishSC(File finishFile) throws FileNotFoundException {
        try (Scanner sc = new Scanner(new FileReader(finishFile))) {
            int bib;
            LocalTime finishTime;
            String line;
            sc.nextLine();
            while (sc.hasNext()) {
                line = sc.nextLine();
                String[] parts = line.split(",");
                bib = Integer.parseInt(parts[0]);
                finishTime = LocalTime.parse(parts[1], dtftime);
                Runner currentR = findByNumber(bib);
                currentR.setFinishTime(finishTime);
            }
        }
    }

    public Runner findByNumber(int number) {
        for (Runner runner : runners) {
            if (runner.getNumber() == number) {
                return runner;
            }
        }
        throw new NoSuchElementException("Bezec s cislem " + number + " nebyl nalezen.");
        //return null;
    }

    private String printRunners() {
        StringBuilder sb = new StringBuilder();
        for (Runner runner : runners) {
            sb.append(runner).append("\n");
        }
        return sb.toString();
    }

    public String getResultsByBib() {
        Collections.sort(runners);
        return printRunners();
    }

    public String getResultsSortedRunningTime() {
        Collections.sort(runners, new ComparatorByRunTime());
        return printRunners();
    }

    public void saveResults(File resultFile) throws IOException {
        Collections.sort(runners);
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(resultFile, true)))) {
            pw.println("Vysledková listina");
            pw.println(String.format("%4s %10s %15s %12s %18s %18s %18s", "č.", "Jméno", "Příjmení", "Klub", "Startovní čas", "Čas v cíli", "Výsledný čas"));
            //printRunners();
            pw.println("___________________________________________________________________________________________________________");
            String s;
            for (Runner runner : runners) {
                s = String.format("%4d %10s %15s %12s %18s %18s %18s", runner.getNumber(), runner.getFirstName(), runner.getLastName(), runner.getClub(), runner.getStartTime().toString(), runner.getFinishTime().toString(), runner.runningTime().toString());
                pw.println(s);
            }
        }
    }

    public void saveResultsToBinary(File filename) throws FileNotFoundException, IOException {
        try (DataOutputStream outS = new DataOutputStream(new FileOutputStream(filename))) {
            for (Runner runner : runners) {
                //bib, name, surname, runningtime 
                outS.writeInt(runner.getNumber());
                outS.writeUTF(runner.getFirstName());
                outS.writeUTF(runner.getLastName()); //automatic javovska implementace
                /* alternativa pro zapis stringu: pocet bajtu na kterych je string, + jednotlive znaky
                outS.writeInt(nChars);
                int nChars = runner.getLastName().length();
                for (int i = 0; i < nChars; i++) {
                    outS.writeChar(runner.getLastName().charAt(i));
                }
                 */
                outS.writeLong(runner.runningTime().toSecondOfDay());
            }
        }
    }

    public String readResultsBinary(File filename) throws FileNotFoundException, IOException {
        StringBuilder sb = new StringBuilder();
        try (DataInputStream in = new DataInputStream(new FileInputStream(filename))) {
            int number;
            String firstName;
            String lastName;
            //int nChars;
            LocalTime runningTime;
            //Input stream -> konec souboru: vyjimka end of file exc
            boolean end = false;

            while (!end) {
                try {
                    lastName = "";
                    number = in.readInt();
                    System.out.println(number);
                    firstName = in.readUTF();
                    lastName = in.readUTF();
                    /*
                    nChars=in.readInt();
                    for (int i = 0; i < nChars; i++) {
                    lastName+=in.readChar();
                    }
                     */
                    runningTime = LocalTime.ofSecondOfDay(in.readLong());
                    sb.append(String.format("%3d %10s %10s %10s", number, firstName, lastName, runningTime.format(dtftime)));
                } catch (EOFException e) {
                    end = true;
                }
            }
        }
        return sb.toString();
    }

}
