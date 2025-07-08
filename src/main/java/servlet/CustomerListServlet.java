package servlet;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class CustomerList
 */
@WebServlet("/CustomerList")
public class CustomerListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ログイン中のユーザーIDを取得（セッションから）
		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");
			        
		if (userId == null) {
		   	RequestDispatcher dispatcher =  
				request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);
		    return;
		}
		
		String keyword = request.getParameter("keyword");
		
		CustomerDAO dao = new CustomerDAO();
		List<Customer> customerList;
		
		
		if(keyword != null && !keyword.isEmpty()) {
			customerList = dao.searchByUserIdAndKeyword(userId,keyword);
		}else {
			customerList = dao.findByUserId(userId); //検索欄が空の場合全て表示
		}
		
		request.setAttribute("customerList", customerList);
        request.setAttribute("keyword", keyword);
        
		//顧客一覧画面にフォワード
		RequestDispatcher dispatcher =  
				request.getRequestDispatcher("WEB-INF/jsp/customerList.jsp");
			dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
