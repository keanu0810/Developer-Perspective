package webtoon.semi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webtoon.semi.dto.Member;
import webtoon.semi.mapper.LoginMapper;

@Service
public class LoginService {
	
	@Autowired
    private LoginMapper loginMapper;

    public Member getLogin(String login_id, String login_pw, String login_name, String login_email) {
        return loginMapper.getLogin(login_id, login_pw, login_name, login_email);
        
        
    }
}
