package board.dao;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

import board.vo.BoardVO;
import board.vo.CommentVO;
import member.vo.MemberVO;


public class CommentDao {
	
	private SqlSession session;
	
	//생성자에서 session Injection
	public CommentDao(SqlSession session) {
		this.session = session;
	}


	public ArrayList<CommentVO> selectComment(int post_id) throws Exception{
		
		List<CommentVO> resultList = session.selectList("comment.selectallcomment", post_id);
		
		//List에서 ArrayList로 형변환
	    ArrayList<CommentVO> resultArrayList = new ArrayList<>(resultList);
	    
	    return resultArrayList;
		
	
	}
	
//	
//	public BoardVO selectOnePost(int post_id) throws Exception{
//		BoardVO result = null;
//		result = session.selectOne("board.selectonepost",post_id);  //Member.xml에 있는 쿼리 id
//		
//		return result;
//	
//	}
//
	public int deletcomment(int comment_id) {
		int row = -1;
		System.out.println("여기는 commentdao");
		row = session.delete("comment.deletecomment",comment_id);
		
		return row;
	}
//
	public int updatecomment(CommentVO vo) {
		int result = 0;
		result = session.update("comment.editcomment",vo);
		
		return result;
	}
//	
//	
//	public int insertpost(BoardVO postvo) {
//		int result = 0;
//		result = session.insert("board.insertpost", postvo);
//		
//		return result;
//	}
//	
	
	
}
