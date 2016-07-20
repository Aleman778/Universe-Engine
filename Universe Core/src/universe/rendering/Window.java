/*
 * Copyright (c) 2016, Aleman778. All rights reserved.
 * License terms are in the included LICENSE file.
 */
package universe.rendering;

import java.awt.Point;
import universe.util.Disposable;

/**
 * Abstract window provides basic functions for
 * working with different window APIs.
 * @author Aleman778
 * @since Universe Core 1.0
 */
public abstract class Window implements Disposable {

    protected String title;
    
    public Window(String title) {
        this.title = title;
    }
    
    /**
     * Updating the window for continuous use in loops.
     * Should be called at the end of each loop update.
     */
    public abstract void update();
    
    /**
     * Refreshing the window for rendering using double buffering.
     * Should be called at the end of each frame in loop.
     */
    public abstract void refresh();
    
    /**
     * Disposes the window.
     * Note: window cannot be used after disposing.
     */
    @Override
    public abstract void dispose();
    
    /**
     * Make a rendering context for this window.
     */
    public abstract void makeContext();
    
    /**
     * Get the width of this window.
     * @return the window width
     */
    public abstract int getWidth();
    
    /**
     * Get the height of this window.
     * @return the window height
     */
    public abstract int getHeight();
    
    /**
     * Get the size of this window
     * @return the window size
     */
    public abstract Point getSize();
    
    /**
     * Checks whether the window is closed or not.
     * @return true if the window is closed
     */
    public abstract boolean isClosed();
    
    /**
     * Get the title of this window.
     * @return the window title
     */
    public final String getTitle() {
        return title;
    }
}
