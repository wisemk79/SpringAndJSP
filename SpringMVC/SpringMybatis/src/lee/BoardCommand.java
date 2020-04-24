package lee;
/*
 *  테이블의 필드와 매핑한 클래스=>DTO=>Board(실질적으로 입력받는 필드+입력X(글번호,조회수,날짜)
 *  BoardCommand=>순수하게 입력받는 필드만 처리하기위해서 만들어진 클래스
 *                             자동으로 입력받은 필드만 Setter Method를 호출해주는 메서드이용
 */
public class BoardCommand {
     //추가
	int num;
	String author,title,content;//num,date,readcnt(X)
	//추가2
	String writeday;
	int readcnt;
	//검색분야,검색어-->HashMap을 설정해도 된다.
	String searchName,searchValue;

	public int getNum() { //#{num}
		System.out.println("BoardCommand의 getNum()호출됨");
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getWriteday() {
		return writeday;
	}

	public void setWriteday(String writeday) {
		this.writeday = writeday;
	}

	public int getReadcnt() {
		return readcnt;
	}

	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}
    //-------------------------------------------------------
	public String getAuthor() {
		System.out.println("BoardCommand의 getAuthor()호출됨");
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
		System.out.println("BoardCommand의 setAuthor()호출");
	}

	public String getTitle() {
		System.out.println("BoardCommand의 getTitle() 호출됨");
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
		System.out.println("BoardCommand의 setTitle()호출");
	}

	public String getContent() {
		System.out.println("BoardCommand의 getContent()호출됨");
		return content;
	}

	public void setContent(String content) {
		this.content = content;
		System.out.println("BoardCommand의 setContent()호출");
	}
}
