package entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String address;
	private Integer zipcode;
	private String email;
	private Integer phonenumber;
//	
//	public Member getMember() {
//		return member;
//	}
//	public void setMember(Member member) {
//		this.member = member;
//	}
	@ManyToOne
	private Member member;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getZipcode() {
		return zipcode;
	}
	public void setZipcode(Integer zipcode) {
		this.zipcode = zipcode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getPhoneNumber() {
		return phonenumber;
	}
	public void setPhoneNumber(Integer phoneNumber) {
		this.phonenumber = phoneNumber;
	}
	
	
}
