/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileserver;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


/**
 *
 * @author Codename-tkc
 */
public class ScreenShotGuy {
   static public boolean getScreenshot() throws AWTException, IOException{ 
   Rectangle screenRect =new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
  Robot robot=  new Robot();
  BufferedImage capture= robot.createScreenCapture(screenRect);
  File file = new File("C:\\Users\\Codename-tkc\\Documents\\NetBeansProjects\\FileServer\\src\\fileserver\\screenshot.png");
  boolean b= ImageIO.write(capture, "png", file);
  return b;
   }
  
}
