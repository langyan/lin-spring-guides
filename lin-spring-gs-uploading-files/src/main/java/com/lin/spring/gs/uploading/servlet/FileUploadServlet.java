package com.lin.spring.gs.uploading.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Collection;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;

/**
 * 文件数据已被spring 获取
 * @author michael
 *
 */
//@WebServlet(urlPatterns="/fileServlet", description="Servlet的说明")
public class FileUploadServlet extends HttpServlet {

	private Path rootLocation;

	public void init(ServletConfig config) throws ServletException {
		rootLocation = Paths.get("upload-dir");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">>>>>>>>>>doGet()<<<<<<<<<<<");
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">>>>>>>>>>doPost()<<<<<<<<<<<");
		Collection<Part> parts = request.getParts();
		for (Part part : parts) {
			String headerValue = part.getHeader(HttpHeaders.CONTENT_DISPOSITION);
			ContentDisposition disposition = ContentDisposition.parse(headerValue);// spring
																					// ContentDisposition
			String filename = disposition.getFilename();
			if (filename != null) {
				if (filename.startsWith("=?") && filename.endsWith("?=")) {
					// filename = MimeDelegate.decode(filename);//spring
					// MimeDelegate
				}
			}
			InputStream inputStream = part.getInputStream();
			Files.copy(inputStream, this.rootLocation.resolve(filename), StandardCopyOption.REPLACE_EXISTING);
		}
		resp.sendRedirect("/");

	}

}
