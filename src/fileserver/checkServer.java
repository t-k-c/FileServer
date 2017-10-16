/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileserver;

import java.io.IOException;
import java.net.Socket;
/**
 *
 * @author codename-tkc
 */
public class checkServer {
    public static Boolean serverIsActive(){
        Boolean result=false;
       String port;
           String theport =  !(port = SettingsManager.readSetting(SettingsManager.CUSTOM_PORT)).equals(SettingsManager.CUSTOM_PORT_STATUS_OFF)
                   ?  port : "1998" ;
        try {
            try (Socket socket = new Socket("127.0.0.1",Integer.parseInt(theport))) {
                result=true;
              
            }
            
        } catch (IOException ex) {
            
        }
        return result; 
    }
}
