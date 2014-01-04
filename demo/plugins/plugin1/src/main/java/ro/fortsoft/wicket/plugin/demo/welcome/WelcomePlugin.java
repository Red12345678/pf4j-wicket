/*
 * Copyright 2012 Decebal Suiu
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this work except in compliance with
 * the License. You may obtain a copy of the License in the LICENSE file, or at:
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package ro.fortsoft.wicket.plugin.demo.welcome;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.resource.PackageResourceReference;
import org.apache.wicket.request.resource.ResourceReference;

import ro.fortsoft.pf4j.Extension;
import ro.fortsoft.pf4j.PluginWrapper;
import ro.fortsoft.wicket.plugin.WicketPlugin;
import ro.fortsoft.wicket.plugin.demo.api.Section;

/**
 * @author Decebal Suiu
 */
public class WelcomePlugin extends WicketPlugin {

	private static WelcomePlugin instance;
	
    public WelcomePlugin(PluginWrapper wrapper) {
        super(wrapper);
        
        instance = this;
    }

    @Override
    public void start() {
        System.out.println("WelcomePlugin.start()");
    }

    @Override
    public void stop() {
        System.out.println("WelcomePlugin.stop()");
    }

    public static WelcomePlugin get() {
    	return instance;
    }
    
    @Extension
    public static class WelcomeSection extends Section {

    	private static final long serialVersionUID = 1L;

		public WelcomeSection() {
			super(Model.of("Welcome Plugin"));
    	}

		@Override
		public ResourceReference getImage() {
			return new PackageResourceReference(WelcomePlugin.class, "res/datasource.png");
		}

		@Override
		public WebMarkupContainer getPanel(String panelId) {
			return new WelcomePanel(panelId, Model.of("This plugin contributes with a css file to the head of page."));
		}

    }

}