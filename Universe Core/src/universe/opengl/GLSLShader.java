/*
 * Copyright (c) 2016, Aleman778. All rights reserved.
 * License terms are in the included LICENSE file.
 */
package universe.opengl;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL32.*;
import universe.rendering.Shader;
import universe.rendering.ShaderException;

/**
 * GLSL shader used for rendering objects.
 * @author Aleman778
 * @since Universe Core 1.0
 */
public final class GLSLShader extends Shader {
    /**
     * Shader object reference.
     */
    private int shader;
    
    /**
     * Shader compiled flag.
     */
    private boolean compiled;
    
    /**
     * Get opengl shader type.
     * @param type the shader type
     * @return the opengl shader type
     */
    private static int glGetShaderType(ShaderType type) {
        switch (type) {
            case VERTEX: return GL_VERTEX_SHADER;
            case FRAGMENT: return GL_FRAGMENT_SHADER;
            case GEOMETRY: return GL_GEOMETRY_SHADER;
        }
        
        return -1;
    }

    /**
     * Constructor.
     * @param type the shader type.
     */
    public GLSLShader(ShaderType type) {
        super(type);
        shader = glCreateShader(glGetShaderType(type));
    }

    /**
     * Compiles the shader.
     */
    @Override
    public void compile() {
        if (shader == -1) {
            throw new NullPointerException("Failed to compile shader. Shader does not exist.");
        }
        
        glCompileShader(shader);
        
        if (glGetShaderi(shader, GL_COMPILE_STATUS) == GL_TRUE) {
            compiled = true;
        } else {
            compiled = false;
            String log = glGetShaderInfoLog(shader);
            throw new ShaderException("Failed to compile shader:\n" + log);
        }
    }

    /**
     * Disposes the shader.
     * Note: shader cannot be used after disposing.
     */
    @Override
    public void dispose() {
        if (shader == -1) {
            throw new NullPointerException("Shader could not be disposed. Shader does not exist.");
        }
        
        glDeleteShader(shader);
        compiled = false;
        shader = -1;
    }

    /**
     * Set shader source code.
     * @param source the source code
     */
    @Override
    public void setSource(String source) {
        glShaderSource(shader, source);
    }

    /**
     * Get the compiled status.
     * @return true if the shader is compiled
     */
    @Override
    public boolean isCompiled() {
        return compiled;
    }
    
    /**
     * Get the opengl shader reference id.
     * @return the reference id
     */
    public int getRef() {
        return shader;
    }
}
