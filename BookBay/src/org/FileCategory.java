package org;

public enum FileCategory {
	TextBook("textbook"), Comics("comics"), Manga("manga");
	
	private String _text;
	
	FileCategory(String id) {
		this._text = id;
	}
	
	@Override
	public String toString() {
		return _text;
	}
}
