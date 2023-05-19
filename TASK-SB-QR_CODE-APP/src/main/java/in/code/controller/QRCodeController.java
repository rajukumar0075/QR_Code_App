package in.code.controller;

import java.awt.image.BufferedImage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.code.entity.Student;
import in.code.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class QRCodeController {
	@Autowired
	private StudentService service;

	@PostMapping("/")
	public ResponseEntity<Student> saveData(@RequestBody Student student) {

		Student saveData = service.saveData(student);
		return new ResponseEntity<Student>(saveData, HttpStatus.CREATED);

	}

	@GetMapping(value = "/barcode/{stuid}", produces = MediaType.IMAGE_PNG_VALUE)
	public ResponseEntity<BufferedImage> getQRCode(@PathVariable Integer stuid) throws Exception {

		BufferedImage qrCode = service.generateQRCode(stuid);
		return new ResponseEntity<>(qrCode, HttpStatus.OK);
	}

}
