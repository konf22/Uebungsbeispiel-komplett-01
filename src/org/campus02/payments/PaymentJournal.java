package org.campus02.payments;

import java.util.ArrayList;
import java.util.HashMap;

public class PaymentJournal {

    private ArrayList<Payment> payments = new ArrayList<>();

    public void add(Payment payment) {
        payments.add(payment);
    }

    public double totalTransactionCosts() {
        double totalCosts = 0;

        for (Payment p : payments) {
            totalCosts += p.calcTransactionCosts();
        }

        return totalCosts;
    }

    public HashMap<String, Integer> getPaymentsPerCurrency() {
        HashMap<String, Integer> result = new HashMap<>();

        for (Payment p : payments) {
            /*
                1. Kontrollieren, ob der das Element (key) enthalten ist
                    2. wenn ja, manipulieren (summieren, addieren)
                    3. wenn nein, dann hinzufügen (init-wert beachten)
             */
            if (result.containsKey(p.getCurrency())){
                // aktuellen Wert auslesen
                Integer count = result.get(p.getCurrency());
                count++;
                // wert wieder ablegen
                result.put(p.getCurrency(), count);
            } else {
                result.put(p.getCurrency(), 1);
            }
        }

        return result;
    }

    public HashMap<String, Double> getPaymentAmountPerCurrency() {
        HashMap<String, Double> result = new HashMap<>();

        for (Payment p : payments) {
            /*
                1. Kontrollieren, ob der das Element (key) enthalten ist
                    2. wenn ja, manipulieren (summieren, addieren)
                    3. wenn nein, dann hinzufügen (init-wert beachten)
             */
            if (result.containsKey(p.getCurrency())){
                // aktuellen Wert auslesen
                Double amount = result.get(p.getCurrency());
                amount += p.getAmount();
                // wert wieder ablegen
                result.put(p.getCurrency(), amount);
            } else {
                result.put(p.getCurrency(), p.getAmount());
            }
        }

        return result;
    }
}
