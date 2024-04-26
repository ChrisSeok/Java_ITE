package board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.service.BoardService;
import board.service.CommentService;
import board.vo.BoardVO;
import board.vo.CommentVO;
import member.service.MemberService;
import member.vo.MemberVO;

import org.json.JSONArray;
import org.json.JSONObject;

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
		request.setCharacterEncoding("UTF-8");
		
		//post_id를 가지고 db에서 해당 글의 정보 가져오자!
		//먼저 posts 테이블에서 글 정보 가져오자..post_id로 select 쿼리 > BoardVO로 가져오기
		int post_id = Integer.parseInt(request.getParameter("postid")); //해당 글의 post_id
		BoardService service = new BoardService();
		BoardVO postinfo = service.ShowPost(post_id);
		
		//postinfo랑 comment 정보를 session으로 넘겨
		
	

//게시글		
		//여기서 가져온 postinfo 중 user_id를 이용해서 userinfo DB의 user_name을 가져오자!
		int userno = postinfo.getUser_id();
		
		MemberService service1 = new MemberService();
		MemberVO userinfo = service1.getUserInfo(userno);
		String username = userinfo.getUser_name();
		
		
		
//댓글		
		//post_id에 해당하는 모든 댓글을 comment 테이블에서 가져오자. 
		CommentService service2 = new CommentService();

		ArrayList<CommentVO> comms = service2.BringAllComment(post_id); //원글 번호로 원글에 달린 댓글 전부 불러오기
		

//		System.out.println("가져온 댓글: "+comms);
		request.setAttribute("commentlist", comms);
		
//		JSONArray arr = new JSONArray(); //[배열]
//		for (CommentVO vo:comms) {
//			//각 vo의 user id로 username 가져오기 // 처리하기! 일단 넘어감
//			
//			JSONObject obj = new JSONObject(); //{객체}
//			obj.put("commentuserid", vo.getUser_id());
//			obj.put("commentcontent", vo.getComment_text());
//			arr.put(obj);
//		}
//		System.out.println("arr:"+arr);
//		String txt = arr.toString();
//		System.out.println("txt:"+txt);
//
//		response.getWriter().append(txt);
		
		
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
