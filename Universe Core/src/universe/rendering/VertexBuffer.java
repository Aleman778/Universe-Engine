/*
 * Copyright (c) 2016, Aleman778. All rights reserved.
 * License terms are in the included LICENSE file.
 */
package universe.rendering;

/**
 * Abstract Vertex Buffer is a basic class handling buffers.
 * @author Aleman778
 * @since Universe Core 1.0
 */
public abstract class VertexBuffer extends Buffer {
    /**
     * Constructor.
     */
    public VertexBuffer() {
        count = 0;
        size = 0;
    }
    
    /**
     * Set array data to this buffer.
     * @param data the flaot array data to use
     */
    public void setData(float[] data) {
        count = data.length;
        size = data.length * Float.BYTES;
    }
    
    /**
     * Bind the vertex buffer object.
     */
    @Override
    public abstract void bind();
    
    /**
     * Unbind the vertex buffer object.
     */
    @Override
    public abstract void unbind();
    
    /**
     * Disposes the buffer.
     * Note: buffer cannot be used after disposing.
     */
    @Override
    public abstract void dispose();
}
