package fileserver;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Date;

public class test {
    String text="";
    File[] rootFiles;
    
    public String Dummytext(String fileName){   
    if(!fileName.equals("getDrives") && !fileName.equals("checkDrives"))  {
        File paramFile= new File(fileName);
           Log.log("client requested content of "+fileName.replace("\\","/")+" ...");
       if(paramFile.toPath().getParent()!=null){
          // System.out.println(sp[sp.length-1]+"/"+" to be removed and be left with "+fileName.replace(sp[sp.length-1]+"/",""));
       text+="<tr titile='back to "+new File(fileName).toPath().getParent().toString()+"' style='cursor:pointer' path=\""+new File(fileName).toPath().getParent().toString()+"\" onclick='backButtonClicked(this,event)'><td><img src='stuff/icons/up.png'/></td><td>...</td><td colspan='3'></td></tr>";
       }
        File file= new File(fileName);
        if(file.canRead()&& file.exists()){
     File[] files = file.listFiles();
    try{if(files.length!=0){
        for (File file1 : files) {
            String[] filenn = file1.getName().split("[.]");
            String myext = filenn[filenn.length-1];
            if(file1.isFile()){
                if(isMedia(myext.toLowerCase()))
                text+="<tr class='tr filemedia' id='folder' media='"+mediaType(myext.toLowerCase())+"'  oncontextmenu=\"return false\" style='cursor:pointer' path=\""+file1.getAbsolutePath().replace("\\","\\\\")+"\" onmousedown='mediaDown(this,event)'>";
                    else
             text+="<tr style='cursor:pointer' class='filefile' onmousedown='fileDown(this,event)' oncontextmenu=\"return false\" path=\""+file1.getAbsolutePath().replace("\\","\\\\")+"\">";
            }else
            {   
                text+="<tr class='tr filefolder' id='folder' oncontextmenu=\"return false\" style='cursor:pointer' path=\""+file1.getAbsolutePath().replace("\\","\\\\")+"\" onmousedown='folderDown(this,event)'>";
            }
            if(!file1.isFile())
             text += "<td ><img src='stuff/icons/Folder_24px.png' class='icon'></td>";
            else{
               // System.out.println("ICon: "+);
             text += "<td><img src='"+getAssociatedIcon(new Mime(file1.getName()).getExt())+"'></td>";
            
            }
            text += "<td>" +file1.getName()+ "</td>";
            
            if (file1.isFile()) {
                text += "<td>" + makePresentable(file1.length()) + "</td>";
                text+="<td>"+myext.toLowerCase()+"</td>";
                text += "<td>" + makeDatePresentable(new Date(file1.lastModified())) + "</td>";
            } else {
                text += "<td>" + ""/*FolderSizeCalculator.calculate(file1)*/ + "</td>";
                text+="<td>folder</td>";
                text+="<td>"+""+"</td>";
            }
        }
    }
    }catch(NullPointerException e){
        text+="<tr><td colspan='2'><img src='stuff/icons/error.png'/></td colspan='3'><td><center>Error retreiving contents:"+"Access Denied by System of the remote PC"+" </center></td></tr>";
    }
        }
        


     }
//      text+="\n]";              
    else{
    if(fileName.equals("getDrives")){
    File[] files = File.listRoots();
   
//    System.out.println("getDrives rootfiles length: "+rootFiles.length);
     text="[\n";
      for(int i=0;i<files.length;i++){
      text+="{\"Name\":\""+files[i].getAbsolutePath().replace("\\", "\\\\")+"\",\"size\":\""+makePresentable(files[i].getTotalSpace())+"\",\"freeSpace\":\""+makePresentable(files[i].getFreeSpace())+"\",\"usedSpace\":\""+makePresentable(files[i].getTotalSpace() - files[i].getFreeSpace())+"\"}";
      if(i!=files.length-1){
      text+=",\n";
      }
   
      }
      text+="\n]";
    }
    else if(fileName.equals("checkDrives")){
    
        text=""+File.listRoots().length;
//        //System.out.println("Have to check drives");
//        text=""; 
//        //System.out.println("length: "+rootFiles.length);
//        File[] newRootFiles =File.listRoots();
//        if(rootFiles.length<newRootFiles.length){
//            text+="1";
//           text+=compare(newRootFiles,rootFiles);
//        }
//        else if(rootFiles.length > newRootFiles.length){
//            text+="0";
//            text+=compare(rootFiles,newRootFiles);
//        }
    }        
    }

        return text;
    }
    
public static String compare(File[] longerarray,File[] shorterarray){
    String resp="";
    for(File afile : longerarray){
        Boolean found=false;
        for(File anotherFile : shorterarray){
           if(afile==anotherFile){
               found=true;
           }
        }
        if(!found){
            resp=afile.getPath()+"|";
        }
    }
    return resp;
}

