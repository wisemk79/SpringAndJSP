package lee;

//테이블의 필드와 입력받은 값을 연결(=매핑)시키기 위해서 필요

public class Board {
    private int num;
    private String author,title,content,date;//date형은 날짜형->문자형으로 저장(화면출력)
    private int readcnt;
    
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
		System.out.println("setAuthor() 호출됨");
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
		System.out.println("setTitle() 호출됨");
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
		System.out.println("setContent() 호출됨");
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getReadcnt() {
		return readcnt;
	}
	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}
}
