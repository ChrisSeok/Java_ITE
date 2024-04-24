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
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/boardlistservlet")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListServlet() {
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
//		System.out.println("여기는 BoardListServlet");
		
		//쿼리 처리해서 posts 테이블에서 게시글 정보(post_id, user_id,title,content,created_at) 다 가져오기
//		BoardVO vo = new BoardVO();   

		
		//2. 로직처리 (Service에게 위임 - service 객체 만들어서)
		BoardService service = new BoardService();
		List<BoardVO> resultlist = (List<BoardVO>) service.BringAllPost();
		
//		System.out.println("result:" + result);
		
		//result 가 1이면 insert 성공 - 팝업을 띄우든가 하세요
		
		if(resultlist!=null) {
//			System.out.println("게시글: " + resultlist);
			
//			//이제 게시판 jsp로 넘어가게 합쉬다
			HttpSession session = request.getSession(true); //현재 요청과 관련된 세션을 반환한다. 만약 없다면, 새로운 세션을 생성한다.
		    session.setAttribute("PostList", resultlist); //user_id 값을 세션으로 넘길게요
//		
//		    
		    RequestDispatcher dispatcher = request.getRequestDispatcher("board_list.jsp");
		    dispatcher.forward(request, response);
		    
		}
		else {
			//게시글 없을 때 
			//게시글 없이 화면 표시
			
		}
		
		
		
		
	
	}

}





