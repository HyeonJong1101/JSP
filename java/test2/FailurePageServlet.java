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
 * Servlet implementation class FailurePageServlet
 */
@WebServlet("/FailurePageServlet")
public class FailurePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FailurePageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=EUC-KR");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false);

        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"EUC-KR\">");
            out.println("<title>Insert title here</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<a href=\"./LoginServlet\">에러페이지 다시 로그인하세요</a>");

            if (session != null) {
                session.invalidate();
            }

            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
