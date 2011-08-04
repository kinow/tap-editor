package org.tap4j.editor_;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

/**
 * Logging helper class.
 * 
 * @author Matt Garner (original class for JSon plug-in)
 * @author Bruno P. Kinoshita - http://www.kinoshita.eti.br (modified version for TAP plug-in)
 * 
 * @since 0.2
 */
public class TAPLog
{
	
	private TAPLog() {}

	/**
	 * Log info method.
	 * @param message
	 */
	public static void logInfo(String message) {
		log(IStatus.INFO, IStatus.OK, message, null);
	}
	
	/**
	 * Log error method.
	 * @param exception
	 */
	public static void logError(Throwable exception) {
		logError("Unexpected Exception", exception);
	}
	
	/**
	 * Log error method.
	 * @param message
	 * @param exception
	 */
	public static void logError(String message, Throwable exception) {
		log(IStatus.ERROR, IStatus.OK, message, exception);
	}
	
	/**
	 * Log method.
	 * 
	 * @param severity
	 * @param code
	 * @param message
	 * @param exception
	 */
	public static void log(int severity, int code, String message, Throwable exception) {
		log(createStatus(severity, code, message, exception));
	}
	
	/**
	 * Create status method.
	 * 
	 * @param severity
	 * @param code
	 * @param message
	 * @param exception
	 * @return
	 */
	public static IStatus createStatus(int severity, int code, String message, Throwable exception) {
		return new Status(severity, TAPEditorPlugin.PLUGIN_ID, code, message, exception);
	}
	
	/**
	 * Log status method.
	 * @param status
	 */
	public static void log(IStatus status) {
		TAPEditorPlugin.getDefault().getLog().log(status);
	}
	
}
