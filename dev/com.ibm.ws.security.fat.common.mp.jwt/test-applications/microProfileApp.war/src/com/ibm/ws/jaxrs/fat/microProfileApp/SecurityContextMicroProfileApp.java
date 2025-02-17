/*******************************************************************************
 * Copyright (c) 2017, 2018 IBM Corporation and others.
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

package com.ibm.ws.jaxrs.fat.microProfileApp;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

import org.eclipse.microprofile.jwt.JsonWebToken;

import com.ibm.ws.security.fat.common.mp.jwt.CommonMicroProfileApp;

// http://localhost:8010/microProfileApp/rest/SecurityContext/MicroProfileApp
public class SecurityContextMicroProfileApp extends CommonMicroProfileApp {

    // get the Security Context
    @Context
    SecurityContext secContext;

    @Override
    protected String doWorker(String requestType) {

        String errMsg = "JsonWebToken from SecurityContext was null" + Utils.newLine;
        String returnMsg = null;

        JsonWebToken token = (JsonWebToken) secContext.getUserPrincipal();
        System.out.println("JsonWebToken when obtained from SecurityContext, is set to: " + token);
        if (token == null) {
            returnMsg = errMsg;
        } else {
            returnMsg = Utils.runApis(this.getClass().getCanonicalName(), token, requestType);
        }
        return returnMsg;

    }

}
