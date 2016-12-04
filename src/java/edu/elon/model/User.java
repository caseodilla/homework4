/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.elon.model;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 *
 * @author jameszach
 */
public class User {
  private String email;
  private String firstName;
  private String lastName;
  private String bookName;
  private Date date;
    
  public User() {
    email = "";
    firstName = "";
    lastName = "";
    bookName = "";
    date = null;
  }

  public User(String email, String firstName, String lastName, String bookName, 
  Date date) {
    this.email = email;
    this.firstName = firstName;
    this.lastName = lastName;
    this.bookName = bookName;
    this.date = date;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
    
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
    
  public String getBookName() {
    return bookName;
  }

  public void setBookName(String bookName) {
    this.bookName = bookName;
  }
    
  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }
  
  public String getFormattedDate(){
    //Formats a desired due date string
    String dateFormat = "MM-dd-yyyy";
    SimpleDateFormat df = new SimpleDateFormat(dateFormat);
    return df.format(date);
  }
}
