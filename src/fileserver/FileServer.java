/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileserver;

import java.io.IOException;
import java.net.ServerSocket;



/**
 *
 * @author Codename-tkc
 */
public class FileServer {

    /**
     */
    static public Intro intro;
    public static void main(String[] args) {
       try{
           String port;
           try (ServerSocket ss = new ServerSocket(
           !(port = SettingsManager.readSetting(SettingsManager.CUSTOM_PORT)).equals(SettingsManager.CUSTOM_PORT_STATUS_OFF)
                   ?  Integer.parseInt(port) : 1998                   
           )) {
               Intro.main(null);
           }
       }
       catch(IOException e){
           System.out.println("A server already active");
       }
    
    }
  
}
