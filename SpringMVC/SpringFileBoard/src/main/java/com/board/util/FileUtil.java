package com.board.util;

import java.io.File;

//파일업로드와 다운로드를 구현=>업로드위치=다운로드 위치(상대경로X)=>절대경로 복잡=>정적상수
public class FileUtil {

	//업로드 및 다운로드 경로
	public static final String UPLOAD_PATH="C:/webtest/4.jsp/sou/SpringFileBoard/src/main/webapp/upload";
	
	//1.탐색기의 원본파일명만 받아서 처리해주는 메서드(ex test.txt)
	public static String rename(String filename) throws Exception {
		 if(filename==null) return null; //업로드 X ->이름 변경 X
		 //새이름 규칙=>시스템 날짜+랜덤숫자(0~49)->조합
		 String newName=Long.toString(System.currentTimeMillis())
				                   +(int)(Math.random()*50);//난수발생(0~0.99999)
		 System.out.println("newName(난수)=>"+newName);
		 return rename(filename,newName); //test.txt,조합이름
	}
	
	//2.실제로 새로운 파일명을 변경하는 역할->확장자 구분=>변경된 이름만 구해서 변경
	//ex)testkimaaa.txt(뒤에서 검색)->123add.txt
	public static String rename(String filename,String newName) throws Exception{
		if(filename==null) return null;
		//확장자 구하기
		int idx=filename.lastIndexOf(".");//못찾으면 -1을 리턴
		String extention="";//확장자 저장
		String newFileName="";//새파일명을 저장
		if(idx!=-1) { //확장자를 찾았다면
			extention=filename.substring(idx);//인수하나를 기준 문자열끝까지(확장자만 저장)
			System.out.println("extention=>"+extention);
		}
		//새파일명을 구해서+extention
		int newIdx=newName.lastIndexOf(".");//확장자를  포함한 변경된 파일명
		if(newIdx!=-1) {
			newName=newName.substring(0,newIdx);//0(문자열의 시작포함,newIdx바로앞까지)
			//testkim.txt
			System.out.println("newName(변경된파일명)=>"+newName);
		}
		//testkim.TXT
		newFileName=newName+extention.toLowerCase();//확장자가 대문자->소문자로변경
		return newFileName;//실질적인 업로드된 파일명
	}
	
	//3.글수정->업로드된 파일도 수정대상->기존 업로드된 파일 삭제->새로운파일 업로드
	//파일사제->수정목적
	public static void removeFile(String filename) {
		File file=new File(UPLOAD_PATH,filename);//1.경로 2.파일명
		if (file.exists()) file.delete();//이 경로에 파일이 존재한다면 삭제하라
	}
	
}


