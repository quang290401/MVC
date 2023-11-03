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
import com.service.Icatagoryservice;
import com.service.IproductService;
import com.utlis.FromUtil;

@WebServlet(urlPatterns = { "/admin-product" })
public class NewController extends HttpServlet {

	/**
	 * 
	 */
	@Inject
	private IproductService producService;

	@Inject
	private Icatagoryservice icatagoryservice;

	private static final long serialVersionUID = 8914909708111560155L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Product product = FromUtil.toModel(Product.class, req);
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
		String view = "";
		if (product.getType().equals(SystemConstants.LIST)) {
			Pageble pageble = new PageRequest(product.getPage(), product.getMaxPageItem());
			product.setListResulset(producService.findAll(pageble));
			product.setTotalItem(producService.getTotalitem());
			product.setTotalPage((int) Math.ceil((double) product.getTotalItem() / product.getMaxPageItem()));
			view = "views/admin/New/List.jsp";

		} else if (product.getType().equals(SystemConstants.EDIT)) {
			if (product.getIdProduct() != null) {
				
				product = producService.finOne2(product.getIdProduct());

			}
			req.setAttribute("listCatgory", icatagoryservice.findAll());
			view = "views/admin/New/Edit.jsp";

		}
		req.setAttribute(SystemConstants.MODEL, product);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher(view);
		requestDispatcher.forward(req, resp);

	}
}
