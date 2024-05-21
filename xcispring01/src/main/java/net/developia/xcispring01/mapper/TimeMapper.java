package net.developia.xcispring01.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	// @Select 어노테이션은 getTime 메서드에 직접 SQL 쿼리를 매핑합니다.
	// getTime2 메서드는 XML 매퍼 파일에서 SQL 쿼리를 정의해야 합니다.
	@Select("SELECT to_char(sysdate, 'YYYY-MM-DD') from dual")
	public String getTime();
	public String getTime2();
}
