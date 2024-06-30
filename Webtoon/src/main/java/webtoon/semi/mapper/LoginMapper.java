package webtoon.semi.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import webtoon.semi.dto.Member;

@Mapper
public interface LoginMapper {
	
    Member getLogin(@Param("login_id") String login_id, 
            @Param("login_pw") String login_pw,
            @Param("login_name") String login_name,
            @Param("login_email") String login_email);

}
