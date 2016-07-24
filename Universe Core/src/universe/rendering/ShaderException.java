package universe.rendering;

public class ShaderException extends RuntimeException {

    public ShaderException() {
    }

    public ShaderException(String string) {
        super(string);
    }

    public ShaderException(Throwable thrwbl) {
        super(thrwbl);
    }

    public ShaderException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }    
}
