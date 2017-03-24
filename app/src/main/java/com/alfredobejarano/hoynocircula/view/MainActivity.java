package com.alfredobejarano.hoynocircula.view;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alfredobejarano.hoynocircula.R;
import com.alfredobejarano.hoynocircula.dto.Dia;
import com.alfredobejarano.hoynocircula.runnable.HoyRunnable;
import com.alfredobejarano.hoynocircula.utils.DiaUtils;
import com.alfredobejarano.hoynocircula.utils.Scrapper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView title;
    private ImageView engomado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = (TextView) findViewById(R.id.test);
        engomado = (ImageView) findViewById(R.id.engomado);

        HoyRunnable runnable = new HoyRunnable(this, new View[] {title, engomado});
        new Thread(runnable).start();

    }
}
