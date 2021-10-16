package ctis210lab5;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 *
 * Adapted by Rob Whitnell (rwhitnel@guilford.edu) from the Java Image
 * Processing Cookbook by Rafael Santos (rafael.santos@lac.inpe.br) (No longer
 * available on the web, but was at
 * http://www.lac.inpe.br/JIPCookbook/index.jsp) Except for the code copyrighted
 * by others, it is distributed under the Creative Commons
 * Attribution-NonCommercial-ShareAlike 3.0 Unported License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/).
 *
 * @author Rob Whitnell
 * @version 1.0
 *
 * This class demonstrates how to select a color for transparency to create
 * overlays of images. It reads two images from the disk, drawing the second one
 * over the first one but considering green pixels on the second one as
 * transparent.
 *
 */
public class CTIS210Lab5 extends Canvas {

    static BufferedImage background;
    static BufferedImage layer;
    static JFrame overlay;
    static JFrame finalImage;
    
    static double alpha = 0.95;

    /**
     *
     *
     * @param args command line arguments
     * @throws IOException thrown if file containing specified image is not
     * present
     *
     */
    public static void main(String[] args) throws IOException {
        // Read the input images. We assume that the first image is the background, and that it is larger
        // than the second image.
        background = ImageIO.read(new File("galaxy.jpg"));

        System.out.println("The background is " + background.getWidth() + " pixels wide.");
        System.out.println("The background is " + background.getHeight() + " pixels tall.");

        layer = ImageIO.read(new File("duck.png"));

        System.out.println("The layer is " + layer.getWidth() + " pixels wide.");
        System.out.println("The layer is " + layer.getHeight() + " pixels tall.");

        // We will shift the overlay image over the background this amount.
        int shiftX = 72;
        int shiftY = 30;

        //These three values set the reference color for transparency
        int redClear = 255;
        int greenClear = 255;
        int blueClear = 255;

        //Any color that is within this tolerance of the reference color will be transparent
        //A higher value means a wider range of colors will be set transparent
        double tolerance = 130;

        //Make a composite of the background image and the overlay
        layerImages(shiftX, shiftY, redClear, greenClear, blueClear, tolerance);

        // 
        Canvas mainCanvas = new CTIS210Lab5();
        JFrame imageWindow = new JFrame("UFO over New Garden!");
        imageWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainCanvas.setSize(background.getWidth(), background.getHeight());
        imageWindow.add(mainCanvas);

        imageWindow.pack();
        imageWindow.setVisible(true);

        // Save the image as a PNG via ImageIO.
        ImageIO.write(background, "PNG", new File("transparency.png"));

    }

    /**
     *
     * Place a layer image onto a background image, making all the pixels of a
     * specified color transparent, within a given tolerance
     *
     * @param shiftX number of pixels to shift overlaid image horizontally
     * @param shiftY number of pixels to shift overlaid image vertically
     * @param redClear red component of chromakey color
     * @param greenClear green component of chromakey color
     * @param blueClear blue component of chromakey color
     * @param tolerance maximum distance in color space for which a pixel is
     * considered to be of the chromakey color
     */
    public static void layerImages(int shiftX, int shiftY,
            int redClear, int greenClear, int blueClear, double tolerance) {
        WritableRaster raster = background.getRaster();
        int width = layer.getWidth();
        int height = layer.getHeight();
        int lPixel, bPixel, lRed, lGreen, lBlue, bRed, bGreen, bBlue;

        // Slow method: scan all input (layer) image pixels, plotting only those which are not 
        // the reference color
        for (int w = 0; w < width; w++) {
            for (int h = 0; h < height; h++) {
                // I tried
                
                lPixel = layer.getRGB(w, h);
                bPixel = background.getRGB(w, h);
                
                lRed = (int) ((lPixel & 0b00000000111111110000000000000000) >>> 16); // Red level
                lGreen = (int) ((lPixel & 0b00000000000000001111111100000000) >>> 8);  // Green level
                lBlue = (int) (lPixel & 0b00000000000000000000000011111111);  // Blue level
                
                bRed = (int) ((bPixel & 0b00000000111111110000000000000000) >>> 16); // Red level
                bGreen = (int) ((bPixel & 0b00000000000000001111111100000000) >>> 8);  // Green level
                bBlue = (int) (bPixel & 0b00000000000000000000000011111111);  // Blue level
                
                int rOutput = (int)((alpha * lRed) + (1 - alpha) * bRed);
                int gOutput = (int)((alpha * lGreen) + (1 - alpha) * bGreen);
                int bOutput = (int)((alpha * lBlue) + (1 - alpha) * bBlue);
                
                //If the pixel color isn't close enough to the specified color of the overlay,
                //draw it on the background
                if (colorDistance(rOutput, gOutput, bOutput, redClear, greenClear, blueClear) > tolerance) {
                    raster.setPixel(w + shiftX, h + shiftY, new int[]{rOutput, gOutput, bOutput});
                }
            }
        }

    }

    /**
     *
     * Calculate the distance between two colors in RGB color space using
     * Pythagorean calculation
     *
     *
     * @param red1 red component of first color
     * @param green1 green component of first color
     * @param blue1 blue component of first color
     * @param red2 red component of second color
     * @param green2 green component of second color
     * @param blue2 blue component of second color
     * @return distance in color space
     */
    public static double colorDistance(int red1, int green1, int blue1,
            int red2, int green2, int blue2) {
        double distance;

        int redDist = red1 - red2;
        int greenDist = green1 - green2;
        int blueDist = blue1 - blue2;

        distance = Math.sqrt(redDist * redDist + greenDist * greenDist + blueDist * blueDist);

        return distance;
    }

    /**
     *
     * draw images and any other objects
     *
     * @param g graphics context of Canvas
     */
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(background, 0, 0, null);

        /*
        
        g2.setColor(Color.GREEN);  
        g2.draw(new Ellipse2D.Double(250, 300, 40, 40));  
        g2.fill(new Ellipse2D.Double(400, 100, 80, 30));
        g2.fill(new Ellipse2D.Double(150, -30, 40, 40));  
        g2.fill(new Ellipse2D.Double(200, 200, 80, -30));

         */
        
        // Base
        g2.setColor(Color.YELLOW);
        g2.fill(new Ellipse2D.Double(500, 300, 200, 200));
        
        // Tail
        g2.fill(new Rectangle2D.Double(600, 300, 100, 100));
        
        // Head
        g2.fill(new Ellipse2D.Double(525, 275, 125, 125));
        g2.setColor(Color.WHITE);
        g2.draw(new Ellipse2D.Double(525, 275, 125, 125));
        
        // Eyes
        g2.setColor(Color.BLACK);
        g2.fill(new Ellipse2D.Double(550, 350, 10, 10));
        g2.fill(new Ellipse2D.Double(575, 360, 10, 10));
        
        // Beak
        g2.setColor(new Color(216, 51, 0));
        g2.fill(new CubicCurve2D.Double(528, 360, 520, 410, 575, 410, 590, 400));
        
        // Text
        g2.setColor(Color.RED);
        g2.setFont(new Font("Times New Roman", Font.BOLD, 20));
        String text = "Quack";
        int width = g2.getFontMetrics().stringWidth(text);
        g2.drawString(text, 600 - width / 2, 525);
        
        text = "I love working with splines!";
        width = g2.getFontMetrics().stringWidth(text);
        g2.drawString(text, 600 - width / 2, 250);
    }

}
