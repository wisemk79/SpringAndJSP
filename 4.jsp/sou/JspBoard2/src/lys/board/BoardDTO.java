package lys.board;

//게시판의 작성날짜,시간->DB에 관련된 클래스 따로 존재
import java.sql.Timestamp;  //import java.util.Date(일반적인 날짜)

//웹상에서 테이블의 필드별로 저장,꺼내올 목적으로 사용하는 클래스(메서드의 매개변수,반환형을 이용)
public class BoardDTO {

	private int num;//게시물번호
	//1.눈에 보이는 상태(입력)
	private String writer;//작성자
	private String subject;//글제목
	private String email;//이메일
	private String content;//글내용
	private String passwd;//암호(글쓰기,수정할때->본인임을 인증때문에)
	//2.눈에 안보이는 경우->직접 X
	private Timestamp reg_date;//작성날짜->sysdate<->now()(MySQL에서 사용하는 함수)
	private int readcount;//조회수->default->0을 입력
	private String ip;//작성자 ip주소를 출력
	//공지사항,자유게시판+3개의 필드추가(답변형)
	private int ref;//글 그룹번호(=단독으로 사용되면 게시물 번호와 역할이 같다)
	private int re_step;//답변글의 순서를 지정(=같은 그룹일때의 답변글 순서)
	private int re_level;//답변글의 답변에 대한 깊이(depth)
	//자료실 추가
	//private String file;//업로드되는 파일의 정보추가(자료실)
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public Timestamp getReg_date() {
		return reg_date;
	}
	public void setReg_date(Timestamp reg_date) {
		this.reg_date = reg_date;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getRe_step() {
		return re_step;
	}
	public void setRe_step(int re_step) {
		this.re_step = re_step;
	}
	public int getRe_level() {
		return re_level;
	}
	public void setRe_level(int re_level) {
		this.re_level = re_level;
	}
}






