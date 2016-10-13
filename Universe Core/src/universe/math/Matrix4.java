package universe.math;

import java.nio.FloatBuffer;
import universe.util.BufferUtils;

/**
 * Four by four matrix.
 * @author Aleman778
 * @since Universe Core 1.0
 */
public class Matrix4 {
    /**
     * The number of values used to represent a matrix value.
     */
    public static final int COUNT = 4 * 4;
    
    /**
     * The number of bytes used to represent a matrix value.
     */
    public static final int BYTES = COUNT * Float.BYTES;
    
    /**
     * The number of bits used to represent a matrix value.
     */
    public static final int SIZE = COUNT * Float.SIZE;
    
    /**
     * The matrix contents.
     */
    public float[] m;
    
    /**
     * Constructor.
     * Creates a new empty matrix.
     */
    public Matrix4() {
        m = new float[COUNT];
    }
    
    /**
     * Creates an identity matrix.
     * @return the identity matrix
     */
    public static Matrix4 identity() {
        Matrix4 result = new Matrix4();
        for (int i = 0; i < COUNT; i++) {
            result.m[i] = 0.0f;
        }
        result.m[0 + 0 * 4] = 1.0f;
        result.m[1 + 1 * 4] = 1.0f;
        result.m[2 + 2 * 4] = 1.0f;
        result.m[3 + 3 * 4] = 1.0f;
        return result;
    }
    
    /**
     * Creates an orthographic matrix
     * @param left the left boundary
     * @param right the right boundary
     * @param bottom the bottom boundary
     * @param top the top boundary
     * @param near the near boundary
     * @param far the far boundary
     * @return the orthographic matrix
     */
    public static Matrix4 orthographic(float left, float right, float bottom, float top, float near, float far) {
        Matrix4 result = identity();
        result.m[0 + 0 * 4] = 2.0f / (right - left);
        result.m[1 + 1 * 4] = 2.0f / (top - bottom);
        result.m[2 + 2 * 4] = 2.0f / (near - far);
        result.m[0 + 3 * 4] = (left + right) / (left - right);
        result.m[1 + 3 * 4] = (bottom + top) / (bottom - top);
        result.m[2 + 3 * 4] = (far + near) / (far - near);
        return result;
    }
    
    /**
     * Creates a translation matrix
     * @param position the position reference
     * @return the translation matrix
     */
    public static Matrix4 translate(Vector3 position) {
        Matrix4 result = identity();
        result.m[0 + 3 * 4] = position.x;
        result.m[1 + 3 * 4] = position.y;
        result.m[2 + 3 * 4] = position.z;
        return result;
    }
    
    /**
     * Creates a rotation matrix
     * @param angle the rotation angle
     * @return the rotation matrix
     */
    public static Matrix4 rotate(float angle) {
        Matrix4 result = identity();
        float r = (float) Math.toRadians(angle);
        float cos = (float) Math.cos(r);
        float sin = (float) Math.sin(r);
        result.m[0 + 0 * 4] = cos;
        result.m[1 + 0 * 4] = sin;
        result.m[0 + 1 * 4] = -sin;
        result.m[1 + 1 * 4] = cos;
        return result;
    }
    
    /**
     * Creates a scaling matrix
     * @param scale the scaling reference
     * @return the scaling matrix
     */
    public static Matrix4 scale(Vector3 scale) {
        Matrix4 result = new Matrix4();
        for (int i = 0; i < COUNT; i++) {
            result.m[i] = 0.0f;
        }
        result.m[0 + 0 * 4] = scale.x;
        result.m[1 + 1 * 4] = scale.y;
        result.m[2 + 2 * 4] = scale.z;
        result.m[3 + 3 * 4] = 1.0f;
        return result;
    }
    
    /**
     * Multiply two matrices
     * @param matrix the other matrix term
     * @return the matrix product
     */
    public Matrix4 mul(Matrix4 matrix) {
        Matrix4 result = new Matrix4();
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                float sum = 0.0f;
                for (int e = 0; e < 4; e++) {
                    sum += this.m[x + e * 4] * matrix.m[e + y * 4];
                }
                result.m[x + y * 4] = sum;
            }
        }
        return result;
    }
    
        
    /**
     * Convert matrix to float buffer.
     * @return the convertex float buffer
     */
    public FloatBuffer toFloatBuffer() {
        return BufferUtils.createFloatBuffer(m);
    }
}
