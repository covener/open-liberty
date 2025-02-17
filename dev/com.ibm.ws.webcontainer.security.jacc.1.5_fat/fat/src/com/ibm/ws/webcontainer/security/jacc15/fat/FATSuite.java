/*******************************************************************************
 * Copyright (c) 2020, 2022 IBM Corporation and others.
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

package com.ibm.ws.webcontainer.security.jacc15.fat;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.junit.ClassRule;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.ibm.ws.webcontainer.security.jacc15.fat.audit.BasicAuthAuditAUTHZTest;

import componenttest.custom.junit.runner.AlwaysPassesTest;
import componenttest.rules.repeater.EmptyAction;
import componenttest.rules.repeater.FeatureReplacementAction;
import componenttest.rules.repeater.JakartaEE10Action;
import componenttest.rules.repeater.JakartaEE9Action;
import componenttest.rules.repeater.RepeatTests;

@RunWith(Suite.class)
@SuiteClasses({
                AlwaysPassesTest.class,
                BasicAuthTest.class,
                //BasicAuthDenyTest.class,
                //BasicAuthJSPTest.class,
                //BasicAuthWithCustomRegistryTest.class,
                //LDAPTest.class,
                //LDAPTestForGroupMemberIdMaps.class,
                //LDAPADNestedGroupsTest.class,
                //LDAPTDSNestedGroupsTest.class,
                FormLoginTest.class,
                //FormLoginJSPTest.class,
                //XMLBindingsTest.class,
                //XMIBindingsTest.class,
                //ServerXMLOverridesXMLBindingsTest.class,
                //ServerXMLOverridesXMIBindingsTest.class,
                //LoginMethodTest.class,
                //CustomMethodTest.class,
                //AuthenticateMethodTest.class,
                //ConfigurableOptionsTest.class,
                RunAsTest.class,
                //OSGIAppTest.class,
                //ClientCertTest.class,
                //SSLRedirectTest.class,
                StaticAnnotationsTest.class,
                //InheritanceTest.class,
                DynamicAnnotationsTest.class,
                //HttpMethodOmissionTest.class,
                SpecialAuthConstraintServlet31.class,
                BasicAuthAuditAUTHZTest.class
})
/**
 * Purpose: This suite collects and runs all known good test suites.
 */
public class FATSuite extends CommonLocalLDAPServerSuite {
    private static final Set<String> EE78_FEATURES;
    private static final String[] EE78_FEATURES_ARRAY = {
                                                          "appSecurity-1.0",
                                                          "jsp-2.2",
                                                          "usr:jaccTestProvider-1.0"
    };

    private static final Set<String> EE9_FEATURES;
    private static final String[] EE9_FEATURES_ARRAY = {
                                                         "usr:jaccTestProvider-2.0"
    };

    private static final Set<String> EE10_FEATURES;
    private static final String[] EE10_FEATURES_ARRAY = {
                                                          "usr:jaccTestProvider-2.1"
    };

    static {
        EE78_FEATURES = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(EE78_FEATURES_ARRAY)));
        EE9_FEATURES = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(EE9_FEATURES_ARRAY)));
        EE10_FEATURES = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(EE10_FEATURES_ARRAY)));
    }

    /*
     * Run EE9 tests in LITE mode if Java 8, EE10 tests in LITE mode if >= Java 11 and run all tests in FULL mode.
     */
    @ClassRule
    public static RepeatTests repeat = RepeatTests.with(new EmptyAction().fullFATOnly()).andWith(new JakartaEE9Action().removeFeatures(EE78_FEATURES).addFeatures(EE9_FEATURES).conditionalFullFATOnly(FeatureReplacementAction.GREATER_THAN_OR_EQUAL_JAVA_11)).andWith(new JakartaEE10Action().removeFeatures(EE78_FEATURES).removeFeatures(EE9_FEATURES).addFeatures(EE10_FEATURES));
}