package fi.bankaccountapp.data;

import java.io.Serializable;


public class AccountData implements Serializable {
    private boolean isValid;
    private String electronicAccount;

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


}
