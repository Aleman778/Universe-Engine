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

    public GLSLShader(ShaderType type) {
        super(type);
        shader = glCreateShader(glGetShaderType(type));
    }

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

    @Override
    public void dispose() {
        if (shader == -1) {
            throw new NullPointerException("Shader could not be disposed. Shader does not exist.");
        }
        
        glDeleteShader(shader);
        compiled = false;
        shader = -1;
    }

    @Override
    public void setSource(String source) {
        glShaderSource(shader, source);
    }
    
    public int getRef() {
        return shader;
    }
}
