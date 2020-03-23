function loginCheck(){
	//document.폼객체명.입력양식객체명.속성
	if(document.login.mem_id.value==""){
		alert("아이디를 입력해 주세요.");
		document.login.mem_id.focus();
		return; //return false;
	}
	if(document.login.mem_passwd.value==""){
		alert("비밀번호를 입력해 주세요.");
		document.login.mem_passwd.focus();
		return;
	}
	document.login.submit();//<input type="button" onclick="loginCheck()" ~>
}

function memberReg(){ //회원가입창으로 가는 함수
	document.location="agreement.jsp" //Register.jsp
}
//회원의 값을 입력을 제대로 했는지를 각각 체크해주는 자바스크립트함수
function inputCheck(){
	if(document.regForm.mem_id.value==""){
		alert("아이디를 입력해 주세요.");
		document.regForm.mem_id.focus();
		return;
	}
	if(document.regForm.mem_passwd.value==""){
		alert("비밀번호를 입력해 주세요.");
		document.regForm.mem_passwd.focus();
		return;
	}
	if(document.regForm.mem_repasswd.value==""){
		alert("비밀번호를 확인해 주세요");
		document.regForm.mem_repasswd.focus();
		return;
	}
	if(document.regForm.mem_name.value==""){
		alert("이름을 입력해 주세요.");
		document.regForm.mem_name.focus();
		return;
	}
	
	if(document.regForm.mem_email.value==""){
		alert("이메일을 입력해 주세요.");
		document.regForm.mem_email.focus();
		return;
	}
	if(document.regForm.mem_phone.value==""){
		alert("연락처를 입력해 주세요.");
		document.regForm.mem_phone.focus();
		return;
	}
	if(document.regForm.mem_job.value=="0"){
		alert("직업을 선택해 주세요.");
		document.regForm.mem_job.focus();
		return;
	}
	
	if(document.regForm.mem_passwd.value != document.regForm.mem_repasswd.value){
		alert("비밀번호가 일치하지 않습니다.");
		document.regForm.mem_repasswd.focus();
		return;
	}
	document.regForm.submit();//document.폼객체명.submit()->action속성을 처리
}

//중복ID체크 해주는 자바스크립트함수 선언
function idCheck(id){
   if(id==""){
	   alert("아이디를 먼저 입력하세요!")
	   document.regForm.mem_id.focus()//document.폼객체명.입력양식.호출할 함수
   }else{//id를 입력하고 누른경우
	   //입력받은 중복id를 jsp로 전달->매개변수로 전달
	   url="IdCheck.jsp?mem_id="+id
	   //1.호출할 문서명 2.창의 제목 3.창의 옵션(width,height,left,top)
	   window.open(url,"post","left=450,top=150,width=300,height=150")
   }
}
//우편번호를 검색해주는 함수선언
//check=y->검색전의 창의 모습을 구분하는 인자(매개변수로 전달하기위해서 필요)
function zipCheck(){
	url="ZipCheck.jsp?check=y"
	   //1.호출할 문서명 2.창의 제목 3.창의 옵션(width,height,left,top)
	   //menubar(메뉴바),status(상태바),scrollbars(스크롤바),toolbar=yes|no
	   window.open(url,"post","left=450,top=220,width=500,height=300,"+
			                    "menubar=no,status=yes,toolbar=no,scrollbars=yes")
}













