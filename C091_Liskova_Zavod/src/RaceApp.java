/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Race;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author sarka
 */
public class RaceApp {

    public static void main(String[] args) throws IOException {
        Race r = new Race();
        String PATH = "data"+File.separator;
        r.loadRegistration(PATH+"registration.csv");
        System.out.println(r.getResults());
        r.saveResults(PATH+"results.txt");
    }
}
