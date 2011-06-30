package org.tap4j.editor;

import org.eclipse.ui.editors.text.TextEditor;

public class TAPEditor extends TextEditor {

	private ColorManager colorManager;

	public TAPEditor() {
		super();
		colorManager = new ColorManager();
		setSourceViewerConfiguration(new XMLConfiguration(colorManager));
		setDocumentProvider(new XMLDocumentProvider());
	}
	public void dispose() {
		colorManager.dispose();
		super.dispose();
	}

}
