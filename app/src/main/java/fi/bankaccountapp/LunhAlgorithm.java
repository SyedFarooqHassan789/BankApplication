package fi.bankaccountapp;

import fi.bankaccountapp.data.AccountNumber;

/**
 * Created by Farooq on 5/11/2018.
 */

public class LunhAlgorithm {
    AccountNumber accountNumber;

    public LunhAlgorithm() {

    }

    public static boolean CheckAccNumber(String electronicAccount) {
        if (electronicAccount == null)
            return false;
        int sum = 0;
        boolean alternate = false;
        for (int i = electronicAccount.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(electronicAccount.substring(i, i + 1));
            if (alternate) {
                n *= 2;
                if (n > 9) {
                    n = (n % 10) + 1;
                }
            }
            sum += n;
            alternate = !alternate;
        }
        return (sum % 10 == 0);

    }
}
