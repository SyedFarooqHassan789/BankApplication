package fi.bankaccountapp;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import fi.bankaccountapp.common.Extras;
import fi.bankaccountapp.data.AccountData;
import fi.bankaccountapp.fragment.BankFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, TextWatcher {

    private EditText editTextAccountNumber;
    private Button buttonSubmitAccountNumber;
    private Bank bank;
    private FragmentManager fragmentManager;
    private int previousLength = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitializeUI();
        InitializeData();
    }

    private void InitializeUI() {
        //Set Action Bar Text
        String title = getResources().getString(R.string.app_name);
        SpannableString spannableString = new SpannableString(title);
        spannableString.setSpan(new ForegroundColorSpan(Color.BLACK), 0, title.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        getSupportActionBar().setTitle(spannableString);

        //Initialize UI
        editTextAccountNumber = findViewById(R.id.edit_text_account_number);
        editTextAccountNumber.addTextChangedListener(this);
        buttonSubmitAccountNumber = findViewById(R.id.button_submit_account_number);
        buttonSubmitAccountNumber.setOnClickListener(this);
    }

    private void InitializeData() {
        bank = new Bank();
        fragmentManager = getSupportFragmentManager();//Get Fragment Manager
    }

    //Add click events
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_submit_account_number:
                checkEditText();
                break;

        }

    }

    //set fragment
    private void setFragment(AccountData accountData) {
        Fragment bankFragment = new BankFragment();
        Bundle args = new Bundle();
        args.putSerializable(Extras.ACCOUNT_DATA, accountData);
        bankFragment.setArguments(args);
        fragmentManager.beginTransaction().replace(R.id.fragment_bank, bankFragment).commit();
    }

    //show error dialog
    private void createDialog() {
        new AlertDialog.Builder(this).setTitle(R.string.enter_again).setMessage(
                R.string.you_have_entered_invalid_account_number_it_should_have_hyphen_first_part_should_have_6_digits_and_second_part_should_have_2_8_digits
        ).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        }).create().show();
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int aft) {
        previousLength = editTextAccountNumber.getText().toString().length();
    }

    @Override
    public void afterTextChanged(Editable text) {
        int length = text.length();
        if ((previousLength < length) && text.length() == Extras.FIRST_PART_LENGTH) {
            text.append('-');
        }

    }

    public void checkEditText() {
        if (editTextAccountNumber.getText() != null && editTextAccountNumber.getText().
                toString().contains("-")) {
            bank.setAccountNumber(editTextAccountNumber.getText().toString());
            AccountData accountData = bank.validateAccountNumber();
            if (accountData == null) {
                createDialog();
            }
            setFragment(accountData);
        } else {
            createDialog();
        }
    }

}