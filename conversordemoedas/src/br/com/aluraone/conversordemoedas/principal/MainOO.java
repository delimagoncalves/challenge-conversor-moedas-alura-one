package br.com.aluraone.conversordemoedas.principal;

import br.com.aluraone.conversordemoedas.modelo.Menu;
import br.com.aluraone.conversordemoedas.util.ConversaoDeValor;
import br.com.aluraone.conversordemoedas.util.ObjetoJSON;
import br.com.aluraone.conversordemoedas.util.ObjetoJSONtoMAP;
import br.com.aluraone.conversordemoedas.util.RealizaConexao;
import com.google.gson.JsonElement;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Scanner;

public class MainOO
{
    public static void main(String[] args) {

        String url = "https://v6.exchangerate-api.com/v6/b81c8d3cf263971637ad94f3/latest/";

        Scanner scanner = new Scanner(System.in);
        RealizaConexao realizaConexao = new RealizaConexao();
        ObjetoJSON objetoJSON = new ObjetoJSON();
        Menu menu = new Menu();
        ConversaoDeValor conversaoDeValor = new ConversaoDeValor();

        try {

            String moedaBase = "";
            String moedaConvertida = "";
            int opcao = 0;

            while(opcao != 7){

                opcao = menu.exibeMenu();
                if(opcao == 7) break;

                switch (opcao){
                    case 1:
                        moedaBase = "USD";
                        moedaConvertida = "BRL";
                        break;
                    case 2:
                        moedaBase = "BRL";
                        moedaConvertida = "USD";
                        break;
                    case 3:
                        moedaBase = "EUR";
                        moedaConvertida = "BRL";
                        break;
                    case 4:
                        moedaBase = "BRL";
                        moedaConvertida = "EUR";
                        break;
                    case 5:
                        moedaBase = "JPY";
                        moedaConvertida = "BRL";
                        break;
                    case 6:
                        moedaBase = "BRL";
                        moedaConvertida = "JPY";
                        break;
                    default:
                        System.out.println("Opção Inválida");
                        break;
                }
                if(!moedaBase.equals("") && !moedaConvertida.equals("")){

                    double valorDigitado = menu.pegaValor(scanner);
                    HttpURLConnection request = realizaConexao.pegaConexao(url,moedaBase);
                    JsonElement jsonElement = objetoJSON.pegaObjetoJSON(request);
                    ObjetoJSONtoMAP objetoJSONtoMAP = new ObjetoJSONtoMAP();
                    Double valorDaMoeda = Double.parseDouble(objetoJSONtoMAP.converteJSONParaMap(jsonElement, moedaConvertida));
                    conversaoDeValor.realizaConversao(opcao, valorDaMoeda,valorDigitado,moedaConvertida,moedaBase);

                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
