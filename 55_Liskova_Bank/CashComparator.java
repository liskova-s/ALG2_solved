/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.util.Comparator;

/**
 *
 * @author sarka
 */
public interface CashComparator {

    public static Comparator<Client> CashComparator = (Client c1, Client c2) -> {

        if (c1.getTotalResidual() < c2.getTotalResidual()) {
            return 1;
        }
        if (c1.getTotalResidual() > c2.getTotalResidual()) {
            return -1;
        }
        return 0;
    };
}
