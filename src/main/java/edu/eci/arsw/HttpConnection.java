/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.springframework.stereotype.Service;

/**
 *
 * @author danielagonzalez
 */
@Service
public class HttpConnection {

    //private static final String GET_URL = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=fb&apikey=Q1QZFVJQ21K7C6XM";

    public JsonObject getAPI(String identificador, String tipo) throws IOException {

        String GET_URL = "https://www.alphavantage.co/query?function="+tipo+"&symbol="+identificador+"&apikey=Q1QZFVJQ21K7C6XM";
        URL obj = new URL(GET_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        
        int responseCode = con.getResponseCode();
        
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            JsonParser jsonParser = new JsonParser();
            JsonObject res = jsonParser.parse(response.toString()).getAsJsonObject();
            //System.out.println(res.toString());
            return res;
        } else {
            String res = "GET request not worked";
            return null;
        }
    }

}