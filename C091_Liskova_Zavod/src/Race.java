/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Race;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author sarka
 */
public class Race {

    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M/d/yyyy");
    private List<Runner> runners;

    public Race() {
        runners = new ArrayList<>();
    }

    public void loadRegistration(String filename) throws FileNotFoundException, IOException {

        try (BufferedReader br = new BufferedReader(new FileReader(new File(filename)))) {

            String line;
            int bib;
            LocalDate born;
            String firstname;
            String lastname;
            String club;
            String nationality;
            char gender;
            br.readLine();//eliminace zahlavi
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                bib = Integer.parseInt(parts[0]);
                gender = parts[2].charAt(0);
                born = LocalDate.parse(parts[3], dtf);
                club = parts[4];
                nationality = parts[5];
                String[] name = parts[1].split(" ");
                firstname = name[1];
                lastname = name[0];
                Runner run = new Runner(firstname, lastname, gender, born, club, nationality, bib);
                runners.add(run);

                //br.close(); try with sŕesources zavírá automaticky
            }
        }
    }

    public String getResults() {
        Collections.sort(runners);
        StringBuilder sb=new StringBuilder();
        for(Runner run:runners){
            sb.append(run).append("\n");
        }
        return sb.toString();
    }
    public void saveResults(String filename) throws IOException{
        Collections.sort(runners);
        try(PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter(new File(filename),true)))){ //s true nepřepisuje existující soubor, data prida pod existujici, jinak přepisuje
            for (Runner runner : runners) {
                pw.println(runner);
            }
        }
        
    }

}
