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
@WebServlet("/getpost")
public class BoardGetPost extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardGetPost() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("doGet");	// 제목을 선택하면 해당 글의 post id가 get 방식으로 url 뒤에 붙어서 (crud/getpost?id=2)로 전달됨.

		//post_id를 가지고 db에서 해당 글의 정보 가져오자!
		//먼저 posts 테이블에서 글 정보 가져오자..post_id로 select 쿼리 > BoardVO로 가져오기
		int post_id = Integer.parseInt(request.getParameter("postid")); //해당 글의 post_id
		BoardService service = new BoardService();
		BoardVO postinfo = service.ShowPost(post_id);
		
		// +++댓글 ajax로 가져오기
		
		//postinfo랑 comment 정보를 session으로 넘겨
		
	

		
		//여기서 가져온 postinfo 중 user_id를 이용해서 userinfo DB의 user name을 가져오자!
//		System.out.println(postinfo.getUser_id());
		int userno = postinfo.getUser_id();
		
		MemberService service1 = new MemberService();
		MemberVO userinfo = service1.getUserInfo(userno);
		String username = userinfo.getUser_name();
		
		// JSP로 포워딩
		HttpSession session = request.getSession(true);
		session.setAttribute("POSTINFO", postinfo);
		session.setAttribute("USERNAME", username);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("board_detail.jsp");
		dispatcher.forward(request, response);
	}




	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");



	}

}
