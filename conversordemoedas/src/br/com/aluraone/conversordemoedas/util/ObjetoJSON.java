package br.com.aluraone.conversordemoedas.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class ObjetoJSON{

    public JsonElement pegaObjetoJSON(HttpURLConnection request) throws IOException {
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();
        JsonElement req_result = jsonobj.get("conversion_rates");
        return req_result;
    }
}
