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

	    // 기존 쿠키 확인
	    Cookie[] cookies = request.getCookies();
	    if (cookies != null) {
	        for (Cookie cookie : cookies) {
	            if (cookie.getName().equals(n1)) {
	                // 이미 존재하는 ID인 경우 예외 처리
	                response.sendError(HttpServletResponse.SC_CONFLICT, "로그인 성공!!");
	                System.out.println("로그인성공!!");
	                return;
	            }
	        }
	        System.out.println("가입성공!");
	    }

	    // ID가 존재하지 않으면 쿠키를 생성하고 파일에 저장
	    Cookie cookie = new Cookie(n1, n2);
	    response.addCookie(cookie);
	    try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:/Users/User/eclipse-workspaceJSP/Example01/src/main/java/test/IDPW.txt", true))) {
	        writer.write("ID: " + n1 + ", PW: " + n2);
	        writer.newLine();
	    } catch (IOException e) {
	        // 파일 저장 실패 시 예외 처리
	        e.printStackTrace();
	    }

	    response.sendRedirect("SignMember");
	}


}
