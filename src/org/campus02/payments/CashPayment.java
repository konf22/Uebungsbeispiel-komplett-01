package org.campus02.payments;

public class CashPayment extends Payment {

    private String name;

    public CashPayment(double amount, String currency) {
        super(amount, currency);
    }

    public CashPayment(double amount, String currency, String name) {
        super(amount, currency);
        this.name = name;
    }

    @Override
    public double calcTransactionCosts() {
        if (name == null) {
            return 2;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "CashPayment, Name=" + name + ", Amount=" +
                getAmount() + ", Currency=" +
                getCurrency()+ ", TransactionCosts=" + calcTransactionCosts();
    }
}
