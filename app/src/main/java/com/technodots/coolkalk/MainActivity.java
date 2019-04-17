package com.technodots.coolkalk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String runningNumber="";

    public enum Operation{

        ADD,SUBTRACT,DIVIDE,MULTIPLY,EQUAL
    }

    TextView resultsView;
    String leftvalue="";
    String rightvalue="";
    Operation currentOperation;

    int results = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button0=(Button)findViewById(R.id.button0);
        Button button1=(Button)findViewById(R.id.button1);
        Button button2=(Button)findViewById(R.id.button2);
        Button button3=(Button)findViewById(R.id.button3);
        Button button4=(Button)findViewById(R.id.button4);
        Button button5=(Button)findViewById(R.id.button5);
        Button button6=(Button)findViewById(R.id.button6);
        Button button7=(Button)findViewById(R.id.button7);
        Button button8=(Button)findViewById(R.id.button8);
        Button button9=(Button)findViewById(R.id.button9);
        Button buttonadd=(Button)findViewById(R.id.buttonadd);
        Button buttonmul=(Button)findViewById(R.id.buttonmul);
        Button buttondiv=(Button)findViewById(R.id.buttondiv);
        Button buttonsub=(Button)findViewById(R.id.buttonsub);
        Button clear=(Button)findViewById(R.id.buttonclear);

        ImageButton eql=(ImageButton)findViewById(R.id.btneql);

        resultsView=(TextView)findViewById(R.id.results) ;
        resultsView.setText("");


        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(0);

            }
        });


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(1);

            }
        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(2);
            }
        });


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(3);
            }
        });




        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(4);
            }
        });




        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(5);
            }
        });


        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(6);
            }
        });



        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(7);
            }
        });



        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(8);
            }
        });



        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(9);
            }
        });



        buttonadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                procesOperation(Operation.ADD);

            }
        });




        buttonsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                procesOperation(Operation.SUBTRACT);

            }
        });


        buttondiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                procesOperation(Operation.DIVIDE);

            }
        });


        buttonmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                procesOperation(Operation.MULTIPLY);
            }
        });



        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                leftvalue="";
                rightvalue="";
                results=0;
                runningNumber="";
                currentOperation=null;
                resultsView.setText("0");

            }
        });


       eql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                procesOperation(Operation.EQUAL);
            }
        });

    }

    void procesOperation(Operation operation){
        if(currentOperation != null){

            if(runningNumber !=""){
                rightvalue = runningNumber;
                runningNumber="";

                switch (currentOperation){


                    case ADD:

                        results=Integer.parseInt(leftvalue) + Integer.parseInt(rightvalue);
                    break;
                    case MULTIPLY:
                        results=Integer.parseInt(leftvalue) * Integer.parseInt(rightvalue);
                        break;
                    case DIVIDE:
                        results=Integer.parseInt(leftvalue) / Integer.parseInt(rightvalue);
                        break;
                    case SUBTRACT:
                        results=Integer.parseInt(leftvalue) - Integer.parseInt(rightvalue);
                        break;
                }
                leftvalue=String.valueOf(results);
                resultsView.setText(leftvalue);
            }


        }else{

            leftvalue=runningNumber;
            runningNumber="";
            currentOperation=operation;
        }
        currentOperation=operation;

    }

    void numberPressed(int number){

        runningNumber += String.valueOf(number);
        resultsView.setText(runningNumber);

    }
}
