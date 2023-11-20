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
import com.DAO.Model.DetailCart;
import com.DAO.Model.ItemCart;
import com.DAO.Model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.IItemCartService;
import com.service.IdetailCartService;
//import com.service.IMPL.ItemCartService;
import com.utlis.HttpUtil;

@WebServlet(urlPatterns = { "/add-to-cart" })
public class AddtoCartController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private IdetailCartService deCartService;
	@Inject
	private IItemCartService dCartService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idkh = req.getParameter("idUser");
		Cart cart = deCartService.findOneCart(idkh);

		req.setAttribute("Cart", cart);
		List<ItemCart> listDetailCart = dCartService.findAllProduct(cart.getId());

		req.setAttribute("ListCardetail", listDetailCart);
		RequestDispatcher rd = req.getRequestDispatcher("/views/web/ShoppingCart.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		DetailCart insertNew= HttpUtil.of(req.getReader()).toProduct(DetailCart.class);
		 deCartService.save(insertNew);
		mapper.writeValue(resp.getOutputStream(), insertNew);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		ItemCart insertNew= HttpUtil.of(req.getReader()).toProduct(ItemCart.class);
		 deCartService.delete(insertNew.getIdSanPham());
		mapper.writeValue(resp.getOutputStream(), insertNew);
	}

}
