package com.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.Model.Product;
import com.constants.SystemConstants;
import com.paging.PageRequest;
import com.paging.Pageble;
import com.service.IproductService;
import com.utlis.FromUtil;

@WebServlet(urlPatterns = { "/admin-product" })
public class NewController extends HttpServlet {

	/**
	 * 
	 */
	@Inject
	private IproductService producService;
	private static final long serialVersionUID = 8914909708111560155L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Product product = FromUtil.toProduct(Product.class, req);
//		(cách thủ công)
//		String pageStr = req.getParameter("page");
//		String maxPageitem = req.getParameter("maxPageItem");
//		if(pageStr!=null) {
//			product.setPage(Integer.parseInt(pageStr));
//		}else {
//			product.setPage(1);
//		}
//		if(maxPageitem!=null) {
//			product.setMaxPageItem(Integer.parseInt(maxPageitem));
//		}
			
		Pageble pageble = new PageRequest(product.getPage(), product.getMaxPageItem());
		product.setListResulset(producService.findAll(pageble));
		product.setTotalItem(producService.getTotalitem());
		product.setTotalPage((int) Math.ceil((double) product.getTotalItem() / product.getMaxPageItem()));
		req.setAttribute(SystemConstants.MODEL,product);
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/admin/New/List.jsp");
		requestDispatcher.forward(req, resp);
	}
}
