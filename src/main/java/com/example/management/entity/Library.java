package com.example.management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name="book_detail")
public class Library {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
@Column(name="book_name")
private String bookname;
@Column(name="author_name")
@NotBlank(message="author name cannot be blank")
private String authorname;
@Column (name ="mail_id")
@Email(message="email is invalid")
@NotEmpty(message = "Email cannot be empty")
private String email;
@Column(name = "phone_num")
@Range(min = 10,max=10,message="ten number should be availabe in a phone number")
private long phnum;

public long getPhnum() {
	return phnum;
}
public void setPhnum(long phnum) {
	this.phnum = phnum;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getBookname() {
	return bookname;
}
public void setBookname(String bookname) {
	this.bookname = bookname;
}
public String getAuthorname() {
	return authorname;
}
public void setAuthorname(String authorname) {
	this.authorname = authorname;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
}
