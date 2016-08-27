package universe.math;

import java.nio.FloatBuffer;
import universe.util.BufferUtils;

/**
 * Three component vector.
 * @author Aleman778
 * @since Universe Core 1.0
 */
public class Vector3 {
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
     * Constructor.
     * Creates a zero vector.
     */
    public Vector3() {
        this(0, 0, 0);
    }
    
    /**
     * Constructor.
     * Creates a clone of the provided vector.
     * @param vec the vector to clone from
     */
    public Vector3(Vector3 vec) {
        this(vec.x, vec.y, vec.z);
    }

    /**
     * Constructor.
     * Creates a vector based on the provided parameters.
     * @param x the x component
     * @param y the y component
     * @param z the z component
     */
    public Vector3(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
        
    /**
     * Convert vector to float buffer.
     * @return the convertex float buffer
     */
    public FloatBuffer toFloatBuffer() {
        return BufferUtils.createFloatBuffer(x, y, z);
    }
}

