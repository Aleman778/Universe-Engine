/*
 * Copyright (c) 2016, Aleman778. All rights reserved.
 * License terms are in the included LICENSE file.
 */
package universe.rendering;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.system.MemoryUtil.*;
import java.awt.Point;
import java.nio.IntBuffer;
import universe.util.BufferUtils;

/**
 * GLFW is a free, Open Source, multi-platform library for
 * OpenGL, OpenGL ES and Vulkan development on the desktop.
 * It provides a simple API for creating windows, contexts
 * and surfaces, receiving input and events.
 * 
 * GLFW is written in C and has native support for Windows,
 * OS X and many Unix-like systems using the X Window System,
 * such as Linux and FreeBSD.
 * @author Aleman778
 * @since Universe Core 1.0
 */
public class GlfwWindow extends Window {
    /**
     * The glfw window handle 
     */
    private long window;

    public GlfwWindow(String title) {
        super(title);
        
        window = glfwCreateWindow(640, 480, title, NULL, NULL);
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
        if (window == -1) {
            throw new NullPointerException("Window could not disposed. Window does not exist.");
        }
        
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
        return getSize().x;
    }

    /**
     * Set the width of this window.
     * @param width the new window width
     */
    public void setWidth(int width) {
        setSize(width, getHeight());
    }

    /**
     * Get the height of this window.
     * @return the window height
     */
    @Override
    public int getHeight() {
        return getSize().y;
    }

    /**
     * Set the height of this window.
     * @param height the new window height
     */
    public void setHeight(int height) {
        setSize(getWidth(), height);
    }
    
    /**
     * Get the size of this window.
     * @return the size of this window
     */
    @Override
    public Point getSize() {
        IntBuffer width = BufferUtils.createIntBuffer(0);
        IntBuffer height = BufferUtils.createIntBuffer(0);
        glfwGetWindowSize(window, width, height);
        return new Point(width.get(0), height.get(0));
    }
    
    /**
     * Set the size of this window.
     * @param width the new window width
     * @param height the new window height
     */
    public void setSize(int width, int height) {
        glfwSetWindowSize(window, width, height);
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
