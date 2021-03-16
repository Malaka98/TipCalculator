package com.example.tipcalculatorv0;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private EditText billEitText;
    private EditText tipEditText;
    private EditText npText;
    private TextView billTextView;
    private TextView tipTextView;
    private TextView npTextView;

    private TipCalculator tipcal = new TipCalculator(0f, 0f, 0);
    public NumberFormat money = NumberFormat.getCurrencyInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         billEitText = (EditText) findViewById(R.id.txt1);
         tipEditText = (EditText) findViewById(R.id.txt2);
         npText = (EditText) findViewById(R.id.txt3);
         billTextView = (TextView) findViewById(R.id.view1);
         tipTextView = (TextView) findViewById(R.id.view2);
         npTextView = (TextView) findViewById(R.id.view);

         TextChangeHandler textChangeHandler = new TextChangeHandler();

         billEitText.addTextChangedListener(textChangeHandler);
         tipEditText.addTextChangedListener(textChangeHandler);
         npText.addTextChangedListener(textChangeHandler);
    }

    public void calculate() {


        String bill = billEitText.getText().toString();
        String tip = tipEditText.getText().toString();
        String np = npText.getText().toString();

        try {

            tipcal.setTip(Float.parseFloat(bill));
            tipcal.setBill(Float.parseFloat(tip));
            tipcal.setPpl(Integer.parseInt(np));

            float tipValue = tipcal.tipAmount();
            float total = tipcal.totalAmount();
            float pp = tipcal.perPerson();

            billTextView.setText(money.format(tipValue));
            tipTextView.setText(money.format(total));
            npTextView.setText(Float.toString(pp));

        }catch (NumberFormatException e) {

        }
    }

    private class TextChangeHandler implements TextWatcher{

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            calculate();
        }
    }
}