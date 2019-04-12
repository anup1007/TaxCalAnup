package com.taxcalanup;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    EditText etIncome;
    TextView tvTax;
    Button btnCal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etIncome= findViewById(R.id.etIncome);
        tvTax= findViewById(R.id.tvTax);

        btnCal= findViewById(R.id.btnCalculate);

        btnCal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                double income, tax;

                income = Integer.parseInt(etIncome.getText().toString());

                TaxCal taxCalculator= new TaxCal(income);
                tax= taxCalculator.Tax();
                tvTax.setText(Double.toString(tax));

                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(btnCal.getWindowToken(), InputMethodManager.RESULT_UNCHANGED_SHOWN);
            }
        });
    }
}
