import java.awt.*;
import java.util.*;
public class Client {
    public static void main(String[] args) {
        // Make a picture of 500 x 500 pixels
        Picture p = new Picture(500, 500);
        // Make the pictures origin the lower-left of the screen
        // (rather than the upper-left)
        p.setOriginLowerLeft();
        // Get the pixels out of the image as a 2d Color array
        Color[][] pixels = p.getPixels();
        System.out.println(pixels.length);

        // TODO: Modify pixels as desired
        Color myColor = new Color(255,0,0);
        drawHorizontalLine(pixels, 400, myColor);
        myColor = new Color(20,255,255);
        drawVerticalLine(pixels, 400, myColor);

        // Update the picture with our new pixels
        p.setPixels(pixels);
        // Save (and display) the updated picture
        p.save("updated.png");
    }

    // Behavior: Fills the provided 2d array of color 'pixels' with the provided Color 'c'
    // Parameters:
    //      pixels - The 2d array to fill
    //      c - The color to fill with
    public static void fill(Color[][] pixels, Color c) {
        // Provided as an example!
        for (int y = 0; y < pixels.length; y++) {
            for (int x = 0; x < pixels[y].length; x++) {
                pixels[y][x] = c;
            }
        }
    }

    // Behavior: Draws a horizontal line within the provided 2d array or Color 'pixels' at
    //           value 'y' with Color 'c'
    // Parameters:
    //      pixels - The 2d array to draw the line within
    //      y - The pixel-space y value to draw the line at
    //      c - The color to make the line
    public static void drawHorizontalLine(Color[][] pixels, int y, Color c) {
        // TODO: Implement
        for(int i = 0; i<pixels[y].length; i++){
            pixels[y][i] = c;
        }
    }

    // Behavior: Draws a vertical line within the provided 2d array or Color 'pixels' at
    //           value 'x' with Color 'c'
    // Parameters:
    //      pixels - The 2d array to draw the line within
    //      x - The pixel-space x value to draw the line at
    //      c - The color to make the line
    public static void drawVerticalLine(Color[][] pixels, int x, Color c) {
        // TODO: Implement
        for(int i = 0; i<pixels.length; i++){
            pixels[i][x] = c;
        }
    }
}
