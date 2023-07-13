package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import dao.KhachHangDAO;
import model.KhachHang;
import util.Encrypt;

/**
 * Servlet implementation class changePassword
 */
@WebServlet("/changePassword")
public class changePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changePassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String lastPassword = request.getParameter("last-password");
		String newPassword = request.getParameter("new-password");
		String retypeNewPassword = request.getParameter("retype-new-password");
		HttpSession session = request.getSession();
		KhachHang khachHang = (KhachHang)session.getAttribute("khachHang");
		boolean valid = true;
		String url = "/change-password.jsp";
		
		if(!newPassword.equals(retypeNewPassword)) {
			valid = false;
			request.setAttribute("eRetype", "Retyped Password is incorrect please enter again");
		} else {
			request.setAttribute("eRetype", "");
		}
		
		if(!khachHang.getMatKhau().equals(Encrypt.toSHA1(lastPassword))) {
			valid = false;
			request.setAttribute("ePassword", "Password typed in is incorrect");
		} else {
			request.setAttribute("ePassword", "");
		}
		
		if(khachHang.getMatKhau().equals(Encrypt.toSHA1(newPassword))) {
			valid = false;
			request.setAttribute("eNewPassword", "New password can't be the same with the last one");
		} else {
			request.setAttribute("eNewPassword", "");
		}
		
		if(valid) {
			khachHang.setMatKhau(Encrypt.toSHA1(newPassword));
			KhachHangDAO.updatePassword(khachHang);
			request.setAttribute("success", "Change password successfully");
		} 
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
