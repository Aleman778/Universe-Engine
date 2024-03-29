/*
 * Copyright (c) 2016, Aleman778. All rights reserved.
 * License terms are in the included LICENSE file.
 */
package universe.rendering;

import universe.math.Matrix4;
import universe.util.Disposable;

/**
 * Simple material class, provides a shader, projection matrix and a main texture.
 * @author Aleman778
 * @since Universe Core 1.0
 */
public abstract class Material implements Disposable {
    
    protected ShaderProgram shader;
    
    protected Texture mainTexture;

    protected Matrix4 projection;
    
    public Material() {
        this.projection = new Matrix4();
        this.mainTexture = null;
        this.shader = null;
    }
    
    public abstract void bind();
    
    public abstract void unbind();

    @Override
    public void dispose() {
        shader.dispose();
        mainTexture.dispose();
    }

    public final Texture getMainTexture() {
        return mainTexture;
    }

    public final Matrix4 getProjection() {
        return projection;
    }

    public void setProjection(Matrix4 projection) {
        this.projection = projection;
        shader.setUniform("m_projection", projection);
    }
}
