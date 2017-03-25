package com.alfredobejarano.hoynocircula.runnable;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.alfredobejarano.hoynocircula.R;
import com.alfredobejarano.hoynocircula.dto.Dia;
import com.alfredobejarano.hoynocircula.utils.DiaUtils;
import com.alfredobejarano.hoynocircula.view.MainActivity;

import java.io.IOException;

/**
 * Created by Alfredo on 24/03/2017.
 */

public class HoyRunnable implements Runnable {
    private Dia dia;
    private Activity activity;

    public HoyRunnable(@NonNull Activity activity) {
        this.activity = activity;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {
        try {
            Dia hoy = new DiaUtils().getToday();
            dia = hoy;
        } catch (IOException e) {
            Dia hoy = new Dia("0", "0", 0);

            hoy.setTerminaciones("0,0");
            hoy.setColor(R.color.colorAccent);
            hoy.setHologramas("0");

            dia = hoy;
        }

        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ((MainActivity) activity).setup(dia);
            }
        });
    }
}
