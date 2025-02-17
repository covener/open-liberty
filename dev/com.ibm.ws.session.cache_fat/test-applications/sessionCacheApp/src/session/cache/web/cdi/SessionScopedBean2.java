/*******************************************************************************
 * Copyright (c) 2018 IBM Corporation and others.
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
package session.cache.web.cdi;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

@SessionScoped
public class SessionScopedBean2 implements Serializable {
    private static final long serialVersionUID = 8257261434327004664L;
    private String str;

    public SessionScopedBean2() {}

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        System.out.println("SessionScopedBean2.setStringValue: [" + this.str + "] -> [" + str + "]");
        this.str = str;
    }
}