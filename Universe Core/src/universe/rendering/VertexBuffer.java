/*
 * Copyright (c) 2016, Aleman778. All rights reserved.
 * License terms are in the included LICENSE file.
 */
package universe.rendering;

/**
 * Abstract Vertex Buffer is a basic class handling buffers
 * @author Aleman778
 * @since Universe Core 1.0
 */
public abstract class VertexBuffer {
    /**
     * Element count in buffer.
     */
    protected int count;
    
    /**
     * Buffer size in bytes.
     */
    protected long size;

    /**
     * Constructor.
     */
    public VertexBuffer() {
        size = 0;
        count = 0;
    }
    
    /**
     * Set array data to this buffer.
     * @param data the flaot array data to use
     */
    public abstract void setArray(float[] data);
    
    /**
     * Bind the vertex buffer object.
     */
    public abstract void bind();
    
    /**
     * Unbind the vertex buffer object.
     */
    public abstract void unbind();
    
    /**
     * Disposes the buffer.
     * Note: buffer cannot be used after disposing.
     */
    public abstract void dispose();
    
    /**
     * Get the number of elements in the buffer.
     * @return 
     */
    public int getCount() {
        return count;
    }
    
    /**
     * Get the size of this buffer in bytes.
     * @return 
     */
    public long getSize() {
        return size;
    }
}
