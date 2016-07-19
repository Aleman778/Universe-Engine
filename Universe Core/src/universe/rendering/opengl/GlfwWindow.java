/*
 * Copyright (c) 2016, Aleman778. All rights reserved.
 * License terms are in the included LICENSE file.
 */
package universe.rendering.opengl;

import static org.lwjgl.glfw.GLFW.*;
import org.lwjgl.glfw.GLFWWindowSizeCallback;
import static org.lwjgl.system.MemoryUtil.*;
import universe.rendering.Window;

/**
 * GLFW is a free, Open Source, multi-platform library for
 * OpenGL, OpenGL ES and Vulkan development on the desktop.
 * It provides a simple API for creating windows, contexts
 * and surfaces, receiving input and events.
 * 
 * GLFW is written in C and has native support for Windows,
 * OS X and many Unix-like systems using the X Window System,
 * such as Linux and FreeBSD.
 * @author alema
 * @since Universe Core 1.0
 */
public class GlfwWindow implements Window {
    /**
     * The glfw window handle 
     */
    private long window;
    
    /**
     * The title of this window
     */
    private String title;
    
    /**
     * The width of this window
     */
    private int width;
    
    /**
     * The height of this window
     */
    private int height;

    /**
     * Constructor.
     * @param title the title of the window 
     */
    public GlfwWindow(String title) {
        this(title, 640, 480);
    }
    
    /**
     * Constructor.
     * @param title the title of the window
     * @param width the width of the window
     * @param height the height of the window
     */
    public GlfwWindow(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        this.window = glfwCreateWindow(width, height, title, NULL, NULL);
        
        glfwSetWindowSizeCallback(window, new GLFWWindowSizeCallback() {
            @Override
            public void invoke(long window, int width, int height) {
                GlfwWindow.this.width = width;
                GlfwWindow.this.height = height;
            }
        });
    }
    
    /**
     * Updating the window for continuous use in loops.
     * Should be called at the end of each loop update.
     */
    @Override
    public void update() {
        glfwPollEvents();
    }
    
    /**
     * Refreshing the window for rendering using double buffering.
     * Should be called at the end of each frame in loop.
     */
    @Override
    public void refresh() {
        glfwSwapBuffers(window);
    }
    
    /**
     * Disposes the window.
     * Note: window cannot be used after disposing.
     */
    @Override
    public void dispose() {
        glfwDestroyWindow(window);
        window = -1;
    }
    
    /**
     * Make a rendering context for this window.
     */
    @Override
    public void makeContext() {
        glfwMakeContextCurrent(window);
    }

    /**
     * Get the title of this window.
     * @return the window title
     */
    @Override
    public String getTitle() {
        return title;
    }

    /**
     * Set the title of this window
     * @param title the new window title
     */
    public void setTitle(String title) {
        this.title = title;
        glfwSetWindowTitle(window, this.title);
    }
    
    /**
     * Get the width of this window.
     * @return the window width
     */
    @Override
    public int getWidth() {
        return width;
    }

    /**
     * Set the width of this window
     * @param width the new window width
     */
    public void setWidth(int width) {
        this.width = width;
        glfwSetWindowSize(window, this.width, this.height);
    }

    /**
     * Get the height of this window.
     * @return the window height
     */
    @Override
    public int getHeight() {
        return height;
    }

    /**
     * Set the height of this window
     * @param height the new window height
     */
    public void setHeight(int height) {
        this.height = height;
        glfwSetWindowSize(window, this.width, this.height);
    }

    /**
     * Checks whether the window is closed or not.
     * @return true if the window is closed
     */
    @Override
    public boolean isClosed() {
        return glfwWindowShouldClose(window);
    }
}
