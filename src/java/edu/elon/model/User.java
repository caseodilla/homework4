package edu.elon.model;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 * Copyright (C) 2016 - JZ Greenwell, Casey Hayes Elon University
 */
public class User {
  private String email;
  private String firstName;
  private String lastName;
  private String bookName;
  private Date date;
  
  //for formatting purposes
  private String formattedDate;
  
  //determines whether the book is overdue or not upon creation
  private Boolean overDue;
    
  public User() {
    email = "";
    firstName = "";
    lastName = "";
    bookName = "";
    date = null;
    formattedDate = "";
  }

  public User(String email, String firstName, String lastName, String bookName, 
  Date date) {
    this.email = email;
    this.firstName = firstName;
    this.lastName = lastName;
    this.bookName = bookName;
    this.date = date;
    this.formattedDate = getFormattedDate();
    this.overDue = isOverDue();
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
    
    //as soon as there is a valid date, the date is saved in a formatted form 
    //and it is determined whether or not the book is overdue
    this.formattedDate = getFormattedDate();
    this.overDue = isOverDue();
  }
  
  public String getFormattedDate(){
    //Formats a desired due date string
    String dateFormat = "MM-dd-yyyy";
    SimpleDateFormat df = new SimpleDateFormat(dateFormat);
    return df.format(date);
  }
  
  public boolean isOverDue(){
    GregorianCalendar currentCal = new GregorianCalendar();
    Date currentDate = new Date(currentCal.getTimeInMillis());
    if(currentDate.compareTo(this.date)<0){
      return false;
    }
    return true;
  }
}
