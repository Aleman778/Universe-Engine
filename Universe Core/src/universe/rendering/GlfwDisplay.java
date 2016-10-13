/*
 * Copyright (c) 2016, Aleman778. All rights reserved.
 * License terms are in the included LICENSE file.
 */
package universe.rendering;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.system.MemoryUtil.*;
import org.lwjgl.glfw.GLFWErrorCallback;
import universe.core.Config;

/**
 * GLFW is a free, Open Source, multi-platform library for
 * OpenGL, OpenGL ES and Vulkan development on the desktop.
 * It provides a simple API for creating displays, contexts
 * and surfaces, receiving input and events.
 * 
 * GLFW is written in C and has native support for Windows,
 * OS X and many Unix-like systems using the X Window System,
 * such as Linux and FreeBSD.
 * 
 * This is a GLFW display implementation in java.
 * @author Aleman778
 * @since Universe Core 1.0
 */
public final class GlfwDisplay extends Display {
    /**
     * The glfw display handle 
     */
    private long display;
    
    public GlfwDisplay(Config config) {
        super(config);
        
        display = glfwCreateWindow(config.width, config.height, config.title, NULL, NULL);
        glfwSetErrorCallback(new GLFWErrorCallback() {
            @Override
            public void callback(long args) {
            }

            @Override
            public void invoke(int error, long description) {
                System.err.println(GLFWErrorCallback.getDescription(description));
            }
        });
    }
    
    /**
     * Updating the display for continuous use in loops.
     * Should be called at the end of each loop update.
     */
    @Override
    public void update() {
        glfwPollEvents();
    }
    
    /**
     * Refreshing the display for rendering using double buffering.
     * Should be called at the end of each frame in loop.
     */
    @Override
    public void refresh() {
        glfwSwapBuffers(display);
    }
    
    /**
     * Disposes the display.
     * Note: display cannot be used after disposing.
     */
    @Override
    public void dispose() {
        if (display == -1) {
            throw new NullPointerException("Window could not disposed. Window does not exist.");
        }
        
        glfwDestroyWindow(display);
        display = -1;
    }
    
    /**
     * Make a rendering context for this display.
     */
    @Override
    public void makeContext() {
        glfwMakeContextCurrent(display);
    }

    /**
     * Set the title of this display
     * @param title the new display title
     */
    public void setTitle(String title) {
        config.title = title;
        glfwSetWindowTitle(display, config.title);
    }

    /**
     * Set the width of this display.
     * @param width the new display width
     */
    public void setWidth(int width) {
        setSize(width, getHeight());
    }

    /**
     * Set the height of this display.
     * @param height the new display height
     */
    public void setHeight(int height) {
        setSize(getWidth(), height);
    }

    /**
     * Set the size of this display.
     * @param width the new display width
     * @param height the new display height
     */
    public void setSize(int width, int height) {
        glfwSetWindowSize(display, width, height);
    }

    /**
     * Checks whether the display is closed or not.
     * @return true if the display is closed
     */
    @Override
    public boolean isClosed() {
        return glfwWindowShouldClose(display);
    }
}
