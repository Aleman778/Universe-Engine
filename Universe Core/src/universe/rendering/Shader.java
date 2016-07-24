/*
 * Copyright (c) 2016, Aleman778. All rights reserved.
 * License terms are in the included LICENSE file.
 */
package universe.rendering;

import universe.util.Disposable;
import universe.util.FileUtils;

/**
 * Abstract shader used to render objects.
 * 
 * A Shader is resposible for the actual rendering of objects. A full shader program
 * typically uses two different shaders or more in order to render objects.
 * 
 * There are different types of shaders, for instance there is the vertex shader and
 * fragment (or pixel) shader. The vertex shader is reposible for the different vertices
 * and sending them to the fragment shader which provides color per pixel on the face.
 * 
 * Building a shader program requires atleast a vertex- and fragment shader.
 * @author Aleman778
 * @since Universe Core 1.0
 */
public abstract class Shader implements Disposable {
    /**
     * Different types of shaders.
     */
    public enum ShaderType {
        VERTEX, FRAGMENT, GEOMETRY
    }
    
    /**
     * The specific type of shader.
     */
    protected ShaderType type;
    
    /**
     * Shader compiled flag.
     */
    protected boolean compiled;
    
    /**
     * Constructor.
     * @param type the type of shader
     */
    public Shader(ShaderType type) {
        this.type = type;
        this.compiled = false;
    }
    
    /**
     * Compiles the shader.
     */
    public abstract void compile();
    
    /**
     * Disposes the shader.
     * Note: shader cannot be used after disposing.
     */
    @Override
    public abstract void dispose();

    /**
     * Set shader source code.
     * @param source the source code
     */
    public abstract void setSource(String source);
    
    /**
     * Get the compiled status.
     * @return true if the shader is compiled
     */
    public boolean isCompiled() {
        return compiled;
    }
}
