/*
 * Copyright (c) 2016, Aleman778. All rights reserved.
 * License terms are in the included LICENSE file.
 */
package universe.opengl;

import static org.lwjgl.opengl.GL20.*;
import universe.rendering.Shader;
import universe.rendering.ShaderException;
import universe.rendering.ShaderProgram;

/**
 * Shader program with combined shaders used for rendering objects.
 * @author Aleman778
 * @since Universe Core 1.0
 */ 
public final class GLSLShaderProgram extends ShaderProgram {
    /**
     * The OpenGL bound shader program.
     */
    private static int glBoundProgram = 0;
    
    /**
     * The OpenGL shader program reference.
     */
    private int program;

    public GLSLShaderProgram() {
        program = glCreateProgram();
    }

    /**
     * Attach a shader to this program.
     * @param shader the shader to attach
     */
    @Override
    public void attach(Shader shader) {
        if (shader instanceof GLSLShader) {
            if (shader.isCompiled()) {
                glAttachShader(program, ((GLSLShader) shader).getRef());
            } else {
                throw new ShaderException("Attached shader is not compiled.");
            }
        } else {
            throw new ShaderException("Incompatible shading language with OpenGL, please use GLSLShader instead.");
        }
        
    }

    /**
     * Preparing the shader for use. OpenGL links the attached shaders and validates them.
     * Note: shaders has to be attached before program is ready
     */
    @Override
    public void ready() {
        glLinkProgram(program);
        glValidateProgram(program);
    }
    
    /**
     * Enable this shader.
     * Note: only enabled shader can be used for rendering.
     */
    @Override
    public void enable() {
        glUseProgram(program);
        glBoundProgram = program;
    }
    
    /**
     * Disable this shader.
     * Note: only enabled shader can be used for rendering.
     */
    @Override
    public void disable() {
        glUseProgram(0);
        glBoundProgram = 0;
    }
    
    /**
     * Check if shader is enabled.
     * @return true if the shader program is enabled
     */
    @Override
    public boolean isEnabled() {
        return (glBoundProgram == program);
    }
}
