/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileserver;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 *
 * @author Codename-tkc
 */
public class AddressMan {
    public String getAddress(){
        String resp="";
       Enumeration<NetworkInterface> ints;
        try {
            ints = NetworkInterface.getNetworkInterfaces();
            while(ints.hasMoreElements()){
                NetworkInterface news = ints.nextElement();
                resp=verifyInterface(news);
            }
        } catch (SocketException ex) {
        }
            return resp;   
    }

    private String verifyInterface(NetworkInterface nextElement) {
        String resp="";
     Enumeration<InetAddress> ips= nextElement.getInetAddresses();
    while(ips.hasMoreElements()){
        resp =verifyIpAddress(ips.nextElement(),nextElement);
    }
    return resp;
    }

    private String verifyIpAddress(InetAddress nextElement,NetworkInterface ni) {
        String response="";
      if(nextElement instanceof Inet4Address){
          if(!nextElement.isLoopbackAddress()){
              response=nextElement.getHostAddress()+":";
              if(ni.toString().contains("wlan"))
                  response+="Wifi;";
              else if(ni.toString().contains("eth"))
                  response+="Cable;";
          
          }
      }
    return response;  
   }
}
