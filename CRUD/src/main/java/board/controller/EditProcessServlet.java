package board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.service.BoardService;
import board.vo.BoardVO;
import member.service.MemberService;
import member.vo.MemberVO;

/**
 * Servlet implementation class EditProcessServlet
 */
@WebServlet("/editprocessservlet")
public class EditProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProcessServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("doPost in editprocessservlet");
		
		//한글 인코딩 깨져서 인코딩 설정 추가
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String new_content = request.getParameter("editted_content");
		String new_title = request.getParameter("editted_title");
		int post_id = Integer.parseInt(request.getParameter("post_id"));
		
//		System.out.println(new_content + "\n" + new_title);
		
		//jsp에서 받은 title, content, post_id로 DB 수정 - update 쿼리
		BoardService service = new BoardService();
		BoardVO postvo = new BoardVO();
		
		postvo.setContent(new_content);
		postvo.setPost_id(post_id);
		postvo.setTitle(new_title);
		
		int row = service.EditPost(postvo);
		
		if (row == 1) {
//			System.out.println("update 성공!");
			
			//이제 post id로 게시글 정보 가져와서 board_detail.jsp로 보내기
			BoardVO postinfo2 = service.ShowPost(post_id);
			
			//아래는 BoardGetPost.java 복붙
			int userno = postinfo2.getUser_id();
			
			MemberService service2 = new MemberService();
			MemberVO userinfo2 = service2.getUserInfo(userno);
			String username2 = userinfo2.getUser_name();
			
			// JSP로 포워딩
			HttpSession session = request.getSession(true);
			session.setAttribute("POSTINFO", postinfo2);    //BoardGetPost에서 설정했던 Attribute이니까 overwrite 되겠지?
			session.setAttribute("USERNAME", username2);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("board_detail.jsp");
			dispatcher.forward(request, response);
			
			
			
			
		}

	}

}






