/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileserver;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Codename-tkc
 */
public class FileServer {

    /**
     */
    static public Intro intro;
    public static void main(String[] args) {
        boolean anError=false;
       try{
           String port;
           try (ServerSocket ss = new ServerSocket(
           !(port = SettingsManager.readSetting(SettingsManager.CUSTOM_PORT)).equals(SettingsManager.CUSTOM_PORT_STATUS_OFF)
                   ?  Integer.parseInt(port) : 1998                   
           )) {
               
           }
       }
       catch(IOException e){
           anError = true;
                ServerIsRunning serverIsRunning = new ServerIsRunning();            
                Dimension dimension =  Toolkit.getDefaultToolkit().getScreenSize();
                int width = serverIsRunning.getWidth();
                int height = serverIsRunning.getHeight();
                Point point = new Point((int)(dimension.width-width)/2,(int)(dimension.height-height)/2);
                serverIsRunning.setLocation(point);
                serverIsRunning.setVisible(true);
       }
              
       if(!anError){
        try {
            FileWriter fw = new FileWriter("src/fileserver/AdminChecker/AdminChecker.startup");
            fw.write(("\n"+new Date().toString()).toCharArray());
        } catch (IOException ex) {
            anError=true;
                AdminModeExigence adminModeExigence = new AdminModeExigence();            
                Dimension dimension =  Toolkit.getDefaultToolkit().getScreenSize();
                int width = adminModeExigence.getWidth();
                int height = adminModeExigence.getHeight();
                Point point = new Point((int)(dimension.width-width)/2,(int)(dimension.height-height)/2);
                adminModeExigence.setLocation(point);
                adminModeExigence.setVisible(true);
        }
       }
       if(!anError){
           Intro.main(null);
       }
    }
  
}
