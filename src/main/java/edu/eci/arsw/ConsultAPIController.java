/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author danielagonzalez
 */
@RestController
@RequestMapping("/consult")
public class ConsultAPIController {

    @Autowired
    private HttpConnection APIconnection;
  
    @RequestMapping(method = RequestMethod.GET,value = "/{idaccion}/{valoracion}")
    JsonObject consult(@PathVariable String idaccion, @PathVariable String valoracion) throws IOException{
        //System.out.println("ENTRA "+APIconnection.getAPI(idaccion, valoracion));
        //APIconnection.getAPI(idaccion, valoracion).isJsonObject();
        return APIconnection.getAPI(idaccion, valoracion);
    }
}

