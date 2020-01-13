package com.dhanjyothi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/file")
public class FileController {
	
	@GetMapping("/showuploadpage")
	private ModelAndView showUploadPage() {
		return null;
	}
	
	@PostMapping("/doUpload")
	private ModelAndView saveFileUpload(HttpServletRequest request, @RequestParam CommonsMultipartFile[] fileUpload) {
		return null;
	}
	
	@GetMapping("/viewall")
	private ModelAndView viewAllFiles() {
		return null;
	}
	
	@GetMapping("/doDownload/{fileName}")
	private ModelAndView downloadFile(@PathVariable("fileName") String fileName, HttpServletResponse response) {
		return null;
	}
}
