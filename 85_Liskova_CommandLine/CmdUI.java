/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandline;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author sarka
 */
public class CmdUi {

    public static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        CommandLine cmd = new CommandLine();
        String command;
        do {
            System.out.println(cmd.getPath() + ">");
            command = sc.nextLine();
            System.out.println(cmd.parseAndExecute(command));
            //}while(!command.equals("exit")); smart UI
        } while (!cmd.EndTrue()); //dummy UI
    }

}
