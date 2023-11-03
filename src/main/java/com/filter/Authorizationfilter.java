package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.Model.User;
import com.constants.SystemConstants;
import com.utlis.SessionUtil;

@WebFilter("/*")
public class Authorizationfilter implements Filter {

	private ServletContext context;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.context = filterConfig.getServletContext();

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse Response = (HttpServletResponse) servletResponse;
		String url = request.getServletPath();

		if (url.startsWith("/admin")) {
			User userModel = (User) SessionUtil.getInstance().getValue(request, "USERMODEL");

			if (userModel != null) {
				if (userModel.getRole().getTenVaiTro().equals(SystemConstants.ADMIN)) {
					chain.doFilter(servletRequest, servletResponse);
				} else if (userModel.getRole().getTenVaiTro().equals(SystemConstants.USER)) {
					Response.sendRedirect(
							request.getContextPath() + "/dang-nhap?action=login&&message=not_permition&alert=danger ");
				}
			} else {
				Response.sendRedirect(
						request.getContextPath() + "/dang-nhap?action=login&&message=not_null&alert=danger ");
			}
		} else if (url.startsWith("/detail")) {
			User userModel = (User) SessionUtil.getInstance().getValue(request, "USERMODEL");

			if (userModel != null) {
				if (userModel.getRole().getTenVaiTro().equals(SystemConstants.USER)) {
					chain.doFilter(servletRequest, servletResponse);
				}
			} else {
				Response.sendRedirect(
						request.getContextPath() + "/dang-nhap?action=login&&message=not_null&alert=danger ");
			}
		} else {
			chain.doFilter(servletRequest, servletResponse);
		}

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
