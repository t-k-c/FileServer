package fileserver;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.awt.AWTException;
import java.io.*;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.json.simple.JSONObject;


public class Main{static HttpServer httpServer=null;
//public static void main(String args[]){
  public  static  boolean startSever() {
        Boolean worked=false;
        String port;
           String theport =  !(port = SettingsManager.readSetting(SettingsManager.CUSTOM_PORT)).equals(SettingsManager.CUSTOM_PORT_STATUS_OFF)
                   ?  port : "1998" ;
        try{
         httpServer=  HttpServer.create(new InetSocketAddress(Integer.parseInt(theport)),0);
        httpServer.createContext("/",new MyHanlder());
        httpServer.start();
        ValueReactor.serverIsOn();
        worked=true;
        }
        catch(IOException e){
        ValueReactor.serverIsOff();
        }
   return worked;
    }
    static class  MyHanlder implements HttpHandler{
        @Override
        public void handle(HttpExchange httpExchange) {
            System.out.println(httpExchange.getRequestURI());
            new Thread(() -> {
                    
                //httpExchange.getRemoteAddress().
                
                try{
                    
                    
                    String fileString= URLDecoder.decode(httpExchange.getRequestURI().toString().replace("+", "32435465789ygiyjgfsarg41546e867"), "UTF-8").replace("243wqs4wdwe67213erdfcxsvbdc128930649137ehgkajbczcxvnm164213e30","#").replace("32435465789ygiyjgfsarg41546e867","+");
                   
                    System.out.println("String  "+fileString);
                    if("/".equals(fileString)||"//".equals(fileString))
                        fileString="\\index.html";
                    // fileString=httpExchange.getRequestURI().toString().replace("243wqs4wdwe67213erdfcxsvbdc128930649137ehgkajbczcxvnm164213e30","#");
                    if(! new Mime(fileString.replace("\\","")).getExt().equals("1j1s1o1n1")&&
                            ! new Mime(fileString.replace("\\","")).getExt().equals("1r1e1n1a1m1e1")&&
                            !new Mime(fileString.replace("\\","")).getExt().equals("1d1e1l1e1t1e1")&&
                            !new Mime(fileString.replace("\\","")).getExt().equals("1s1c1r1e1e1n1s1h1o1t1")&&
                            !new Mime(fileString.replace("\\","")).getExt().equals("1m1u1s1i1c1s1")&&
                            ! new Mime(fileString.replace("\\","")).getExt().equals("1c1r1e1a1t1e1") &&
                            !new Mime(fileString.replace("\\","")).getExt().equals("1p1r1o1p1e1r1t1i1e1s1") &&
                            !new Mime(fileString.replace("\\","")).getExt().equals("2d2e2l2e2t2e2") &&
                            !new Mime(fileString.replace("\\","")).getExt().equals("1c1h1e1c1k1") &&
                            !new Mime(fileString.replace("\\","")).getExt().equals("1p1a1s1t1e1") &&
                            !new Mime(fileString.replace("\\","")).getExt().equals("1f1i1l1e1s1") &&
                            !new Mime(fileString.replace("\\","")).getExt().equals("1u1s1e1r1a1u1t1h1") &&
                            !new Mime(fileString.replace("\\","")).getExt().equals("1r1w1a1r1w1a")) {
                        File file;
                        String mime;
                        if(!fileString.startsWith("/a010101110011010110011011")){
                            String rootFolder ="src\\fileserver\\htmlfiles";  
                            System.out.println(rootFolder+fileString.replace("/a010101110011010110011011",""));  //im doing this for the
                            file=new File(rootFolder+fileString.replace("/a010101110011010110011011","")); //download file lol...
                            mime= new Mime(file).getMime();
                        }
                        else{
                            file = new File(stringify(fileString.replace("/a010101110011010110011011","")));                          
                            mime="application/octet-stream";
                            Log.log("client Requested Opening "+file.getPath()+" ...");                           
                        }
                        System.out.println("FILE: "+file.getPath());
                        httpExchange.sendResponseHeaders(200, file.length());
                                                                        
                        /**         Modify header            **/
                        
                        httpExchange.getResponseHeaders().add("Content-Type", mime);
                        
                        /**         Open file and send data             **/
//                byte[] bytes = new byte[(int) file.length()];
            
//                FileInputStream fileInputStream = new FileInputStream(file);
//                BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
//                bufferedInputStream.read(bytes, 0, bytes.length);
OutputStream outputStream = httpExchange.getResponseBody();
Files.copy(file.toPath(), outputStream);
//                outputStream.write(bytes, 0, bytes.length);
outputStream.close();
//                bufferedInputStream.close();
//                fileInputStream.close();
                    }
                    
                    if(new Mime(fileString.replace("\\","")).getExt().equals("1j1s1o1n1"))
                    {
                        if(!fileString.equals("/a010101110011010110011011getDrives.1j1s1o1n1"))
                            Log.log("client requested data ...");
                        String string =new Mime(fileString).getFileName();
                        String textToSend = new test().Dummytext(stringify(string.replace("/a010101110011010110011011", "").replace("c001100900345711010n", ":")));
                        httpExchange.getResponseHeaders().add("Content-Type", "text/html");
                        
                        /*  remeber to change the below     */
                        
                        File file = new File("src\\fileserver\\htmlfilesresponse.html");
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        fileOutputStream.write(textToSend.getBytes());
                        fileOutputStream.close();
                        FileInputStream fileInputStream = new FileInputStream(file);
                        httpExchange.sendResponseHeaders(200, file.length());
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
                        byte[] bytes = new byte[(int) file.length()];
                        bufferedInputStream.read(bytes, 0, bytes.length);
                        OutputStream outputStream = httpExchange.getResponseBody();
                        outputStream.write(bytes, 0, bytes.length);
                        outputStream.close();
                        bufferedInputStream.close();
                        fileInputStream.close();
//                httpExchange.sendResponseHeaders(200,textToSend.length());
//               OutputStream os=  httpExchange.getResponseBody();
//                       os.write(textToSend.getBytes());
//                        os.close();
                    }
                    
                    if(new Mime(fileString.replace("\\","")).getExt().equals("1r1e1n1a1m1e1")){
                        Boolean result=false;
                        String filesw[] = stringify(fileString.replace(".1r1e1n1a1m1e1","")).split("0001200oieuahdjsbco13846t9eqd7gvizcm1o2371");
                        
                        String firstFile=filesw[0];
                        String secondFile=filesw[1];
                        File filew =new File(firstFile);
                        File filew2;
                        if(secondFile.contains("\\") || secondFile.contains("/")){
                            filew2= new File(secondFile);
                        }
                        else{
                            filew2= new File(filew.getParent()+"/"+secondFile);
                        }
                        Log.log("client trying to rename "+filew.getPath() + " to "+filew2.getPath());
                        System.out.println("Renaming "+filew.getPath()+" to "+filew2.getPath());
                        if(filew.canWrite()){
                            result= filew.renameTo(filew2);
                        }
                        if(result){
                            Log.log("Rename "+filew.getPath() + " to "+filew2.getPath()+" , status: Success");
                        }
                        else{
                            Log.log("Rename "+filew.getPath() + " to "+filew2.getPath()+" , status: Failure");
                        }
                        httpExchange.sendResponseHeaders(200, (result+"").length());
                        OutputStream outputStream = httpExchange.getResponseBody();
                        outputStream.write((result+"").getBytes());
                        outputStream.close();
                    }
                    if(new Mime(fileString.replace("\\","")).getExt().equals("1p1a1s1t1e1")){
                        String receivedRawText =stringify(fileString).replace(".1p1a1s1t1e1",""); //has the same format as the one coming directly from the web browser
                        String SEPARATOR="3165qgus091384tw7017qhdcmsloadutiy";
                        String[] portions =receivedRawText.split(SEPARATOR);
                        /*  SEQUENCE : operation + SEPERATOR + operationType + SEPARATOR + data + SEPARATOR + current  */
                        String operation=portions[0];
                        String operationType=portions[1];
                        String data = portions[2];
                        String current =portions[3];
                        String resultFromPaste=(recursivePaste(operation,operationType,data,current));
                        httpExchange.sendResponseHeaders(200, (""+resultFromPaste).length());
                        try (OutputStream outputStream = httpExchange.getResponseBody()) {
                            outputStream.write((""+resultFromPaste).getBytes());
                        }
                    }
                    
                    
                    if(new Mime(fileString.replace("\\","")).getExt().equals("1c1r1e1a1t1e1")){
                        Boolean result=false;
                        String filesw[] = stringify(fileString.replace(".1c1r1e1a1t1e1","")).split("0001200oieuahdjsbco13846t9eqd7gvizcm1o2371");
                        String[] filesplit=filesw[0].split("/");
                        String reconstructedFile1="";String reconstructedFile2="";
                        
                        for (int i=1;i<filesplit.length-1;i++){
                            reconstructedFile1+=filesplit[i]+"/";
                        }
                        for (int i=1;i<filesplit.length;i++){
                            reconstructedFile2+=filesplit[i];
                            if(i!=filesplit.length-1){
                                reconstructedFile2+="/";
                            }
                        }
                        
                        
                        File filew =new File(reconstructedFile2+"/"+filesw[1]);
                        if(filew.canWrite()){
                            result= filew.createNewFile();
                        }
                        httpExchange.sendResponseHeaders(200, (result+"").length());
                        OutputStream outputStream = httpExchange.getResponseBody();
                        outputStream.write((result+"").getBytes());
                        outputStream.close();
                    }
                    if(new Mime(fileString.replace("\\","")).getExt().equals("1d1e1l1e1t1e1")){
                        
                        String filesw = stringify(fileString.replace(".1d1e1l1e1t1e1",""));
                        
                        Log.log("Client Requested delete "+filesw+" ...");
                        File filew =new File(filesw);
                        Boolean result=delete(filew);
                        if(result)
                            Log.log("Client Delete: "+filesw+" ..." +", Status: Success");
                        else
                            Log.log("Client Delete: "+filesw+" ..." +", Status: Failure");
                        
                        httpExchange.sendResponseHeaders(200, (result+"").length());
                        OutputStream outputStream = httpExchange.getResponseBody();
                        outputStream.write((result+"").getBytes());
                        outputStream.close();
                    }
                    if(new Mime(fileString.replace("\\","")).getExt().equals("1p1r1o1p1e1r1t1i1e1s1")){
                        
                        String filesw = stringify(fileString.replace(".1p1r1o1p1e1r1t1i1e1s1",""));
                        
                        Log.log("Client Requested properties of "+filesw+" ...");
                        
                        File filew =new File(filesw);
                        String result=props(filew);
                        httpExchange.sendResponseHeaders(200, (result+"").length());
                        OutputStream outputStream = httpExchange.getResponseBody();
                        outputStream.write((result+"").getBytes());
                        outputStream.close();
                    }
                    
                    // Here, i defined a method to delete all at once but i saw it will be better to delete
                    //one by one using delete so that i can show status on the webpage directly rather than
                    //showing a report list of all of them
                    
                    if(new Mime(fileString.replace("\\","")).getExt().equals("2d2e2l2e2t2e2")){
                        String HOLDER_HEADER = "1265ersfkasjdfhkauicy9872093i542p4hgjchasidll";//header of the holder;
                        
                        String  HOLDER_DIVIDER = "17263781yedbasncbiwahdkuy71qyiut414144121989"; //divides two paths i.e in between paths for easy separation!
                        
                        String files = stringify(fileString.replace(".2d2e2l2e2t2e2","").replace(HOLDER_HEADER, "").replace(HOLDER_DIVIDER, ","));
                        
                        
//                    File filew =new File(filesw);
//                  String result=props(filew);
//               httpExchange.sendResponseHeaders(200, (result+"").length());
//              OutputStream outputStream = httpExchange.getResponseBody();
//               outputStream.write((result+"").getBytes());
//               outputStream.close();
                    }  if(new Mime(fileString.replace("\\","")).getExt().equals("1c1h1e1c1k1")){ //checls to see if new drives are present
                        httpExchange.sendResponseHeaders(200, (File.listRoots().length+"").length());
                        try (OutputStream outputStream = httpExchange.getResponseBody()) {
                            outputStream.write((File.listRoots().length+"").getBytes());
                        }
                    }
                    
                    
                    if(new Mime(fileString.replace("\\","")).getExt().equals("1s1c1r1e1e1n1s1h1o1t1")){
                        try {
                            if(ScreenShotGuy.getScreenshot()){
                                File file = new File("src\\fileserver\\htmlfilesscreenshot.png");
                                httpExchange.sendResponseHeaders(200, file.length());
                                OutputStream os= httpExchange.getResponseBody();
                                Files.copy(file.toPath(),os);
                                os.close();
                            }
                        } catch (AWTException ex) {
                            
                        }
                    }
                    if(new Mime(fileString.replace("\\","")).getExt().equals("1m1u1s1i1c1s1")){
                        
                        String string = Filter.getMusicFiles(new File("m:\\"));
                        httpExchange.sendResponseHeaders(200, string.length());
                        OutputStream os = httpExchange.getResponseBody();
                        os.write(string.getBytes());
                        os.flush();
                        os.close();
                        
                        
                    } if(new Mime(fileString.replace("\\","")).getExt().equals("1r1w1a1r1w1a")){
                        
                     boolean string = SettingsManager.readSetting(SettingsManager.READ_WRITE_ACCESS) == SettingsManager.READ_WRITE_ACCESS_WRITE;
                        httpExchange.sendResponseHeaders(200,String.valueOf(string).length());
                        OutputStream os = httpExchange.getResponseBody();
                        os.write(String.valueOf(string).getBytes());
                        os.flush();
                        os.close();
                    }
                    if(new Mime(fileString.replace("\\","")).getExt().equals("1u1s1e1r1a1u1t1h1")){
                        String resp = "1f2a3l4s5e6lasdbaj901289wshadakjbalaksdnki";
                        String other;
                     if((other = SettingsManager.readSetting(SettingsManager.AUTH_ACCESS_PASS))!= SettingsManager.AUTH_ACCESS_FALSE)
                        resp = other;
                     httpExchange.sendResponseHeaders(200, resp.length());
                        try (OutputStream os = httpExchange.getResponseBody()) {
                            os.write(resp.getBytes());
                            os.flush();
                        }
                     }
                    
                    if(new Mime(fileString.replace("\\","")).getExt().equals("1f1i1l1e1s1")){
                        System.out.println("Download coming in");
                        InputStream inputStream = httpExchange.getRequestBody();
                       BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
                       String line="";
                       String resp="";
                       while((line  = br.readLine()) !=  null || resp==""){
                           resp+=line;
                       }
                       String[] resultOfResp = resp.split("oi3wnscnkjznciuyasdhbhzvxvgihwhssnjanxbbvfsghgsakkannshhyauhgshbbcbvafrwyq");
                     String answer =   addToZip(resultOfResp);
                           httpExchange.sendResponseHeaders(200, answer.length());
                        try (OutputStream os = httpExchange.getResponseBody()) {
                            os.write(answer.getBytes());
                            os.flush();
                        }
                    }
                }
                catch(IOException e){
                    Log.log(e.getMessage());
                }
            }).start();
              ///end
        }
    }
    
