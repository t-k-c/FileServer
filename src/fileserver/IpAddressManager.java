/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileserver;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 *
 * @author codename-tkc
 */
public class IpAddressManager {
    public static String getIpInterfaces() throws SocketException{
    Enumeration<NetworkInterface>  ni = NetworkInterface.getNetworkInterfaces();
    String port;
           String theport =  !(port = SettingsManager.readSetting(SettingsManager.CUSTOM_PORT)).equals(SettingsManager.CUSTOM_PORT_STATUS_OFF)
                   ?  port : "1998" ;
            
    String resp=" Notice : On any browser on your own pc, you can type http://127.0.0.1:"+theport+" to test the server\n";
   while(ni.hasMoreElements()){
      NetworkInterface networkI =  ni.nextElement();
      Enumeration<InetAddress> ip = networkI.getInetAddresses();
     while (ip.hasMoreElements()){
         InetAddress anIp = ip.nextElement();
         if(!anIp.isLoopbackAddress()){
            if(!(anIp instanceof Inet6Address)){ 
                resp+=" ===========================================\n Interface: "+networkI.getName()+" \n Adapter Name: "+networkI.getDisplayName()+"\n";
                resp+=" Ip Address: "+anIp.getHostAddress()+"\n";
                resp+=" Address to type on the browser : http://"+anIp.getHostAddress()+":"+theport+""+"\n";
            }
         }
     }
   }
   if((" Notice : On any browser on your own pc, you can type http://127.0.0.1:"+theport+" to test the server\n").equals(resp)){
   resp+=" Notice : You seem not to have any network connection";    
   }
   else{
       resp+=" ===========================================\n Notice :\n wlan : Wireless Interface (Computers connected through a wireless network)";
       resp+=" Notice :\n eth : Ethernet (Computers connected through ethernet e.g ethernet cable)";
   }
   System.out.println(resp);
   return resp;
    }  
}
