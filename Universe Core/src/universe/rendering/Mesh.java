/*
 * Copyright (c) 2016, Aleman778. All rights reserved.
 * License terms are in the included LICENSE file.
 */
package universe.rendering;

/**
 * Simple mesh class.
 * @author Aleman778
 * @since Universe Core 1.0
 */
public class Mesh {
    
    private VertexBuffer buffer;
    
    private IndexBuffer indices;
    
    private VertexArray array;
    
    private Material material;

    public Mesh() {
        this(null, null, null, null);
    }
    
    public Mesh(Material material) {
        this(null, null, null, material);
    }

    public Mesh(VertexArray array, Material material) {
        this(array.vbo, null, array, material);
    }

    public Mesh(VertexArray array, IndexBuffer indices, Material material) {
        this(array.vbo, indices, array, material);
    }

    public Mesh(VertexBuffer buffer, IndexBuffer indices, VertexArray array, Material material) {
        this.buffer = buffer;
        this.indices = indices;
        this.array = array;
        this.material = material;
    }
        
    public void bind() {
        if (array != null) {
            material.bind();
            array.bind();
        } else {
            buffer.bind();
            material.bind();
        }
    }
    
    public void unbind() {
        array.unbind();
        buffer.unbind();
        material.unbind();
    }
    
    public void draw() {
        array.draw();
    }
    
    public void render() {
        bind();
        draw();
    }

    public VertexBuffer getBuffer() {
        return buffer;
    }

    public VertexArray getArray() {
        return array;
    }

    public IndexBuffer getIndices() {
        return indices;
    }

    public Material getMaterial() {
        return material;
    }
}
