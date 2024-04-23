package member.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;

import member.vo.MemberVO;

public class MemberDao {
	
	private SqlSession session;
	
	//생성자에서 session Injection
	public MemberDao(SqlSession session) {
		this.session = session;
	}

	public int insert(MemberVO vo) throws Exception{

//		System.out.println("여기는 dao , vo: "); //여기까진 넘어온다
		int result = session.insert("member.insertmemberinfo",vo);  //Member.xml에 있는 쿼리 id
									
		
		
		System.out.println("여기는 Dao: " + vo);

//		System.out.println("MemberDao - insert 성공");
		
		return result;
	}
}
