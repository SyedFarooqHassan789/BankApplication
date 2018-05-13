package fi.bankaccountapp;

import fi.bankaccountapp.common.Extras;
import fi.bankaccountapp.data.AccountData;


public class LunhAlgorithm {


    //Check account number using LunhAlgorithm
    public static boolean CheckAccNumber(String electronicAccount) {
        if (electronicAccount == null)
            return false;
        int sum = 0;
        boolean alternate = false;
        for (int i = electronicAccount.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(electronicAccount.substring(i, i + 1));
            if (alternate) {
                n *= Extras.DOUBLE_VALUE;
                if (n > Extras.GREATER_THEN_NINE) {
                    n = (n % 10) + 1;
                }
            }
            sum += n;
            alternate = !alternate;
        }
        return (sum % 10 == 0);

    }
}
