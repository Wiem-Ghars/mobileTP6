package com.example.wiem_ghars_lsi3_mesureglycemie;

import androidx.appcompat.app.AppCompatActivity;

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
    private TextView tvAge, tvRes;
    private RadioButton rbtnYes, rbtnNo;

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

                        calculer(view);

                    }
                }
        );

    }

    private void init() {
        etVal = (EditText) findViewById(R.id.etVal);
        sbAge = (SeekBar) findViewById(R.id.sbAge);
        btn = (Button) findViewById(R.id.btnConculter);
        tvAge = (TextView) findViewById(R.id.textAge);
        tvRes = (TextView) findViewById(R.id.resultat);
        rbtnYes = (RadioButton) findViewById(R.id.rbtOui);
        rbtnNo = (RadioButton) findViewById(R.id.rbtNon);

    }

    public void calculer(View v) {
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
            if (isFasting)
                if (age >= 13)
                    if (valMesuree < 5)
                        tvRes.setText("Niveau de glycemie est bas");
                    else if (valMesuree >= 5 && valMesuree <= 7.2)
                        tvRes.setText("Niveau de glycemie est normale");
                    else tvRes.setText("Niveau de glycemie est elevee");
                else if (age >= 6 && age <= 12)
                    if (valMesuree < 5)
                        tvRes.setText("Niveau de glycemie est bas");
                    else if (valMesuree >= 5 && valMesuree <= 10.0)
                        tvRes.setText("Niveau de glycemie est normale");
                    else tvRes.setText("Niveau de glycemie est elevee");
                else if (age < 6)
                    if (valMesuree < 5.5)
                        tvRes.setText("Niveau de glycemie est bas");
                    else if (valMesuree >= 5.5 && valMesuree <= 10.0)
                        tvRes.setText("Niveau de glycemie est normale");
                    else tvRes.setText("Niveau de glycemie est elevee");
                else if (valMesuree > 10.5)
                    tvRes.setText("Niveau elevee");
                else
                    tvRes.setText("Niveau de glycemie est normale");
        }

    }
}



