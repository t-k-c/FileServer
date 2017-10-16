/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileserver;

import java.awt.Color;

/**
 *
 * @author Codename-tkc
 */
class ValueReactor {
    static Boolean isServerOn=false;
    static String serverstatus="Off";
   static Color hovercolor  = new Color(51,181,229);
static Color normalcolor = new Color(0,153,204);
static Color rednormalcolor =new Color(172,0,0);
static Color redhovercolor= new Color(233,8,8);
    public ValueReactor(){
    }
    public static void serverIsOn(){
    isServerOn=true;
    serverstatus="On";
    }
     public static void serverIsOff(){
    isServerOn=false;
    serverstatus="Off";
    }
    public static boolean isServerOn(){  
        return isServerOn;
    }
    public static Color getNormalColor(){
        Color co;
    if(isServerOn()){
    co=normalcolor;
    }
    else{
       co=rednormalcolor; 
    }
    return co;
    }
    static public Color getHoveredColor(){
       Color co;
    if(isServerOn()){
    co=hovercolor;
    }
    else{
       co=redhovercolor; 
    }
    return co;
    }
    public static String getServerStatus(){
        String status;
    if(isServerOn()){
    status ="On";
    }
    else{
    status="Off";
    }
    return status;
    }
    }
    
//      text+=",\"ext\":\""+myext+"\",\"Date\":\""+new Date(files[i].lastModified())+"\"}";
//      
//       }
//      else{
//       text+=",\"ext\":\"\"}";   
//      }
//      if(i!=files.length-1){
//      text+=",\n";
//      }
//   
//      text+="{\"Name\":\""+files[i].getName()+"\",\"IsFile\":\""+files[i].isFile()+"\",\"size\":\""+makePresentable(files[i].length())+"\",\"path\":\""+files[i].getAbsolutePath().replace("\\","\\\\")+"\"";
//      if(files[i].isFile()){