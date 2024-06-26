package net.developia.spring01.di101e;

public class OutputterImpl implements Outputter{
	private String name;
	private String greeting;
	private FileOutputter fileOutputter;
	
	
public OutputterImpl(String name, String greeting, FileOutputter fileOutputter) {
		super();
		this.name = name;
		this.greeting = greeting;
		this.fileOutputter = fileOutputter;
	}


//
//	public void setFileOutputter(FileOutputter fileOutputter) {
//		this.fileOutputter = fileOutputter;
//	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getGreeting() {
		return greeting;
	}


	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}


	@Override
	public void greeting() {
		System.out.println(name+"님 "+greeting);
		try {
			fileOutputter.output(name+"님 "+greeting);
		}catch (Exception e) {
			e.printStackTrace();
		}
	
	}




}
