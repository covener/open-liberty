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

package com.ibm.ws.jpa.tests.beanvalidation;

import org.junit.ClassRule;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.ibm.ws.jpa.tests.beanvalidation.tests.AbstractFATSuite;
import com.ibm.ws.jpa.tests.beanvalidation.tests.BeanValidation_EJB;
import com.ibm.ws.jpa.tests.beanvalidation.tests.BeanValidation_Web;
import com.ibm.ws.jpa.tests.beanvalidation.tests.ValidateJPAFeatureTest;

import componenttest.rules.repeater.RepeatTests;

@RunWith(Suite.class)
@SuiteClasses({
                BeanValidation_EJB.class,
                BeanValidation_Web.class,
                ValidateJPAFeatureTest.class
})
public class JPA20Suite extends AbstractFATSuite {

    @ClassRule
    public static RepeatTests r = RepeatTests.with(new RepeatWithJPA20());

}
