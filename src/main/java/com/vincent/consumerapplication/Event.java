package com.vincent.consumerapplication;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Event implements Serializable {
    private String accountNumber;
    private double transactionAmount;
    private String transactionEffectiveDate;
    private String transactionTraceIdentifier;
    private boolean marketingConsent;
    private boolean kycIndicator;
    private String granted;

    public Event() {
    }

    public Event(String accountNumber, double transactionAmount, String transactionEffectiveDate,
                 String transactionTraceIdentifier, boolean marketingConsent, boolean kycIndicator) {
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

    public void setGranted(String granted) {
        this.granted = granted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Double.compare(event.getTransactionAmount(), getTransactionAmount()) == 0 &&
                isMarketingConsent() == event.isMarketingConsent() &&
                isKycIndicator() == event.isKycIndicator() &&
                Objects.equals(getAccountNumber(), event.getAccountNumber()) &&
                Objects.equals(getTransactionEffectiveDate(), event.getTransactionEffectiveDate()) &&
                Objects.equals(getTransactionTraceIdentifier(), event.getTransactionTraceIdentifier()) &&
                Objects.equals(granted, event.granted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAccountNumber(), getTransactionAmount(), getTransactionEffectiveDate(), getTransactionTraceIdentifier(), isMarketingConsent(), isKycIndicator(), granted);
    }
}
