/*
 * Copyright (c) 2016, Aleman778. All rights reserved.
 * License terms are in the included LICENSE file.
 */
package universe.rendering;

/**
 * Abstract texture class uses a array bitmap as texture.
 * @author Aleman778
 * @since Universe Core 1.0
 */
public abstract class Texture {
    /**
     * Texture filtering options.
     */
    public enum Filter {
        NEAREST,
        LINEAR
    }
    
    /**
     * Bitmap image used as texture.
     */
    protected final ArrayBitmap image;

    /**
     * Constructor.
     */
    public Texture() {
        this.image = null;
    }
    
    /**
     * Constructor.
     * @param image the texture image.
     */
    public Texture(ArrayBitmap image) {
        this.image = image;
    }
    
    /**
     * Load texture from input stream.
     * @param resource
     * @return the loaded texture
     */
    public static Texture load(String resource) {
        return null;//new Texture(ArrayBitmap.load(resource));
    }
    
    /**
     * Bind this texture.
     */
    public abstract void bind();
    
    /**
     * Unbind this texture.
     */
    public abstract void unbind();
    
    /**
     * Set the minification filtering option.
     * @param filter the minification filter
     */
    public abstract void setMinFilter(Filter filter);
    
    /**
     * Set the magnification filtering option.
     * @param filter the magnification filter
     */
    public abstract void setMagFilter(Filter filter);
    
    /**
     * Get the width of this texture.
     * @return the width in pixels
     */
    public final int getWidth() {
        return image.getWidth();
    }
    
    /**
     * Get the height of this texture.
     * @return the height in pixels
     */
    public final int getHeight() {
        return image.getHeight();
    }
}
