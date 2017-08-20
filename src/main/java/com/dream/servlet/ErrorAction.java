package com.dream.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

/**
 * Created by ning on 2017/8/14.
 */
public class ErrorAction extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

         String  message = (String) request.getAttribute("javax.servlet.error.message");
         Integer statusCode = (Integer)request.getAttribute("javax.servlet.error.status_code");

       Cookie cookie = new Cookie("name", URLEncoder.encode("xiaoming"));
       cookie.setMaxAge(60*2);
        response.addCookie(cookie);
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        out.print("<body>");
        out.print("<h1>");
        out.print(statusCode);
        out.print("</h1>");
        out.print("<div>");
        out.print(message);
        out.print("</div>");
        out.print("</body>");

    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
