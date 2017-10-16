/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileserver;

/**
 *
 * @author Codename-tkc
 */
public class extensionManager {
    String ext;
    public extensionManager(String ext){
    this.ext=ext;
    }
    String getAssociatedIcon(){
     String rootAssoc="stuff/icons/";
     String assoc="File_24px";
     String iconExtension="png";
    // ||ext.equals("ooxml")  
             if(ext.equals("doc")||ext.equals("docx")||ext.equals("dot")||ext.equals("wbk")||ext.equals("dotx")||ext.equals("docm")||ext.equals("dotm")||ext.equals("docb")){
       assoc="word";
        }
        else if(ext.equals("xls")||ext.equals("xlt")||ext.equals("xlm")||ext.equals("xlsx")||ext.equals("xlsm")||ext.equals("xltx")||ext.equals("xltm")||ext.equals("xlsb")||ext.equals("xla")||ext.equals("xlam")||ext.equals("xll")||ext.equals("xlm")){
        assoc="xls";
        }
        else if(ext.equals("ppt")||ext.equals("pot")||ext.equals("pps")||ext.equals("pptx")||ext.equals("pptx")||ext.equals("pptm")||ext.equals("potx")||ext.equals("potm")||ext.equals("ppam")||ext.equals("ppsx")||ext.equals("ppsm")||ext.equals("sldx")||ext.equals("sldm")){
        assoc="ppt";
        }
        else if(ext.equals("accdb")||ext.equals("accde")||ext.equals("accdt")||ext.equals("accdr")){
          assoc= "access"; 
        }
        else if(ext.equals("pub")){
            assoc="publisher";
        }
        else if(ext.equals("webm")||ext.equals("mkv")||ext.equals("flv")||ext.equals("f4v")||ext.equals("vob")||ext.equals("ogg")||ext.equals("ogv")||ext.equals("drc")||ext.equals("gif")||ext.equals("gifv")||ext.equals("mng")||ext.equals("avi")||ext.equals("mov")||ext.equals("qt")||ext.equals("wmv")||ext.equals("yuv")||ext.equals("rm")||ext.equals("rmvb")||ext.equals("asf")||ext.equals("amv")||ext.equals("mp4")||ext.equals("m4p")||ext.equals("m4v")||ext.equals("mpg")||ext.equals("mp2")||ext.equals("mpeg")||ext.equals("mpe")||ext.equals("mpv")||ext.equals("mpg")||ext.equals("m2v")||ext.equals("m4v")||ext.equals("svi")||ext.equals("3gp")||ext.equals("mxf")||ext.equals("roq")||ext.equals("nsv")||ext.equals("flv")||ext.equals("f4v")||ext.equals("f4p")||ext.equals("f4a")||ext.equals("f4b")){
         assoc="video";
        }
     
     return rootAssoc+assoc+iconExtension;
    }
}
