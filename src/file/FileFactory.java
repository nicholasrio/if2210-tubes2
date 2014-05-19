package file;

import file.MyFile;
import file.PDF;
import file.TXT;
import file.DOC;

/**
 *
 * @author Mamat Rahmat / 135120007
 */
public class FileFactory {

	public MyFile getFile(String fileType) {
		if (fileType == null) {
			return null;
		}
		if (fileType.equalsIgnoreCase("pdf")) {
			return new PDF();
		} else if (fileType.equalsIgnoreCase("TXT")) {
			return new TXT();
		} else if (fileType.equalsIgnoreCase("DOC")) {
			return new DOC();
		}

		return null;
	}
}
