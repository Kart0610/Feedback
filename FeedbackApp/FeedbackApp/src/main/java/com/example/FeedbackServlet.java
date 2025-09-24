package com.example;

import java.io.*;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.*;

public class FeedbackServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String name = request.getParameter("name");
        String book = request.getParameter("book");
        String feedback = request.getParameter("feedback");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/feedbackdb", "root", "Kart@0610");

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO feedback (name, book, feedback) VALUES (?, ?, ?)");
            ps.setString(1, name);
            ps.setString(2, book);
            ps.setString(3, feedback);
            ps.executeUpdate();

            con.close();
            out.println("feedback saved");
        } catch (Exception e) {
            e.printStackTrace();
            out.println("Error: " + e.getMessage());
        }
    }
}
