package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ログイン画面にフォワード
		RequestDispatcher dispatcher =  
				request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメーターを取得
		request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("userName");
		String pass = request.getParameter("pass");
		
		//ログイン処理の実行
		UserDAO dao = new UserDAO();
		User user = dao.findByLogin(userName,pass); 
		
		//ログイン処理の成否によって処理を分岐
		if(user != null) { //ログイン成功時
			//セッションスコープにユーザーIDを保存
			HttpSession session = request.getSession();
			session.setAttribute("userId",userName );
			
			//フォワード
			RequestDispatcher dispatcher =  
					request.getRequestDispatcher("CustomerListServlet");
				dispatcher.forward(request, response);
		}else { //ログイン失敗時
			//リダイレクト
			response.sendRedirect("LoginServlet");
		}
	
		
	}

}
