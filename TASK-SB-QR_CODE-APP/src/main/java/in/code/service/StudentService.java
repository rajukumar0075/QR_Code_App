package in.code.service;

import java.awt.image.BufferedImage;

import in.code.entity.Student;

public interface StudentService {
	
	public BufferedImage generateQRCode(Integer stuId)throws Exception;
	
	public Student saveData(Student student);

}
