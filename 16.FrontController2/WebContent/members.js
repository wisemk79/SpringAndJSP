/*
if(document.reg_frm.email.value.length == 0){
   /*
     * reg_frm이라는 form의
     * email이란 input의
     * value라는 객체(?)의 length가 0이라면...
     * alert("Email을 써주세요.");
	   reg_frm.email.focus();
	   return false;
	}
	document.reg_frm.submit();  //action으로 입력한 주소로 이동
*/



function infoConfirm(){
	if(document.reg_frm.id.value.length == 0){
		alert("아이디는 필수 사항 입니다. ");
		reg_frm.id.docus();
		return;
	}
	
	if(document.reg_frm.id.value.length < 4){
		alert("아이디는 4글자 이상이어야 합니다. ");
		reg_frm.id.docus();
		return;
	}
	
	if(document.reg_frm.pw.value.length == 0){
		alert("비밀번호는 필수 사항 입니다. ");
		reg_frm.pw.docus();
		return;
	}
	
	if(document.reg_frm.pw.value != document.reg_frm.pw_check.value){
		alert("비밀번호가 일치하지 않습니다.");
		reg_frm.pw.docus();
		return;
	}
	
	if(document.reg_frm.name.value.length == 0){
		alert("이름은 필수 사항 입니다. ");
		reg_frm.name.docus();
		return;
	}
	
	if(document.reg_frm.eMail.value.length == 0){
		alert("이메일은 필수 사항 입니다. ");
		reg_frm.eMail.docus();
		return;
	}
	
	if(document.reg_frm.address.value.length == 0){
		alert("주소는 필수 사항 입니다. ");
		reg_frm.address.docus();
		return;
	}
	
	document.reg_frm.submit();

}


function UpdateInfoConfirm(){
	if(document.reg_frm.pw.value.length == 0){
		alert("비밀번호는 필수 사항 입니다. ");
		reg_frm.pw.docus();
		return;
	}
	
	if(document.reg_frm.pw.value != document.reg_frm.pw_check.value){
		alert("비밀번호가 일치하지 않습니다.");
		reg_frm.pw.docus();
		return;
	}
	
	
	if(document.reg_frm.eMail.value.length == 0){
		alert("이메일은 필수 사항 입니다. ");
		reg_frm.eMail.docus();
		return;
	}
	
	if(document.reg_frm.address.value.length == 0){
		alert("주소는 필수 사항 입니다. ");
		reg_frm.address.docus();
		return;
	}
	
	document.reg_frm.submit();

}