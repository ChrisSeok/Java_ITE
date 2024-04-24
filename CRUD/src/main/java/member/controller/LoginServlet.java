package member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.service.MemberService;
import member.vo.MemberVO;

/**
 * Servlet implementation class LoginServlet
 */


@WebServlet("/loginservlet")

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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 요청 파라미터에서 사용자가 입력한 정보 추출
		String login_loginid = request.getParameter("loginUserid"); //index.jsp 에서 사용자 입력값
		String login_pw = request.getParameter("loginPassword");
		
		//나중에 $로 바꿔주세용
		login_loginid ="\"" +login_loginid +"\"";
		login_pw ="\"" +login_pw +"\"";
		
		MemberVO vo = new MemberVO();   
		vo.setUser_loginid(login_loginid);
		vo.setUser_pw(login_pw);
		
		
		//2. 로직처리 (Service에게 위임 - service 객체 만들어서)
		MemberService service = new MemberService();
		MemberVO result = service.Login(vo);
		
//		System.out.println("result:" + result);
		
		//result 가 1이면 insert 성공 - 팝업을 띄우든가 하세요
		
		if(result!=null) {
			System.out.println("로그인 성공~!");
			System.out.println("멤버 정보: " + result);
			
			//이제 게시판 jsp로 넘어가게 합쉬다
			HttpSession session = request.getSession(true); //현재 요청과 관련된 세션을 반환한다. 만약 없다면, 새로운 세션을 생성한다.
		    session.setAttribute("UserID", result.getUser_id()); //user_id 값을 세션으로 넘길게요
		
//		    response.sendRedirect("board_list.jsp");
//		    response.sendRedirect("/boardlistservlet");
		    
		    RequestDispatcher dispatcher = request.getRequestDispatcher("/boardlistservlet");
		    dispatcher.forward(request, response);
		    
		}

	
	
	}

}
