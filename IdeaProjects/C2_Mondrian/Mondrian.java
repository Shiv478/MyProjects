import java.util.*;
import java.awt.*;

public class Mondrian {

    public Mondrian(){

    }
    /*
    private static void completeFill(Color newColor, Color[][] pixels, int x1, int x2, int y1, int y2){
        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                if (i > x1 && i < x2 - 1 && j > y1 && j < y2 - 1) {
                    pixels[j][i] = newColor;
                }
            }
        }
    }
    public static void fill(Color[][] pixels, int x1, int x2, int y1, int y2) {
        Color newColor;
        int randomColorNumber = (int) (Math.random() * 4) + 1;
        if(randomColorNumber == 1){
            newColor = Color.RED;
        }else if(randomColorNumber == 2){
            newColor = Color.YELLOW;
        }else if(randomColorNumber == 3){
            newColor = Color.CYAN;
        }else{
            newColor = Color.WHITE;
        }
        //System.out.println(x1 + "," + x2 + "," + y1 + "," + y2 + "," + newColor);
        completeFill(newColor, pixels, x1, x2, y1, y2);
    }
    public void paintBasicMondrian(Color[][] pixels){
        paintBasicMondrian(pixels,0,pixels[0].length, 0,pixels.length);
    }
    private void paintBasicMondrian(Color[][] pixels, int x1, int x2, int y1, int y2){
        int widthCanvas = pixels[0].length;
        int lengthCanvas = pixels.length;
        int midX = (int) (Math.random() * (x2 - x1 + 1)) + x1;
        while(!((midX - x1 >= 10) && (x2 - midX >= 10))){
            midX = (int) (Math.random() * (x2 - x1 + 1)) + x1;
        }
        int midY = (int) (Math.random() * (y2 - y1 + 1)) + y1;
        while(!((midY - y1 >= 10) && (y2 - midY >= 10))){
            midY = (int) (Math.random() * (y2 - y1 + 1)) + y1;
        }
        if(((x2 - x1) < (widthCanvas/4)) && ((y2 - y1) < (lengthCanvas/4)) || (x2 - x1 < 10 || y2 - y1 < 10)){
            fill(pixels, x1, x2, y1, y2);
        }else{
            if(((x2 - x1) >= (widthCanvas/4)) && ((y2 - y1) >= (lengthCanvas/4))){
                // Recursively divide each quadrant
                paintBasicMondrian(pixels, x1, midX, y1, midY); // Top-left quadrant
                paintBasicMondrian(pixels,midX, x2, y1, midY); // Top-right quadrant
                paintBasicMondrian(pixels, x1, midX, midY, y2); // Bottom-left quadrant
                paintBasicMondrian(pixels,midX, x2, midY, y2); // Bottom-right quadrant
            }else if((x2 - x1) >= (widthCanvas/4)){
                paintBasicMondrian(pixels, x1, midX, y1, y2);
                paintBasicMondrian(pixels, midX, x2, y1, y2);
            }else if((y2 - y1) >= (lengthCanvas/4)){
                paintBasicMondrian(pixels,x1, x2, y1,midY);
                paintBasicMondrian(pixels,x1,x2, midY,y2);
            }
        }
    }
    public void paintComplexMondrian(Color[][] pixels){
        paintComplexMondrian(pixels, 0, pixels[0].length, 0, pixels.length);
    }
    private void paintComplexMondrian(Color[][] pixels, int x1, int x2, int y1, int y2){
        int widthCanvas = pixels[0].length;
        int lengthCanvas = pixels.length;
        int midX = (int) (Math.random() * (x2 - x1 + 1)) + x1;
        while(!((midX - x1 >= 10) && (x2 - midX >= 10))){
            midX = (int) (Math.random() * (x2 - x1 + 1)) + x1;
        }
        int midY = (int) (Math.random() * (y2 - y1 + 1)) + y1;
        while(!((midY - y1 >= 10) && (y2 - midY >= 10))){
            midY = (int) (Math.random() * (y2 - y1 + 1)) + y1;
        }
        if(((x2 - x1) < (widthCanvas/4)) && ((y2 - y1) < (lengthCanvas/4)) || (x2 - x1 < 10 || y2 - y1 < 10)){
            fillComplex(pixels, x1, x2, y1, y2);
        }else{
            if(((x2 - x1) >= (widthCanvas/4)) && ((y2 - y1) >= (lengthCanvas/4))){
                // Recursively divide each quadrant
                paintComplexMondrian(pixels, x1, midX, y1, midY); // Top-left quadrant
                paintComplexMondrian(pixels,midX, x2, y1, midY); // Top-right quadrant
                paintComplexMondrian(pixels, x1, midX, midY, y2); // Bottom-left quadrant
                paintComplexMondrian(pixels,midX, x2, midY, y2); // Bottom-right quadrant
            }else if((x2 - x1) >= (widthCanvas/4)){
                paintComplexMondrian(pixels, x1, midX, y1, y2);
                paintComplexMondrian(pixels, midX, x2, y1, y2);
            }else if((y2 - y1) >= (lengthCanvas/4)){
                paintComplexMondrian(pixels,x1, x2, y1,midY);
                paintComplexMondrian(pixels,x1,x2, midY,y2);
            }
        }
    }
    public static void fillComplex(Color[][] pixels, int x1, int x2, int y1, int y2) {
        Color newColor;
        int randomColorNumber = (int) (Math.random() * 5) + 1;
        int midXCanvas = pixels[0].length/2;
        int midYCanvas = pixels.length/2;
        int midXBox = (x2 - x1) / 2;
        int midYBox =(y2 - y1) / 2;
        System.out.println(randomColorNumber);
        if((midXBox<midXCanvas && midYBox<midYCanvas)){ //Top Left
            if(randomColorNumber == 1 || randomColorNumber == 2){
                newColor = Color.RED;
            }else if(randomColorNumber == 3){
                newColor = Color.YELLOW;
            }else if(randomColorNumber == 4){
                newColor = Color.CYAN;
            }else{
                newColor = Color.WHITE;
            }
        }else if((midXBox< midXCanvas) && (midYBox>midYCanvas)){//Bottom Left
            if(randomColorNumber == 1){
                newColor = Color.RED;
            }else if(randomColorNumber == 2 || randomColorNumber == 5){
                newColor = Color.YELLOW;
            }else if(randomColorNumber == 3){
                newColor = Color.CYAN;
            }else{
                newColor = Color.WHITE;
            }
        }else if((midXBox > midXCanvas) && (midYBox > midYCanvas)){ //Top Right
            if(randomColorNumber == 1){
                newColor = Color.RED;
            }else if(randomColorNumber == 2){
                newColor = Color.YELLOW;
            }else if(randomColorNumber == 3 || randomColorNumber == 5){
                newColor = Color.CYAN;
            }else{
                newColor = Color.WHITE;
            }
        }else{ //Bottom Right
            if(randomColorNumber == 1){
                newColor = Color.RED;
            }else if(randomColorNumber == 2){
                newColor = Color.YELLOW;
            }else if(randomColorNumber == 3){
                newColor = Color.CYAN;
            }else{
                newColor = Color.WHITE;
            }
        }
        //System.out.println(x1 + "," + x2 + "," + y1 + "," + y2 + "," + newColor);
        completeFill(newColor, pixels, x1, x2, y1, y2);
    }*/

