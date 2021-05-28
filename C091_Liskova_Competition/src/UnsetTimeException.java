/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package competition;

/**
 *
 * @author sarka
 */
public class UnsetTimeException extends RuntimeException {
    
    public UnsetTimeException(){
        super(); //stačí odchytit runtime exception obecně
    }
    
    public UnsetTimeException(String message){
        super(message); //stačí odchytit runtime exception obecně
    }
    
}
