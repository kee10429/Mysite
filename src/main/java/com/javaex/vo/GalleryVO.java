package com.javaex.vo;

public class GalleryVO {
	
	//필드
	private int no;
	private int userNo;
	private String name;
	private String content;
	private String filePath;
	private String orgName;
	private String saveName;
	private int fileSize;
	
	public GalleryVO(int no, int userNo, String name, String content, String filePath, String orgName, String saveName,
			int fileSize) {
		super();
		this.no = no;
		this.userNo = userNo;
		this.name = name;
		this.content = content;
		this.filePath = filePath;
		this.orgName = orgName;
		this.saveName = saveName;
		this.fileSize = fileSize;
	}

	public GalleryVO() {
		super();
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getSaveName() {
		return saveName;
	}

	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}

	public int getFileSize() {
		return fileSize;
	}

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

	@Override
	public String toString() {
		return "GalleryVO [no=" + no + ", userNo=" + userNo + ", name=" + name + ", content=" + content + ", filePath="
				+ filePath + ", orgName=" + orgName + ", saveName=" + saveName + ", fileSize=" + fileSize + "]";
	}
	
	
	
	
	
	
}