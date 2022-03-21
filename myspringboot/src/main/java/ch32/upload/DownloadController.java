package ch32.upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DownloadController {
	
	// 다운로드 목록 보여달라는 요청 
	@RequestMapping("/filedownloadlist")
	public ModelAndView downloadlist(){
		
		File file = new File("/Users/jungmin/Desktop/kdt-venture/workspace/spring/upload");
		String[] filearray = file.list();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("filearray", filearray); 	// mv.addObject("list", 파일목록);
		mv.setViewName("ch32_upload/downloadlist");
		return mv;
	}
	
	// 파일명이 이상하다 확인필요.
	// 실제로 다운로드 하겠다 
	@RequestMapping("/filedownloadresult")
	public void downloadresult(String filename, HttpServletResponse response)  throws IOException {

		File f = new File("/Users/jungmin/Desktop/kdt-venture/workspace/spring/upload/", filename); 
		// long len = f.length(); // 원래 file클래스의 length메서드는 리턴타입이 long타입. (8byte 정수). 따라서 int로 사용하려면 형변환 해줘야.
		int len = (int)f.length();
		
		// 파일 다운로드 httpdmdekq tjsdjs 
		response.setContentType("application/download");
		// 다운로드할 파일을 사용자가 선택한 후 
//		response.setContentLength((int)filename.length()); filename.length(): 파일명의 길이 확인 
		response.setContentLength(len);
		response.setHeader("Content-Disposition", "attachment;filename=\"" + filename +"\"");// 원래는 attachment:filename="파일명"
		System.out.println(filename);
		// 파일전송
		OutputStream out = response.getOutputStream(); // 브라우저 응답(출력 객체) 
		FileInputStream fin = new FileInputStream(f); // 파일 입력 객체 생성
		FileCopyUtils.copy(fin, out); // 서버내부에 있던 파일 입력 객체를 브라우저 응답출력 객체로 복사.
		fin.close();
		out.close();
	}
}
