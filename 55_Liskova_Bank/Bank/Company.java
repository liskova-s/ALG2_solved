/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.util.ArrayList;

/**
 *
 * @author sarka
 */
public class Company extends Client {

    public Company(String name) {
        super(name);
    }

    @Override
    public String adressClient() {
        return String.format("Firma %s", super.client);
    }

}
