package fileserver;

import java.io.File;
public class Mime {
   private String fileName=null;
    public Mime(File file){
     fileName = file.getName();
    }
  public Mime(String fileName){
        this.fileName = fileName;
    }

    public  String getExt(){
        String[] fileSplit  =fileName.split("[.]");
        String ext;
        if(fileSplit.length > 1) { ext = fileSplit[fileSplit.length - 1]; } else{ ext = "null" ;}
        return ext;
    }

    public  String getFileName(){
        String fileName=this.fileName;
       // if(this.fileName.contains("\\")) {fileName = this.fileName.replace("\\","");} else{ fileName = this.fileName.replace("/","");}
        String[] fileSplit  =fileName.split("[.]");
        String fileUniqueName="";
        for (int i  =0; i < fileSplit.length -1 ;i++){
            fileUniqueName+=fileSplit[i];
             if(i!=fileSplit.length -2){
                fileUniqueName+=".";
            }
        }
        return fileUniqueName;
    }

    public String getStuff(){
          String[] fileSplit  =fileName.split("[.]");
        String fileUniqueName="";
        for (int i  =0; i < fileSplit.length -1 ;i++){
            fileUniqueName+=fileSplit[i];
            if(i!=fileSplit.length -2){
                fileUniqueName+=".";
            }
        }
    return fileUniqueName;
    }
    
    public String getMime(){
        String ext = getExt();
        String mime="text/html";
        switch (ext){
            case "jpg" :  mime = "image/jpg";break;
            case "png" :  mime = "image/png";break;
            case "jpeg":  mime = "image/jpg";break;
            case "mp3" :  mime = "audio/mpeg";break;
            case "html":  mime = "text/html";break;
            case "js"  :  mime = "text/javascript";break;
            case "css" :  mime = "text/css";break;
            case "ico" :  mime = "image/x-icon";break;
         }
        return  mime;
    }
}
