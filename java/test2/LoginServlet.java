package test2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();
        String sessionID = (String) session.getAttribute("id");

        if (sessionID != null) {
        	out.println("로그인중");
            out.println("<form method='post' action='LogoutServlet'>");
            out.println("<input type='submit' value='로그아웃'>");
            out.println("</form>");
        } else {
            out.println("<form method = 'post' action='LoginServlet'>");
            out.println("ID<input type='text' name='id'/>");
            out.println("PW<input type='password' name='pw'/>");
            out.println("<input type='submit'/>");
            out.println("</form>");
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
        String pw = request.getParameter("pw");
        
        if (id != null && pw != null && id.equals("test1") && pw.equals("1234")) {
            HttpSession session = request.getSession();
            session.setAttribute("id", id);
            response.sendRedirect("SuccessPageServlet");
        } else {
            response.sendRedirect("FailurePageServlet");
        }
	}

}
