package in.code.service;

import java.awt.image.BufferedImage;
import java.util.Optional;

import javax.crypto.SealedObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.code.entity.Student;
import in.code.helper.EncryptionUtility;
import in.code.helper.QRCodeGenerator;
import in.code.repository.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	private EncryptionUtility encryptionUtility;
	@Autowired
	private QRCodeGenerator codeGenerator;
	@Autowired
	private StudentRepo studentRepo;

	@Override
	public BufferedImage generateQRCode(Integer stuId) throws Exception {

		Optional<Student> object = studentRepo.findById(stuId);
		if (object.isPresent()) {
			Student student = object.get();
			SealedObject sealedObject = encryptionUtility.doEncrypt(student);
			String string = sealedObject.toString();
			return codeGenerator.generateQRCode(string);

		}

		return null;

	}

	@Override
	public Student saveData(Student student) {
		Student save = studentRepo.save(student);
		return save;
	}

}
