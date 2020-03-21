package com.loneliness.servlet;

import com.loneliness.entity.Phone;
import com.loneliness.service.IPhoneService;
import com.loneliness.service.PhoneService;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@WebServlet(name = "SearchServlet", urlPatterns = { "/mobilePhones/search" })
public class SearchServlet extends HttpServlet {
    @EJB
    IPhoneService phoneService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean status =  Boolean.parseBoolean(req.getParameter("status"));
        BigDecimal price = new BigDecimal(req.getParameter("price"));
        List<Phone> phones = phoneService.getPhonesByStatusAndPrice(status,price);
        req.setAttribute("phones", phones);

        getServletContext().getRequestDispatcher("/jsp/phonesPage.jsp").forward(req, resp);
    }

}
