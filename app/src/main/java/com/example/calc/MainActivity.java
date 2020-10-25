package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button one, two, three, four, five, six, seven, eight, nine, zero, AC, dot, add, sub, mul, div, module, equal;
    TextView input, output;
    double value1, value2;
    char operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        givingID();

        onclick();


    }

    private void onclick() {
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNumber(getResources().getString(R.string._1));
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNumber(getResources().getString(R.string._2));
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNumber(getResources().getString(R.string._3));
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNumber(getResources().getString(R.string._4));
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNumber(getResources().getString(R.string._5));
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNumber(getResources().getString(R.string._6));
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNumber(getResources().getString(R.string._7));
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNumber(getResources().getString(R.string._8));
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNumber(getResources().getString(R.string._9));
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNumber(getResources().getString(R.string._0));
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                beforeOperation(getResources().getString(R.string.add).charAt(0));
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        module.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                beforeOperation(getResources().getString(R.string.equal).charAt(0));
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNumber(getResources().getString(R.string.dot));
            }
        });
        AC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText("");
                output.setText("");
                value1 = 0;
                value2 = 0;
            }
        });
    }


    private void showNumber(String number) {
        input.setText(input.getText().toString() + number);
    }

    private void givingID() {
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        zero = findViewById(R.id.zero);
        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        mul = findViewById(R.id.mul);
        div = findViewById(R.id.div);
        module = findViewById(R.id.modulus);
        dot = findViewById(R.id.dot);
        equal = findViewById(R.id.equal);
        AC = findViewById(R.id.buttonAC);
        input = findViewById(R.id.input);
        output = findViewById(R.id.output);
    }

    private boolean checkDoubleType() {
        return value1 != (int) value1;
    }

    private void beforeOperation(char c) {
        if (input.getText().length() > 0) {
            if (operation == '=') {
                doOperation();
                operation = c;
            } else {
                operation = c;
                doOperation();
            }
            if (checkDoubleType()) {
                Log.d("value",String.valueOf(value1));
                output.setText(String.valueOf(value1));
            } else {
                Log.d("value",String.valueOf(value1));
                output.setText(String.valueOf((int) value1));
            }
            input.setText(null);
        }
    }


    private void doOperation() {
        if (!Double.isNaN(value1)) {
            value2 = Double.parseDouble(input.getText().toString());
            switch (operation) {
                case '+':
                    value1 = value1 + value2;
                    break;
                case '-':
                    value1 = value1 - value2;
                    break;
                case 'X':
                    value1 = value1 * value2;
                    break;
                case '%':
                    value1 = value1 / value2;
                    break;
                case '$':
                    value1 = value1 % value2;
                    break;
                case '=':
                    break;

            }
        } else
            value1 = Double.parseDouble(input.getText().toString());
    }
}