/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import comp_decomp.compressor;
import comp_decomp.decompressor;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;


/**
 *
 * @author Jayesh
 */
public class AppFrame extends JFrame implements ActionListener {

    
    JButton compressButton;
    JButton decompressButton;
    
    AppFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        javax.swing.border.Border buttonBorder = BorderFactory.createLineBorder(Color.RED, 2);
        this.setLayout(null);
        compressButton = new JButton("Select File to compress");
        compressButton.setBounds(250,50,200,30);
        compressButton.setBorder(buttonBorder);
        compressButton.setForeground(Color.RED);
         //compressButton.setBackground(Color.black);
        compressButton.addActionListener(this);
       
        decompressButton = new JButton("Select File to Decompress");
        decompressButton.setBounds(250,100,200,30);
        decompressButton.setBorder(buttonBorder);
        decompressButton.setForeground(Color.RED);
        //decompressButton.setBackground(Color.black);
        decompressButton.addActionListener(this);
        // adding both the button
        this.add(compressButton);
        this.add(decompressButton);
        //setSize
        this.setSize(1500,500);
        //setting bacgroundcolour
        this.getContentPane().setBackground(Color.green);
        //setting visibility of this jframe
        this.setVisible(true);
        
        
    }
      @Override
      public void actionPerformed(ActionEvent e){
          if(e.getSource()==compressButton){// if user have pressed compress button
              JFileChooser filechooser = new JFileChooser();// help us to choose file from our system
              int response = filechooser.showSaveDialog(null);
              if(response==JFileChooser.APPROVE_OPTION){
                  File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                  System.out.print(file);
                  try{
                      compressor.method(file);
                  }
                  catch(Exception ee){
                      JOptionPane.showMessageDialog(null, ee.toString());
                  }
              }
          }
          
          if(e.getSource()==decompressButton){
              JFileChooser filechooser = new JFileChooser();// help us to choose file from our system
              int response = filechooser.showSaveDialog(null);
              if(response==JFileChooser.APPROVE_OPTION){
                  File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                  System.out.print(file);
                  try{
                      decompressor.method(file);
                  }
                  catch(Exception ee){
                      JOptionPane.showMessageDialog(null, ee.toString());
                  }
              }
          }
      }
      
    
}
