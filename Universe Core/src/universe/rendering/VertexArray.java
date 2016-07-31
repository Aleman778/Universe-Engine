/*
 * Copyright (c) 2016, Aleman778. All rights reserved.
 * License terms are in the included LICENSE file.
 */
package universe.rendering;

import java.util.HashSet;
import universe.util.Disposable;

/**
 * Abstract vertex array.
 * @author Aleman778
 * @since Universe Core 1.0
 */
public abstract class VertexArray implements Disposable {
    /**
     * Main index buffer in vertex array.
     */
    protected IndexBuffer ibo;
    
    /**
     * Main vertex buffer in vertex array.
     */
    protected VertexBuffer vbo;
    
    /**
     * Vertex attribute layout.
     */
    protected VertexLayout layout;
    
    /**
     * List of all buffers in vertex array.
     */
    protected HashSet<Buffer> buffers;
    
    /**
     * Constructor.
     */
    public VertexArray() {
        buffers = new HashSet<>();
        layout = null;
        ibo = null;
        vbo = null;
    }
    
    /**
     * Push buffer to vertex array. 
     * @param buffer the buffer to push
     */
    public void push(Buffer buffer) {
        buffers.add(buffer);
        
        if (buffer instanceof IndexBuffer) {
            ibo = (IndexBuffer) buffer;
        }
        
        if (buffer instanceof VertexBuffer) {
            vbo = (VertexBuffer) buffer;
        }
    }
    
    /**
     * Bind the vertex array.
     */
    public void bind() {
        if (ibo != null) {
            ibo.bind();
        } else {
            for (Buffer buf: buffers) {
                buf.bind();
            }
        }
    }
    
    /**
     * Unbind the vertex array.
     */
    public void unbind() {
        if (ibo != null) {
            ibo.unbind();
        } else {
            for (Buffer buf: buffers) {
                buf.unbind();
            }
        }
    }
    
    /**
     * Disposes the vertex array.
     * Note: vertex array cannot be used after disposing.
     */
    @Override
    public void dispose() {
        for (Buffer buf: buffers) {
            buf.dispose();
        }
    }
        
    /**
     * Set a layout of this vertex buffer.
     * @param layout the vertex layout to set
     */
    public void setLayout(VertexLayout layout) {
        this.layout = layout;
    }
    
    /**
     * Draw the vertex array.
     */
    public abstract void draw();
}
