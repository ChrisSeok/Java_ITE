package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.MemberService;
import member.vo.MemberVO;

/**
 * Servlet implementation class RegisterServlet
 */

@WebServlet("/registerservlet")

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 요청 파라미터에서 사용자가 입력한 정보 추출
		String user_loginid = request.getParameter("signupUserid"); //index.jsp 에서 사용자 입력값
		String user_pw = request.getParameter("signupPassword");
		String user_name = request.getParameter("signupUserid");
		
		
		
		MemberVO vo = new MemberVO();    // 이부분 나중에 자동화
		vo.setUser_loginid(user_loginid);
		vo.setUser_pw(user_pw);
		vo.setUser_name(user_name);
		
//		System.out.println("여기는 RegisterServlet: " + vo.getUserid()+ vo.getUserpw()+vo.getUsername());
		
		//2. 로직처리 (Service에게 위임 - service 객체 만들어서)
		MemberService service = new MemberService();
		int result = service.Register(vo);
		System.out.println("result:" + result);
		
		//result 가 1이면 insert 성공 - 팝업을 띄우든가 하세요

		if(result==1) {
			response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        out.println("<html><head><title>Register Result</title></head><body>");
	        out.println("<script>");
	        out.println("alert('Register Success!');");
	        out.println("window.location.href = 'index.jsp';"); // 팝업 후 리다이렉트할 URL
	        out.println("</script>");
	        out.println("</body></html>");
		}

		
		
		
	}

}




