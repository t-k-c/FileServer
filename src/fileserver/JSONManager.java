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
public class JSONManager {
    String command;
  public  JSONManager(String command){
      this.command=command;
}  
  public boolean isCommand(){
      boolean isCommand=false;
  if( "partitions".equals(command)){
  isCommand=true;
  }
  return isCommand;
  }
  public String returnResponse(){
  String response=null;
  if("partitions".equals(command)){
   
  }
  return response;    
  }
}
