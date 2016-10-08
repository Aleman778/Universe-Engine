/*
 * Copyright (c) 2016, Aleman778. All rights reserved.
 * License terms are in the included LICENSE file.
 */
package universe.rendering;

import static org.lwjgl.opengl.GL13.*;
import universe.util.Disposable;

/**
 * Abstract texture class uses a array bitmap as texture.
 * @author Aleman778
 * @since Universe Core 1.0
 */
public abstract class Texture implements Disposable {
    /**
     * Texture filtering options.
     */
    public enum Filter {
        NEAREST,
        LINEAR
    }
    
    protected int slot;
    
    /**
     * Bitmap image used as texture.
     */
    protected final ArrayBitmap image;

    /**
     * Constructor.
     */
    public Texture() {
        this.image = null;
        this.slot = 0;
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
    
    public static void activate(int slot) {
        if (slot < 0 || slot > 31) {
            throw new IllegalStateException("OpenGL texture slot out of bounds. Please use slot between 0 and 31.");
        } else {
            glActiveTexture(GL_TEXTURE0 + slot);
        }
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
     * Disposes the texture.
     * Note: texture cannot be used after disposing.
     */
    @Override
    public abstract void dispose();
    
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
     * Set this texture to an output slot.
     * @param slot the enabled slot
     */
    public void setSlot(int slot) {
        this.slot = slot;
    }
    
    /**
     * Get the active texture slot.
     * @return the active slot
     */
    public final int getSlot() {
        return slot;
    }
    
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
