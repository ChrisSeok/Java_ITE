package net.developia.spring01.di201;

import org.springframework.stereotype.Component;

@Component(value ="Orange") //빈 이름 지정
public class OrangeSpeaker implements Speaker{
	   
	   @Override
	   public void soundUp(){
	      System.out.println("OrangeSpeaker 소리를 키웁니다.");
	   }
	   
	   @Override
	   public void soundDown(){
	      System.out.println("OrangeSpeaker 소리를 내립니다.");
	   }
}

