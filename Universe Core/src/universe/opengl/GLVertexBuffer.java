/*
 * Copyright (c) 2016, Aleman778. All rights reserved.
 * License terms are in the included LICENSE file.
 */
package universe.opengl;

import static org.lwjgl.opengl.GL15.*;
import universe.rendering.VertexBuffer;
import universe.util.BufferUtils;

/**
 * OpenGL implementation for Vertex Buffers
 * @author Aleman778
 * @since Universe Core 1.0
 */
public final class GLVertexBuffer extends VertexBuffer {
    /**
     * The buffer object reference.
     */
    private int buffer;
    
    /**
     * Constructor.
     */
    public GLVertexBuffer() {
        super();
        buffer = glGenBuffers();
    }

    /**
     * Set array data to this buffer.
     * @param data the flaot array data to use
     */
    @Override
    public void setData(float[] data) {
        super.setData(data);
        
        bind();
        glBufferData(GL_ARRAY_BUFFER, BufferUtils.createFloatBuffer(data), GL_STATIC_DRAW);
        unbind();
    }

    
    /**
     * Bind the vertex buffer object.
     */
    @Override
    public void bind() {
        glBindBuffer(GL_ARRAY_BUFFER, buffer);
    }
    
    /**
     * Unbind the vertex buffer object.
     */
    @Override
    public void unbind() {
        glBindBuffer(GL_ARRAY_BUFFER, 0);
    }
    
    /**
     * Disposes the buffer.
     * Note: buffer cannot be used after disposing.
     */
    @Override
    public void dispose() {
        glDeleteBuffers(buffer);
        buffer = -1;
    }
}
