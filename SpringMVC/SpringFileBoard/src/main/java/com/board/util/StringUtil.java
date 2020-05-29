package com.board.util;

//게시판의 글상세보기때문에 필요=>글내용=>여러줄의 문자열->DB에 저장(줄바꿈)<br>로 변경
//<pre>여러줄  </pre>

public class StringUtil {
	public static String parseBr(String msg){
		
		if(msg == null) return null;
		
		return msg.replace("\r\n", "<br>")  //줄바꿈을 만나면-><br>태그로 변경하라
                         .replace("\n", "<br>");
	}
}
