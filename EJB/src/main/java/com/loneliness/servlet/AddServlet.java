package com.loneliness.servlet;

import com.loneliness.entity.Phone;
import com.loneliness.service.IPhoneService;
import com.loneliness.service.PhoneService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@WebServlet(name = "AddServlet", urlPatterns = { "/mobilePhones/add" })
public class AddServlet extends HttpServlet {
    @EJB
    IPhoneService phoneService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/jsp/addpage.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String model= req.getParameter("model");
        String category = req.getParameter("category");
        BigDecimal price= new BigDecimal(req.getParameter("price"));
        boolean status= Boolean.parseBoolean("status");

        Phone phone =new Phone();


        phone.setModel(model);
        phone.setCategory(category);
        phone.setPrice(price);
        phone.setStatus(status);
        phoneService.add(phone);

        getServletContext().getRequestDispatcher("/jsp/addedpage.jsp").forward(req, resp);
    }
}
