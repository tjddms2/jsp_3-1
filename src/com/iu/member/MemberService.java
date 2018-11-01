package com.iu.member;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iu.action.ActionFoward;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MemberService {
	private MemberDAO memberDAO;
	
	public MemberService() {
		memberDAO = new MemberDAO();
	}
	
	//login
	public ActionFoward login(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		
		String method=request.getMethod();
		
		if(method.equals("POST")) {
		
			MemberDTO memberDTO = new MemberDTO();
			memberDTO.setId(request.getParameter("id"));
			memberDTO.setPw(request.getParameter("pw"));
			memberDTO.setKind(request.getParameter("kind"));
			try {
				memberDTO = memberDAO.login(memberDTO);
			} catch (Exception e) {
				memberDTO = null;
				e.printStackTrace();
			}
			
			if(memberDTO != null) {
				HttpSession session = request.getSession();
				session.setAttribute("member", memberDTO);
				actionFoward.setCheck(false);
				actionFoward.setPath("../index.jsp");
			}else {
				request.setAttribute("message", "Login Fail");
				actionFoward.setCheck(true);
				actionFoward.setPath("../WEB-INF/view/member/memberLogin.jsp");
			}
			
		}else {
			//GET
			actionFoward.setCheck(true);
			actionFoward.setPath("../WEB-INF/view/member/memberLogin.jsp");
			
		}
		return actionFoward;
	}
	
	
	//join
	public ActionFoward join(HttpServletRequest request, HttpServletResponse response) {
		ActionFoward actionFoward = new ActionFoward();
		String method = request.getMethod();
		if(method.equals("POST")) {
		
		
		int max=1024*1024*10;
		String path = request.getServletContext().getRealPath("upload");
		File file = new File(path);
		if(!file.exists()) {
			file.mkdirs();
		}
		
		try {
			//파일저장
			MultipartRequest multi = new MultipartRequest(request, path, max, "UTF-8", new DefaultFileRenamePolicy());
			//Member Data
			MemberDTO memberDTO = new MemberDTO();
			memberDTO.setId(multi.getParameter("id"));
			memberDTO.setPw(multi.getParameter("pw"));
			memberDTO.setName(multi.getParameter("name"));
			memberDTO.setEmail(multi.getParameter("email"));
			memberDTO.setKind(multi.getParameter("kind"));
			memberDTO.setClassMate(multi.getParameter("classMate"));
			memberDTO.setFname(multi.getFilesystemName("f1"));
			memberDTO.setOname(multi.getOriginalFileName("f1"));
			/*
			 *  파일의 정보를 DTO에 추가  
			 * 
			 */
			int result = memberDAO.join(memberDTO);
			if(result>0) {
				request.setAttribute("message", "Join Success");
				request.setAttribute("path", "../index.jsp");
			}else {
				request.setAttribute("message", "Join Fail");
				request.setAttribute("path", "./memberJoin.do");
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		actionFoward.setCheck(true);
		actionFoward.setPath("../WEB-INF/view/common/result.jsp");
		}else {
			actionFoward.setCheck(true);
			actionFoward.setPath("../WEB-INF/view/member/memberJoin.jsp");
		}
		
		return actionFoward;
	}

}













