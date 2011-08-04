package org.tap4j.editor_;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * Main class that integrates with Eclipse.
 * 
 * @author Bruno P. Kinoshita - http://www.kinoshita.eti.br
 */
public class TAPEditorPlugin 
extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "TAP";

	// The shared instance
	private static TAPEditorPlugin pluginInstance;
	
	/**
	 * The constructor
	 */
	public TAPEditorPlugin() {
		pluginInstance = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		pluginInstance = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		pluginInstance = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static TAPEditorPlugin getDefault() {
		return pluginInstance;
	}

	/**
	 * Returns an image descriptor for the image file at the given
	 * plug-in relative path
	 *
	 * @param path the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}
	

	
}
