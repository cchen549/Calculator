package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button minus,plus,mult,divide;
    int num1=0,num2=0, result;

    @Override
    public void onClick(View view) {
        EditText firstNum = (EditText) findViewById(R.id.firstNumber);
        EditText secondNum = (EditText) findViewById(R.id.secondNumber);
        num1 = Integer.parseInt(firstNum.getText().toString());
        num2 = Integer.parseInt(secondNum.getText().toString());

        switch (view.getId()){
            case R.id.plus:
                result = num1 + num2;
                goToActivity2(result);
                break;
            case R.id.minus:
                result = num1 - num2;
                goToActivity2(result);
                break;
            case R.id.mult:
                result = num1 * num2;
                goToActivity2(result);
                break;
            case R.id.divide:
                result = num1 / num2;
                goToActivity2(result);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }


    }

    public void goToActivity2(Integer s){
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("message",s.toString());
        startActivity(intent);
    }

    private void initViewAndListener(){
        minus = (Button)findViewById(R.id.minus);
        minus.setOnClickListener(this);

        plus = (Button) findViewById(R.id.plus);
        plus.setOnClickListener(this);

        mult = (Button) findViewById(R.id.mult);
        mult.setOnClickListener(this);

        divide = (Button) findViewById(R.id.divide);
        divide.setOnClickListener(this);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViewAndListener();
    }

}