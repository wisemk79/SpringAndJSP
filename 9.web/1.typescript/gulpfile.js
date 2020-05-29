/*
  1.typescript\gulpfile.js로 저장
  gulp서버->src에 저장된 소스파일을 읽어들여서 dist폴더에 컴파일시킨 파일을 복사
*/

//1.gulp서버와 연관이 있는 모듈을 전부 불러오기->import(es6이상은 )->require이용
var gulp=require('gulp');// var 불러올객체명=require('경로포함해서 불러올 패키지명')
var ts=require('gulp-typescript');//gulp에서 typescript를 사용할때 필요로하는 패키지명
//추가 ->target:es5->es5로 변환해서 작업하라는 옵션,  
//      noImplicitAny->명확하게 자료형을 사용하라(경고메세지출력유무)
var tsProject=ts.createProject({'target':'es5','noImplicitAny':true});
var sorucemaps=require('gulp-sourcemaps');//소스코드의 위치를 지정할때 필요
var webserver=require('gulp-webserver');//웹서버를 작동시키기위해서 필요
var livereload=require('gulp-livereload');//변경된 소스코드를 다시 메모리에 로드할때 필요

/* 2.작업(task)을 설정해준다.->서버에서 실행시키는 작업단위(태스크)
     세부적인 내용을 실행(pipe)-실행2-실행3
*/
//3.서버를 가동시킨다.->포트번호 9400 ->형식) gulp객체명.task('태스크이름',익명함수->처리)
gulp.task('server',function(){
    return gulp.src('./') //src함수->작업영역을 설정할때 사용(1.경로,2.옵션)
           .pipe(webserver({port:9400}));//기존설정구문.pipe(추가 옵션 설정)
})//gulp서버를 가동시키는데 포트번호는 9400을 열어라(현재 폴더 위치는 ./)

//4.컴파일할 파일,실행할 파일의 위치를 지정
gulp.task('scripts',function(){
    // src/**/*.ts ->src/let/let.ts, src/const/const.ts
    var tsResult=gulp.src("src/*.ts")
    .pipe(sourcemaps.init()) //소스코드의 위치를 기록하기위해서 소스맵을 생성
    .pipe(tsProject());//생성->es5,경고성에러메세지를 출력시키겠다
    return tsResult.js.pipe(sourcempas.write())//js파일에 기록(컴파일에 관련된 내용)
    .pipe(gulp.dest('dist'));//gulp객체명.dest(경로포함해서 목적지 폴더 지정)
})

//5.변경된 소스코드를 다시 읽어들여서 다시 반영(reload)->새로 고침
gulp.task('watch',function(){
    livereload.listen();//읽어들일 준비하라
    //1.경로명 및 파일 확장자 지정 2.옵션(다시 실행시킬 태스크명)->자동으로 반복한다.
    gulp.watch('src/*.ts',['scripts'])
})

//6.gulp서버를 가동시킬때 기본적으로 작동되는 순서를 지정->여러개인 경우(배열로 표시)