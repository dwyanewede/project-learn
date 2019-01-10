package com.learn.demo.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName: SimpleAsyncServlet
 * @Description: java类作用描述
 * @Author: 尚先生
 * @CreateDate: 2018/12/25 17:47
 * @Version: 1.0
 */
@WebServlet(name = "simpleServlet", urlPatterns = "/simple/async/")
public class SimpleAsyncServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        PrintWriter writer = resp.getWriter();
        writer.write("hello world !");
        writer.flush();
    }
}
