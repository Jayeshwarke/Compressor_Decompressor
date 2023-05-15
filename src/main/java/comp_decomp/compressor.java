/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp_decomp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

/**
 *
 * @author Jayesh
 */
public class compressor {
    // this method will take file as input
    public static void method(File file)throws IOException{
        // for choosing file i  need to implement file chooser which which will help to choose file anywhere from system .. and from where my file is choosed
                // i need to save my output file into that same folder only
                String fileDirectory = file.getParent();// this gives me parent directory of input file and then i can push my output into the parent file
                // taking input using file input stream
                FileInputStream fis = new FileInputStream(file);
                 //file ouptput stream
                 FileOutputStream fos = new FileOutputStream(fileDirectory+"/CompressedFile.gz");
                  // i want my file compressed , for this i am using i use gzipoputpu stram
                 GZIPOutputStream gzip = new GZIPOutputStream(fos);
                 
                 //i need to read in the form of byte form
                 
                 byte[] buffer = new byte[1024];
                 int len;
                 
                 while((len=fis.read(buffer))!=-1 ){// fis.read : it read upto buffer.length bytes of data from the input stream into an array of bytes
                         // since i have read the input bytes and stored in buffer array.. now i will write those using gzip.write
                         gzip.write(buffer,0, len);// wrtite from buffer array starting index is 0 and ending index is end ie len;
                 }
                 gzip.close();
                 fos.close();
                 fis.close();
                         
                 }
    
    public static void main(String[]args)throws IOException{
        File path = new File("C:\\Users\\DELL\\Desktop\\compressor_decompressor");//it takes path of file in string format
        method(path);
        
    }
    }

    // main function
    

