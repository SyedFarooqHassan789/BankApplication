package fi.bankaccountapp;


import org.junit.Before;
import org.junit.Test;

import fi.bankaccountapp.data.AccountData;

import static junit.framework.Assert.assertEquals;

public class BankTest {
    private Bank bank;

    @Before
    public void setup() {
        bank = new Bank();
    }

    @Test
    public void validateIncorrectAccountNumber() {
        String accountNumber = "45660-94";
        bank.setAccountNumber(accountNumber);
        AccountData accountData = bank.validateAccountNumber();
        assertEquals(accountData, null);

    }

    @Test
    public void validateCorrectAccountNumber() {
        String accountNumber = "123456-785";
        String expectedResult = "12345600000785";
        bank.setAccountNumber(accountNumber);
        AccountData accountData = bank.validateAccountNumber();
        String electronicAccount = accountData.getElectronicAccount();
        assertEquals(electronicAccount, expectedResult);
        boolean validity = accountData.isValid();
        assertEquals(validity, true);
    }
}
