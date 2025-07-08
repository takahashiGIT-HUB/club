package servlet;

import java.io.IOException;
import java.sql.Date;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import dao.CustomerDAO;
import model.Customer;

/**
 * Servlet implementation class CustomerRegister
 */
@WebServlet("/CustomerRegister")
public class CustomerRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//フォワード
		RequestDispatcher dispatcher =  
				request.getRequestDispatcher("WEB-INF/jsp/customerRegister.jsp");
			dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//ログイン中のユーザーIDを取得（セッションから）
		HttpSession session = request.getSession();
	    Integer userId = (Integer) session.getAttribute("userId");
	        
	    if (userId == null) {
	    	response.sendRedirect("WEB-INF/jsp/login.jsp");
	        return;
	     }
	    
		//入力データの取得
		String companyName = request.getParameter("companyName");
		String name = request.getParameter("name");
		String birthday = request.getParameter("birthday");
		String lineId = request.getParameter("lineId");
		String keepBottle = request.getParameter("keepBottle");
		String likesGolfParam = request.getParameter("likesGolf");
		String memo = request.getParameter("memo");
		
		boolean likesGolf = "true".equals(likesGolfParam);
		
		
		
		//Customerオブジェクトに詰める
		Customer customer = new Customer();
		customer.setUserId(userId);
		customer.setCompanyName(companyName);
		customer.setName(name);
		customer.setBirthday(Date.valueOf(birthday));
		customer.setLineId(lineId);
		customer.setKeepBottle(keepBottle);
		customer.setLikesGolf(likesGolf);
		customer.setMemo(memo);
		
		//登録処理
		CustomerDAO dao = new CustomerDAO();
		dao.insert(customer);
		
		//一覧にリダイレクト
		response.sendRedirect("WEB-INF/jsp/customerList.jsp");
		
	}

}
