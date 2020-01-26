package ro.oradeaecasa.Pojo;

public class Client {
	private int id;
	private String name;
	private String identificationCode;
	private String phoneNumber;
	private String email;
	public Client(int id, String name, String identificationCode, String phoneNumber, String email) {
		this.id = id;
		this.name = name;
		this.identificationCode = identificationCode;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	public Client(String name, String identificationCode, String phoneNumber, String email) {
		this.name = name;
		this.identificationCode = identificationCode;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	public Client(int id) {
		this.id = id;
	}
	public Client(String name) {
	this.name=name;
	}
	public Client() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdentificationCode() {
		return identificationCode;
	}
	public void setIdentificationCode(String identificationCode) {
		this.identificationCode = identificationCode;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
