package hcmute.edu.vn.calculator_01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    double firstNum, secondNum, ans;
    String operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.textOutput);

        final Button btn0 = findViewById(R.id.btn0);
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e( "onClick: ", textView.getText().toString());
                if (textView.getText().toString().equals("0")) return;
                textView.setText(textView.getText().toString() + btn0.getText().toString());
            }
        });

        final Button btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                printNumber(btn1.getText().toString());
            }
        });

        final Button btnCong = findViewById(R.id.btnCong);
        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstNum = Double.parseDouble(textView.getText().toString());
                operator = "+";
                textView.setText("0");
            }
        });

        final Button btnTru = findViewById(R.id.btnTru);
        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstNum = Double.parseDouble(textView.getText().toString());
                operator = "-";
                textView.setText("0");
            }
        });

        final Button btnBang = findViewById(R.id.btnBang);
        btnBang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processAnswer(operator);
            }
        });

        final Button btnC = findViewById(R.id.btnC);
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstNum = secondNum = 0;
                textView.setText("0");
            }
        });
    }

    private void processAnswer(String op) {
        TextView textView = (TextView) findViewById(R.id.textOutput);

        secondNum = Double.parseDouble(textView.getText().toString());
        if (operator == "+") {
            ans = firstNum + secondNum;
        }
        else if (operator == "-") {
            ans = firstNum - secondNum;
        }
        textView.setText(Double.toString(ans));
    }

    private void printNumber(String num) {
        TextView textView = (TextView) findViewById(R.id.textOutput);

        if (!textView.getText().toString().equals("0")) {
            textView.setText(textView.getText().toString() + num);
        } else {
            textView.setText(num);
        }
    }
}