/*******************************************************************************
 * Copyright (c) 2007, 2020 IBM Corporation and others.
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

package com.ibm.bnd.err.ejb.error17.ejb;

import java.rmi.RemoteException;

import javax.annotation.Resource;
import javax.ejb.CreateException;
import javax.ejb.LocalHome;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless(name = "TargetBean")
@LocalHome(LocalTargetHome.class)
public class TargetBean implements SessionBean {
    private static final long serialVersionUID = 7435573037724452299L;

    @Resource
    private SessionContext ivContext;

    public String ping() {
        return "pong";
    }

    public void ejbCreate() throws CreateException, java.rmi.RemoteException {}

    @Override
    public void ejbActivate() throws RemoteException {}

    @Override
    public void ejbPassivate() throws RemoteException {}

    @Override
    public void ejbRemove() throws RemoteException {}

    @Override
    public void setSessionContext(SessionContext sc) {
        ivContext = sc;
    }
}
