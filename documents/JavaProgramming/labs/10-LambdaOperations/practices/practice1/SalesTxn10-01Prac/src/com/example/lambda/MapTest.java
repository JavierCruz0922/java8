package com.example.lambda;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author oracle
 */
public class MapTest {
    
    public static void main(String[] args) {

        List<SalesTxn> tList = SalesTxn.createTxnList();
   
        // Calculate sales tax for CA Transactions
        System.out.println("=== Widget Pro Sales Tax in CA ===");
        tList
            .stream()
            .filter(salesTxn -> salesTxn.getState().equals(State.CA))
            .filter(salesTxn -> salesTxn.getProduct().equalsIgnoreCase("Widget Pro"))
            .forEach(SalesTxn::printSummary);

        
        
    }
}
