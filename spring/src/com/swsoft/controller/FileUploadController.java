package com.swsoft.controller;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(urlPatterns = { "/fileupload" })
@MultipartConfig
public class FileUploadController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//上传txt, html是正确的
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
//		uploadTXTOrHTML(request, response);
		
//https://recalll.co/app/?q=Java%20Servlet/Jsp%20image%20upload%20along%20with%20form%20values		
		uploadFile(request, response);
		//uploadTXTOrHTML(request, response);
	}

	
	//=================begin file updated(solution 1 for all file)==============================================
	private String getFileName(final Part part) {
	   String a = part.getHeader("content-disposition");
		System.out.println(a);
	    for (String content : part.getHeader("content-disposition").split(";")) {
	        if (content.trim().startsWith("filename")) {
	            return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
	        }
	    }
	    return null;
	}

	//all file can be uploaded
	private void uploadFile(HttpServletRequest request, HttpServletResponse response){
		try {
			Part filePart = request.getPart("myFile");
			
			String fileName = getFileName(filePart);
			InputStream  fileContent = filePart.getInputStream();
			
			OutputStream out = new FileOutputStream("d:/"+fileName);
			
		    int read = 0;
	        final byte[] bytes = new byte[1024];

	        while ((read = fileContent.read(bytes)) != -1) {
	            out.write(bytes, 0, read);
	        }
	        
	        out.flush();
	        out.close();
	        
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/file/fileuploadpage.jsp");

			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//===============end file updated(solution 1 for all file)============================================
	
	
	//=================begin file updated(solution 2 for txt, html file， custom codes)==============================================
	private void uploadTXTOrHTML(HttpServletRequest request, HttpServletResponse response){
		try {
            ServletInputStream sis = request.getInputStream();
			
			int length = request.getContentLength();
			System.out.println("length: " + length);
			String contentType = request.getContentType();
			System.out.println("contentType: " + contentType);
			
			byte[] datas = new byte[length];
			sis.read(datas, 0, length);
			
			String body = new String(datas,"utf-8");
			
			//取以"filename=\" 和结尾之间的字符串
			String filename = body.substring(body.indexOf("filename=\"") + 10);
			//取从头开始，以第一个\n为结尾的中间的字符串,包括了一个引号在最后面
			filename = filename.substring(0, filename.indexOf("\n"));
           //去除最后面的引号
		   filename = filename.substring(0, filename.indexOf("\""));
		   System.out.println("filename: " + filename);
			
		   //边界(文件内容的边界)
		   String boundary = contentType.substring(contentType.lastIndexOf("=")+1, contentType.length());
		   System.out.println("boundary: ====" + boundary);
			 //filename = filename.substring(filename.lastIndexOf("\\") + 1, filename.indexOf("\""));
			//这个是取不到的,当jsp使用enctype="multipart/form-data"
			//request.getParameter("myFile");
			
			System.out.println("\n\n\n\n\n");
			System.out.println("body:======\n" +body);
		    int pos;
		   
		    //从头开始查找是否存在指定的字符串 
	        pos = body.indexOf("filename=\"");
	        //从pos开始查找是否存在"\n"字符串 
	        pos = body.indexOf("\n", pos) + 1;
	        //从pos开始查找是否存在"\n"字符串 
	        pos = body.indexOf("\n", pos) + 1;
	       //从pos开始查找是否存在"\n"字符串 
	        pos = body.indexOf("\n", pos) + 1;
	    
	        //从pos位置开始往后继续查找 boundary
	        //boundary,少了四个-(相对body最后内容），所有需要减去4
	        int boundaryLoc = body.indexOf(boundary, pos) - 4;
	        int startPos = ((body.substring(0, pos))
	                             .getBytes("utf-8")).length;
	        int endPos = ((body.substring(0, boundaryLoc))
	                             .getBytes("utf-8")).length;
	        
		    FileOutputStream fileOutputStream = new FileOutputStream("d:/" + filename);
	        fileOutputStream.write(datas, startPos, (endPos - startPos));
	        fileOutputStream.flush();
	        fileOutputStream.close();
	        
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/file/fileuploadpage.jsp");

			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	//=================end file updated(solution 2 for txt, html file)==============================================
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		doGet(request, response);
	}
}
