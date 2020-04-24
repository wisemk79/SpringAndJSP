package spring3;

import java.io.FileWriter;
import java.io.IOException;

public class OutFileImpl implements OutFile {

	private String filePath;//경로명 및 만들어질 파일명 저장
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	   System.out.println("setFilePath() 호출됨!"+filePath);
	}

    //만들어진 파일에 내용을 추가시켜주는 메서드
	@Override
	public void out(String message) throws IOException {
		// TODO Auto-generated method stub
       //한글데이터를 파일로 저장
		FileWriter fw=new FileWriter(filePath);//c:/webtest/good.txt
		fw.write(message);//파일생성->출력
		fw.close();
	}
}






