package com.file;

public class FileDTO {
	private String name;
	private String file;
	private String image;
	
	public FileDTO() {
		super();
	}
	public FileDTO(String name, String file, String image) {
		super();
		this.name = name;
		this.file = file;
		this.image = image;
	}
	
	
	public String getName() {
		return name == null ? "" : name.trim();
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFile() {
		return file == null ? "" : file.trim();
	}
	public void setFile(String file) {
		this.file = file;
	}
	public String getImage() {
		return image == null ? "" : image.trim();
	}
	public void setImage(String image) {
		this.image = image;
	}
	
}
