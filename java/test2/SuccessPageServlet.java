package test2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SuccessPageServlet")
public class SuccessPageServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=EUC-KR");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false);

        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"EUC-KR\">");
            out.println("<title>Insert title here</title>");
            out.println("<script src=\"https://code.jquery.com/jquery-3.6.0.min.js\"></script>");
            out.println("<script>");
            out.println("function logout() {");
            out.println("$.ajax({");
            out.println("url: \"LogoutServlet\",");
            out.println("type: \"POST\",");
            out.println("success: function() {");
            out.println("location.reload();");
            out.println("},");
            out.println("error: function() {");
            out.println("alert(\"로그아웃에 실패했습니다.\");");
            out.println("}");
            out.println("});");
            out.println("}");
            out.println("</script>");
            out.println("</head>");
            out.println("<body>");
            out.println("사용자" + session.getAttribute("id") + "의 페이지입니다.");
            out.println("<br>");
            out.println("<a href=\"./LoginServlet\">처음화면 돌아가기</a>");
            out.println("<input type=\"button\" value=\"로그아웃\" onclick=\"logout()\">");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }
}
