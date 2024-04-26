package board.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;

import board.vo.BoardVO;
import member.vo.MemberVO;


public class BoardDao {
	
	private SqlSession session;
	
	//생성자에서 session Injection
	public BoardDao(SqlSession session) {
		this.session = session;
	}

//	public int insert(MemberVO vo) throws Exception{
//
//	}

	public List<BoardVO> select() throws Exception{
		List<BoardVO> resultlist = null;
		resultlist = session.selectList("board.selectallpost");  //Member.xml에 있는 쿼리 id
		
		return resultlist;
	
	}
	
	public BoardVO selectOnePost(int post_id) throws Exception{
		BoardVO result = null;
		result = session.selectOne("board.selectonepost",post_id);  //Member.xml에 있는 쿼리 id
		
		return result;
	
	}

	public int deletpost(int post_id) {
		int row = -1;
		row = session.delete("board.deletepost",post_id);
		
		return row;
	}

	public int updatepost(BoardVO postvo) {
		int result = 0;
		result = session.update("board.updatepost",postvo);
		
		return result;
	}
	
	
	public int insertpost(BoardVO postvo) {
		int result = 0;
		result = session.insert("board.insertpost", postvo);
		
		return result;
	}
	public List<BoardVO> selectMyPost(int userid) throws Exception{
		List<BoardVO> resultlist = null;
		resultlist = session.selectList("board.selectmypost",userid); 
		
		return resultlist;
	
	}
	
	
}
