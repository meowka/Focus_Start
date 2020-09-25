package com.example.focus_start;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Converter extends AppCompatActivity {

    Double value;
    Double moneyTxt;
    TextView resultTxt;
    Double result;
    EditText money;
    Button resultBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);
        money = findViewById(R.id.moneyEdtxt);
        resultTxt = findViewById(R.id.result);
        resultBtn = findViewById(R.id.resultBtn);

        Bundle arguments = getIntent().getExtras();
        value = arguments.getDouble(getString(R.string.bundleValue));
        resultBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moneyTxt = Double.valueOf(money.getText().toString());
                result = moneyTxt/value;
                resultTxt.setText(String.format(getString(R.string.strFormat), result));
            }
        });

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putDouble(getString(R.string.outStateResult), result);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        result = savedInstanceState.getDouble(getString(R.string.outStateResult));
        resultTxt.setText(String.format(getString(R.string.strFormat), result));
    }
}