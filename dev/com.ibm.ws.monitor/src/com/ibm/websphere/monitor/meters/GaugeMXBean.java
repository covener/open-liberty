/*******************************************************************************
 * Copyright (c) 2010 IBM Corporation and others.
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

package com.ibm.websphere.monitor.meters;

public interface GaugeMXBean {

    public String getDescription();

    public String getUnit();

    public long getCurrentValue();

    public long getMinimumValue();

    public long getMaximumValue();

    public boolean isBounded();

    public long getLowerBound();

    public long getUpperBound();

    public GaugeReading getReading();

}
