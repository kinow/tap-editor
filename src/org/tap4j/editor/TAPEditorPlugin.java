package org.tap4j.editor;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.tap4j.editor.text.TAPScanner;
import org.tap4j.editor.util.TAPColorProvider;

/**
 * @author Bruno P. Kinoshita - http://www.kinoshita.eti.br
 * @since 1.0
 */
public class TAPEditorPlugin extends AbstractUIPlugin
{

	// The Plug-in ID
	public static final String PLUGIN_ID = "TAP";

	// Singleton plug-in instance.
	private static TAPEditorPlugin instance;

	// TAP Scanner used for text coloring.
	private TAPScanner tapScanner;
	
	// Color Provider used by TAP Scanner.
	private TAPColorProvider colorProvider;

	public static final String SPACES_FOR_TABS = "spaces_for_tabs"; //$NON-NLS-1$
	public static final String NUM_SPACES = "num_spaces"; //$NON-NLS-1$
	public final static String EDITOR_MATCHING_BRACKETS = "matchingBrackets"; //$NON-NLS-1$	
	public final static String EDITOR_MATCHING_BRACKETS_COLOR =  "matchingBracketsColor"; //$NON-NLS-1$

	public TAPEditorPlugin()
	{
		instance = this;
	}

	/**
	 * Returns the default plug-in instance.
	 * 
	 * @return the default plug-in instance
	 */
	public static TAPEditorPlugin getDefault()
	{
		return instance;
	}

	public TAPScanner getTAPScanner()
	{
		if ( this.tapScanner == null )
		{
			this.tapScanner = new TAPScanner( this.getColorProvider() );
		}
		return this.tapScanner;
	}

	public TAPColorProvider getColorProvider()
	{
		if (this.colorProvider == null)
		{
			this.colorProvider = new TAPColorProvider();
		}
		return this.colorProvider;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
	 * )
	 */
	@Override
	public void start( BundleContext context ) throws Exception
	{
		super.start(context);
		instance = this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
	 * )
	 */
	@Override
	public void stop( BundleContext context ) throws Exception
	{
		instance = null;
		super.stop(context);
	}

	public static ImageDescriptor getImageDescriptor( String path )
	{
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}

	/**
	 * Returns the default preference store.
	 * 
	 * @return IPreferenceStore
	 */
	public static IPreferenceStore getJsonPreferenceStore() {
		IPreferenceStore store =
			getDefault().getPreferenceStore();
		TAPColorProvider provider = getDefault().getColorProvider();
		store.setDefault(SPACES_FOR_TABS, true);
		store.setDefault(NUM_SPACES, 4);
		store.setDefault(EDITOR_MATCHING_BRACKETS, true);
		store.setDefault(EDITOR_MATCHING_BRACKETS_COLOR, provider.getColor(TAPColorProvider.STRING).toString());
		return store;
	}
	
}
