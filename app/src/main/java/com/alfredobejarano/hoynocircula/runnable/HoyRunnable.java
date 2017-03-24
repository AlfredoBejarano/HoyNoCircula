package com.alfredobejarano.hoynocircula.runnable;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alfredobejarano.hoynocircula.R;
import com.alfredobejarano.hoynocircula.dto.Dia;
import com.alfredobejarano.hoynocircula.utils.DiaUtils;
import com.alfredobejarano.hoynocircula.utils.DrawableHelper;

import java.io.IOException;

/**
 * Created by Alfredo on 24/03/2017.
 */

public class HoyRunnable implements Runnable {
    private Dia dia;
    private Activity activity;
    private View[] views;

    public HoyRunnable(@NonNull Activity activity, @NonNull View[] views) {
        this.activity = activity;
        this.views = views;
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
            Dia hoy = new Dia();

            hoy.setTitle("No se pudo obtener el dia");
            hoy.setColor(R.color.colorAccent);

            dia = hoy;
        }

        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ((TextView)views[0]).setText(dia.getTitle());

                Drawable drawable = DrawableHelper
                        .withContext(activity)
                        .withColor(dia.getColor())
                        .withDrawable(R.drawable.ic_engomado)
                        .tint()
                        .get();

                ((ImageView)views[1]).setImageDrawable(drawable);
            }
        });
    }
}
