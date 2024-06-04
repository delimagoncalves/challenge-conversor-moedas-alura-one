package br.com.aluraone.conversordemoedas.util;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import java.util.Map;

public class ObjetoJSONtoMAP {


    public String converteJSONParaMap(JsonElement req_result, String moeda){
        Gson gson = new Gson();
        TypeToken<Map<String, String>> mapType = new TypeToken<Map<String, String>>(){};
        Map<String, String> stringMap = gson.fromJson(req_result, mapType);
        return stringMap.get(moeda);
    }

}
