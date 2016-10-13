/*
 * Copyright (c) 2016, Aleman778. All rights reserved.
 * License terms are in the included LICENSE file.
 */
package universe.rendering;

import universe.util.Disposable;

/**
 * Abstract buffer.
 * @author Aleman778
 * @since Universe Core 1.0
 */
public abstract class Buffer implements Disposable {
    /**
     * Element count in buffer.
     */
    protected int count;
    
    /**
     * Buffer size in bytes.
     */
    protected long size;
    
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
    @Override
    public abstract void dispose();
    
    /**
     * Get the number of elements in the buffer.
     * @return 
     */
    public final int getCount() {
        return count;
    }
    
    /**
     * Get the size of this buffer in bytes.
     * @return 
     */
    public final long getSize() {
        return size;
    }
}
