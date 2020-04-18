package com.javalec.ex;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MembersAllService implements Service {
	
	public MembersAllService() {
		
	}

	@Override
	public ArrayList<MemberDto> execute(HttpServletRequest request, HttpServletResponse response) {
		//dao 인스턴스를 가져와서 dao에 있는 메소드를 전달해준다.
		MemberDao dao = MemberDao.getInstance();
		return dao.membersAll();
	}
}
