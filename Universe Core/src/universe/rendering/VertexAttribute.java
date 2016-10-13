/*
 * Copyright (c) 2016, Aleman778. All rights reserved.
 * License terms are in the included LICENSE file.
 */
package universe.rendering;

/**
 * Vertex attribute class.
 * @author Aleman778
 * @since Universe Core 1.0
 */
public class VertexAttribute {
    /**
     * The name of the attibute.
     */
    private final String name;
    
    /**
     * The number of components in attribute.
     */
    private final int count;
    
    /**
     * The attribute offset in layout.
     */
    private final int offset;
    
    /**
     * The location reference to the attribute.
     */
    private final int location;

    /**
     * Constructor.
     * @param name the attribute name
     * @param count the number of components
     * @param offset the attribute offset in layout
     * @param location the location reference to attribute
     */
    public VertexAttribute(String name, int count, int offset, int location) {
        this.name = name;
        this.count = count;
        this.offset = offset;
        this.location = location;
    }

    public String getName() {
        return name;
    }
    
    public int getCount() {
        return count;
    }

    public int getOffset() {
        return offset;
    }
    
    public int getLocation() {
        return location;
    }
}
