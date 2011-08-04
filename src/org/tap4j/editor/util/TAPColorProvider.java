package org.tap4j.editor.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

/**
 * Provides the coloring for the text editor.
 * 
 * @author Bruno P. Kinoshita - http://www.kinoshita.eti.br
 * @since 1.0
 */
public class TAPColorProvider
{

	public static final RGB STRING = new RGB(0, 128, 0);
	public static final RGB DEFAULT = new RGB(0, 0, 0);
	public static final RGB VALUE = new RGB(0, 0, 128);
	public static final RGB NULL = new RGB(128, 0, 128);

	protected Map<RGB, Color> colorTable = new HashMap<RGB, Color>(10);

	/**
	 * Release all of the color resources held onto by the receiver.
	 */
	public void dispose()
	{
		Iterator<Color> e = colorTable.values().iterator();
		while (e.hasNext())
			e.next().dispose();
	}

	/**
	 * Return the color that is stored in the color table under the given RGB
	 * value.
	 * 
	 * @param rgb
	 *            the RGB value
	 * @return the color stored in the color table for the given RGB value
	 */
	public Color getColor( RGB rgb )
	{
		Color color = (Color) colorTable.get(rgb);
		if (color == null)
		{
			color = new Color(Display.getCurrent(), rgb);
			colorTable.put(rgb, color);
		}
		return color;
	}

}
