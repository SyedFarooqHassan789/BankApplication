package fi.bankaccountapp.data;

import java.io.Serializable;


public class AccountData implements Serializable {
    private boolean isValid;
    private String electronicAccount;
    private String validAccountNumber;


    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public String getElectronicAccount() {
        return electronicAccount;
    }

    public void setElectronicAccount(String electronicAccount) {
        this.electronicAccount = electronicAccount;
    }

    public String getValidAccountNumber() {
        return validAccountNumber;
    }

    public void setValidAccountNumber(String validAccountNumber) {
        this.validAccountNumber = validAccountNumber;
    }

}
