/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.googlecode.wicket.jquery.core.settings;

import org.apache.wicket.request.resource.ResourceReference;
import org.apache.wicket.settings.def.JavaScriptLibrarySettings;

import com.googlecode.wicket.jquery.core.resource.JQueryUIResourceReference;

/**
 * Default implementation of {@link IJQueryLibrarySettings}.<br/>
 *
 * <code><pre>
 * public class MyApplication extends WebApplication
 * {
 *     public void init()
 *     {
 *         super.init();
 *
 *         IJQueryLibrarySettings settings = new JQueryLibrarySettings();
 *         settings.setJQueryReference(new PackageResourceReference(SampleApplication.class, "jquery-1.9.1.js"));	// jQuery
 *         settings.setJQueryGlobalizeReference(JQueryGlobalizeResourceReference.get());							// jQuery Globalize
 *
 *         this.setJavaScriptLibrarySettings(settings);
 *     }
 * }
 * <pre></code>
 *
 * <b>Note:</b> The reference given as parameter can be null.
 *
 * @author Sebastien Briquet - sebfz1
 *
 */
//TODO: rename to JQueryUILibrarySettings and move to jquery-ui
public class JQueryLibrarySettings extends JavaScriptLibrarySettings implements IJQueryLibrarySettings
{
	private static JQueryLibrarySettings instance = null;

	private ResourceReference javascriptReference = JQueryUIResourceReference.get();
	private ResourceReference stylesheetReference = null;
	private ResourceReference globalizeReference = null; // null by default, meaning the user has to set it explicitly

	/**
	 * INTERNAL USE<br/>
	 * Gets the {@link JQueryLibrarySettings} instance
	 *
	 * @return the {@link JQueryLibrarySettings} instance
	 */
	public static synchronized JQueryLibrarySettings get()
	{
		if (JQueryLibrarySettings.instance == null)
		{
			JQueryLibrarySettings.instance = new JQueryLibrarySettings();
		}

		return JQueryLibrarySettings.instance;
	}

	/**
	 * Constructor
	 */
	public JQueryLibrarySettings()
	{
	}

	// jQuery UI //

	@Override
	public ResourceReference getJQueryUIReference()
	{
		return this.getJQueryUIJavaScriptReference();
	}

	@Override
	public void setJQueryUIReference(ResourceReference reference)
	{
		this.setJQueryUIJavaScriptReference(reference);
	}

	@Override
	public ResourceReference getJQueryUIJavaScriptReference()
	{
		return this.javascriptReference;
	}

	/**
	 * Gets the jQuery UI javascript resource reference
	 *
	 * @param reference the {@link ResourceReference}
	 */
	public void setJQueryUIJavaScriptReference(ResourceReference reference)
	{
		this.javascriptReference = reference;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @return <tt>null</tt> by default
	 * @see #setJQueryUIStyleSheetReference(ResourceReference)
	 */
	@Override
	public ResourceReference getJQueryUIStyleSheetReference()
	{
		return this.stylesheetReference;
	}

	/**
	 * Gets the jQuery UI stylesheet resource reference
	 *
	 * @param reference the {@link ResourceReference}
	 */
	public void setJQueryUIStyleSheetReference(ResourceReference reference)
	{
		this.stylesheetReference = reference;
	}

	// jQuery Globalize //

	@Override
	public ResourceReference getJQueryGlobalizeReference()
	{
		return this.globalizeReference;
	}

	@Override
	@Deprecated
	public void setJQueryGlobalizeReference(ResourceReference reference)
	{
		this.globalizeReference = reference;
	}
}
