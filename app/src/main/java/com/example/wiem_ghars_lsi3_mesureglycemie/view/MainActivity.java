package com.example.wiem_ghars_lsi3_mesureglycemie.view;

import com.example.wiem_ghars_lsi3_mesureglycemie.controller.Controller;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import com.example.wiem_ghars_lsi3_mesureglycemie.R;

public class MainActivity extends AppCompatActivity {
    //attributs
    private EditText etVal;
    private Button btn;
    private SeekBar sbAge;
    private TextView tvAge;
    private RadioButton rbtnYes, rbtnNo;
    private final int REQUEST_CODE=1;
    //private Controller controller=new Controller();
    private Controller controller = Controller.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        //Listener Seekbar
        sbAge.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        Log.i("Information", "On Progress Change" + i);
                        tvAge.setText("Votre Age :" + i);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );
        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        int age;
                        float valMesuree;
                        boolean verifAge = false, verifVal = false;
                        if (sbAge.getProgress() != 0)
                            verifAge = true;
                        else
                            Toast.makeText(MainActivity.this, "veuillez verifier votre age", Toast.LENGTH_SHORT).show();
                        if (!etVal.getText().toString().isEmpty())
                            verifVal = true;
                        else
                            Toast.makeText(MainActivity.this, "veuillez verifier votre valeur mesuree", Toast.LENGTH_LONG).show();
                        if (verifAge && verifVal) {
                            age = sbAge.getProgress();
                            valMesuree = Float.valueOf(etVal.getText().toString());
                            boolean isFasting = rbtnYes.isChecked();
                            //user action view--> controller
                            controller.createPatient(age,valMesuree,isFasting);
                            //controller --> view
                            //tvRes.setText(controller.getResult())
                            Intent intent=new Intent(MainActivity.this,ConsultActivity.class);
                            intent.putExtra("Reponse",controller.getResult());
                            startActivityForResult(intent,REQUEST_CODE);
                        }


                    }
                }
        );

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_CODE)
            if (resultCode==RESULT_CANCELED)
                Toast.makeText(MainActivity.this,"Error(resultat est null)",Toast.LENGTH_SHORT).show();

    }

    private void init() {
        etVal = (EditText) findViewById(R.id.etVal);
        sbAge = (SeekBar) findViewById(R.id.sbAge);
        btn = (Button) findViewById(R.id.btnConculter);
        tvAge = (TextView) findViewById(R.id.textAge);
        rbtnYes = (RadioButton) findViewById(R.id.rbtOui);
        rbtnNo = (RadioButton) findViewById(R.id.rbtNon);

    }


    }




