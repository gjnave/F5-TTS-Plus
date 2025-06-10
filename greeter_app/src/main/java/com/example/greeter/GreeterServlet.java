package com.example.greeter;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GreeterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Serve the index.html page for GET requests
        response.setContentType("text/html");
        request.getRequestDispatcher("/index.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = request.getParameter("userName");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Greeter App</title></head><body>");
        if (userName != null && !userName.trim().isEmpty()) {
            out.println("<h2>Hello, " + userName + "!</h2>");
        } else {
            out.println("<h2>Hello, stranger! Please provide your name.</h2>");
            out.println("<p><a href="index.html">Go back</a></p>");
        }
        out.println("</body></html>");
    }
}
