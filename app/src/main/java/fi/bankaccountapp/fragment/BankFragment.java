package fi.bankaccountapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import fi.bankaccountapp.R;
import fi.bankaccountapp.common.Extras;
import fi.bankaccountapp.data.AccountData;

/**
 * Created by Farooq on 5/12/2018.
 */

public class BankFragment extends Fragment {

    private TextView textViewValidity;
    private TextView textViewElectronicAccount;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bank, container, false);//Inflate Layout

        InitializeUI(view);
        InitializeData();

        return view;
    }

    private void InitializeData() {
        Bundle args = getArguments();
        if (args != null) {
            AccountData accountData = (AccountData) args.getSerializable(Extras.ACCOUNT_DATA);

            if (accountData != null) {
                textViewElectronicAccount.setText(accountData.getElectronicAccount());
                if (accountData.isValid()) {
                    textViewValidity.setText(R.string.account_number_is_valid);
                    textViewValidity.setTextColor(getResources().getColor(R.color.colorButtonGreen));
                    textViewElectronicAccount.setTextColor(getResources().getColor(R.color.colorButtonGreen));
                } else {
                    textViewValidity.setText(R.string.account_number_is_not_valid);
                    textViewValidity.setTextColor(getResources().getColor(R.color.colorButtonRed));
                    textViewElectronicAccount.setTextColor(getResources().getColor(R.color.colorButtonRed));

                }

            }
        }


    }


    private void InitializeUI(View view) {
        textViewValidity = view.findViewById(R.id.text_view_status);
        textViewElectronicAccount = view.findViewById(R.id.text_view_electronic_account);


    }

}
