package models;

import java.util.Date;

public class User {
	
	public int id;
	public String name, email, role, phone;
	public Date create_at, update_at;

	public User(int id, String name, String email, String role, String phone, Date create_at, Date update_at)
	{
		this.id = id;
		this.name = name;
		this.email = email;
		this.role = role;
		this.phone = phone;
		this.create_at = create_at;
		this.update_at = update_at;
	}

}
