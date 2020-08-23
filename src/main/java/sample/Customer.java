package sample;

public class Customer {
    String FirstName,LastName,password;
    long cnic,accountNo;
    int pinCode,branchId;
    float balance;

    public void setCnic(long cnic) {
        this.cnic = cnic;
    }

    public int getBranchId() {
        return branchId;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public int getPinCode() {
        return pinCode;
    }

    public long getAccountNo() {
        return accountNo;
    }

    public long getCnic() {
        return cnic;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setAccountNo(long accountNo) {
        this.accountNo = accountNo;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
