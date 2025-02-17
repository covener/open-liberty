/*******************************************************************************
 * Copyright (c) 2021 IBM Corporation and others.
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
package com.ibm.ws.microprofile.openapi.fat.filter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Basic resource, just so there's an endpoint to document in the app
 */
@Path("/")
public class FilterTestResource {

    @GET
    public String get() {
        return "OK";
    }
}
