/*
 * Copyright (c) 2016, Aleman778. All rights reserved.
 * License terms are in the included LICENSE file.
 */
package universe.opengl;

import java.util.HashMap;
import static org.lwjgl.opengl.GL20.*;
import universe.math.Mat4;
import universe.math.Vec2;
import universe.math.Vec3;
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
     * The OpenGL uniform references.
     */
    private final HashMap<String, Integer> uniforms;
    
    /**
     * The OpenGL shader program reference.
     */
    private int program;

    public GLSLShaderProgram() {
        program = glCreateProgram();
        uniforms = new HashMap<>();
    }

    /**
     * Attach a shader to this program.
     * @param shader the shader to attach.
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
     * Note: shaders has to be attached before program is ready.
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
        if (isEnabled())
            return;
        
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

    /**
     * Disposes the program.
     * Note: program cannot be used after disposing.
     */
    @Override
    public void dispose() {
        if (program == -1) {
            throw new ShaderException("Shader program could not be disposed."
                    + "Shader program does not exist.");
        }
        
        glDeleteProgram(program);
        program = -1;
    }
    
    /**
     * Set shader uniform variable value.
     * @param name the variable name
     * @param value the value of the uniform
     */
    @Override
    public void setUniform(String name, Integer value) {
        enable();
        glUniform1i(getUniform(name), value);
    }
    
    /**
     * Set shader uniform variable value.
     * @param name the variable name
     * @param value the value of the uniform
     */
    @Override
    public void setUniform(String name, Float value) {
        enable();
        glUniform1f(getUniform(name), value);
    }
    
    /**
     * Set shader uniform variable value.
     * @param name the variable name
     * @param value the value of the uniform
     */
    @Override
    public void setUniform(String name, Vec2 value) {
        enable();
        glUniform2fv(getUniform(name), value.toFloatBuffer());
    }
    
    /**
     * Set shader uniform variable value.
     * @param name the variable name
     * @param value the value of the uniform
     */
    @Override
    public void setUniform(String name, Vec3 value) {
        enable();
        glUniform3fv(getUniform(name), value.toFloatBuffer());
    }

    /**
     * Set shader uniform variable value.
     * @param name the variable name
     * @param value the value of the uniform
     */
    @Override
    public void setUniform(String name, Mat4 value) {
        enable();
        glUniformMatrix4fv(getUniform(name), false, value.toFloatBuffer());
    }
    
    /**
     * Get the uniform reference from name.
     * @param name the name of the uniform variable
     */
    private int getUniform(String name) {
        if (uniforms.containsKey(name)) {
            return uniforms.get(name);
        }
        
        int ref = glGetUniformLocation(program, name);
        if (ref == -1) {
            throw new ShaderException("Uniform \"" + name + "\" is not found in shader.");
        }
        
        return ref;
    }
}
