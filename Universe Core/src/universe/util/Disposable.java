/*
 * Copyright (c) 2016, Aleman778. All rights reserved.
 * License terms are in the included LICENSE file.
 */
package universe.util;

/**
 * Disposeable interface used for classes with disposable content.
 * @author Aleman778
 * @since Universe Core 1.0
 */
public interface Disposable {
    /**
     * Disposes the object.
     * Note: object cannot be used after disposing.
     */
    public void dispose();
}
