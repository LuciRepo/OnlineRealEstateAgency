package ro.oradeaecasa.Pojo;

public class RealEstate {
	private int id;
	private String address;
	private String statusOfTransaction;
	private double areaSqm;
	private String description;
	private double salePrice;
	private double rentPrice;
	private Owner owner;
	private Client client;
	
	public RealEstate(int id, String address, String statusOfTransaction, double areaSqm, String description,
			double salePrice, double rentPrice, Owner owner, Client client) {
	
		this.id = id;
		this.address = address;
		this.statusOfTransaction = statusOfTransaction;
		this.areaSqm = areaSqm;
		this.description = description;
		this.salePrice = salePrice;
		this.rentPrice = rentPrice;
		this.owner = owner;
		this.client = client;
	}
	public RealEstate(int id, String address, String statusOfTransaction, double areaSqm, String description,
			double salePrice, double rentPrice, Owner owner) {
		this.id = id;
		this.address = address;
		this.statusOfTransaction = statusOfTransaction;
		this.areaSqm = areaSqm;
		this.description = description;
		this.salePrice = salePrice;
		this.rentPrice = rentPrice;
		this.owner = owner;
	}
	public RealEstate(String address, String statusOfTransaction, double areaSqm, String description, double salePrice,
			double rentPrice) {
		
		this.address = address;
		this.statusOfTransaction = statusOfTransaction;
		this.areaSqm = areaSqm;
		this.description = description;
		this.salePrice = salePrice;
		this.rentPrice = rentPrice;
	}
	public RealEstate() {
		
	}
public RealEstate(Owner owner) {
	this.owner=owner;
		
	}
	public RealEstate(int id,String statusOfTransaction, Client client) {
	this.id=id;
	this.statusOfTransaction = statusOfTransaction;
	this.client = client;
}
	public RealEstate(Client client) {
		super();
		this.client = client;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStatusOfTransaction() {
		return statusOfTransaction;
	}
	public void setStatusOfTransaction(String statusOfTransaction) {
		this.statusOfTransaction = statusOfTransaction;
	}
	public double getAreaSqm() {
		return areaSqm;
	}
	public void setAreaSqm(double areaSqm) {
		this.areaSqm = areaSqm;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}
	public double getRentPrice() {
		return rentPrice;
	}
	public void setRentPrice(double rentPrice) {
		this.rentPrice = rentPrice;
	}
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
}

