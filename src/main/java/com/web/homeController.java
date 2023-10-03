package com.web;

import java.io.IOException;
import java.math.BigDecimal;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.service.Icatagoryservice;


@WebServlet(urlPatterns = { "/trang-chu", "/dang-nhap", "/dang-xuat" })
public class homeController extends HttpServlet {

	/**
	 * 
	 */
	@Inject
	private Icatagoryservice caIcatagoryservice;

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action != null && action.equals("login")) {
			RequestDispatcher rd = req.getRequestDispatcher("views/web/login.jsp");
			rd.forward(req, resp);
		} else if (action != null && action.equals("logout")) {

		} else {
			req.setAttribute("products", caIcatagoryservice.findAll());
			RequestDispatcher rd = req.getRequestDispatcher("views/web/Home.jsp");
			rd.forward(req, resp);
		
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
