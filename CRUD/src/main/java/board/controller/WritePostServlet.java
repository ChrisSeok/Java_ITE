package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.service.BoardService;
import board.vo.BoardVO;
import member.*;
import member.service.MemberService;
import member.vo.MemberVO;

/**
 * Servlet implementation class BoardGetPost
 */
@WebServlet("/writepostservlet")
public class WritePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WritePostServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//세션에 저장된 로그인된 유저 아이디
		HttpSession session = request.getSession(true);
		String s_user_id = (String)session.getAttribute("UserID");
		int user_id = Integer.parseInt(s_user_id)
				
		//writepost.jsp에서 가져온 제목, 내용 입력값
		String title = request.getParameter("newtitle");
		String content = request.getParameter("newcontent");
		
		//을 가지고 insert 쿼리로 posts테이블에 게시글 추가
		BoardService service = new BoardService();
		BoardVO vo = new BoardVo();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setUser_Id(user_id);
		int insertrow = service.InsertPost(vo);
		
		if(insertrow==1) {
			response.sendRedirect("/boardlistservlet");
		}
//		MemberService service1 = new MemberService();
//		MemberVO userinfo = service1.getUserInfo(userno);
//		String username = userinfo.getUser_name();
		
		// JSP로 포워딩
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("board_detail.jsp");
		dispatcher.forward(request, response);


	}

}
