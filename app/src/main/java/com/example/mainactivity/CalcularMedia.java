package com.example.mainactivity;
//Letícia Castelo e Vitória Hilgert
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalcularMedia extends AppCompatActivity {
    private TextView txtNota1;
    private TextView txtNota2;
    private Button btnCalcular;
    private TextView lblMedia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_media);
        txtNota1 = findViewById(R.id.txtNota1);
        txtNota2 = findViewById(R.id.txtNota2);
        btnCalcular = findViewById(R.id.btnCalcular);
        lblMedia = findViewById(R.id.lblMedia);

        btnCalcular.setOnClickListener(new EscutadorBotaoCalcula());
    }

    class EscutadorBotaoCalcula implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            double n1 = Double.parseDouble(txtNota1.getText().toString());
            double n2 = Double.parseDouble(txtNota2.getText().toString());
            double media = (n1 + n2) /2;
            lblMedia.setText(Double.toString(media));
        }
    }
}