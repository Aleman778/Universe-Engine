/*
 * Copyright (c) 2016, Aleman778. All rights reserved.
 * License terms are in the included LICENSE file.
 */
package universe.rendering;

import java.util.ArrayList;

/**
 * Vertex layout class.
 * @author Aleman778
 * @since Universe Core 1.0
 */
public class VertexLayout {
    
    private int offset;
    
    private int stride;
    
    private final ArrayList<VertexAttribute> attributes;

    public VertexLayout() {
        attributes = new ArrayList<>();
        stride = 0;
        offset = 0;
    }
    
    public void push(String name, int count) {
        VertexAttribute attri =
                new VertexAttribute(name, count, offset * Float.BYTES, getSize());
        attributes.add(attri);
        offset += count;
        stride = offset * Float.BYTES;
    }

    public VertexLayout(int stride, ArrayList<VertexAttribute> attributes) {
        this.stride = stride;
        this.attributes = attributes;
    }

    public ArrayList<VertexAttribute> getAttributes() {
        return attributes;
    }

    public int getStride() {
        return stride;
    }
    
    public int getSize() {
        return attributes.size();
    }
}
