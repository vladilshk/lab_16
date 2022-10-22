package com.example.demo;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

@WebServlet(name = "DoubleListServlet", value = "/DoubleListServlet")
public class DoubleListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Data data = new Data();
        Map<String, ArrayList<String>> list = data.getData();
        int counter = 1;

        out.println("<!DOCTYPE html>\n" +
                "<head>\n" +
                "    <title>List</title>\n" +
                "    <link rel=\"stylesheet\" href=\"style2.css\">\n" +
                "    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js\"></script>\n" +
                "    <script src=\"script.js\"></script>\n" +
                "    <style></style>\n" +
                "</head>\n" +
                "<body>");


        out.println("<ul class=\"list\" id=\"list\">");

        for(String header : list.keySet()){
            out.println("<li class=\"span\">" + counter++ + ". " + header);
            out.println("<ul>");
            for (int i = 0; i < list.get(header).size(); i++) {
                out.println("<li>" + list.get(header).get(i) + "</li>");
            }
            out.println("</ul>");
            out.println("</li>");
        }

        out.println("</ul>");
        out.println("</body>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
