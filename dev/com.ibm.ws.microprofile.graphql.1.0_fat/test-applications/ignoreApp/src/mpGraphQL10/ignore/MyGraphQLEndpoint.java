/*******************************************************************************
 * Copyright (c) 2019 IBM Corporation and others.
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
package mpGraphQL10.ignore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;

@GraphQLApi
@ApplicationScoped
public class MyGraphQLEndpoint {

    private final List<Widget> allWidgets = new ArrayList<>();

    public MyGraphQLEndpoint() {
        System.out.println("MyGraphQLEndpoint <init>");
        reset();
    }
    
    public void reset() {
        allWidgets.clear();
        allWidgets.add(new Widget("Keyboard", 300, 8.5, 18.0, 1.5, 9.5));
    }

    @Query("allWidgets")
    public Collection<Widget> getAllInstances() {
        System.out.println("MyGraphQLEndpoint returning: " + allWidgets);
        return allWidgets;
    }

    @Mutation("createWidgetByHand")
    public Widget createNewWidgetByHand(@Name("widgetString") String widgetString) {
        Widget w = Widget.fromString(widgetString);
        allWidgets.add(w);
        return w;
        
    }

    @Mutation("createWidget")
    public Widget createNewWidget(@Name("widget") Widget input) {
        Widget w = Widget.fromWidgetInput(input);
        allWidgets.add(w);
        return w;
    }
}
