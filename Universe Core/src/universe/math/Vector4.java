package universe.math;

import java.nio.FloatBuffer;
import universe.util.BufferUtils;

/**
 * Four component vector.
 * @author Aleman778
 * @since Universe Core 1.0
 */
public class Vector4 {
    /**
     * The x component of the vector.
     */
    public int x;
    
    /**
     * The y component of the vector.
     */
    public int y;
    
    /**
     * The z component of the vector.
     */
    public int z;
    
    /**
     * The w component of the vector.
     */
    public int w;
    
    /**
     * Constructor.
     * Creates a zero vector.
     */
    public Vector4() {
        this(0, 0, 0, 0);
    }
    
    /**
     * Constructor.
     * Creates a clone of the provided vector.
     * @param vec the vector to clone from
     */
    public Vector4(Vector4 vec) {
        this(vec.x, vec.y, vec.z, vec.w);
    }

    /**
     * Constructor.
     * Creates a vector based on the provided parameters.
     * @param x the x component
     * @param y the y component
     * @param z the z component
     * @param w the w component
     */
    public Vector4(int x, int y, int z, int w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }
    
        
    /**
     * Convert vector to float buffer.
     * @return the convertex float buffer
     */
    public FloatBuffer toFloatBuffer() {
        return BufferUtils.createFloatBuffer(x, y, z, w);
    }
}

