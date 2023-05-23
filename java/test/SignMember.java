package test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignMember
 */
@WebServlet("/SignMember")
public class SignMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignMember() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		
		PrintWriter out = response.getWriter();

		out.println("<form method = 'post' action='SignMember'>");
		out.println("ID<input type='text' name='n1'/>");
		out.println("PW<input type='password' name='n2'/>");
		out.println("<input type='submit'/>");
		out.println("</form>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String n1 = request.getParameter("n1");
	    String n2 = request.getParameter("n2");

	    // ���� ��Ű Ȯ��
	    Cookie[] cookies = request.getCookies();
	    if (cookies != null) {
	        for (Cookie cookie : cookies) {
	            if (cookie.getName().equals(n1)) {
	                // �̹� �����ϴ� ID�� ��� ���� ó��
	                response.sendError(HttpServletResponse.SC_CONFLICT, "�α��� ����!!");
	                System.out.println("�α��μ���!!");
	                return;
	            }
	        }
	        System.out.println("���Լ���!");
	    }

	    // ID�� �������� ������ ��Ű�� �����ϰ� ���Ͽ� ����
	    Cookie cookie = new Cookie(n1, n2);
	    response.addCookie(cookie);
	    try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:/Users/User/eclipse-workspaceJSP/Example01/src/main/java/test/IDPW.txt", true))) {
	        writer.write("ID: " + n1 + ", PW: " + n2);
	        writer.newLine();
	    } catch (IOException e) {
	        // ���� ���� ���� �� ���� ó��
	        e.printStackTrace();
	    }

	    response.sendRedirect("SignMember");
	}


}
