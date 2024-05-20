package net.developia.spring01.di301e;

import org.springframework.beans.factory.annotation.Autowired;


public class OutputterImpl implements Outputter{
	//Spring의 Value임. Lombok 아님!08
	@Autowired
	private String name;
	private String greeting;
	private FileOutputter fileOutputter;

	@Override
	public void greeting() {
		System.out.println(name+"님 "+greeting);
		try {
			if(fileOutputter!=null) fileOutputter.output(name+"님 "+greeting);
		}catch (Exception e) {
			e.printStackTrace();
		}
	
	}




}
