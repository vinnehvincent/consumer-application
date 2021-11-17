package com.vincent.consumerapplication;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Event implements Serializable {
    private String accountNumber;
    private double transactionAmount;
    private String transactionEffectiveDate;
    private String transactionTraceIdentifier;
    private boolean marketingConsent;
    private boolean kycIndicator;

    public Event() {
    }

    public Event(String accountNumber, double transactionAmount, String transactionEffectiveDate,
                 String transactionTraceIdentifier, boolean marketingConsent, boolean kycIndicator) throws ParseException {
        this.accountNumber = accountNumber;
        this.transactionAmount = transactionAmount;
        this.transactionEffectiveDate = transactionEffectiveDate;
        this.transactionTraceIdentifier = transactionTraceIdentifier;
        this.marketingConsent = marketingConsent;
        this.kycIndicator = kycIndicator;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public String getTransactionEffectiveDate() {
        return transactionEffectiveDate;
    }

    public String getTransactionTraceIdentifier() {
        return transactionTraceIdentifier;
    }

    public boolean isMarketingConsent() {
        return marketingConsent;
    }

    public boolean isKycIndicator() {
        return kycIndicator;
    }
}
