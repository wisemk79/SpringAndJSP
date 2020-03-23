package hewon;

//우편번호테이블->웹상에서 검색을 할때 검색된 데이터를 필드별로 
//                      가져오기위해서 필요로하는 데이터 저장빈

public class ZipcodeDTO {

	private String zipcode;//우편번호
	private String area1;//시,도
	private String area2;//구,소도시
	private String area3;//동,면,리->실시간으로 입력
	private String area4;//나머지 주소
	
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getArea1() {
		return area1;
	}
	public void setArea1(String area1) {
		this.area1 = area1;
	}
	public String getArea2() {
		return area2;
	}
	public void setArea2(String area2) {
		this.area2 = area2;
	}
	public String getArea3() {
		return area3;
	}
	public void setArea3(String area3) {
		this.area3 = area3;
	}
	public String getArea4() {
		return area4;
	}
	public void setArea4(String area4) {
		this.area4 = area4;
	}
}
