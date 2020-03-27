package nl.rinis.wzd;

public class FilenameHelper {

	/**
	 *
	 * @return returns the absolute path plus filename as a string
	 */
	public static String createUniqueFilename(String outputFolder, String referentieNummer) {
		String filename = referentieNummer + "-" + System.currentTimeMillis() + ".xml";
		if (outputFolder.endsWith("/")) {
			return outputFolder + filename;
		} else {
			return outputFolder + "/" + filename;
		}
	}
}
