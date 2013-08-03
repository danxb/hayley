package uk.co.danxb.hayley.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class hello extends HttpServlet {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
	// Set response content type
      response.setContentType("text/html");

      // Actual logic goes here.
      PrintWriter out = response.getWriter();
      out.println("<h1>Hi there</h1>");
  }
}