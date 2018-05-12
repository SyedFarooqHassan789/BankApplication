package fi.bankaccountapp.data;

/**
 * Created by Farooq on 5/11/2018.
 */

public class AccountNumber {
    private boolean isValid;
    private int checkDigit;

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public int getCheckDigit() {
        return checkDigit;
    }

    public void setCheckDigit(int checkDigit) {
        this.checkDigit = checkDigit;
    }
}
