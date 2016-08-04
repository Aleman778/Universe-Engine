/*
 * Copyright (c) 2016, Aleman778. All rights reserved.
 * License terms are in the included LICENSE file.
 */
package universe.rendering;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Bitmap image stored in a int array.
 * @author Aleman778
 * @since Universe Core 1.0
 */
public class ArrayBitmap {
    
    private int width;
    
    private int height;
    
    private int[] pixels;

    public ArrayBitmap(int width, int height) {
        this.width = width;
        this.height = height;
        this.pixels = new int[width * height];
    }
    
    public static ArrayBitmap load(String resource) {
        try {
            BufferedImage image = ImageIO.read(ArrayBitmap.class.getResourceAsStream("/" + resource));
            ArrayBitmap map = new ArrayBitmap(image.getWidth(), image.getHeight());
            
            int[] data = map.getPixels();
            image.getRGB(0, 0, map.getWidth(), map.getHeight(), data, 0, map.getWidth());
            for (int i = 0; i < map.getWidth() * map.getHeight(); i++) {
                int a = (data[i] & 0xFF000000) >> 24;
                int r = (data[i] & 0xFF0000) >> 16;
                int g = (data[i] & 0xFF00) >> 8;
                int b = (data[i] & 0xFF);

                data[i] = a << 24 | b << 16 | g << 8 | r;
            }
            
            return map;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        return null;
    }

    public int[] getPixels() {
        return pixels;
    }

    public int getIndex(int x, int y) {
        return x + y * width;
    }
    
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
        
    public int get(int x, int y) {
        return pixels[getIndex(x, y)];
    }
    
    public void set(int x, int y, int color) {
        pixels[getIndex(x, y)] = color;
    }
    
    public void clear(int color) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                set(i, j, color);
            }
        }
    }
}
