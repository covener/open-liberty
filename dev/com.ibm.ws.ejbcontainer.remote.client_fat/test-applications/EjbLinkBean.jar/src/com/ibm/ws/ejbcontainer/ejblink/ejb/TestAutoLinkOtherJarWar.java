/*******************************************************************************
 * Copyright (c) 2006, 2020 IBM Corporation and others.
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

package com.ibm.ws.ejbcontainer.ejblink.ejb;

import javax.ejb.EJB;

/**
 * Basic Stateless Bean implementation for testing AutoLink
 **/
public class TestAutoLinkOtherJarWar extends BasicEjbLinkTest {
    @EJB
    public AutoLinkLocalOtherJarWar beanInOtherJarAndWar;

    @Override
    public String verifyStyle1BeanInJarAndWar() {
        return "Failed";
    }

    public TestAutoLinkOtherJarWar() {
        // intentionally blank
    }
}
