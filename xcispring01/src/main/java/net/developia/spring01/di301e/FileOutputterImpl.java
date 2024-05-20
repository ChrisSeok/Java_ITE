package net.developia.spring01.di301e;

import java.io.FileWriter;

import org.springframework.beans.factory.annotation.Autowired;


public class FileOutputterImpl implements FileOutputter{
	@Autowired  String fileName;
	private String name;
	private String 

	@Override
	public void output(String msg) throws Exception {
		// TODO Auto-generated method stub
		FileWriter fw =new FileWriter(fileName);
		fw.write(msg);
		fw.flush();
		fw.close();
		
	}
}
