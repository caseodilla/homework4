package edu.elon.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import edu.elon.model.User;

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
      User user = new User(request.getParameter("email"), request.getParameter("firstName"), request.getParameter("lastName"),request.getParameter("book"),date);
    
      //Gets formatted due date
      String formattedDate = user.getFormattedDate();
      //Adds user and date attribute to request
      
      request.setAttribute("user", user);
      request.setAttribute("formattedDate",formattedDate);

      url = "/success.jsp";
    } else if (action.equals("GetBook")) {
      url = "/checkout.jsp";
    } else if (action.equals("ManageBooks")) {
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
