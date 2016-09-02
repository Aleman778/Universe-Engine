package universe.rendering;

import static universe.rendering.Shader.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import universe.opengl.GLSLShader;
import universe.opengl.GLSLShaderProgram;

/**
 * Builds a shader from input file.<br><br>
 * Note: shaders needs to be defined using preprocessor #shader [Shader type].<br>
 * Shader types:
 * <ul>
 *  <li>Vertex</li>
 *  <li>Fragment</li>
 *  <li>Geometry</li>
 * </ul>
 * @author Aleman778
 * @since Universe Core 1.0
 */
public final class ShaderBuilder {
    
    /**
     * Shader source builder.
     */
    private StringBuilder builder;
    
    /**
     * Constructor.
     * Reads the content from input stream to shader builder.
     * @param input 
     */
    public ShaderBuilder(InputStream input) {
        this();
        append(input);
    }
    
    /**
     * Constructor.
     * Shader builder with provided source.
     * @param source
     */
    public ShaderBuilder(String source) {
        this();
        append(source);
    }

    /**
     * Constructor.
     * Creates an empty shader builder.
     */
    public ShaderBuilder() {
        builder = new StringBuilder();
    }
    
    /**
     * Append source from input stream.
     * @param input the source input
     */
    public void append(InputStream input) {
        try (Reader r = new InputStreamReader(input);
                BufferedReader br = new BufferedReader(r)) {
            
            String line;
            while ((line = br.readLine()) != null) {
                append(line + "\n");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * Append source from string input
     * @param input the source
     */
    public void append(String input) {
        builder.append(input);
    }
    
    /**
     * Parse shader program and returns the result.
     * @return the parsed shaders (Note: shaders are not compiled)
     */
    public List<Shader> parse() {
        List<Shader> shaders = new ArrayList<>();
        
        String source = builder.toString();
        source = source.trim();
        
        String[] parts = source.split("#shader ");
        for (String p: parts) {
            Shader shader = parseShader(p);
            if (shader != null) {
                shaders.add(shader);
            }
        }
        
        return shaders;
    }
    
    /**
     * Builds the shader program and returns the result.
     * @return the builded shader program
     */
    public ShaderProgram build() {
        ShaderProgram program = new GLSLShaderProgram();
        for (Shader shader: parse()) {
            if (!shader.isCompiled())
                shader.compile();
            
            program.attach(shader);
        }
        program.ready();
        
        return program;
    }
    
    /**
     * Parses one specific shader that begins with a specific shader type.
     * Supported types: vertex, fragment or geometry.
     * @param source the shader source code
     * @return the parsed shader
     */
    private Shader parseShader(String source) {
        if (source.isEmpty())
            return null;
        
        ShaderType type = ShaderType.VERTEX;
        if (source.startsWith("vertex")) {
            type = ShaderType.VERTEX;
            source = source.replaceFirst("vertex", "");
        } else if (source.startsWith("fragment")) {
            type = ShaderType.FRAGMENT;
            source = source.replaceFirst("fragment", "");
        } else if (source.startsWith("geometry")) {
            type = ShaderType.GEOMETRY;
            source = source.replaceFirst("geometry", "");
        }
        
        Shader shader = new GLSLShader(type);
        source = source.trim();
        shader.setSource(source);
        return shader;
    }
}
