/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw;

import java.util.Map;

/**
 *
 * @author danielagonzalez
 */
public class Consult {
    
    private Map<String,String> metaData;
    private Map<String, Map<String,String>> timeSeries;
    
    public Map<String,String> getMetaData(){
        return metaData;
    }
    
    public Map<String, Map<String,String>> getTimeSeries(){
        return timeSeries;
    }
    
    public void setMetaData(Map<String,String> metaData){
        this.metaData = metaData;
    }
    
    public void setTimeSeries(Map<String, Map<String,String>> timeSeries){
        this.timeSeries = timeSeries;
    }
}
