package com.example.riza.Score;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView txtScoreA;
    TextView txtScoreB;

    int scoreA = 0, scoreB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button p3A = (Button) findViewById(R.id.p3_A);
        Button p2A = (Button) findViewById(R.id.p2_A);
        Button ftA = (Button) findViewById(R.id.ft_A);
        Button p3B = (Button) findViewById(R.id.p3_B);
        Button p2B = (Button) findViewById(R.id.p2_B);
        Button ftB = (Button) findViewById(R.id.ft_B);
        Button btnRes = (Button) findViewById(R.id.btn_reset);

        p3A.setOnClickListener(this);
        p2A.setOnClickListener(this);
        ftA.setOnClickListener(this);
        p3B.setOnClickListener(this);
        p2B.setOnClickListener(this);
        ftB.setOnClickListener(this);
        btnRes.setOnClickListener(this);

        txtScoreA = (TextView) findViewById(R.id.txt_A);
        txtScoreB = (TextView) findViewById(R.id.txt_B);

        if (savedInstanceState != null) {
            scoreA = savedInstanceState.getInt("scoreA");
            scoreB = savedInstanceState.getInt("scoreB");
        }
        updateScore();
    }

    public void updateScore(){
        txtScoreA.setText(String.valueOf(scoreA));
        txtScoreB.setText(String.valueOf(scoreB));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ft_A:
                scoreA++;
                break;
            case R.id.p2_A:
                scoreA+=2;
                break;
            case R.id.p3_A:
                scoreA+=3;
                break;
            case R.id.ft_B:
                scoreB++;
                break;
            case R.id.p2_B:
                scoreB+=2;
                break;
            case R.id.p3_B:
                scoreB+=3;
                break;
            case R.id.btn_reset:
                askReset();
                break;
        }
        updateScore();
    }

    public void askReset(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Do you want to reset ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                scoreA =0;
                scoreB = 0;
                updateScore();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        savedInstanceState.putInt("scoreA", scoreA);
        savedInstanceState.putInt("scoreB", scoreB);
        super.onSaveInstanceState(savedInstanceState);
    }
}
