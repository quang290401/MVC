 package com.web;


import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.Model.Catagory;
import com.DAO.Model.Product;
import com.DAO.Model.User;

import com.service.Icatagoryservice;
import com.service.IproductService;
import com.service.IuserService;
import com.utlis.FromUtil;
import com.utlis.SessionUtil;

@WebServlet(urlPatterns = { "/trang-chu", "/dang-nhap", "/dang-xuat" })
public class HomeController extends HttpServlet {

	/**
	 * 
	 */
	@Inject
	private Icatagoryservice caIcatagoryservice;
	@Inject
	private IproductService iproductService;
	@Inject
	private IuserService iuserService;

	private static final long serialVersionUID = 1L;
	 ResourceBundle resourceBundle = ResourceBundle.getBundle("message");

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String action = req.getParameter("action");
		if (action != null && action.equals("login")) {
			String message =req.getParameter("message");
			String alert =req.getParameter("alert");
			if(message!=null&&alert!=null) {
				req.setAttribute("message", resourceBundle.getString(message));
				req.setAttribute("alert",alert);
			}
			RequestDispatcher rd = req.getRequestDispatcher("views/web/login.jsp");
			rd.forward(req, resp);
		} else if (action != null && action.equals("logout")) {
			SessionUtil.getInstance().removeValue(req, "USERMODEL");
			resp.sendRedirect(req.getContextPath() + "/trang-chu");
		} else {
			
				List<Product>lisProducts = iproductService.findAllProduct();
				List<Catagory>litsC = caIcatagoryservice.findAll();
	     		Product lisProductTop = (Product) iproductService.findAllTopProduct();
				req.setAttribute("listP", lisProducts);
				req.setAttribute("litsC", litsC);
				req.setAttribute("litsT", lisProductTop);
				RequestDispatcher rd = req.getRequestDispatcher("views/web/Home.jsp");
				rd.forward(req, resp);
			}
		

		}	
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action != null && action.equals("login")) {
			User user = FromUtil.toModel(User.class, req);
			user = iuserService.findByUserNameAndPassWordAndStatus(user.getTaiKhoan(), user.getMatKhau(), 1);
			if (user != null) {
				SessionUtil.getInstance().putValue(req, "USERMODEL", user);
				if (user.getRole().getTenVaiTro().equals("User")) {
					resp.sendRedirect(req.getContextPath() + "/trang-chu ");
				} else if (user.getRole().getTenVaiTro().equals("admin")) {
					resp.sendRedirect(req.getContextPath() + "/admin-home");
				}
			} else {
				resp.sendRedirect(req.getContextPath() + "/dang-nhap?action=login&message=username_password_invalid&alert=danger ");
			}
			
		}
	}
}
