/*
 * Copyright (c) 2016, Aleman778. All rights reserved.
 * License terms are in the included LICENSE file.
 */
package universe.opengl;

import static org.lwjgl.opengl.GL15.*;
import universe.rendering.IndexBuffer;
import universe.util.BufferUtils;

/**
 * OpenGL index buffer.
 * @author Aleman778
 * @since Universe Core 1.0
 */
public final class GLIndexBuffer extends IndexBuffer {
    /**
     * The buffer object reference.
     */
    private final int buffer;
        
    /**
     * Constructor.
     * @param indices the int array of index data
     */
    public GLIndexBuffer(int[] indices) {
        super(indices);
        buffer = glGenBuffers();
        bind();
        glBufferData(GL_ELEMENT_ARRAY_BUFFER,
                BufferUtils.createIntBuffer(indices), GL_STATIC_DRAW);
        unbind();
        
    }
    
    /**
     * Bind the vertex buffer object.
     */
    @Override
    public void bind() {
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, buffer);
    }
    
    /**
     * Unbind the vertex buffer object.
     */
    @Override
    public void unbind() {
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, 0);
    }
    
    /**
     * Disposes the buffer.
     * Note: buffer cannot be used after disposing.
     */
    @Override
    public void dispose() {
        glDeleteBuffers(buffer);
    }
    
}
