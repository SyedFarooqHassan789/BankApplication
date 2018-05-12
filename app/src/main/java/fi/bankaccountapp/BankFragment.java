package fi.bankaccountapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Farooq on 5/12/2018.
 */

public class BankFragment extends Fragment {

    private TextView textViewValidity;
    private TextView textViewBankName;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bank, container, false);//Inflate Layout
        InitializeUI(view);
        return view;
    }

    private void InitializeUI(View view) {
        textViewValidity = view.findViewById(R.id.text_view_status);
        textViewBankName = view.findViewById(R.id.text_view_bank_name);


    }

}
