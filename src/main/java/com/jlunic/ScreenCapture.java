package com.jlunic;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class ScreenCapture {

    public BufferedImage captureScreen() throws AWTException
    {
        Robot robot = new Robot();
        Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
        return screenFullImage;
    }

    public void saveImage(BufferedImage image, String path)
    {
        try
        {
        ImageIO.write(image, "png", new File(path));
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
