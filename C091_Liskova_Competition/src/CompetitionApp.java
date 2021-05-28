package competition;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JV
 */
public class CompetitionApp {

    public static Scanner sc = new Scanner(System.in);
    public static boolean end = false;
    public static Competition comp;
    public static File dataDirectory;

    public static void main(String[] args) throws IOException {
        comp = new Competition();
        String userDir = System.getProperty("user.dir");

        dataDirectory = new File(userDir + File.separator + "data");

        System.out.println("Zadej soubor registrace.");
        String registrationFile = sc.next();
        try {
            comp.loadRegistration(new File(dataDirectory, registrationFile));
        } catch (FileNotFoundException exc) {
            System.out.println("Soubor nenalezen.");
        }

        System.out.println("Zadej soubor se startovnimi casy.");
        String startFile = sc.next();
        try {
            comp.loadStart(new File(dataDirectory, startFile));
        } catch (FileNotFoundException exc) {
            System.out.println("Soubor nenalezen.");
        }

        System.out.println("Zadej soubor s cilovymi casy.");
        String finishFile = sc.next();
        try {
            comp.loadFinish(new File(dataDirectory, finishFile));
        } catch (FileNotFoundException exc) {
            System.out.println("Soubor nenalezen.");
        }
        //testing space_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
        
        //System.out.println(comp.getResultsByBib());
        //System.out.println(comp.getResultsSortedRunningTime());
        
        
        
        //_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ 
        ui();
        /*
        String path = "data" + File.separator;
        try{
            while(true){
                try{
                    System.out.println("Zadej soubor");
                    comp.loadRegistration(path + sc.next());
                    System.out.println(comp.getResults());
                    break;
                }catch(FileNotFoundException e){
                    System.out.println("Zadali jste neexistujici soubor");
                }
            }
            comp.saveResults(path + "results.txt");
        }catch (IOException e){
            //Logger.getLogger(CompetitionApp.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Nastal problem" + e.getMessage());
        }    
         */
    }
    public static void ui(){
        System.out.println("Soubory načteny.");
        System.out.println("");
        System.out.println("DALŠÍ KROKY:");
        System.out.println("-list               pro výpis výsledkové listiny na obrazovku");
        System.out.println("-s                  pro uložení výsledkové listiny do textového souboru results.txt");
        System.out.println("-sb                 pro uložení výsledkové listiny do binárního souboru resultsBI.txt");
        System.out.println("-cl <filename>      pro kontrolní načtení a výpis výsledkové listiny z binárního souboru");
        System.out.println("-exit               pro ukončení programu");
        while (!end) {
            String[] line = sc.nextLine().split(" ");
            switch (line[0]) {
                case "-list":
                    System.out.println(comp.getResultsByBib());
                    break;
                case "-s":
            {
                try {
                    comp.saveResults(new File(dataDirectory, "results.txt"));
                } catch (IOException ex) {
                    System.out.println("Nastal problém.");
                }
            }
                    break;
                case "-sb":
            {
                try {
                    comp.saveResultsToBinary(new File(dataDirectory, "resultsBI.txt"));
                } catch (IOException ex) {
                    System.out.println("Nastal problém.");
                }
            }
                    break;
                case "-cl":
                    if (line.length > 1) {
                        File bin = new File(dataDirectory, line[1]);
                        if (bin.isFile()) {
                            try {
                                System.out.println(comp.readResultsBinary(bin));
                            } catch (IOException ex) {
                               System.out.println("Nastal problém.");
                            }
                        } else {
                            System.out.println("Nelze provést bez jména souboru.");
                        }
                    }
                    break;
                case "-exit":
                    end = true;
                default:
                    break;
            }
        }
    }
}