    private static void colorFiller(Color[][] pixels, int x1, int x2, int y1, int y2, Color newColor){
        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                if (i > x1 && i < x2 - 1 && j > y1 && j < y2 - 1) {
                    pixels[j][i] = newColor; // White color inside, leaving a 1-pixel black border
                }
            }
        }
    }
    public static void fill(Color[][] pixels, int x1, int x2, int y1, int y2) {
            Color newColor;
            int randomColorNumber = (int) (Math.random() * 4) + 1;
            if(randomColorNumber == 1){
                newColor = Color.RED;
            }else if(randomColorNumber == 2){
                newColor = Color.YELLOW;
            }else if(randomColorNumber == 3){
                newColor = Color.CYAN;
            }else{
                newColor = Color.WHITE;
            }
            System.out.println(x1 + "," + x2 + "," + y1 + "," + y2 + "," + newColor);
            colorFiller(pixels, x1, x2, y1, y2, newColor);

    }
    public void paintBasicMondrian(Color[][] pixels){
            paintBasicMondrian(pixels,0,pixels[0].length, 0,pixels.length);
    }
    private void paintBasicMondrian(Color[][] pixels, int x1, int x2, int y1, int y2){
            int widthCanvas = pixels[0].length;
            int lengthCanvas = pixels.length;
            if(((x2 - x1) < (widthCanvas/4)) && ((y2 - y1) < (lengthCanvas/4)) || (x2 - x1 < 10 || y2 - y1 < 10)){
                fill(pixels, x1, x2, y1, y2);
            }else{
                if(((x2 - x1) >= (widthCanvas/4)) && ((y2 - y1) >= (lengthCanvas/4))){
                    int midX = (int) (Math.random() * (x2 - x1 + 1)) + x1;
                    while(!((midX - x1 >= 10) && (x2 - midX >= 10))){
                        midX = (int) (Math.random() * (x2 - x1 + 1)) + x1;
                    }
                    int midY = (int) (Math.random() * (y2 - y1 + 1)) + y1;
                    while(!((midY - y1 >= 10) && (y2 - midY >= 10))){
                        midY = (int) (Math.random() * (y2 - y1 + 1)) + y1;
                    }
                    // Recursively divide each quadrant
                    paintBasicMondrian(pixels, x1, midX, y1, midY); // Top-left quadrant
                    paintBasicMondrian(pixels,midX, x2, y1, midY); // Top-right quadrant
                    paintBasicMondrian(pixels, x1, midX, midY, y2); // Bottom-left quadrant
                    paintBasicMondrian(pixels,midX, x2, midY, y2); // Bottom-right quadrant
                }else if((x2 - x1) >= (widthCanvas/4)){
                    int midX = (int) (Math.random() * (x2 - x1 + 1)) + x1;
                    while(!((midX - x1 >= 10) && (x2 - midX >= 10))){
                        midX = (int) (Math.random() * (x2 - x1 + 1)) + x1;
                    }
                    paintBasicMondrian(pixels, x1, midX, y1, y2);
                    paintBasicMondrian(pixels, midX, x2, y1, y2);
                }else if((y2 - y1) >= (lengthCanvas/4)){
                    int midY = (int) (Math.random() * (y2 - y1 + 1)) + y1;
                    while(!((midY - y1 >= 10) && (y2 - midY >= 10))){
                        midY = (int) (Math.random() * (y2 - y1 + 1)) + y1;
                    }
                    paintBasicMondrian(pixels,x1, x2, y1,midY);
                    paintBasicMondrian(pixels,x1,x2, midY,y2);
                }
            }
    }
    public void paintComplexMondrian(Color[][] pixels){
            paintComplexMondrian(pixels, 0, pixels[0].length, 0, pixels.length);
    }
    private void paintComplexMondrian(Color[][] pixels, int x1, int x2, int y1, int y2){
            int widthCanvas = pixels[0].length;
            int lengthCanvas = pixels.length;
            if(((x2 - x1) < (widthCanvas/4)) && ((y2 - y1) < (lengthCanvas/4)) || (x2 - x1 < 10 || y2 - y1 < 10)){
                fillComplex(pixels, x1, x2, y1, y2);
            }else{
                if(((x2 - x1) >= (widthCanvas/4)) && ((y2 - y1) >= (lengthCanvas/4))){
                    int midX = (int) (Math.random() * (x2 - x1 + 1)) + x1;
                    while(!((midX - x1 >= 10) && (x2 - midX >= 10))){
                        midX = (int) (Math.random() * (x2 - x1 + 1)) + x1;
                    }
                    int midY = (int) (Math.random() * (y2 - y1 + 1)) + y1;
                    while(!((midY - y1 >= 10) && (y2 - midY >= 10))){
                        midY = (int) (Math.random() * (y2 - y1 + 1)) + y1;
                    }
                    // Recursively divide each quadrant
                    paintComplexMondrian(pixels, x1, midX, y1, midY); // Top-left quadrant
                    paintComplexMondrian(pixels,midX, x2, y1, midY); // Top-right quadrant
                    paintComplexMondrian(pixels, x1, midX, midY, y2); // Bottom-left quadrant
                    paintComplexMondrian(pixels,midX, x2, midY, y2); // Bottom-right quadrant
                }else if((x2 - x1) >= (widthCanvas/4)){
                    int midX = (int) (Math.random() * (x2 - x1 + 1)) + x1;
                    while(!((midX - x1 >= 10) && (x2 - midX >= 10))){
                        midX = (int) (Math.random() * (x2 - x1 + 1)) + x1;
                    }
                    paintComplexMondrian(pixels, x1, midX, y1, y2);
                    paintComplexMondrian(pixels, midX, x2, y1, y2);
                }else if((y2 - y1) >= (lengthCanvas/4)){
                    int midY = (int) (Math.random() * (y2 - y1 + 1)) + y1;
                    while(!((midY - y1 >= 10) && (y2 - midY >= 10))){
                        midY = (int) (Math.random() * (y2 - y1 + 1)) + y1;
                    }
                    paintComplexMondrian(pixels,x1, x2, y1,midY);
                    paintComplexMondrian(pixels,x1,x2, midY,y2);
                }
            }
    }
    public static void fillComplex(Color[][] pixels, int x1, int x2, int y1, int y2) {
        Color newColor;
        int randomColorNumber = (int) (Math.random() * 4) + 1;
        if(randomColorNumber == 1){
            newColor = Color.RED;
        }else if(randomColorNumber == 2){
            newColor = Color.YELLOW;
        }else if(randomColorNumber == 3){
            newColor = Color.CYAN;
        }else{
            newColor = Color.WHITE;
        }

        // Fill upper-left triangle
        for (int i = x1; i < x2; i++) {
                for (int j = y1; j <= y1 + (i - x1); j++) { // Fill up to the diagonal
                    if (i > x1 && i < x2 - 1 && j > y1 && j < y2 - 1) {
                        pixels[j][i] = newColor; // Fill inside, leaving a 1-pixel border
                    }
                }
        }
    }
}


