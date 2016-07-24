/*
 * Copyright (c) 2016, Aleman778. All rights reserved.
 * License terms are in the included LICENSE file.
 */
package universe.rendering;

/**
 * Abstract shader program used for combining shaders in order to render objects.
 * Note: Shaders has to be <b>enabled</b> in order to use it for rendering.
 * Call the <i>enable()</i> function to enable the shader.
 * @author Aleman778
 * @since Universe Core 1.0
 */
public abstract class ShaderProgram {
    /**
     * Constructor.
     */
    public ShaderProgram() {
    }
    
    /**
     * Attach a shader to this program.
     * @param shader the shader to attach
     */
    public abstract void attach(Shader shader);

    /**
     * Preparing the shader for use.
     * Note: shaders has to be attached before program is ready
     */
    public abstract void ready();
    
    /**
     * Enable this shader. 
     * Note: only enabled shader can be used for rendering.
     */
    public abstract void enable();
    
    /**
     * Disable this shader.
     * Note: only enabled shader can be used for rendering.
     */
    public abstract void disable();
    
    /**
     * Check if shader is enabled.
     * @return true if the shader program is enabled
     */
    public abstract boolean isEnabled();
}