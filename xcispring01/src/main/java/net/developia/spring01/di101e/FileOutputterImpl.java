package net.developia.spring01.di101e;

import java.io.FileWriter;

public class FileOutputterImpl implements FileOutputter{
	private String fileName;
	
	public FileOutputterImpl(String fileName) {
		super();
		this.fileName = fileName;
	}

	public void setFileName(String fileName) {
		this.fileName =fileName;
	}
	
	@Override
	public void output(String msg) throws Exception {
		// TODO Auto-generated method stub
		FileWriter fw =new FileWriter(fileName);
		fw.write(msg);
		fw.flush();
		fw.close();
		
	}
}
