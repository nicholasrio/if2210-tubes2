package org;

public enum FileCategory {
	TextBook("textbook"), Comics("comics"), Manga("manga");
	
	public static String[] catStrings = {TextBook.toString(), Comics.toString(), Manga.toString()};
	
	private String _text;
	
	FileCategory(String id) {
		this._text = id;
	}
	
	public static FileCategory getCategory(String cat) throws InvalidFileCategoryException {
		FileCategory category;
		String comp = cat.toLowerCase();
		
		switch(comp) {
		case "textbook":
			category = TextBook;
			break;
		case "comics":
			category = Comics;
			break;
		case "manga":
			category = Manga;
			break;
		default:
			throw new InvalidFileCategoryException();
		}
		
		return category;
	}
	
	@Override
	public String toString() {
		return _text;
	}
}

class InvalidFileCategoryException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8009067121868160585L;

	public InvalidFileCategoryException() {
		super("Invalid file category!");
	}
}