/*******************************************************************************
 * Copyright (c) 2018 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package jsf.container.somelib;

public class SomeLibClass {

    public void printClassloader() {
        System.out.println("Loaded " + getClass() + " with loader " + getClass().getClassLoader());
    }

}
