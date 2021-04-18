package com.example.ciclopdm;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.InputType;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ciclopdm.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding activityMainBinding;

    private final String CICLO_PDM_TAG = "CICLO_PDM_TAG";

    private final String TELEFONE = "TELEFONE";

    private TextView telefoneTextView;
    private TextView telefoneEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        telefoneTextView = new TextView(this);
        telefoneTextView.setText("Telefone");
        telefoneEditText = new EditText(this);
        telefoneEditText.setInputType(InputType.TYPE_CLASS_PHONE);

        activityMainBinding.linearLayout.addView(telefoneTextView);
        activityMainBinding.linearLayout.addView(telefoneEditText);

        //if(savedInstanceState != null){
        //    telefoneEditText.setText(savedInstanceState.getString(TELEFONE, ""));
        //}

        Log.v(CICLO_PDM_TAG, "onCreate - Iniciando ciclo completo!");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.v(CICLO_PDM_TAG, "onDestroy - Finalizando ciclo completo!");
    }

    @Override
    public void onRestoreInstanceState(@Nullable Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        telefoneEditText.setText(savedInstanceState.getString(TELEFONE, ""));
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.v(CICLO_PDM_TAG, "onStart - Iniciando ciclo visivel!");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.v(CICLO_PDM_TAG, "onStop - Finalizando ciclo visivel!");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.v(CICLO_PDM_TAG, "onResume - Iniciando ciclo em primeiro plano(foreground)!");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.v(CICLO_PDM_TAG, "onPause - Finalizando ciclo em primeiro plano(foreground)!");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.v(CICLO_PDM_TAG, "onRestart - Preparando pra chamar o onStart!");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(TELEFONE, telefoneEditText.getText().toString());
    }

}