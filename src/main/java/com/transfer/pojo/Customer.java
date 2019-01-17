package com.transfer.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Qualifier;


@Qualifier("Customer")
@Entity
@Table(name="customer")
public class Customer 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String fullname;
	@Column
	private String username;
	@Column
	private String email;
	@Column
	private String password;
	@Column
	private String confirmpassword;
	
	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="id")
    private Set<TripDetails> obj;
	
	public Customer()
	{
		
	}
	
	public Customer(int id)
	{
		this.id=id;
	}
	
	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getUsername() 
	{
		return username;
	}

	public void setUsername(String username) 
	{
		this.username = username;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

	public String getFullname() 
	{
		return fullname;
	}

	public void setFullname(String fullname) 
	{
		this.fullname = fullname;
	}

	public String getConfirmpassword() 
	{
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) 
	{
		this.confirmpassword = confirmpassword;
	}
	
	public Set<TripDetails> getObj() 
	{
		return obj;
	}

	public void setObj(HashSet<TripDetails> hshSet) 
	{
		this.obj = hshSet;
	}

	@Override
	public String toString() 
	{
		return "Customer [id=" + id + ", fullname=" + fullname + ", username=" + username + ", email=" + email
				+ ", password=" + password + ", confirmpassword=" + confirmpassword + "]";
	}

}