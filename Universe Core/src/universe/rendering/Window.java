/*
 * Copyright (c) 2016, Aleman778. All rights reserved.
 * License terms are in the included LICENSE file.
 */
package universe.rendering;

/**
 * Window interface provides basic functions for
 * working with different window APIs.
 * @author Aleman778
 * @since Universe Core 1.0
 */
public interface Window {
    /**
     * Updating the window for continuous use in loops.
     * Should be called at the end of each loop update.
     */
    public void update();
    
    /**
     * Refreshing the window for rendering using double buffering.
     * Should be called at the end of each frame in loop.
     */
    public void refresh();
    
    /**
     * Disposes the window.
     * Note: window cannot be used after disposing.
     */
    public void dispose();
    
    /**
     * Make a rendering context for this window.
     */
    public void makeContext();
    
    /**
     * Get the title of this window.
     * @return the window title
     */
    public String getTitle();
    
    /**
     * Get the width of this window.
     * @return the window width
     */
    public int getWidth();
    
    /**
     * Get the height of this window.
     * @return the window height
     */
    public int getHeight();
    
    /**
     * Checks whether the window is closed or not.
     * @return true if the window is closed
     */
    public boolean isClosed();
}
