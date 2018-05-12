package fi.bankaccountapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextAccountNumber;
    private Button buttonSubmitAccountNumber;
    private Bank bank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitializeUI();
        InitializeData();
    }

    private void InitializeUI() {
        editTextAccountNumber = findViewById(R.id.edit_text_account_number);
        buttonSubmitAccountNumber = findViewById(R.id.button_submit_account_number);
        buttonSubmitAccountNumber.setOnClickListener(this);
    }

    private void InitializeData() {
        bank = new Bank();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_submit_account_number:
                if (editTextAccountNumber.getText() != null && editTextAccountNumber.getText().
                        toString().contains("-")) {
                    bank.setAccountNumber(editTextAccountNumber.getText().toString());
                    String isAccountValid = bank.Validate();
                    if (isAccountValid.equals("-1")) {
                        bank.getAccountNumber();

                    } else
                    {
                        //UpdateUI
                    }
                    break;
                }

        }

    }

}