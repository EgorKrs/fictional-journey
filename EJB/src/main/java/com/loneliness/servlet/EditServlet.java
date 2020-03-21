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

@WebServlet(name = "EditServlet", urlPatterns = { "/mobilePhones/edit" })
public class EditServlet extends HttpServlet {
    @EJB
    IPhoneService phoneService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        req.setAttribute("mobilePhoneAttribute", phoneService.get(id));



        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/jsp/editpage.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id= Integer.parseInt(req.getParameter("id"));
        String model= req.getParameter("model");
        String category = req.getParameter("category");
        BigDecimal price= new BigDecimal(req.getParameter("price"));
        boolean status= Boolean.parseBoolean("status");

        Phone phone =new Phone();

        phone.setId(id);
        phone.setModel(model);
        phone.setCategory(category);
        phone.setPrice(price);
        phone.setStatus(status);


        phoneService.edit(phone);


        req.setAttribute("id", id);

        getServletContext().getRequestDispatcher("/jsp/editedpage.jsp").forward(req, resp);


    }

}
