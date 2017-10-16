/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileserver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 *
 * @author codename-tkc
 */
public class SettingsManager {
    
    public static final String READ_WRITE_ACCESS = "rwa";
    public static final String READ_WRITE_ACCESS_READ = "rwar";
    public static final String READ_WRITE_ACCESS_WRITE = "rwaw";
    public static final String CUSTOM_PORT_STATUS = "cps";
    public static final String CUSTOM_PORT_STATUS_ON = "cpson";
    public static final String CUSTOM_PORT_STATUS_OFF = "cpsoff";
    public static final String CUSTOM_PORT = "cp";
    public static final String AUTH_ACCESS = "aa";
    public static final String AUTH_ACCESS_TRUE = "aat";
    public static final String AUTH_ACCESS_FALSE = "aaf";
    public static final String AUTH_ACCESS_PASS= "aap";
    public static final String INACCESSIBLE_DATA = "iad";
    private static final String SETTINGS_FILE_PATH="src/fileserver/settings/config.fs";
       /**
     * returns the whole settings data content
     * could return null in case file reading generates an error
     * @return 
     */ 
    public static String readSettingsFile(){
    File file = new File(SETTINGS_FILE_PATH);
       String res=null;
               try {
        try (FileReader fileReader = new FileReader(file)) {
            char[] chars = new char[(int)file.length()];
            fileReader.read(chars, 0, chars.length);
            res = String.copyValueOf(chars);
        }
        } catch (FileNotFoundException ex) {
            echo(ex.getMessage());
        } catch (IOException ex) {
            echo(ex.getMessage());
        }
       return res;
    }
    public static void echo(String text){
        System.out.println(text);
    }
    /**
     * returns the whole settings data content
     * could return INACCESSIBLE_DATA in case file reading generates an error
     * @return 
     */
    public static String readSettings(){
        String response=INACCESSIBLE_DATA;
        String fileData = readSettingsFile();
        if(fileData !=null){
         response = fileData;
        }
        return fileData;
    }
    /**
     * 
     * @param setting
     * INACCESSIBLE_DATA is returned in case of error generation
     * @return String
     */
    public static String readSetting(String setting){
       String settings = readSettings();
       String response = INACCESSIBLE_DATA;
       if(!settings.equals(INACCESSIBLE_DATA)){
           {
             try
             {
                String[] settingsSplit = settings.split("\n");
                
                 if(setting.equals(READ_WRITE_ACCESS)){
                     //Read Operation
                     if("1".equals(settingsSplit[0])){
                         response = READ_WRITE_ACCESS_WRITE;
                     }
                     //write operation
                     else{
                         response = READ_WRITE_ACCESS_READ;
                     }
                 } 
                 if(setting.equals(AUTH_ACCESS)){
                          //Auth On
                     if("1".equals(settingsSplit[1])){
                         response = AUTH_ACCESS_TRUE;
                     }
                           //Auth Off
                     else{
                         response = AUTH_ACCESS_FALSE;
                 }
                 }

                if(setting.equals(AUTH_ACCESS_PASS)){
                     if(readSetting(AUTH_ACCESS).equals(AUTH_ACCESS_TRUE)){
                         response = settingsSplit[2];
                     }
                     else{
                         response = AUTH_ACCESS_FALSE;
                     }
                 }

               
                 if(setting.equals(CUSTOM_PORT_STATUS)){
                     //custom port on
                     if("1".equals(settingsSplit[3])){
                         response =  CUSTOM_PORT_STATUS_ON;
                     }
                     //custom port off
                     else{
                         response =  CUSTOM_PORT_STATUS_OFF;
                     }
                 }
                 
                 if(setting.equals(CUSTOM_PORT)){
                     if(readSetting(CUSTOM_PORT_STATUS).equals(CUSTOM_PORT_STATUS_ON)){
                         response = settingsSplit[4];
                     }
                     else{
                         response =  CUSTOM_PORT_STATUS_OFF;
                     }
                 }
               
             }
             catch(ArrayIndexOutOfBoundsException | NullPointerException e){
                 echo (e.getMessage());
             }
       }
       }
       return response;
    }
   public static boolean setWritable(boolean bool){
       return writeSettings(bool ? "1" : "0",null,null,null,null);        
   }
      public static boolean setAuthAccess(boolean bool,String value){
       return writeSettings(null,bool ? "1" : "0", bool ? value : null ,null,null);        
   }
      public static boolean setCustomPort(boolean bool,String value){
       return writeSettings(null,null,null,bool ? "1" : "0", bool ? value : null );        
   }
      
    private static boolean writeSettings(String readWriteAccess, 
                String authaccess,
                String authaccesspass, 
                String customportstatus,
                String customportvalue
                 ){
        boolean operationDone = false;
        String fileData[] = readSettingsFile().split("\n"); 
                try{                   
                   if(fileData!=null){
                    if(customportstatus!=null){
                        Array.set(fileData, 3, customportstatus);
                    }
                    if(customportvalue!=null){
                        try{
                           int customport =  Integer.parseInt(customportvalue);
                           if(customport  <= 60000){
                               Array.set(fileData,4,customportvalue);
                           }
                        }
                        catch(NumberFormatException e){
                           
                        }
                    }
                    if(readWriteAccess!=null){
                        Array.set(fileData,0,readWriteAccess); 
                    }
                    if(authaccesspass!=null){
                        Array.set(fileData,2,authaccesspass);
                    }
                    if(authaccess!=null){
                     Array.set(fileData,1,authaccess);   
                    }
                    }
                }catch(ArrayIndexOutOfBoundsException | NullPointerException | IllegalArgumentException e){
                    echo (e.getMessage());
                    return false;
                }
                if(!Arrays.equals(fileData, readSettingsFile().split("\n"))){
               
               File file= new File(SETTINGS_FILE_PATH);                
            try {
                try(FileWriter fw = new FileWriter(file)){
                fw.write(String.join("\n", fileData).toCharArray());
                operationDone=true;
                }
            } catch (IOException ex) {
               echo(ex.getMessage());
            }
                }
        return operationDone;
    }

//    public static void main(String args[]){
//    echo (writeSettings(null,null,null,null,null)+"");
//    public static String READ_WRITE_ACCESS = "rwa";
//    public static String READ_WRITE_ACCESS_READ = "rwar";
//    public static String READ_WRITE_ACCESS_WRITE = "rwaw";
//    public static String CUSTOM_PORT_STATUS = "cps";
//    public static String CUSTOM_PORT_STATUS_ON = "cpson";
//    public static String CUSTOM_PORT_STATUS_OFF = "cpsoff";
//    public static String CUSTOM_PORT = "cp";
//    public static String AUTH_ACCESS = "aa";
//    public static String AUTH_ACCESS_TRUE = "aat";
//    public static String AUTH_ACCESS_FALSE = "aaf";
//    public static String AUTH_ACCESS_PASS= "aap";
//    public static String INACCESSIBLE_DATA = "iad";
//    }
}
