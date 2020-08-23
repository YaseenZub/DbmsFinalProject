package sample;

import java.sql.Date;

public class Transactions {
    private int uid,transactionId;
    private Date transactionDate;
    private String typeOfTransaction,FullName;
    private double transactionAmount;
    private long recipientAccountNo;

    public long getRecipientAccountNo() {
        return recipientAccountNo;
    }

    public void setRecipientAccountNo(long recipientAccountNo) {
        this.recipientAccountNo = recipientAccountNo;
    }

    public void setUid(int uid){
        this.uid=uid;
    }

    public int getUid() {
        return uid;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTypeOfTransaction(String typeOfTransaction) {
        this.typeOfTransaction = typeOfTransaction;
    }

    public String getTypeOfTransaction() {
        return typeOfTransaction;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getFullName() {
        return FullName;
    }

    public int getTransactionId() {
            return transactionId;
        }
}
