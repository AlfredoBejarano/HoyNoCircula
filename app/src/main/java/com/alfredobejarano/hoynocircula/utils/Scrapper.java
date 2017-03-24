package com.alfredobejarano.hoynocircula.utils;

import android.support.annotation.NonNull;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by Alfredo on 24/03/2017.
 */

/**
 * Esta clase se encarga de todas las utilidades que se puedan requerir para hacer "scrapping" a una URL.
 */
public class Scrapper {
    public static final String ENCODING = "UTF-8";
    public static final String GOB_URL = "http://www.hoy-no-circula.com.mx/calendario";

    public Scrapper() { /* código generado autoomáticamente */ }

    /**
     * Este metodo se encarga de hacer  "Scrapping" a una URL y regresar el contenido en
     * un documento Jsoup.
     *
     * @param url - URL: la URL a "scrappear".
     * @return - String: El valor del contenido HTMl.
     * @throws IOException
     */
    public Document scrapURL(@NonNull String url) throws IOException {
        BufferedReader reader = null;
        StringBuilder builder = new StringBuilder();

        URL webUrl = new URL(url);

        try {
            reader = new BufferedReader(new InputStreamReader(webUrl.openStream(), ENCODING));
            for (String line; (line = reader.readLine()) != null; ) {
                builder.append(line);
            }

            return Jsoup.parse(String.valueOf(builder));
        } catch (Exception e) {
            e.printStackTrace();
            return Jsoup.parse(e.getLocalizedMessage());
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }
}
