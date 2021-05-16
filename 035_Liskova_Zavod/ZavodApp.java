/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Zavod;

import java.util.Scanner;
import Zavod.Zavod;
import java.time.LocalTime;
/**
 *
 * @author sarka
 */
public class ZavodApp {
    public static Scanner sc=new Scanner(System.in);
    public static Zavod z;
    public static boolean end=false;
    public static void main(String[] args) {
        System.out.println("Zadejte indentifikační kód závodu:");
        z=new Zavod(sc.next());
        help();
        do{
            execute(sc.next());
        } while(!end);
    }
    public static void help(){
        System.out.println("Ovladani: \n"
                + "+r           registrace noveho zavodnika\n"
                + "-r           zruseni registrace zavodnika\n"
                + "+st          zápis startovního času zavodníkovi\n"
                + "+ft          zápis cílového času závodníkovi\n"
                + "--vysl       zobrazeni vysledkove listiny\n"
                + "--zavodnici  zobrazeni jmenneho seznamu zavodniku\n"
                + "--help       zobrazeni teto zpravy\n"
                + "--exit       ukončení aplikace\n");
    }
    public static void execute(String s){
        switch(s){
            case "+r":
                System.out.println("Nová registrace - zadejte jméno a příjmení závodníka:");
                z.newRegistration(sc.next(), sc.next());
                System.out.println("Závodník zaregistrován.");
                System.out.println("");
                break;
            case "-r":
                System.out.println("Zrušení registrace - zadejte jméno a příjmení závodníka:");
                z.cancelRegistration(sc.next(), sc.next());
                System.out.println("Registrace zrušena.");
                System.out.println("");
                break;
            case "+st":
                System.out.println("Zadejte jméno, příjmení a startovní čas závodníka:");
                z.setStart(sc.next(), sc.next(), sc.next());
                System.out.println("Čas přidán.");
                System.out.println("");
                break;
            case "+ft":
                System.out.println("Zadejte jméno, příjmení a cílový čas závodníka:");
                z.setFinish(sc.next(), sc.next(), sc.next());
                System.out.println("Čas přidán.");
                System.out.println("");
                break;
            case "--vysl":
                System.out.println("Výsledková listina");
                System.out.println("");
                System.out.println(z.toPrintResults());
                System.out.println("");
                break;
            case "--zavodnici":
                System.out.println("Seznam závodníků");
                System.out.println("");
                System.out.println(z.runnerListRepr());
                System.out.println("");
                break;

            case "--help":
                help();
                System.out.println("");
                break;

            case "--exit":
                end=true;
                break;
            default:
                break;
        }

    }

}
