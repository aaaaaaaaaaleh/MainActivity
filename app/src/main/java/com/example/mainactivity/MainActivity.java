package com.example.mainactivity;
//Letícia Castelo e Vitória Hilgert
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private class EscutadorFecharOK implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            finish();
            Toast.makeText(getApplicationContext(), "Saindo...", Toast.LENGTH_SHORT).show();
        }
    }

    private class EscutadorFecharCancela implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
            Toast.makeText(getApplicationContext(), "Cancelando...", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.meumenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menAct1:
                Intent i1 = new Intent(getApplicationContext(), CalcularMedia.class);
                startActivity(i1);
                return true;
            case R.id.menAct2:
                AlertDialog.Builder fechar = new AlertDialog.Builder(MainActivity.this);
                fechar.setTitle("SAIR DO APLICATIVO");
                fechar.setMessage("Deseja mesmo sair?");
                fechar.setPositiveButton("Sair", new EscutadorFecharOK());
                fechar.setNegativeButton("Cancelar", new EscutadorFecharCancela());
                fechar.setCancelable(false);
                fechar.create();
                fechar.show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}