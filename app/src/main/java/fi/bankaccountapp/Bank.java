package fi.bankaccountapp;

import java.util.Set;

import fi.bankaccountapp.common.Extras;

/**
 * Created by Farooq on 5/9/2018.
 */

public class Bank {
    private String accountNumber;

    //Set testSet = {};
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String Validate() {
        String[] splitedAccountNumber = accountNumber.split("-");
        String firstSplitedPart = splitedAccountNumber[0];
        String secondSplitedPart = splitedAccountNumber[1];
        String accStatus;

        if (firstSplitedPart.length() == Extras.FIRST_PART_LENGTH &&
                secondSplitedPart.length() >= Extras.MIN_SECOND_PART_LENGTH
                && secondSplitedPart.length() <= Extras.MAX_SECOND_PART_LENGTH) {
            accStatus = addingZeros(firstSplitedPart, secondSplitedPart);
        } else
            return "-1";
        return accStatus;
    }

    public String addingZeros(String firstSplitedPart, String secondSplitedPart) {

        String electronicAccount = "";
        String zeros = null;
        boolean isAccValid;
        String compAccountNumber = accountNumber.replace("-", "");
        int calculateZeros = Extras.MAX_LENGTH - compAccountNumber.length();

        if (calculateZeros != 0)
            zeros = String.format("%-" + calculateZeros + "s", "0")
                    .replace(" ", "0");


        int firstDigit = Character.getNumericValue(firstSplitedPart.charAt(0));
        int firstTwoDigits = Integer.parseInt("" + firstSplitedPart.charAt(0) + firstSplitedPart.charAt(1));
//3939 0054 0601 65
//1146 3500 8703 88
//1439 3500 1059 30
//5731  8220 1398 83
//5000 0120 0018 20
//5731 6520 1534 89
//5731 6520 1313 94
//4790 0010 0004 67
        if (compAccountNumber.length() == Extras.MAX_LENGTH) {
            electronicAccount = compAccountNumber;
        } else if (firstDigit == 4 ||
                firstDigit == 5) {
            electronicAccount = compAccountNumber.replaceAll("(.{" + Extras.ADD_ZERO_AT_SEVENTH +
                    "})(?!$)", "$1" + zeros);
        } else if (firstDigit == 1 ||
                firstDigit == 2 ||
                firstTwoDigits == 31 ||
                firstTwoDigits == 33 ||
                firstTwoDigits == 34 ||
                firstTwoDigits == 36 ||
                firstTwoDigits == 37 ||
                firstTwoDigits == 38 ||
                firstTwoDigits == 39 ||
                firstTwoDigits == 6 ||
                firstTwoDigits == 8) {
            electronicAccount = compAccountNumber.replaceAll("(.{" + Extras.ADD_ZERO_AT_SIXTH +
                    "})(?!$)", "$1" + zeros);
        }
        isAccValid = LunhAlgorithm.CheckAccNumber(electronicAccount);

        if (isAccValid)
            return "Valid";
        else
            return "Not Valid";
    }

}
