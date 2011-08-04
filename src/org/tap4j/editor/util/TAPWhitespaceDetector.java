package org.tap4j.editor.util;

import org.eclipse.jface.text.rules.IWhitespaceDetector;

/**
 * @author Bruno P. Kinoshita - http://www.kinoshita.eti.br
 * @since 1.0
 */
public class TAPWhitespaceDetector 
implements IWhitespaceDetector
{

	/* (non-Javadoc)
	 * @see org.eclipse.jface.text.rules.IWhitespaceDetector#isWhitespace(char)
	 */
	public boolean isWhitespace( char character )
	{
		return Character.isWhitespace( character );
	}
	
}
