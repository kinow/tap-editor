package org.tap4j.editor.text;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WhitespaceRule;
import org.eclipse.jface.text.rules.WordRule;
import org.tap4j.editor.util.TAPColorProvider;
import org.tap4j.editor.util.TAPWhitespaceDetector;
import org.tap4j.editor.util.TAPWordDetector;

/**
 * TAPScanner is used to scan the TAP text and apply coloring.
 * 
 * @author Bruno P. Kinoshita - http://www.kinoshita.eti.br
 * @since 1.0
 */
public class TAPScanner 
extends RuleBasedScanner
{
	
	public TAPScanner( TAPColorProvider provider )
	{
		super();
		
		IToken string = new Token(new TextAttribute(provider.getColor(TAPColorProvider.STRING)));
		IToken value = new Token(new TextAttribute(provider.getColor(TAPColorProvider.VALUE)));
		IToken defaultText = new Token(new TextAttribute(provider.getColor(TAPColorProvider.DEFAULT)));
		IToken nullValue = new Token(new TextAttribute(provider.getColor(TAPColorProvider.NULL)));
		
		List<IRule> rules= new LinkedList<IRule>();
		
		rules.add(new SingleLineRule(":\"", "\"", value, '\\'));
		rules.add(new SingleLineRule("\"", "\"", string, '\\')); //$NON-NLS-2$ //$NON-NLS-1$
		WordRule wordRule= new WordRule(new TAPWordDetector(), defaultText);
		wordRule.addWord("null", nullValue);
		rules.add(wordRule);
		rules.add(new WhitespaceRule(new TAPWhitespaceDetector()));
		
		IRule[] result= new IRule[rules.size()];
		rules.toArray(result);
		setRules(result);
	}

}
