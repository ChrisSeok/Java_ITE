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

//		System.out.println("여기는 insert dao , vo: "); //여기까진 넘어온다
		int result = session.insert("member.insertmemberinfo",vo);  //Member.xml에 있는 쿼리 id
		
		
//		System.out.println("여기는 Dao: " + vo);

		
		return result;
	}

	public MemberVO select(MemberVO vo) throws Exception{
//		System.out.println("여기는 select Dao, vo : " + vo);
		MemberVO result1 = null;
		result1 = session.selectOne("member.selectmemberinfo",vo);  //Member.xml에 있는 쿼리 id
		//쿼리 실행 안되면 result1은 null, 실행 됐는데 값이 없으면 0

//		System.out.println("MemberDao - insert 성공");
		
		return result1;
	
	}
	
	
	
	//user_id로 user 정보 가져오는 메서드
	public MemberVO select_with_userid(int user_id) throws Exception{
		MemberVO result2 = null;
		result2 = session.selectOne("member.selectwithid",user_id);  //Member.xml에 있는 쿼리 id

		
		return result2;
	
	}
	
	
	
}
