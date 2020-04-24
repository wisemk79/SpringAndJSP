package com.spring.anno5;

import org.springframework.stereotype.Component;//@Component와 연관
/*
 * 빈즈에 관련된 클래스가 30개->기능에 따라서 어느 특정 패키지에 저장
 * <bean id="camera" class="com.spring.anno5.Camera" />
 * ,,,
 * 클래스 갯수만큼 빈즈객체를 생성할 수 있도록 등록
 * 스프링컨테이너가 어느 특정 패키지를 지정->자동적으로 그 패키지에 들어가 있는 모든 클래스를 
 *                                                    자동적으로 빈즈객체로 등록을 시켜주는 역할을 하는
 *                                                    어노테이션(@Component)
 * 
 */
@Component
public class Camera {}





