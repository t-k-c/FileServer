/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileserver;

import java.awt.Point;

/**
 *
 * @author codename-tkc
 */
public class FileServerAnimations {
    public static boolean interrupt=false;
   public static void slide(javax.swing.JComponent jLabel){
        assert jLabel !=null;
        Point location;
        try {
            location = jLabel.getLocation();
            jLabel.setLocation(location.x - 54, location.y);
            location = jLabel.getLocation();
            for(int i=0;i<=54;i++){
            Thread.sleep(5);
            jLabel.setLocation(location.x + i, location.y);
            } 
        } catch (InterruptedException ex) {
          
        }
    }
      public static void zoom(javax.swing.JComponent jLabel){
//        Dimension dimension;
//        try {
//            for(int i=0;i<=100;i++){
//              Thread.sleep(100);
//              dimension = jLabel.getSize();
//              jLabel.setSize(dimension.width + i, dimension.height + i);
//            if(i%2==0)
//            jLabel.setLocation(jLabel.getLocation().x + i/2, jLabel.getLocation().y + i/2);
//            } 
//            }
//        } catch (InterruptedException ex) {
//          
//        }
    }
//            public static void unZoom(javax.swing.JComponent jLabel){
//        assert jLabel !=null;
//        Dimension dimension;
//        try {
//            dimension = jLabel.getSize();
//            for(int i=0;i<=5;i++){
//            Thread.sleep(10);
//            jLabel.setSize(dimension.width - i, dimension.height - i);
//            if(i%2==0)
//            jLabel.setLocation(jLabel.getLocation().x + i/2, jLabel.getLocation().y + i/2);
//            } 
//        } catch (InterruptedException ex) {
//          
//        }
//    }
            public static void animateText(javax.swing.JLabel jLabel,String text){
                char[]  chars = text.toCharArray();
                jLabel.setText("");
                String message="";
               try { for(int i=0;i<chars.length;i++)
                    {                    
                       if(!interrupt){
                           message+=chars[i];
                           jLabel.setText(message+"_");
                        Thread.sleep(10);
                       }
                        
                    }
                       if(!interrupt) 
                        jLabel.setText(text.replace("_", ""));
                       Thread.sleep(500);
                       if(!interrupt)
                        jLabel.setText(text.replace("_", "")+"_");
                       Thread.sleep(500);
                       if(!interrupt)
                        jLabel.setText(text.replace("_", "")); 
                      
                }catch (InterruptedException ex) {
                            SettingsManager.echo(ex.getMessage());
                    }
            }
               public static void animateTextRemoval(javax.swing.JLabel jLabel,String text){
                char[]  chars = text.toCharArray();
                jLabel.setText(text);
               try { for(int i=0;i<chars.length;i++)
                    {                    
                        jLabel.setText(jLabel.getText().replace(jLabel.getText().charAt(jLabel.getText().toCharArray().length-1)+"", "")+"_");
                        Thread.sleep(5);
                    }
                       jLabel.setText(jLabel.getText().replace("_", ""));
                }catch (InterruptedException ex) {
                            SettingsManager.echo(ex.getMessage());
                    }
            }
}
