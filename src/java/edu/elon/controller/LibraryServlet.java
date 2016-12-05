package edu.elon.controller;

import edu.elon.data.UserDB;
import java.io.IOException;
import java.sql.Date;
import java.util.GregorianCalendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import edu.elon.model.User;
import java.util.ArrayList;

/**
 * Copyright (C) 2016 - JZ Greenwell, Casey Hayes Elon University
 */
public class LibraryServlet extends HttpServlet {

  /**
   * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
   * methods.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    String action = request.getParameter("action");
    String url = "/library.jsp";
    if (action == null) {
      action = "Home";
    }
    if (action.equals("Checkout")) {
      //Used to calculate due date
      GregorianCalendar dueDate = new GregorianCalendar();

      //Adds two weeks to the current date
      dueDate.add(GregorianCalendar.DATE, 14);

      //Creates a date that is formatted appropriately for SQL
      Date date = new Date(dueDate.getTimeInMillis());
      
      //Creates a user object with the given input
      User user = new User(request.getParameter("email"), request.getParameter("firstName"), request.getParameter("lastName"), request.getParameter("book"), date);
      
      //Adds user and date attribute to request

      request.setAttribute("user", user);

      if (!UserDB.emailExists(user.getEmail())) {
        UserDB.insertUser(user);
        UserDB.insertBook(user);
      } else {
        UserDB.insertBook(user);
      }
      url = "/success.jsp";
    } else if (action.equals("GetBook")) {
      url = "/checkout.jsp";
    } else if (action.equals("Check in")) {
      UserDB.deleteBook(request.getParameter("email"), request.getParameter("bookName"));
      ArrayList<User> allUsers = new ArrayList<User>();
      allUsers = UserDB.selectUsers();
      request.setAttribute("users", allUsers);
      url = "/manage.jsp";
    } else if (action.equals("ManageBooks")) {
      ArrayList<User> allUsers = new ArrayList<User>();
      allUsers = UserDB.selectUsers();
      request.setAttribute("users", allUsers);
      url = "/manage.jsp";
    } else if (action.equals("Home")) {
      url = "/library.jsp";
    }
    getServletContext().getRequestDispatcher(url).forward(request, response);
  }

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Handles the HTTP <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Returns a short description of the servlet.
   *
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>

}
