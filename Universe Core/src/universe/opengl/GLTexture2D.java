/*
 * Copyright (c) 2016, Aleman778. All rights reserved.
 * License terms are in the included LICENSE file.
 */
package universe.opengl;

import static org.lwjgl.opengl.GL11.*;
import universe.rendering.ArrayBitmap;
import universe.rendering.Texture;
import universe.util.BufferUtils;

/**
 * OpenGL texture.
 * @author Aleman778
 * @since Universe Core 1.0
 */
public final class GLTexture2D extends Texture {
    /**
     * The OpenGL bound shader program.
     */
    private static int glBoundTexture = 0;
    
    /**
     * The OpenGL texture reference.
     */
    private int tex;
    
    /**
     * Constructor.
     */
    public GLTexture2D() {
        super();
        tex = glGenTextures();
    }

    /**
     * Constructor.
     * @param image the texture image.
     */
    public GLTexture2D(ArrayBitmap image) {
        super(image);
        tex = glGenTextures();
        setImage(image);
    }
    
    /**
     * Get OpenGL filter option.
     * @param filter the filter option
     * @return the OpenGL filter option
     */
    private static int glGetFilter(Filter filter) {
        switch (filter) {
            case NEAREST: return GL_NEAREST;
            case LINEAR: return GL_LINEAR;
        }
        
        return -1;
    }
    
    /**
     * Bind this texture.
     */
    @Override
    public void bind() {
        if (isBound())
            return;
        
        glBindTexture(GL_TEXTURE_2D, tex);
        glBoundTexture = tex;
    }
    
    /**
     * Unbind this texture.
     */
    @Override
    public void unbind() {
        glBindTexture(GL_TEXTURE_2D, 0);
        glBoundTexture = 0;
    }
    
    /**
     * Check if this texture is bound.
     * @return true if the texture is bound
     */
    public boolean isBound() {
        return (glBoundTexture == tex);
    }
    
    /**
     * Set image data from provided image.
     * @param image 
     */
    public void setImage(ArrayBitmap image) {
        bind();
        glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, getWidth(), getHeight(), 0,GL_RGBA,
                GL_UNSIGNED_BYTE, BufferUtils.createIntBuffer(image.getPixels()));
    }
    
    /**
     * Set the minification filtering option.
     * @param filter the minification filter
     */
    @Override
    public void setMinFilter(Filter filter) {
        bind();
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, glGetFilter(filter));
    }
    
    /**
     * Set the magnification filtering option.
     * @param filter the magnification filter
     */
    @Override
    public void setMagFilter(Filter filter) {
        bind();
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, glGetFilter(filter));
    }
}
