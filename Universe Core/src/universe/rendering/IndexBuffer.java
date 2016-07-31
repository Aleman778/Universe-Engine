/*
 * Copyright (c) 2016, Aleman778. All rights reserved.
 * License terms are in the included LICENSE file.
 */
package universe.rendering;

import universe.opengl.GLIndexBuffer;

/**
 * Abstract index buffer is a basic class handling buffer.
 * @author Aleman778
 * @since Universe Core 1.0
 */
public abstract class IndexBuffer extends Buffer {
    /**
     * Constructor.
     * @param indices the int array index data
     */
    public IndexBuffer(int[] indices) {
        count = indices.length;
        size = indices.length * Integer.BYTES;
    }
    
    public static IndexBuffer generate(int size) {
        int[] indices = new int[size];
        int offset = 0;
        
        for (int i = 0; i <= size - 6; i += 6) {
            indices[i + 0] = offset + 0;
            indices[i + 1] = offset + 1;
            indices[i + 2] = offset + 2;
            
            indices[i + 3] = offset + 2;
            indices[i + 4] = offset + 3;
            indices[i + 5] = offset + 0;
            
            offset += 4;
        }
        
        return new GLIndexBuffer(indices);
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
