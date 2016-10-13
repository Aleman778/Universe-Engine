/*
 * Copyright (c) 2016, Aleman778. All rights reserved.
 * License terms are in the included LICENSE file.
 */
package universe.opengl;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.*;
import universe.rendering.VertexArray;
import universe.rendering.VertexAttribute;
import universe.rendering.VertexLayout;

/**
 * OpenGL vertex array.
 * @author Aleman778
 * @since Universe Core 1.0
 */
public final class GLVertexArray extends VertexArray {
    
    private int array;
    
    /**
     * Constructor.
     */
    public GLVertexArray() {
        super();
        array = glGenVertexArrays();
    }
    
    /**
     * Bind the vertex array.
     */
    @Override
    public void bind() {
        glBindVertexArray(array);
        super.bind();
        
        if (layout != null) {
            for (int i = 0; i < layout.getSize(); i++) {
                glEnableVertexAttribArray(i);
            }
        }
    }

    /**
     * Unbind the vertex array.
     */
    @Override
    public void unbind() {
        super.unbind();
        glBindVertexArray(0);
        
        if (layout != null) {
            for (int i = 0; i < layout.getSize(); i++) {
                glDisableVertexAttribArray(i);
            }
        }
    }
    
    /**
     * Disposes the vertex array.
     * Note: vertex array cannot be used after disposing.
     */
    @Override
    public void dispose() {
        super.dispose();
        glDeleteVertexArrays(array);
        buffers.clear();
        array = -1;
        
        if (layout != null) {
            for (int i = 0; i < layout.getSize(); i++) {
                glDisableVertexAttribArray(i);
            }
            layout = null;
        }
    }
    
    /**
     * Draw the vertex array.
     */
    @Override
    public void draw() {
        if (ibo != null) {
            glDrawElements(GL_TRIANGLES, ibo.getCount(), GL_UNSIGNED_INT, 0);
        } else if (vbo != null) {
            glDrawArrays(GL_TRIANGLES, 0, vbo.getCount());
        }
    }
    
    @Override
    public void setLayout(VertexLayout layout) {
        super.setLayout(layout);
        
        vbo.bind();
        for (VertexAttribute attrib: layout.getAttributes()) {
            glVertexAttribPointer(attrib.getLocation(), attrib.getCount(),
                    GL_FLOAT, false, layout.getStride(), attrib.getOffset());
        }
        vbo.unbind();
    }
}
