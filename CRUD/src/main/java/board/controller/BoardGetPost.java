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
		System.out.println("doGet");	// 제목을 선택하면 해당 글의 post id가 get 방식으로 url 뒤에 붙어서 (crud/getpost?id=2)로 전달됨.

		//post_id를 가지고 db에서 해당 글의 정보 + 댓글을 다 가져오자!
		//먼저 posts 테이블에서 글 정보 가져오자..post_id로 select 쿼리 > BoardVO로 가져오기
		int post_id = Integer.parseInt(request.getParameter("postid")); //해당 글의 post_id
		BoardService service = new BoardService();
		
		
		//postinfo랑 comment 정보를 session으로 넘겨
		
		BoardVO postinfo = service.ShowPost(post_id);
		CommentVO commentinfo = service.ShowComment(post_id);
		
		System.out.println(postinfo);
		
		
		
		// JSP로 포워딩
		HttpSession session = request.getSession(true);
		session.setAttribute("postinfo", postinfo);
		
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
