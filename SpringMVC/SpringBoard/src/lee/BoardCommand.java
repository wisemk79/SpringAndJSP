package lee;
/*
 *  테이블의 필드와 매핑한 클래스=>DTO=>Board(실질적으로 입력받는 필드+입력X(글번호,조회수,날짜)
 *  BoardCommand=>순수하게 입력받는 필드만 처리하기위해서 만들어진 클래스
 *                             자동으로 입력받은 필드만 Setter Method를 호출해주는 메서드이용
 */
public class BoardCommand {

	String author,title,content;//num,date,readcnt(X)

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
		System.out.println("BoardCommand의 setAuthor()호출");
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
		System.out.println("BoardCommand의 setTitle()호출");
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
		System.out.println("BoardCommand의 setContent()호출");
	}
}
