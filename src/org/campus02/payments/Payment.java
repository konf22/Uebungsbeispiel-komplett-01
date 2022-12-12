package org.campus02.payments;

public abstract class Payment {
    private double amount;
    private String currency;

    // 2 Varianten
    // getter
    // protected


    public String getCurrency() {
        return currency;
    }

    public double getAmount() {
        return amount;
    }

    public Payment(double amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public double exchangeToEUR() {

        if (currency.equals("USD"))
            return amount / 1.1;

        switch (currency) {
            case "EUR":
                return amount;
            case "USD":
                return amount / 1.1;
            case "GBP":
                return amount / 0.85;
                //break;
            case "SEK":
                return amount / 9.5;
            case "HUF":
                return amount / 310.0;
            default:
                return amount / 2.0;
        }
    }

    public abstract double calcTransactionCosts();
}
