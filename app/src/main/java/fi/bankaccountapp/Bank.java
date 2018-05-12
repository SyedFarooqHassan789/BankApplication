package fi.bankaccountapp;

import fi.bankaccountapp.common.Extras;

/**
 * Created by Farooq on 5/9/2018.
 */

public class Bank {
    private String accountNumber;

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
        String accountStatus;

        if (firstSplitedPart.length() == Extras.FIRST_PART_LENGTH &&
                secondSplitedPart.length() >= Extras.MIN_SECOND_PART_LENGTH
                && secondSplitedPart.length() <= Extras.MAX_SECOND_PART_LENGTH) {
            accountStatus = addingZeros(firstSplitedPart, secondSplitedPart);
        } else
            return "-1";
        return accountStatus;
    }

    public String addingZeros(String firstSplitedPart, String secondSplitedPart) {

        String electronicAccount = "";
        String zeros = null;
        boolean isAccountValid;
        String completeAccountNumber = accountNumber.replace("-", "");
        int calculateZeros = Extras.MAX_LENGTH - completeAccountNumber.length();

        if (calculateZeros != 0)
            zeros = String.format("%-" + calculateZeros + "s", "0")
                    .replace(" ", "0");


        int firstDigit = Character.getNumericValue(firstSplitedPart.charAt(Extras.FIRST_INDEX));
        int firstTwoDigits = Integer.parseInt("" + firstSplitedPart.charAt(Extras.FIRST_INDEX) +
                firstSplitedPart.charAt(Extras.SECOND_INDEX));

        if (completeAccountNumber.length() == Extras.MAX_LENGTH) {
            electronicAccount = completeAccountNumber;
        } else if (firstDigit == Extras.SP_POP_AKTIA_BANK ||
                firstDigit == Extras.OP_OKO_BANK) {
            electronicAccount = completeAccountNumber.replaceAll("(.{" + Extras.ADD_ZERO_AT_SEVENTH +
                    "})(?!$)", "$1" + zeros);
        } else if (firstDigit == Extras.NORDEA_BANK_1 ||
                firstDigit == Extras.NORDEA_BANK_2 ||
                firstTwoDigits == Extras.SHB_BANK ||
                firstTwoDigits == Extras.SEB_BANK ||
                firstTwoDigits == Extras.DANSKE_BANK ||
                firstTwoDigits == Extras.TAPIOLA_BANK ||
                firstTwoDigits == Extras.DNB_NOR_BANK ||
                firstTwoDigits == Extras.SWED_BANK ||
                firstTwoDigits == Extras.S_BANK ||
                firstTwoDigits == Extras.ALAND_BANK ||
                firstTwoDigits == Extras.SAMPO_BANK) {
            electronicAccount = completeAccountNumber.replaceAll("(.{" + Extras.ADD_ZERO_AT_SIXTH +
                    "})(?!$)", "$1" + zeros);
        }
        isAccountValid = LunhAlgorithm.CheckAccNumber(electronicAccount);

        if (isAccountValid)
            return "Valid";
        else
            return "Not Valid";
    }

}

