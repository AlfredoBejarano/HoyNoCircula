package com.alfredobejarano.hoynocircula.utils;

import android.support.annotation.NonNull;
import android.util.Log;

import com.alfredobejarano.hoynocircula.R;
import com.alfredobejarano.hoynocircula.dto.Dia;

import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Alfredo on 24/03/2017.
 */

public class DiaUtils {
    public DiaUtils() { /* codigo generado automaticamente */ }

    public Dia getToday() throws IOException {
        Document document = new Scrapper().scrapURL(Scrapper.GOB_URL);

        Dia dia =  new Dia("0","0",0);

        dia.setTerminaciones(getTerminacionesFromText(document.getElementsByClass("today").attr("title")));
        dia.setColor(getDayColor(document.getElementsByClass("today").attr("class")));
        dia.setHologramas(getHologramasFromText(document.getElementsByClass("today").attr("title")).toString());

        return dia;
    }

    public int getDayColor(@NonNull String htmlClass) {
        if(htmlClass.contains("mon")) {
            return R.color.mon;
        } else if(htmlClass.contains("tue")) {
            return R.color.tue;
        } else if(htmlClass.contains("thu")) {
            return R.color.thu;
        } else if(htmlClass.contains("fri")) {
            return R.color.fri;
        } else {
            return R.color.wed;
        }
    }

    public String getTerminacionesFromText(@NonNull  String text) {
        Pattern pattern = Pattern.compile("\\d,\\d");
        Matcher matcher = pattern.matcher(text);

        return matcher.find() ? matcher.group() : "";
    }

    public String getHologramasFromText(@NonNull  String text) {
        Pattern pattern = Pattern.compile("[0-9]:");
        Matcher matcher = pattern.matcher(text);

        String hologramas = "";
        while (matcher.find()) {
            hologramas = hologramas+matcher.group().charAt(0);
        }
        return hologramas;
    }
}
