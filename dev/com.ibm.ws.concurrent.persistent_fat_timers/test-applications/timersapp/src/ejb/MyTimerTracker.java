/*******************************************************************************
 * Copyright (c) 2015, 2020 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package ejb;

import java.util.concurrent.ConcurrentHashMap;

import jakarta.ejb.Singleton;

/**
 * Counts the number of times a timer runs
 */
@Singleton
public class MyTimerTracker {
    private final ConcurrentHashMap<String, Integer> counters = new ConcurrentHashMap<String, Integer>();

    public int getRunCount(String name) {
        Integer count = counters.get(name);
        return count == null ? 0 : count;
    }

    // This method is safe to invoke concurrently for multiple name values but not for the same name value.
    public int incrementRunCount(String name) {
        Integer count = counters.putIfAbsent(name, 1);
        if (count == null)
            count = 1;
        else
            counters.put(name, ++count);
        return count;
    }
}
