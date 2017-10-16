/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileserver;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author codename-tkc
 */
public class Slave {
    public static void main(String args[]){
        File file = new File("C:\\$Recycle.Bin");
       // File filea = new File();
      try{
          echo(new File("C:\\Recovery\\hh").createNewFile()+"");
      }
      catch(IOException e){
          echo(e.getMessage());
      }
    }
    public static void echo(String msg){
        System.out.println(msg);
    }
}
