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

@WebServlet(name = "DeleteServlet", urlPatterns = { "/mobilePhones/delete" })
public class DeleteServlet extends HttpServlet {
    @EJB
    IPhoneService phoneService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String category= req.getParameter("category");
        String modelPhone = req.getParameter("modelPhone");
        phoneService.delete(category,modelPhone);

        req.setAttribute("category", category);
        req.setAttribute("modelPhone", modelPhone);



        getServletContext().getRequestDispatcher("/jsp/deletedpage.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      super.doPost(req, resp);
    }
}
