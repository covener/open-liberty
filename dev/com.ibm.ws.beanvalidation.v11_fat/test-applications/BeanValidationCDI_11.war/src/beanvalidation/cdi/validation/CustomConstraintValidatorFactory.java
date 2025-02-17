/*******************************************************************************
 * Copyright (c) 2017 IBM Corporation and others.
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
package beanvalidation.cdi.validation;

import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorFactory;
import javax.validation.ValidationException;

import beanvalidation.cdi.beans.TestBean;

/**
 * Simple implementation of a ConstraintValidatorFactory that tolerates a null
 * parameter for testing purposes and also checks to see if a CDI bean was
 * injected.
 */
public class CustomConstraintValidatorFactory implements ConstraintValidatorFactory {

    @Inject
    TestBean bean;

    @Override
    public <T extends ConstraintValidator<?, ?>> T getInstance(Class<T> arg0) {
        if (bean == null) {
            throw new ValidationException("bean shouldn't be null");
        }

        try {
            if (arg0 != null) {
                return arg0.newInstance();
            }
        } catch (Throwable e) {
            throw new ValidationException("couldn't create new instance of " + arg0.getName(), e);
        }

        return null;
    }

    @Override
    public void releaseInstance(ConstraintValidator<?, ?> arg0) {

    }

    @PreDestroy
    public void preDestroy() {
        System.out.println(CustomConstraintValidatorFactory.class.getSimpleName() + " is getting destroyed.");
    }

}
