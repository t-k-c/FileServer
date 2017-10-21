package fileserver;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Codename-tkc
 */
public class Connections extends javax.swing.JFrame {

    /**
     * Creates new form Connections
     */
    public Connections() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jTextField2 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Connections");
        setIconImage((new javax.swing.ImageIcon(getClass().getResource("/fileserver/FSLogo.png"))).getImage());
        setLocationByPlatform(true);
        setUndecorated(true);
        setType(java.awt.Window.Type.POPUP);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(36, 47, 65));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(36, 47, 65));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fileserver/Sort Down_20px_3.png"))); // NOI18N
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, 20));

        jPanel6.setBackground(new java.awt.Color(17, 22, 32));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("existing");
        jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 19, 50, 20));

        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("  network if ");
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, -1, 20));

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("  Stop a hosted");
        jPanel6.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 140, 50));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, 150, 80));

        jPanel2.setBackground(new java.awt.Color(17, 22, 32));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel2MouseReleased(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(17, 22, 32));
        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel3MouseExited(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fileserver/multiply_filled_25px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(13, 13, 13))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(13, 13, 13))
        );

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Create Connection");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fileserver/Wi-Fi_30px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 292, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 50));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Name to give to the network");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 150, 30));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Connection Name:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 180, 30));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("(8 characters minimum)");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 150, 20));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Connection Password:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 200, 30));

        jTextField1.setBackground(new java.awt.Color(36, 47, 65));
        jTextField1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setBorder(null);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 270, 30));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 280, 20));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 260, 20));

        jTextField2.setBackground(new java.awt.Color(36, 47, 65));
        jTextField2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));
        jTextField2.setBorder(null);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 250, 30));

        jPanel7.setBackground(new java.awt.Color(0, 153, 204));
        jPanel7.setForeground(new java.awt.Color(255, 255, 255));
        jPanel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        if(!Variables.hotspotActive){
            if(jTextField1.getText().equals("") || jTextField2.getText().equals("") || jTextField2.getText().length()<4 ){
                iCanClick=false;
            }
            else{
                iCanClick=true;
            }       if(!iCanClick){
                setUnclickable(jPanel7,jPanel10,jLabel14);
            }
            else{
                setclickable(jPanel7,jPanel10,jLabel14);
            }}
            jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jPanel7MouseClicked(evt);
                }
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    jPanel7MouseEntered(evt);
                }
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    jPanel7MouseExited(evt);
                }
            });
            jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
            jLabel6.setForeground(new java.awt.Color(255, 255, 255));
            jLabel6.setText("START");
            jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, 40));

            jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 260, 110, 40));

            jPanel8.setBackground(new java.awt.Color(0, 153, 204));
            jPanel8.setForeground(new java.awt.Color(255, 255, 255));
            jPanel5.setVisible(false);
            jPanel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jPanel8MouseClicked(evt);
                }
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    jPanel8MouseEntered(evt);
                }
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    jPanel8MouseExited(evt);
                }
            });
            jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
            jLabel9.setForeground(new java.awt.Color(255, 255, 255));
            jLabel9.setText("STOP");
            jPanel8.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, 40));

            jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 260, 110, -1));
            if(!Variables.hotspotActive)
            {           iCanStop=false;
            }
            else{
                iCanStop=true;
            }       if(!iCanStop){
                setUnclickable(jPanel8,jPanel6,jLabel10);
            }
            else{
                setclickable(jPanel8,jPanel6,jLabel10);
            }

            jLabel18.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
            jLabel18.setForeground(new java.awt.Color(255, 255, 255));
            jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 290, 40));

            jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fileserver/Sort Down_20px_3.png"))); // NOI18N
            jLabel14.setVisible(false);
            jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 240, -1, -1));

            jPanel10.setBackground(new java.awt.Color(17, 22, 32));
            jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
            jPanel10.setVisible(false);

            jLabel16.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
            jLabel16.setForeground(new java.awt.Color(255, 255, 255));
            jLabel16.setText("  network ");
            jPanel10.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 110, 20));

            jLabel17.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
            jLabel17.setForeground(new java.awt.Color(255, 255, 255));
            jLabel17.setText("  Start a hosted");
            jPanel10.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

            jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 200, 140, 50));

            jLabel21.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N
            jLabel21.setForeground(new java.awt.Color(255, 255, 255));
            jLabel21.setText("Password to give to the network");
            jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 170, 30));
            jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 660, -1));

            getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -2, 660, 330));

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jPanel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseEntered
        // TODO add your handling code here:
        if(iCanClick){
        jPanel7.setBackground(hovercolor);
    }
        jPanel10.setVisible(true);
        jLabel14.setVisible(true);
    }//GEN-LAST:event_jPanel7MouseEntered

    private void jPanel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseExited
        // TODO add your handling code here:
        if(iCanClick){
        jPanel7.setBackground(normalcolor);
        }
        jPanel10.setVisible(false);
        jLabel14.setVisible(false);
    }//GEN-LAST:event_jPanel7MouseExited
