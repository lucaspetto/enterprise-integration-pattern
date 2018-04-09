package eip.examples.content;

public enum FilesTypes {

	JSON(".json"),

	XML(".xml"),

	TXT(".txt");

	private String description;

	private FilesTypes(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
