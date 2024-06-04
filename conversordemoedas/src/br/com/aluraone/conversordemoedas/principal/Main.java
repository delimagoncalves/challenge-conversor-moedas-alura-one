package br.com.aluraone.conversordemoedas.principal;

import br.com.aluraone.conversordemoedas.modelo.Menu;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        String url_str = "https://v6.exchangerate-api.com/v6/b81c8d3cf263971637ad94f3/latest/EUR";
        URL url = new URL(url_str);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();

        JsonElement req_result = jsonobj.get("conversion_rates");
        System.out.println(req_result);

        Gson gson = new Gson();
        TypeToken<Map<String, String>> mapType = new TypeToken<Map<String, String>>(){};
        Map<String, String> stringMap = gson.fromJson(req_result, mapType);
        System.out.println(stringMap.get("USD"));

        double usd = Double.parseDouble(stringMap.get("USD"));
        //System.out.println("valor do USD"+usd);
        double brl = Double.parseDouble(stringMap.get("BRL"));
        //System.out.println("Valor do BRL"+brl);

        Scanner leitura = new Scanner(System.in);
        //System.out.println("Digite a opcao desejada:");


//        System.out.println("Digite o valor que deseja converter:");
//        double valor = Integer.parseInt(leitura.next());
//
//        if(opcao == 1){
//            System.out.println(valor+" USD corresponde ao valor final de => "+(brl*valor)+" BRL");
//
//        }else if(opcao == 2){
//            System.out.println(valor+" BRL corresponde ao valor final de => "+(valor/usd)+" USD");
//        }


        Menu menu = new Menu();
        menu.exibeMenu();
        int opcao = leitura.nextInt();

        while(opcao != 7){
            menu.exibeMenu();
            opcao = leitura.nextInt();
        }


    }
}
