/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

/**
 *
 * @author danielagonzalez
 */
@Service
public class HttpConnection implements CommandLineRunner{
    
    private String tipo;
    private String identificador;
    private String respuesta;
    
    @Autowired
    private CustomerRepository repository;
    
    @Override
    public void run(String... args) throws Exception{
        
        try {
            if (repository.findByIdentifierAndType(identificador, tipo) == null){
                String GET_URL = "https://www.alphavantage.co/query?function="+tipo+"&symbol="+identificador+"&apikey=Q1QZFVJQ21K7C6XM";
                URL obj = new URL(GET_URL);
                HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                con.setRequestMethod("GET");

                int responseCode = con.getResponseCode();

                if (responseCode == HttpURLConnection.HTTP_OK) { // success
                    BufferedReader in = new BufferedReader(new InputStreamReader(
                            con.getInputStream()));
                    String inputLine;
                    StringBuffer response = new StringBuffer();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();

                    respuesta = response.toString();
                    repository.save(new Customer(identificador,respuesta,tipo));
                } else {
                    respuesta = "GET request not worked";
                }
            }else{
                respuesta = repository.findByIdentifierAndType(identificador, tipo).getData();
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(HttpConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HttpConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getAPI() throws IOException {
        return respuesta;
    }
    
    public void asignacion(String identificador, String tipo) throws IOException{
        this.identificador = identificador;
        this.tipo = tipo;
    }

}