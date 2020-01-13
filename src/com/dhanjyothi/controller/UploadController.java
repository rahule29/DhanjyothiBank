package com.dhanjyothi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dhanjyothi.model.UploadFile;

@Controller
@RequestMapping("/upload")
public class UploadController {

	@GetMapping("/show")
	private ModelAndView showUpload() {
		return null;
	}
	
	@PostMapping("/upload")
	private ModelAndView fileUploadPage(UploadFile uploadFile) {
		return null;
	}
	
	@GetMapping("/download")
	private ModelAndView fileDownloadPage(HttpServletRequest request, HttpServletResponse response) {
		return null;
	}
}
