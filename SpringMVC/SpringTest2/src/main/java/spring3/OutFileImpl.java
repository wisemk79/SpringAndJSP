package spring3;

import java.io.FileWriter;
import java.io.IOException;

public class OutFileImpl {
	private String filePath;// 경로명 및 만들어질 파일명 저장변수 
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
		System.out.println("setFilePath(String filePath)호출됨! " + filePath);
	}
	
	
	//만들어질 파일에 내용을 추가시켜주는 메소드
	public void out(String message) throws IOException{
		FileWriter fw = new FileWriter(filePath);//경로
		fw.write(message);//파일생성후 출력 
		fw.close();
	}
}