   public static String makePresentable(long length) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        String presentableValue =  decimalFormat.format(length)+" B";
       if(length >= Math.pow(2, 10) && length < Math.pow(2, 20)){
    // kilo
    presentableValue =  decimalFormat.format(length/Math.pow(2, 10))+" KB";
    
    }
       else if(length >= Math.pow(2, 20) && length < Math.pow(2, 30) ){
       //MB
       presentableValue =  decimalFormat.format(length/Math.pow(2, 20))+" MB";
       }
       if (length >= Math.pow(2, 30) && length < Math.pow(2, 40)){
       // GB
       presentableValue =  decimalFormat.format(length/(Math.pow(2, 30)))+" GB";
       }
       return presentableValue;
    }

        String getAssociatedIcon(String ext){
     String rootAssoc="stuff/icons/";
     String assoc="File_24px";
     String iconExtension=".png";
     
    // ||ext.equals("ooxml")  
    if(ext!=null){
        ext =ext.toLowerCase();
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
        else if(ext.equals("pdf"))
            assoc="pdf";
        else if(ext.equals("ani")||ext.equals("gif")||ext.equals("cal")||ext.equals("fax")||ext.equals("img")||ext.equals("jbg")||ext.equals("jpe")||ext.equals("jpeg")||ext.equals("jpg")||ext.equals("mac")||ext.equals("pbm")||ext.equals("pcd")||ext.equals("pcx")||ext.equals("pct")||ext.equals("pgm")||ext.equals("png")||ext.equals("ppm")||ext.equals("ras")||ext.equals("tga")||ext.equals("tiff")||ext.equals("mwf"))
            assoc="photo";
        else if(ext.equals("psd")){
            assoc="psd";
        }
        else if(ext.equals("ico")||ext.equals("svg")){
            assoc="ico";
        }
        else if(ext.equals("aa")||ext.equals("aac")||ext.equals("aax")||ext.equals("aiff")||ext.equals("amr")||ext.equals("au")||ext.equals("m4a")||ext.equals("ogg")||ext.equals("tta")||ext.equals("wav")||ext.equals("wma")){
           assoc="music"; 
        }
        else if(ext.equals("cmd")||ext.equals("ink")||ext.equals("ttf")||ext.equals("tmp")||ext.equals("apk")||ext.equals("asp")||ext.equals("cpp")||ext.equals("dll")||ext.equals("gpx")||ext.equals("html")||ext.equals("js")||ext.equals("jsp")||ext.equals("php")||ext.equals("sql")||ext.equals("xml")||ext.equals("py")||ext.equals("txt")||ext.equals("zip")||ext.equals("7z")||ext.equals("csv")||ext.equals("dng")||ext.equals("exe")||ext.equals("rar")||ext.equals("sys")||ext.equals("bat")||ext.equals("vb")||ext.equals("vbs")||ext.equals("dw")||ext.equals("gz")||ext.equals("lng")||ext.equals("json")||ext.equals("cs")||ext.equals("mp3")||ext.equals("css")||ext.equals("log"))
            assoc=ext;
            }
     String result=rootAssoc+assoc+iconExtension;
     return result;
    }
   public int mediaType(String ext){
       int mediaType=0;
        if(ext.equals("gif")||ext.equals("jpeg")||ext.equals("jpg")||ext.equals("png")||ext.equals("svg"))
            mediaType=1;
        else if(ext.equals("m4a")||ext.equals("mp3")||ext.equals("ogg"))
            mediaType=2;
        else if(ext.equals("webm")||ext.equals("mp4"))
            mediaType=3;
        return mediaType;
   }

    private boolean isMedia(String ext) {
        boolean isMedia=false;
    if(ext.equals("m4a")||ext.equals("webm")||ext.equals("mp4")||ext.equals("gif")||ext.equals("jpeg")||ext.equals("jpg")||ext.equals("png")||ext.equals("mp3")||ext.equals("ogg")){
        isMedia=true;
    }
return isMedia;
    }

    public static String makeDatePresentable(Date date){
        String presentableDate="";
        String dateComponents[]= date.toString().split(" "); // Day | Month | Day | Time(hh:mm:ss) | WAT | year
       
        String month;
        switch(dateComponents[1]){
            case "Jan":month="01";break;
            case "Feb":month="02";break;
            case "Mar":month="03";break;
            case "Apr":month="04";break;
            case "May":month="05";break;
            case "Jun":month="06";break;
            case "Jul":month="07";break;
            case "Aug":month="08";break;
            case "Sep":month="09";break;
            case "Oct":month="10";break;
            case "Nov":month="11";break;
            case "Dec":month="12";break;
            default:month="13";
        }
        String day=dateComponents[0]+" "+dateComponents[2]+
                "-"+month+"-"+dateComponents[5];            // day date-month-year
        String time= dateComponents[3];
        return day + " @ "+time;
        
    }
    
    public static String getPresentTime(){
    return makeDatePresentable(new Date()).split("@")[1];
    }
}
