package org.tap4j.editor_;

import org.eclipse.jface.text.rules.IWhitespaceDetector;

public class TAPWhitespaceDetector implements IWhitespaceDetector {

	public boolean isWhitespace(char c) {
		return (c == ' ' || c == '\t' || c == '\n' || c == '\r');
	}
}
