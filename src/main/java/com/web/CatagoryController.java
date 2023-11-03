package com.web;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.Model.Catagory;
import com.DAO.Model.Product;
import com.service.Icatagoryservice;
import com.service.IproductService;
@WebServlet(urlPatterns = {"/catagory"})
public class CatagoryController extends HttpServlet {

	/**
	 * 
	 */
	@Inject
	private IproductService iproductService;
	@Inject
	private Icatagoryservice caIcatagoryservice;

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String catagoryId = req.getParameter("cid");
		List<Product>Products = iproductService.findAllProductCatagory(catagoryId);
		List<Catagory>litsC = caIcatagoryservice.findAll();
 		Product lisProductTop = (Product) iproductService.findAllTopProduct();
 		req.setAttribute("listP", Products);
 		req.setAttribute("litsC", litsC);
		req.setAttribute("litsT", lisProductTop);
		
		if(true) {
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
