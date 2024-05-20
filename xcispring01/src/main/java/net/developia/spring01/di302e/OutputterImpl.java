package net.developia.spring01.di302e;

public class OutputterImpl implements Outputter{

	//Spring의 Value임. Lombok 아님!
	private String name;
	private String greeting;
	private FileOutputter fileOutputter;

	public OutputterImpl(String name, String greeting, FileOutputter fileOutputter) {
		super();
		this.name = name;
		this.greeting = greeting;
		this.fileOutputter = fileOutputter;
	}

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
