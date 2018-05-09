package fi.bankaccountapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editTextAccountNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitializeUI();
        InitializeData();
    }

    private void InitializeUI() {
        editTextAccountNumber = findViewById(R.id.edit_text_account_number);

    }

    private void InitializeData() {
    }
}
