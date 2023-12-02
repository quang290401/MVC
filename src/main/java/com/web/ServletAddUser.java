package com.web;

import com.DAO.Model.User;
import com.service.IMPL.CartService;
import com.service.IMPL.UserService;
import com.utlis.FromUtil;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletAddUser", value = "/Add-user")
public class ServletAddUser extends HttpServlet {
    @Inject
    UserService userService;
    CartService cartService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         RequestDispatcher rd = request.getRequestDispatcher("/views/web/Adduser.jsp");
         rd.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = FromUtil.toModel(User.class,request);
        userService.save(user);
        response.sendRedirect("/MVC/trang-chu");



    }
}