int x,y,dx,dy,fx,fy;
Boolean iCanStop=false;
    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        // TODO add your handling code here:
        x=evt.getXOnScreen();
        y=evt.getYOnScreen();
        fx=this.getX();
        fy=this.getY();
        jPanel2.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
        
    }//GEN-LAST:event_jPanel2MousePressed
    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        // TODO add your handling code here:
        dx= evt.getXOnScreen() - x;
        dy=evt.getYOnScreen() - y;
        this.setLocation(fx+dx,fy+dy);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void jPanel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2MouseExited

    private void jPanel2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseReleased
        // TODO add your handling code here:
         jPanel2.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_jPanel2MouseReleased
Color darkcolor = new Color(17,22,32);
Color lightcolor = new Color(36,47,65);
    private void jPanel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseEntered
        // TODO add your handling code here:
        jPanel3.setBackground(Color.red);
    }//GEN-LAST:event_jPanel3MouseEntered

    private void jPanel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseExited
        // TODO add your handling code here:
        jPanel3.setBackground(darkcolor);
    }//GEN-LAST:event_jPanel3MouseExited
Boolean iCanClick=false;
Color notClickable = new Color(00,68,90);
    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
        if(!Variables.hotspotActive){
       if(jTextField1.getText().equals("") || jTextField2.getText().equals("") || jTextField2.getText().length()<8 ){
           iCanClick=false;
        }
else{
 iCanClick=true;
}
         if(!iCanClick){
        setUnclickable(jPanel7,jPanel10,jLabel14);
        }
        else{
        setclickable(jPanel7,jPanel10,jLabel14);
        }
        }
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
if(!Variables.hotspotActive){
    if(jTextField1.getText().equals("") || jTextField2.getText().equals("") || jTextField2.getText().length()<8 ){
           iCanClick=false;
        }
else{
 iCanClick=true;
}
        if(!iCanClick){
        setUnclickable(jPanel7,jPanel10,jLabel14);
        }
        else{
        setclickable(jPanel7,jPanel10,jLabel14);
        }
}
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked
        // TODO add your handling code here:
        if(iCanClick){
            jLabel18.setText("Creating hotspot...");
       Thread thread = new Thread(new Runnable(){
       public void run(){
        String ssid=jTextField1.getText();
        String key=jTextField2.getText();
        String aux;
        String text="";
            try {
                Process process = Runtime.getRuntime().exec("netsh wlan set hostednetwork mode=\"allow\" ssid=\""+ssid+"\" key=\""+key+"\" keyusage=persistent");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                
               while((aux=bufferedReader.readLine())!=null){     
                  text+=aux+"\n";
               } 
               bufferedReader.close();
               if(text.contains("The hosted network mode has been set to allow") && text.contains("The user key passphrase of the hosted network has been successfully changed") && text.contains("The SSID of the hosted network has been successfully changed")){
            jLabel18.setText("Created, Please Wait...");
            
            Thread.sleep(1000);
             jLabel18.setText("Starting Hotspot...");
          new Thread(() -> {
              Process processx;
                try {
                    processx = Runtime.getRuntime().exec("netsh wlan start hostednetwork");
                     BufferedReader bufferedReaderx = new BufferedReader(new InputStreamReader(processx.getInputStream()));
                String auxx;
                String textx="";
               while((auxx=bufferedReaderx.readLine())!=null){     
                  textx+=auxx+"\n";
               } 
               bufferedReaderx.close();
               if(textx.contains("The hosted network started")){
                   
               jLabel18.setText("All Done!");
               Thread.sleep(1000);
               jLabel18.setText("HotSpot Active");
               setUnclickable(jPanel7,jPanel10,jLabel14);
               setclickable(jPanel8,jPanel6,jLabel10);
               jTextField1.setEditable(false);
               jTextField2.setEditable(false);
               iCanClick=false;
               iCanStop=true;
               Variables.hotspotActive=true;
               }
               else{
               
               jLabel18.setText("Activation Error");
               }
               
                } catch (IOException ex) {
                   
                } catch (InterruptedException ex) {
                }
            }).start();
            
        }              
               else{
               jLabel18.setText("Error creating...");  
               }
            } catch (IOException ex) {
              
            } catch (InterruptedException ex) {
               Logger.getLogger(Connections.class.getName()).log(Level.SEVERE, null, ex);
           }  
       }
       
       });
       thread.start();
        }
       
    }//GEN-LAST:event_jPanel7MouseClicked

    private void jPanel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseExited
        // TODO add your handling code here:
         if(iCanStop){ jPanel8.setBackground(normalcolor);}
        jPanel5.setVisible(false);

    }//GEN-LAST:event_jPanel8MouseExited

    private void jPanel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseEntered
        // TODO add your handling code here:
         if(iCanStop){ jPanel8.setBackground(hovercolor);
      }
        jPanel5.setVisible(true);

    }//GEN-LAST:event_jPanel8MouseEntered

    private void jPanel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseClicked
        // TODO add your handling code here:
        if(iCanStop){
             jLabel18.setText("Stopping Hotspot");
            new Thread(new Runnable(){
                @Override
                public void run() {
                  try {
                Process processx = Runtime.getRuntime().exec("netsh wlan stop hostednetwork");
                  BufferedReader bufferedReaderx = new BufferedReader(new InputStreamReader(processx.getInputStream()));
                String auxx;
                String textx="";
               while((auxx=bufferedReaderx.readLine())!=null){     
                  textx+=auxx+"\n";
               } 
               bufferedReaderx.close();
               if(textx.contains("The hosted network stopped")){
                   jLabel18.setText("All Done");
                   Thread.sleep(1000);
                setclickable(jPanel7,jPanel10,jLabel14);
               setUnclickable(jPanel8,jPanel6,jLabel10);
               jTextField1.setEditable(true);
               jTextField2.setEditable(true);
               jLabel18.setText("Hotspot Stopped");
               iCanStop=false;
               iCanClick=true;
               Variables.hotspotActive=false;
               }
               else{
                jLabel18.setText("Not Done");   
               }
            } catch (IOException ex) {
                jLabel18.setText("Unkown Error");
            }       catch (InterruptedException ex) {
                    }
                }
              
            }).start();
        }
        
    }//GEN-LAST:event_jPanel8MouseClicked

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        Intro.setEnabled();
        this.setVisible(false);  
    }//GEN-LAST:event_jPanel3MouseClicked

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        // TODO add your handling code here:
      if(evt.getKeyCode()==KeyEvent.VK_ENTER){
      jPanel7MouseClicked(null);
      }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
      jPanel7MouseClicked(null);
      }
    }//GEN-LAST:event_jTextField2KeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Connections.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Connections.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Connections.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Connections.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Connections().setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private static javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
   Color hovercolor  = new Color(51,181,229);
 Color normalcolor = new Color(0,153,204);
public void modify(){
javax.swing.JPanel[] jPanels = {jPanel7,jPanel8};
for(javax.swing.JPanel jPanelo : jPanels){
jPanelo.addMouseListener(new MouseListener(){
    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
     jPanelo.setBackground(hovercolor);
     System.out.println("sadkasd");
    }

    @Override
    public void mouseExited(MouseEvent e) {
    jPanelo.setBackground(normalcolor);
    }
});
}
}
private void setUnclickable(JPanel jPanel,JPanel jp,JLabel jp1) {
    jPanel.setBackground(darkcolor);
    jPanel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    jp.setBackground(darkcolor);
    jp1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fileserver/Sort Down_20px_3.png"))); // NOI18N

}

    private void setclickable(JPanel jPanel,JPanel jp,JLabel jp1) {
      jPanel.setBackground(normalcolor);   
      jPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      jp.setBackground(new Color(0,104,144));
      jp1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fileserver/Sort Down_20px_1.png"))); // NOI18N

    }
}
