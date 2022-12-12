package org.campus02.payments;

public class DemoPaymentApp {
    public static void main(String[] args) {

        CashPayment cp = new CashPayment(500, "EUR");
        System.out.println("cp.calcTransactionCosts() = " + cp.calcTransactionCosts());

        MaestroPayment mp = new MaestroPayment(500, "EUR", "AT12346");
        System.out.println("mp.exchangeToEUR() = " + mp.exchangeToEUR());
        System.out.println("mp.calcTransactionCosts() = " + mp.calcTransactionCosts());
        
        CreditCardPayment ccp = new CreditCardPayment(500, "USD", "AT55555", "876");
        System.out.println("ccp.exchangeToEUR() = " + ccp.exchangeToEUR());
        System.out.println("ccp.calcTransactionCosts() = " + ccp.calcTransactionCosts());
        
        PaymentJournal pj = new PaymentJournal();
        pj.add(mp);
        pj.add(cp);
        pj.add(ccp);

        System.out.println("pj.totalTransactionCosts() = " + pj.totalTransactionCosts());

        System.out.println("pj.getPaymentsPerCurrency() = " + pj.getPaymentsPerCurrency());

        System.out.println("pj.getPaymentAmountPerCurrency() = " + pj.getPaymentAmountPerCurrency());

        // Casting
        System.out.println("\n\n\nCasting ---- \n");
        Payment p = mp;
        System.out.println("p.calcTransactionCosts() = " + p.calcTransactionCosts());

        MaestroPayment mp2 = (MaestroPayment) p; // explizit
        System.out.println(mp2);
        


    }
}
