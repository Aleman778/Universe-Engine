package universe.math;

import java.nio.FloatBuffer;
import universe.util.BufferUtils;

/**
 * Two component vector.
 * @author Aleman778
 * @since Universe Core 1.0
 */
public class Vector2 {
    /**
     * The x component of the vector.
     */
    public int x;
    
    /**
     * The y component of the vector.
     */
    public int y;
    
    /**
     * Constructor.
     * Creates a zero vector.
     */
    public Vector2() {
        this(0, 0);
    }
    
    /**
     * Constructor.
     * Creates a clone of the provided vector.
     * @param vec the vector to clone from
     */
    public Vector2(Vector2 vec) {
        this(vec.x, vec.y);
    }

    /**
     * Constructor.
     * Creates a vector based on the provided parameters.
     * @param x the x component
     * @param y the y component
     */
    public Vector2(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Convert vector to float buffer.
     * @return the convertex float buffer
     */
    public FloatBuffer toFloatBuffer() {
        return BufferUtils.createFloatBuffer(x, y);
    }
}
