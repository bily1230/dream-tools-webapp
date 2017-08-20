package com.dream.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by ning on 2017/8/13.
 */
public class ServletAction extends HttpServlet{

    private  String message ;
    @Override
    public void init(){
        message ="YYYY";
        System.out.println("初始化：YYYY");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int[] a = new int[3];
        a[3]=4;
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<h1>"+ message+"</h1>");
        writer.println("<h1>"+ request.getAttribute("filter")+"</h1>");
        destroy();
    }
    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
        this.doGet(request,response);
    }

    @Override
    public void destroy() {
        System.out.println("destory:"+message);
        super.destroy();
    }
}
