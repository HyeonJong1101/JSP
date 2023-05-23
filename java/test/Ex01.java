package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex01
 */
@WebServlet("/Ex01")
public class Ex01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Ex01() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=EUC-KR");
		PrintWriter out = response.getWriter();

		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				out.println(cookie.getName() + "=" + cookie.getValue() + "<br/>");
			}
		}

		out.println("<form method = 'post' action='Ex01'>");
		out.println("숫자1<input type='text' name='n1'/>");
		out.println("숫자2<input type='text' name='n2'/>");
		
		out.println("연산자<input type='radio' id='a1' name='cal' value='+'>");
		out.println("<label id='a1'>+</label>");
		out.println("<input type='radio' id='a2' name='cal' value='-'>");
		out.println("<label id='a2'>-</label>");
		out.println("<input type='radio' id='a3' name='cal' value='*'>");
		out.println("<label id='a3'>*</label>");
		out.println("<input type='radio' id='a4' name='cal' value='/'>");
		out.println("<label id='a4'>/</label>");
		
		out.println("<input type='submit'/>");
		out.println("</form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String n1 = request.getParameter("n1");
		String n2 = request.getParameter("n2");
		String cal = request.getParameter("cal");

		int num1 = Integer.parseInt(n1);
		int num2 = Integer.parseInt(n2);
		float result = 0;

		switch (cal) {
		case "+":
			result = (num1 + num2);
			break;
		case "-":
			result = (num1 - num2);
			break;
		case "*":
			result = (num1 * num2);
			break;
		case "/":
			result = (num1 / (float)num2);
			break;
		default:
			break;

		}

		String str1 = n1 + cal + n2;
		String str2 = String.valueOf(result);

		Cookie cookie = new Cookie(str1, str2);
		response.addCookie(cookie);
		response.sendRedirect("Ex01");

	}

}
