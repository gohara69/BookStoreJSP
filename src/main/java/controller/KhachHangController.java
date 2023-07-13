package controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.KhachHangDAO;
import model.KhachHang;
import util.Encrypt;

/**
 * Servlet implementation class KhachHangController
 */
@WebServlet("/khach-hang")
public class KhachHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KhachHangController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hanhDong = request.getParameter("hanhDong");
		switch (hanhDong) {
			case "dang-ky": {
				dangKy(request, response);
				break;
			}
			case "dang-nhap": {
				dangNhap(request, response);
				break;
			}
			
			default:
				throw new IllegalArgumentException("Unexpected value: " + hanhDong);
		}
	}

	private void dangNhap(HttpServletRequest request, HttpServletResponse response) {
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			KhachHang khachHang = new KhachHang();
			khachHang.setTenDangNhap(username);
			khachHang.setMatKhau(Encrypt.toSHA1(password));
			String url = ""; 
			
			KhachHangDAO dao = new KhachHangDAO();
			KhachHang khang = dao.selectByUsernamePasssword(khachHang);
			if(khang != null) {
				HttpSession session = request.getSession();
				session.setAttribute("khachHang", khang);
				url = "/index.jsp";
			} else {
				url = "/khachhang/sign-in.jsp";
				request.setAttribute("error", "Username or password is incorrect");
				request.setAttribute("username", username);
			}
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void dangKy(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String retype = request.getParameter("retype-password");
		String fullname = request.getParameter("fullname") + "";
		fullname = fullname.equals("null") ? "" : fullname;
		String sex = request.getParameter("sex");
		String dateOfBirth = request.getParameter("date-of-birth") + "";
		dateOfBirth = dateOfBirth.equals("null") ? "" : dateOfBirth;
		String customerAddress = request.getParameter("customer-address") + "";
		customerAddress = customerAddress.equals("null") ? "" : customerAddress;
		String diliveryAddress = request.getParameter("dilivery-address") + "";
		diliveryAddress = diliveryAddress.equals("null") ? "" : diliveryAddress;
		String phone = request.getParameter("phone") + "";
		phone = phone.equals("null") ? "" : phone;
		String email = request.getParameter("email");
		String agreePolicy = request.getParameter("agree-policy");
		String agreeTakeEmail = request.getParameter("agree-take-email") + "";
		agreeTakeEmail = agreeTakeEmail.equals("null") ? "" : agreeTakeEmail;
		String url = "";
		boolean validate = true;
		
		if(validateUsername(username)) {
			validate = false;
			request.setAttribute("e_username", "Username has already been using");
		} else {
			request.setAttribute("e_username", "");
		}
		
		if(validatePhone(phone)) {
			request.setAttribute("e_phone", "");
		} else {
			validate = false;
			request.setAttribute("e_phone", "Invalid phone number, try again");
		}
		
		if(validateEmail(email)) {
			request.setAttribute("e_email", "");
		} else {
			validate = false;
			request.setAttribute("e_email", "Invalid email, try again");
		}
		
		if(!validateRetypePassword(password, retype)){
			validate = false;
		}
		
		if(validate) {
			System.out.println(dateOfBirth);
			KhachHang khachHang = new KhachHang(
					0, 
					username, 
					Encrypt.toSHA1(password), 
					fullname, 
					sex.equals("Nam") ? false : true, 
					customerAddress, 
					diliveryAddress, 
					customerAddress, 
					(dateOfBirth.equals("") ? Date.valueOf("1970-2-20") : Date.valueOf(dateOfBirth)), 
					phone, 
					email, 
					agreeTakeEmail.equals("on") ? false : true);
			
			KhachHangDAO khachHangDAO = new KhachHangDAO();
			if(khachHangDAO.insert(khachHang) != 0) {
				url = "/khachhang/success.jsp";
			}
		} 
		
		if(url.equals("")) {
			url = "/khachhang/sign-up.jsp";
			request.setAttribute("username", username);
			request.setAttribute("password", password);
			request.setAttribute("retype", retype);
			request.setAttribute("fullname", fullname);
			request.setAttribute("sex", sex);
			request.setAttribute("dateOfBirth", dateOfBirth);
			request.setAttribute("customerAddress", customerAddress);
			request.setAttribute("diliveryAddress", diliveryAddress);
			request.setAttribute("phone", phone);
			request.setAttribute("email", email);
			request.setAttribute("agreePolicy", agreePolicy);
			request.setAttribute("agreeTakeEmail", agreeTakeEmail);
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private boolean validateUsername(String username) {
		return KhachHangDAO.checkAlreadyHaveUsername(username);
	}
	
	private boolean validatePhone(String phone) {
		Pattern phonePattern = Pattern.compile("\\d{10}");
		Matcher matcher = phonePattern.matcher(phone);
		if(!matcher.matches()) {
			return false;
		}
		return true;
	}
	
	private boolean validateEmail(String email) {
		Pattern emailPattern = Pattern.compile("\\w+@\\w+(\\.\\w+)+");
		Matcher matcher = emailPattern.matcher(email);
		if(!matcher.matches()) {
			return false;
		}
		return true;
	}
	
	private boolean validateRetypePassword(String password, String retype) {
		return password.equals(retype);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
