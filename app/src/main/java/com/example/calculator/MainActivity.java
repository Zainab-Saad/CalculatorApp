package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigInteger;
import java.util.Objects;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // variable declaration -- variables store ids of buttons, text view
    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9,
            buttonDot, buttonMul, buttonAdd, buttonSub, buttonDiv, buttonPow, buttonClear, buttonCross, buttonEqual;
    TextView textView;
    // enhance working of calculator
    boolean isOperatorSelected = false;
    boolean anyButtonPressed = false;
    boolean calculated = false;
    /** initialize variables for calculations*/
    String textDisplay = "";                               // variable to set text of text view
    String number = "";                                   // store the current number
    ArrayList<String> numbers = new ArrayList<>();       // store all numbers
    ArrayList<Character> operators = new ArrayList<>(); // store all operators
    Arithmetic arithmetic = new Arithmetic();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide(); // hide title bar
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.Eerie_Black));
        }
        // store the id of buttons, text view
        button0 = findViewById(R.id.button0);        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);        button9 = findViewById(R.id.button9);
        buttonDot = findViewById(R.id.buttonDt);     buttonMul = findViewById(R.id.buttonMm);
        buttonAdd = findViewById(R.id.buttonP);      buttonSub = findViewById(R.id.buttonM);
        buttonDiv = findViewById(R.id.buttonD);      buttonPow = findViewById(R.id.buttonPr);
        buttonClear = findViewById(R.id.buttonC);    buttonCross = findViewById(R.id.buttonX);
        buttonEqual = findViewById(R.id.buttonE);    textView = findViewById(R.id.textView);
        // set the text of TextView
        textView.setText("0");
        // add the action listener to every button
        button0.setOnClickListener(this);            button1.setOnClickListener(this);
        button2.setOnClickListener(this);            button3.setOnClickListener(this);
        button4.setOnClickListener(this);            button5.setOnClickListener(this);
        button6.setOnClickListener(this);            button7.setOnClickListener(this);
        button8.setOnClickListener(this);            button9.setOnClickListener(this);
        buttonDot.setOnClickListener(this);          buttonMul.setOnClickListener(this);
        buttonAdd.setOnClickListener(this);          buttonSub.setOnClickListener(this);
        buttonDiv.setOnClickListener(this);          buttonPow.setOnClickListener(this);
        buttonClear.setOnClickListener(this);        buttonCross.setOnClickListener(this);
        buttonEqual.setOnClickListener(this);
    }
    @SuppressLint("NonConstantResourceId")
    public void onClick(View view){    // override abstract method of interface implemented
        switch (view.getId()){


            case R.id.button0:
            if(anyButtonPressed){
                number += button0.getText();
                textDisplay += button0.getText();
                textView.setText(textDisplay);
            }isOperatorSelected = false;

                break;


            case R.id.button1:
                number += button1.getText();
                textDisplay += button1.getText(); textView.setText(textDisplay);
                isOperatorSelected = false;
                anyButtonPressed = true;
                break;


            case R.id.button2:
                number += button2.getText();
                textDisplay += button2.getText(); textView.setText(textDisplay);
                isOperatorSelected = false;
                anyButtonPressed = true;
                break;

            case R.id.button3:
                number += button3.getText();
                textDisplay += button3.getText(); textView.setText(textDisplay);
                isOperatorSelected = false;
                anyButtonPressed = true;
                break;


            case R.id.button4:
                number += button4.getText();
                textDisplay += button4.getText(); textView.setText(textDisplay);
                isOperatorSelected = false;
                anyButtonPressed = true;
                break;


            case R.id.button5:
                number += button5.getText();
                textDisplay += button5.getText(); textView.setText(textDisplay);
                isOperatorSelected = false;
                anyButtonPressed = true;
                break;


            case R.id.button6:
                number += button6.getText();
                textDisplay += button6.getText(); textView.setText(textDisplay);
                isOperatorSelected = false;
                anyButtonPressed = true;
                break;


            case R.id.button7:
                number += button7.getText();
                textDisplay += button7.getText(); textView.setText(textDisplay);
                isOperatorSelected = false;
                anyButtonPressed = true;
                break;


            case R.id.button8:
                number += button8.getText();
                textDisplay += button8.getText(); textView.setText(textDisplay);
                isOperatorSelected = false;
                anyButtonPressed = true;
                break;


            case R.id.button9:
                number += button9.getText();
                textDisplay += button9.getText(); textView.setText(textDisplay);
                isOperatorSelected = false;
                anyButtonPressed = true;
                break;


            case R.id.buttonDt:
            if (!(number.contains("."))){
                number += buttonDot.getText();
                textDisplay += buttonDot.getText();
                textView.setText(textDisplay);
                isOperatorSelected = false;
                anyButtonPressed = true;
            }
                break;


            case R.id.buttonMm:
            if(anyButtonPressed){
                if (!isOperatorSelected) {    // if no operator presently selected
                    if(!calculated){
                        if (!number.equals("")) {
                            if(number.equals(".") || number.equals("-.")) numbers.add("0.0");
                            else numbers.add(number);
                            number = "";
                        }
                    }else{
                        numbers.set(0, number);
                        calculated = false;
                    }
                    number = "";
                    operators.add('*');
                    textDisplay += buttonMul.getText();
                    textView.setText(textDisplay);
                    isOperatorSelected = true;
                } else {
                    operators.set(operators.size() - 1, '*');
                    textDisplay = textDisplay.substring(0, textDisplay.length() - 1) + "*";
                    textView.setText(textDisplay);
                }
                anyButtonPressed = true;
            }
                break;


            case R.id.buttonP:
            if(anyButtonPressed){
                if (!isOperatorSelected) {
                    if(!calculated){
                        if (!number.equals("")) {
                            if(number.equals(".")|| number.equals("-.")) numbers.add("0.0");
                            else numbers.add(number);
                            number = "";
                        }
                    }else{
                        numbers.set(0, number);
                        calculated = false;
                    }
                    number = "";
                    operators.add('+');
                    textDisplay += buttonAdd.getText();
                    textView.setText(textDisplay);
                    isOperatorSelected = true;
                } else {
                    operators.set(operators.size() - 1, '+');
                    textDisplay = textDisplay.substring(0, textDisplay.length() - 1) + "+";
                    textView.setText(textDisplay);
                }
                anyButtonPressed = true;
            }
                break;


            case R.id.buttonM:
            if(anyButtonPressed){
                if (!isOperatorSelected) {
                    if(!calculated){
                        if (!number.equals("")) {
                            if(number.equals(".")|| number.equals("-.")) numbers.add("0.0");
                            else numbers.add(number);
                            number = "";
                        }
                    }else{
                        numbers.set(0, number);
                        calculated = false;
                    }
                    number = "";
                    operators.add('-');
                    textDisplay += buttonSub.getText();
                    textView.setText(textDisplay);
                    isOperatorSelected = true;
                } else {
                    operators.set(operators.size() - 1, '-');
                    textDisplay = textDisplay.substring(0, textDisplay.length() - 1) + "-";
                    textView.setText(textDisplay);
                }
                anyButtonPressed = true;
            }else{
                number += "-";
                textDisplay += "-"; textView.setText(textDisplay);
                anyButtonPressed = true;
            }

                break;


            case R.id.buttonD:
            if(anyButtonPressed){
                if (!isOperatorSelected) {
                    if(!calculated){
                        if (!number.equals("")) {
                            if(number.equals(".")|| number.equals("-.")) numbers.add("0.0");
                            else numbers.add(number);
                            number = "";
                        }
                    }else{
                        numbers.set(0, number);
                        calculated = false;
                    }
                    number = "";
                    operators.add('÷');
                    textDisplay += buttonDiv.getText();
                    textView.setText(textDisplay);
                    isOperatorSelected = true;
                } else {
                    operators.set(operators.size() - 1, '÷');
                    textDisplay = textDisplay.substring(0, textDisplay.length() - 1) + "÷";
                    textView.setText(textDisplay);
                }
                anyButtonPressed = true;
            }
                break;


            case R.id.buttonPr:
            if(anyButtonPressed){
                if (!isOperatorSelected) {
                    if(!calculated){
                        if (!number.equals("")) {
                            if(number.equals(".")|| number.equals("-.")) numbers.add("0.0");
                            else numbers.add(number);
                            number = "";
                        }
                    }else{
                        numbers.set(0, number);
                        calculated = false;
                    }
                    number = "";
                    operators.add('^');
                    textDisplay += buttonPow.getText();
                    textView.setText(textDisplay);
                    isOperatorSelected = true;
                } else {
                    operators.set(operators.size() - 1, '^');
                    textDisplay = textDisplay.substring(0, textDisplay.length() - 1) + "^";
                    textView.setText(textDisplay);
                }
                anyButtonPressed = true;
            }
                break;


            case R.id.buttonC:
                numbers = new ArrayList<>(); operators = new ArrayList<>(); number = "";
                textDisplay = ""; textView.setText("0");
                anyButtonPressed = false;
                calculated = false;
                break;


            case R.id.buttonX:
                if(textDisplay.length() == 1 && (textDisplay.equals("0"))){}
                else if(textDisplay.length() != 0){
                    // get the last character from text View
                    char CharToBeRemoved = textDisplay.charAt(textDisplay.length() - 1);
                    // if the character is an operator; remove the operator from list
                    if (operators.contains(CharToBeRemoved)) operators.remove((Character) CharToBeRemoved);
                    // else remove from the last digit
                    else {
                        if(number.length()==0){ // case -- altering a number already stored in numbers
                            number = numbers.get(numbers.size() - 1);
                            number = number.substring(0, number.length() - 1);
                            numbers.set(numbers.size() - 1, number);
                            }
                        else{ // case -- altering a number that not yet exist in numbers
                            number = number.substring(0, number.length() - 1);
                        }

                    }
                    // update the text of text view
                    textDisplay = textDisplay.substring(0, textDisplay.length() - 1);
                    textView.setText(textDisplay);
                    if(isOperatorSelected) isOperatorSelected = false;
                    anyButtonPressed = true;
                }
                break;


            case R.id.buttonE:
                if((operators.size() == numbers.size()) && !(number.equals("")) && !calculated){
                    if(!calculated)
                        if(number.equals(".")) numbers.add("0.0");
                        else numbers.add(number);
                int numberOfCalculations = operators.size();
                for (int index = 0; index < numberOfCalculations; index++) {
                    if (operators.contains('^')) {
                        ArrayList<Integer> indexes = new ArrayList<>();
                        for (int i = 0; i < operators.size(); i++) {
                            if ((operators.get(i)).equals('^')) indexes.add(Integer.valueOf(i));
                        }
                        int indexOfOperator;
                        if (indexes.size() == 1) indexOfOperator = indexes.get(0);
                        else indexOfOperator = arithmetic.maxIndex(indexes);
                        try {
                            int num1 = Integer.parseInt(numbers.get(indexOfOperator));
                            int num2 = Integer.parseInt(numbers.get(indexOfOperator + 1));
                            try {
                                long exponent = arithmetic.exponent(num1, num2);
                                numbers.set(indexOfOperator, String.valueOf(exponent));
                            } catch (Exception e) {
                                numbers.set(indexOfOperator, String.valueOf(Double.POSITIVE_INFINITY));
                            }
                        } catch (Exception exception) {
                            double exponent = arithmetic.exponent(Double.parseDouble(numbers.get(indexOfOperator)),
                                    Double.parseDouble(numbers.get(indexOfOperator + 1)));
                            numbers.set(indexOfOperator, String.valueOf(exponent));
                        }
                        numbers.remove(indexOfOperator + 1);
                        operators.remove(indexOfOperator);
                        calculated = true;

                    } else if (operators.contains('*') || operators.contains('÷')) {
                        int indexOfOperator1 = operators.indexOf('*');
                        int indexOfOperator2 = operators.indexOf('÷');
                        int indexOfOperator;
                        if (indexOfOperator1 == -1) indexOfOperator = indexOfOperator2;
                        else if (indexOfOperator2 == -1) indexOfOperator = indexOfOperator1;
                        else indexOfOperator = Math.min(indexOfOperator1, indexOfOperator2);

                        if (operators.get(indexOfOperator).equals('*')) {
                            try {
                                int product = arithmetic.multiply(Integer.parseInt(numbers.get(indexOfOperator)),
                                        Integer.parseInt(numbers.get(indexOfOperator + 1)));
                                numbers.set(indexOfOperator, String.valueOf(product));
                            } catch (Exception exception) {
                                double product = arithmetic.multiply(Double.parseDouble(numbers.get(indexOfOperator)),
                                        Double.parseDouble(numbers.get(indexOfOperator + 1)));
                                numbers.set(indexOfOperator, String.valueOf(product));
                            }
                            operators.remove(Character.valueOf('*'));
                        } else {
                            double quotient = arithmetic.divide(Double.parseDouble(numbers.get(indexOfOperator)),
                                    Double.parseDouble(numbers.get(indexOfOperator + 1)));
                            numbers.set(indexOfOperator, String.valueOf(quotient));
                            operators.remove(Character.valueOf('÷'));
                        }
                        numbers.remove(indexOfOperator + 1);
                        calculated = true;
                    } else {
                        int indexOfOperator1 = operators.indexOf('+');
                        int indexOfOperator2 = operators.indexOf('-');
                        int indexOfOperator;
                        if (indexOfOperator1 == -1) indexOfOperator = indexOfOperator2;
                        else if (indexOfOperator2 == -1) indexOfOperator = indexOfOperator1;
                        else indexOfOperator = Math.min(indexOfOperator1, indexOfOperator2);

                        if (operators.get(indexOfOperator).equals('+')) {
                            try {
                                int sum = arithmetic.add(Integer.parseInt(numbers.get(indexOfOperator)),
                                        Integer.parseInt(numbers.get(indexOfOperator + 1)));
                                numbers.set(indexOfOperator, String.valueOf(sum));
                            } catch (Exception exception) {
                                double sum = arithmetic.add(Double.parseDouble(numbers.get(indexOfOperator)),
                                        Double.parseDouble(numbers.get(indexOfOperator + 1)));
                                numbers.set(indexOfOperator, String.valueOf(sum));
                            }
                            operators.remove(Character.valueOf('+'));
                        } else {
                            try {
                                int diff = arithmetic.subtract(Integer.parseInt(numbers.get(indexOfOperator)),
                                        Integer.parseInt(numbers.get(indexOfOperator + 1)));
                                numbers.set(indexOfOperator, String.valueOf(diff));
                            } catch (Exception exception) {
                                double diff = arithmetic.subtract(Double.parseDouble(numbers.get(indexOfOperator)),
                                        Double.parseDouble(numbers.get(indexOfOperator + 1)));
                                numbers.set(indexOfOperator, String.valueOf(diff));
                            }
                            operators.remove(Character.valueOf('-'));
                        }
                        numbers.remove(indexOfOperator + 1);
                        calculated = true;
                    }
                }   isOperatorSelected = false;
                    number = numbers.get(0);
                    textDisplay = numbers.get(0);
                    textView.setText(textDisplay);
            }
            default:
                break;
        }// end switch
    }// end OnClick method
}// end public class
