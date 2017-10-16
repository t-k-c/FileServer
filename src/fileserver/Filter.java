/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileserver;

import java.io.File;

/**
 *
 * @author Codename-tkc
 */
class Filter {
    String args;
    public Filter(){
       
    }
    public static String getMusicFiles(File file){
        String response="";
        try{
        if(file.isFile()){
           String ext= new Mime(file).getExt();      
    if(ext.equals("webm")||ext.equals("mkv")||ext.equals("flv")||ext.equals("f4v")||ext.equals("vob")||ext.equals("ogg")||ext.equals("ogv")||ext.equals("drc")||ext.equals("gifv")||ext.equals("mng")||ext.equals("avi")||ext.equals("mov")||ext.equals("qt")||ext.equals("wmv")||ext.equals("yuv")||ext.equals("rm")||ext.equals("rmvb")||ext.equals("asf")||ext.equals("amv")||ext.equals("mp4")||ext.equals("m4p")||ext.equals("m4v")||ext.equals("mpg")||ext.equals("mp2")||ext.equals("mpeg")||ext.equals("mpe")||ext.equals("mpv")||ext.equals("mpg")||ext.equals("m2v")||ext.equals("m4v")||ext.equals("svi")||ext.equals("3gp")||ext.equals("mxf")||ext.equals("roq")||ext.equals("nsv")||ext.equals("flv")||ext.equals("f4v")||ext.equals("f4p")||ext.equals("f4a")||ext.equals("f4b")){
         response+=file.toString();
         System.out.println(file.toString());
        
}
        }
        else{
            
           for(File files : file.listFiles()){
                getMusicFiles(files);
            
            
        }
        }
    }
        catch(NullPointerException exception){
            
        }
        return response;
}

}
