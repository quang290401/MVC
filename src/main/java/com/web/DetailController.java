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

import com.DAO.Model.Cart;
import com.DAO.Model.Product;
import com.service.IdetailCartService;
import com.service.IproductService;
import com.utlis.FromUtil;

@WebServlet(urlPatterns = { "/detail" })
public class DetailController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	IproductService proIproductService;
	@Inject
	private IdetailCartService deCartService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Product product = FromUtil.toModel(Product.class, req);
		product = proIproductService.finOne2(product.getIdProduct());
		req.setAttribute("detailSP", product);
		List<Product>products = proIproductService.findTop4();
		req.setAttribute("topProduct", products);
		String idkh = req.getParameter("idUser");
		Cart cart = deCartService.findOneCart(idkh);

		req.setAttribute("Cart", cart);
		RequestDispatcher rd = req.getRequestDispatcher("views/web/paging2.jsp");
		rd.forward(req, resp);
	}

}
