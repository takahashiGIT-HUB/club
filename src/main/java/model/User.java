package model;

import java.sql.Timestamp;

public class User {
	private int id ;
	private String userName;
	private String pass;
	private Timestamp createdAt;
	
	public void setId(int id) {this.id= id;}
	public void setUserName(String userName) {this.userName= userName;}
	public void setPass(String pass) {this.pass= pass;}
	public void setCreatedAt(Timestamp createdAt) {this.createdAt= createdAt;}
	
	public int getId() {return this.id;}
	public String getUserName() {return this.userName;}
	public String getPass() {return this.pass;}
	public Timestamp getCreatedAt() {return this.createdAt;}
	
}
