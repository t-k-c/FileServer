/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileserver;

import java.io.*;
import java.nio.file.Path;
import java.util.Deque;
import java.util.LinkedList;
/**
 *
 * @author Codename-tkc
 */
public class FileCompressor {
    File currentFile,currentFolder;
    public FileCompressor(java.io.File file){
        if(file.isFile()){
            this.currentFile=file;
        }
        else{
            this.currentFolder=file;
        }
    }
    public static void compressList(File ...files){
        LinkedList<Path> paths= new LinkedList<>();
        
    }
    public void compressFolder(File folder){
        
    }
    public void compressFile(File file){
        
    }
}
