package net.developia.spring01.di302e;

import java.io.FileWriter;


public class FileOutputterImpl implements FileOutputter{

	 public FileOutputterImpl(String fileName) {
		super();
		this.fileName = fileName;
	}

	private String fileName;

	@Override
	public void output(String msg) throws Exception {
		// TODO Auto-generated method stub
		FileWriter fw =new FileWriter(fileName);
		fw.write(msg);
		fw.flush();
		fw.close();
		
	}
}
