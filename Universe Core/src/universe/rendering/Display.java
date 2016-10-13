/*
 * Copyright (c) 2016, Aleman778. All rights reserved.
 * License terms are in the included LICENSE file.
 */
package universe.rendering;

import java.awt.Point;
import universe.core.Config;
import universe.util.Disposable;

/**
 * Abstract display provides basic functions for
 * working with different display APIs.
 * @author Aleman778
 * @since Universe Core 1.0
 */
public abstract class Display implements Disposable {

    protected final Config config;
    
    public Display(Config config) {
        this.config = config;
    }
    
    /**
     * Updating the display for continuous use in loops.
     * Should be called at the end of each loop update.
     */
    public abstract void update();
    
    /**
     * Refreshing the display for rendering using double buffering.
     * Should be called at the end of each frame in loop.
     */
    public abstract void refresh();
    
    /**
     * Disposes the display.
     * Note: display cannot be used after disposing.
     */
    @Override
    public abstract void dispose();
    
    /**
     * Make a rendering context for this display.
     */
    public abstract void makeContext();
    
    /**
     * Checks whether the display is closed or not.
     * @return true if the display is closed
     */
    public abstract boolean isClosed();

        
    /**
     * Get the width of this display.
     * @return the display width
     */
    public final int getWidth() {
        return config.width;
    }
    
    /**
     * Get the height of this display.
     * @return the display height
     */
    public final int getHeight() {
        return config.height;
    }
    
    /**
     * Get the size of this display
     * @return the display size
     */
    public final Point getSize() {
        return new Point(config.width, config.height);
    }
        
    /**
     * Get the title of this display.
     * @return the display title
     */
    public final String getTitle() {
        return config.title;
    }
}
