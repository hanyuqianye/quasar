/*
 * Quasar: lightweight threads and actors for the JVM.
 * Copyright (C) 2013, Parallel Universe Software Co. All rights reserved.
 * 
 * This program and the accompanying materials are dual-licensed under
 * either the terms of the Eclipse Public License v1.0 as published by
 * the Eclipse Foundation
 *  
 *   or (per the licensee's choosing)
 *  
 * under the terms of the GNU Lesser General Public License version 3.0
 * as published by the Free Software Foundation.
 */
package co.paralleluniverse.fibers.io;

import co.paralleluniverse.fibers.Fiber;
import co.paralleluniverse.fibers.FiberAsync;
import co.paralleluniverse.fibers.SuspendExecution;
import java.io.IOException;
import java.nio.channels.CompletionHandler;

/**
 *
 * @author pron
 */
abstract class FiberAsyncIO<V> extends FiberAsync<V, CompletionHandler<V, Fiber>, Void, IOException> implements CompletionHandler<V, Fiber> {
    @Override
    public void completed(V result, Fiber fiber) {
        super.completed(result, fiber);
    }

    @Override
    public void failed(Throwable exc, Fiber fiber) {
        super.failed(exc, fiber);
    }

    @Override
    public V run() throws IOException, SuspendExecution {
        try {
            return super.run();
        } catch (InterruptedException e) {
            throw new IOException(e);
        }
    }
}