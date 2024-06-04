package br.com.aluraone.conversordemoedas.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class RealizaConexao {

    public HttpURLConnection pegaConexao(String urlapi, String moeda) throws IOException {
        String url_str = urlapi+moeda;
        URL url = new URL(url_str);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();
        return request;
    }
}
