package net.developia.spring01.di201;

import org.springframework.stereotype.Component;

@Component
public class HarmanSpeaker implements Speaker{
	   
	   @Override
	   public void soundUp(){
	      System.out.println("HarmanSpeaker 소리를 키웁니다.");
	   }
	   
	   @Override
	   public void soundDown(){
	      System.out.println("HarmanSpeaker 소리를 내립니다.");
	   }
}