    public boolean stopServer(){
    httpServer.stop(0);
    ValueReactor.serverIsOff();
    return true;
    }

public static String stringify(String string){
return  string.replace("/a010101110011010110011011","").replace("c001100900345711010n",":").replace("%5C","/").replace("2163e87sabdiaduahbd7863t4e817tgebdhjaczz","%").replace("15263eswysadjkfg3i16754r1623g4hved315634e131256tevjhzsc","[").replace("2135r67134gbjnsaci317648r123ed7gvbcnm612qygrzcjqkh3rt37","]").replace("243wqs4wdwe67213erdfcxsvbdc128930649137ehgkajbczcxvnm164213e30","#");
}

public static boolean delete(File filew){
   boolean result=false;
   
   if(filew.isDirectory()){ 
       try{
                      for(File fileo : filew.listFiles()){
                          delete(fileo);
                      }
                      result= filew.delete();}
                           catch(SecurityException | NullPointerException e){
         result=false;
         
     }
                  }
 
                  else{
                      result= filew.delete();
                  }
     
return result; 
}

public static long totalFileSize(File filew){
  long totalFileSize=0;
  if(filew.isDirectory()){
      for(File files : filew.listFiles()){
          totalFileSize+=totalFileSize(files);
      }
  }
  else{
      totalFileSize+=filew.length();
  }
return totalFileSize; 
}

public static String props(File file){  //prepares file properties to be sent via the socket
    String response="<center><h5 style='color:#1a237e'>\""+file.getName()+"\" Properties</h5></center><br><table><tr>";
    response+="<td>File Name: &nbsp;&nbsp;</td><td>"+file.getName()+"</td></tr><tr>";
    response+="<td>Type of file: &nbsp;&nbsp;</td><td>";
    if(!new Mime(file.getName()).getExt().equals("null") && file.isFile()){
    response+=new Mime(file.getName()).getExt()+" file";
    }
    else{
        response+="File folder";
    }
    response+="</td></tr>";
    response+="<tr><td>Location: &nbsp;&nbsp;</td><td>"+file.toPath().getParent().toString()+"</td></tr>";
    
    try{
        response+="<tr><td>Size: &nbsp;&nbsp;</td><td>"+test.makePresentable(totalFileSize(file))+"</td></tr>";
    }
    catch(NullPointerException e){
        
        response+="<tr><td>Size: &nbsp;&nbsp;</td><td>"+e.getMessage()+"&nbsp;&nbsp;<a href='#!' id='issue1'>Learn More..</a></td></tr>";    
            }
    response+="<tr><td>Last modified: &nbsp;&nbsp;</td><td>"+test.makeDatePresentable(new Date(file.lastModified()))+"</td></tr>";
    response+="<tr><td>ReadOnly: &nbsp;&nbsp;</td><td>"+!file.canWrite()+"</td></tr>";          // if can't write, then its read only...
    response+="<tr><td>Hidden: &nbsp;&nbsp;</td><td>"+file.isHidden()+"</td></tr></table>";   
    return response;
}
 public static String recursivePaste(String operation,String operationType,String data,String current)
{    File dataFile = new File(data);
String result="";
    if(dataFile.isDirectory()){
    try {
        Files.createDirectory(new File(current+"/"+dataFile.getName()).toPath());
    } catch (Exception ex) {
        Log.log("Failed to create directory "+current+"/"+dataFile.getName());
        result="Exception generated. Something went wrong";
    }
        for(File files : dataFile.listFiles()){
          result = recursivePaste(operation,operationType, files.getPath(),current+"/"+dataFile.getName()+"/");
    }
    try {
        Files.delete(dataFile.toPath());
    } catch (IOException ex) {
       
    }
}
    else{
                if(operation.equals("cutop")){  //cutting operation
                if(operationType.equals("or")){ //overwritting operation type
                      if(new File(current+"/"+dataFile.getName()).delete()){                  
                          try {
                              Files.move(dataFile.toPath(), new File(current+"/"+dataFile.getName()).toPath(),StandardCopyOption.REPLACE_EXISTING);
                              Log.log("Moving "+dataFile.toPath()+" to "+current+"/ (overwrite method) is succesful");
          
                          } catch (IOException ex) {
                               Log.log("Moving "+dataFile.toPath()+" to "+current+"/ (overwrite method) failed");
                               result="Exception generated. Something went wrong";
                          }
                      }
                      else{
                      Log.log("Moving "+dataFile.toPath()+" to "+current+"/ (overwrite method) failed");
                      result="Exception generated. Something went wrong";
                      }
                }
                else{                           //skip operation type
                    try {
                        
                    Files.move(dataFile.toPath(), new File(current+"/"+dataFile.getName()).toPath());
                    Log.log("Moving "+dataFile.toPath()+" to "+current+"/ (skip method) is succesful");
                    } catch (Exception ex) {
                        if(!ex.getClass().getName().equals("class java.nio.file.FileAlreadyExistsException")){
                       Log.log("Copying "+dataFile.toPath()+" to "+current+"/ (skip method) generated an exception" + ex.getClass().toString());
                       result=ex.getClass().getName();       
                    }                    
                }
            }
                }
            else{                               
                        //copying operation
                if(operationType.equals("or")){ //overwritting operation type 
                      if(new File(current+"/"+dataFile.getName()).delete()){                  
                          try {
                              Files.copy(dataFile.toPath(), new File(current+"/"+dataFile.getName()).toPath(),StandardCopyOption.REPLACE_EXISTING);
                              Log.log("Copying "+dataFile.toPath()+" to "+current+"/ (overwrite method) is succesful");
          
                          } catch (IOException ex) {
                               Log.log("Copying "+dataFile.toPath()+" to "+current+"/ (overwrite method) is succesful");
                      result="Exception generated. Something went wrong";
                          }
                      }
                      else{
                      Log.log("Copying "+dataFile.toPath()+" to "+current+"/ (overwrite method) is succesful");
                      result="Exception generated. Something went wrong";
                      }
                }
                else{                           //skip operation type
                    try {
                    Files.copy(dataFile.toPath(), new File(current+"/"+dataFile.getName()).toPath());
                    Log.log("Copying "+dataFile.toPath()+" to "+current+"/ (skip method) is succesful");
                    } catch (Exception ex) {
                        if(!ex.getClass().getName().equals("class java.nio.file.FileAlreadyExistsException")){
                       Log.log("Copying "+dataFile.toPath()+" to "+current+"/ (skip method) generated an exception" + ex.getClass().toString());
                       result=ex.getClass().getName();
                    }
                    }
                }
             
            }
        }
    return result;
    }
 public static String addToZip(String[] files){
     Log.log("Request for mass download has been initiated ...");
     String ans="The following files weren't successfully compiled: \n ";
     try{
     File zipFile = new File("src\\\\fileserver\\\\htmlfiles\\\\FileServerDownload.zip");
           if(zipFile.exists())
     {
     Files.delete(zipFile.toPath());
     }     
    try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFile))) {
        for(String fileName : files){
            File file = new File(fileName);
            ans+=addFile(zipOutputStream,file,new File(fileName).getName());
        }
    }
     }
     catch(IOException | NullPointerException e){
         ans = "Error 2003982: Fatal Error";
         Log.log("Error 2003982: Fatal Error, " +e.getMessage());
     }
     if("The following files weren't successfully compiled: \n ".equals(ans))
         ans="100% Successful Compilation";
     return ans;
 }
 public static String addFile(ZipOutputStream zos,File file, String path){
     String errorResponse="";
     if(file.isDirectory()){
         for(File files : file.listFiles()){
             addFile(zos,files,path+"/"+files.getName());
         }
     }
     else{
         try {
             Log.log("Adding "+file.getPath()+" to Zip for mass download");
             zos.putNextEntry(new ZipEntry(path));
             Files.copy(file.toPath(), zos);
             zos.closeEntry();       
         } catch (IOException | NullPointerException ex) {
           Log.log("Failed to add "+file.getPath()+" to Zip for mass download, "+ex.getMessage() );
            errorResponse+=file.getPath()+"\n";
         }
         
     }
     return errorResponse;
 }
}

