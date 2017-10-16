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
public class FolderSizeCalculator {
    public  static String calculate(String fileName){
        String resp;
        try{
        resp= test.makePresentable(getFolderSize(new File(fileName)));
        }
        catch(NullPointerException e){
           resp="-";
        }
        return resp;
    }
     public  static String calculate(File fileName){
        String resp;
        try{
        resp= test.makePresentable(getFolderSize(fileName));
        }
        catch(NullPointerException e){
           resp="-";
        }
        return resp;
    }

    private static long getFolderSize(File file) {
//      file.getPath();
long response=0;
if(file.isDirectory()){
        for(File files : file.listFiles()){
            response+=getFolderSize(files);
        }    
}
else{
    response+=file.length();
}
   
      return response;  
    }
}
