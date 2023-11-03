package com.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.Model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.IproductService;
import com.utlis.HttpUtil;

@WebServlet(urlPatterns = { "/api-admin" })
public class NewAPI extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		super.doGet(req, resp);
//	}
  @Inject
  private IproductService proIproductService;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		Product product=  HttpUtil.of(req.getReader()).toProduct(Product.class);
		product = proIproductService.save(product);
		mapper.writeValue(resp.getOutputStream(), product);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		Product deleteProduct= HttpUtil.of(req.getReader()).toProduct(Product.class);
		proIproductService.delete(deleteProduct.getIds());
		mapper.writeValue(resp.getOutputStream(), "{}");
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		Product updateNew= HttpUtil.of(req.getReader()).toProduct(Product.class);
		updateNew = proIproductService.Update(updateNew);
		mapper.writeValue(resp.getOutputStream(), updateNew);
	}
}
