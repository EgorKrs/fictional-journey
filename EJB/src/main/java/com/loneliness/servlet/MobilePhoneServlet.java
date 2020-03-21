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
import java.util.List;

@WebServlet(name = "MobilePhoneServlet", urlPatterns = { "/mobilePhones" })
public class MobilePhoneServlet extends HttpServlet {
    @EJB
    IPhoneService phoneService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Phone> phones = phoneService.getAll();
        req.setAttribute("phones", phones);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/jsp/phonesPage.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
