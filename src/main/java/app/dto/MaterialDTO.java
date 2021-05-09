package app.dto;

public class MaterialDTO {

	private Integer id;
	private String authorName;
	private String authorSurname;
	private String publisher;
	private String date;
	private String publisherCity;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getAuthorSurname() {
		return authorSurname;
	}
	public void setAuthorSurname(String authorSurname) {
		this.authorSurname = authorSurname;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPublisherCity() {
		return publisherCity;
	}
	public void setPublisherCity(String publisherCity) {
		this.publisherCity = publisherCity;
	}
	
	
}
