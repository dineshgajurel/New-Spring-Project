package com.javastud.springmvcweb.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {
	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String uploadGet() {
		return "fileUpload";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String uploadPost(@RequestParam("file") MultipartFile file, Model model) throws IOException {
		if (!file.isEmpty()) {
			String filePath = "E:\\temp\\" + file.getOriginalFilename();
			// save file in drive
			FileOutputStream out = new FileOutputStream("E:\\temp\\" + file.getOriginalFilename());
			out.write(file.getBytes());
			out.close();
			model.addAttribute("successMsg", "File uploaded:" + file.getOriginalFilename());
			model.addAttribute("downloadFilePath", filePath);

		} else {
			model.addAttribute("successMsg", "R u mad??");
		}

		return "fileUpload";
	}
	@RequestMapping(value="/download", method=RequestMethod.GET)
	public void download(@RequestParam("file") String fileName, HttpServletResponse response) throws IOException{
		response.setContentType("image/png");
		response.setHeader("Content-Disposition","attachment;filename='localdownload.png'");
		PrintWriter out=response.getWriter();
		FileInputStream fi=new FileInputStream(fileName);
		int i;
		while((i=fi.read())!=-1){
			
			out.write(i);
		}
		fi.close();
		out.close();
			
		
	}
		
	
	
	
	
	
}
