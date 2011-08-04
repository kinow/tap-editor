package org.tap4j.editor.util;

import org.eclipse.jface.text.rules.IWordDetector;

/**
 * Word detector for TAP.
 * 
 * @author Bruno P. Kinoshita - http://www.kinoshita.eti.br
 * @since 1.0
 */
public class TAPWordDetector 
implements IWordDetector
{

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.text.rules.IWordDetector#isWordStart(char)
	 */
	public boolean isWordStart( char character )
	{
		return Character.isJavaIdentifierPart(character);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.text.rules.IWordDetector#isWordPart(char)
	 */
	public boolean isWordPart( char character )
	{
		return Character.isJavaIdentifierPart(character);
	}

}
