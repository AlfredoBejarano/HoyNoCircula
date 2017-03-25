package com.alfredobejarano.hoynocircula.view;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alfredobejarano.hoynocircula.R;
import com.alfredobejarano.hoynocircula.dto.Dia;
import com.alfredobejarano.hoynocircula.runnable.HoyRunnable;

public class MainActivity extends AppCompatActivity {

    private Dia dia;
    private TextView title;
    private ImageView engomado;
    private TextView hologramas;
    private RelativeLayout placa;
    private ProgressBar progressBar;

    public void setup(Dia dia) {
        title.setText("Terminaciones: " + "\n" + dia.getTerminaciones());
        engomado.setBackgroundColor(getResources().getColor(dia.getColor()));
        hologramas.setText("Hologramas: " + dia.getHologramas().charAt(0) + ", " + dia.getHologramas().charAt(1));
        this.dia = dia;
        progressBar.setVisibility(View.GONE);
        findViewById(R.id.loading_text).setVisibility(View.GONE);
        placa.setVisibility(View.VISIBLE);
    }

    private void initComponents() {
        placa = (RelativeLayout) findViewById(R.id.placa);
        engomado = (ImageView) findViewById(R.id.engomado);
        title = (TextView) findViewById(R.id.terminaciones);
        hologramas = (TextView) findViewById(R.id.hologramas);
        progressBar = (ProgressBar) findViewById(R.id.loading);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();

        if(savedInstanceState == null) {
            HoyRunnable runnable = new HoyRunnable(this);
            new Thread(runnable).start();
        } else {
            String[] valores = savedInstanceState.getStringArray("today");
            dia = new Dia(valores[0], valores[1], savedInstanceState.getInt("color"));
            setup(dia);
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        if(dia != null) {
            outState.putInt("color", dia.getColor());
            outState.putStringArray("today", new String[]{dia.getTerminaciones(), dia.getHologramas()});
        }
        super.onSaveInstanceState(outState);
    }
}
