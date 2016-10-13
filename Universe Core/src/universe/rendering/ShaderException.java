package universe.rendering;

/**
 * Shader exception.
 * @author Aleman778
 * @since Universe Core 1.0
 */
public class ShaderException extends RuntimeException {
    /**
     * Constructor.
     */
    public ShaderException() {
    }

    /**
     * Constructor.
     * @param string exception message
     */
    public ShaderException(String string) {
        super(string);
    }

    /**
     * Constructor.
     * @param thrwbl throwable exception
     */
    public ShaderException(Throwable thrwbl) {
        super(thrwbl);
    }

    /**
     * Constructor.
     * @param string exception message
     * @param thrwbl throwable exception
     */
    public ShaderException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }    
}
