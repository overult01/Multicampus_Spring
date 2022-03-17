package ch28.upload;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

//패키지 추가했을 때는 servlet-context.xml에 context:component 설정 해주어야. 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	
	@RequestMapping(value="/fileupload", method = RequestMethod.GET)
	public String uploadform() {
		return "ch28_upload/uploadform";
	}
	
	@RequestMapping(value="/fileupload", method = RequestMethod.POST)
	public String uploadresult(@ModelAttribute("dto") UploadDTO dto) throws IOException { // @ModelAttribute("뷰가 받을 이름"): 뷰로 전달해주고 싶을 때.
		
		// ${dto.file1.getOriginalFilename} : 뷰에서 파일명 확인할 때.
		
		MultipartFile mf1 = dto.getFile1();
		MultipartFile mf2 = dto.getFile2();
		
		System.out.println(dto.getName());
		System.out.println(dto.getDescription());
		System.out.println(mf1.getOriginalFilename()); //dto.getFile1():Multipartfile 이 toString 메서드 오버라이딩하지 않았으면 패키지명.클래스명@16진수 주소 로 출력.
		System.out.println(mf2.getOriginalFilename());
		System.out.println(mf1.getSize());
		System.out.println(mf2.getSize()); // getSize: 파일 크기. byte단위.
		System.out.println(mf1.isEmpty()); // isEmpty: 파일 전송 여부를 boolean으로. 
		System.out.println(mf2.isEmpty());
		
		String savePath = "/Users/jungmin/Desktop/kdt-venture/workspace/spring/upload/"; // 파일을 저장할 path를 수동으로 만들었다.
		
		// if문: 사용자가 파일을 2개보내지 않았을 때 500번 에러나는 것 방지.
		if(!mf1.isEmpty()) {
			
			// 여러 클라이언트에서 동일 파일명을 여러번 보냈을 때 덮어씌워지는 것 방지 
			// 원래 파일 이름
			String originname1 = mf1.getOriginalFilename();
			
			// 원래 파일 명에서 확장자(.)이전까지만 추출
			String beforeext1 = originname1.substring(0, originname1.indexOf("."));
			
			// 원래 파일 명에서 확장자(.)이후부터
			String ext1 = originname1.substring(originname1.indexOf("."));

			// 파일내용 + 파일명 --> 서버의 특정폴더(c:upload)에 영구저장. 서버가 종료되더라도 폴더에 저장.
			File serverfile1 = new File(savePath + beforeext1 + "(" + UUID.randomUUID().toString() + ")" + ext1); // 확장자는 그대론데, 파일명만 '원래파일명(랜덤한 UUID)'로 바뀜. 
			mf1.transferTo(serverfile1);
			
			// 그냥 상태로는 둘 중 1개만 업로드할 때(500에러), 동일한 파일이름을 여러 클라이언트에서 업로드할 때 (덮어씌움) 문제생김.
			// System.out.println(UUID.randomUUID().toString()); // randomUUID: 문자열을 랜덤하게 생성. 같은 이름을 덮어쓰지 않게 하기 위해 
		}
		if(!mf2.isEmpty()) {
			String originname2 = mf2.getOriginalFilename();
			
			String beforeext2 = originname2.substring(0, originname2.indexOf("."));
			
			String ext2 = originname2.substring(originname2.indexOf("."));
			
			File serverfile2 = new File(savePath + beforeext2 + "(" + UUID.randomUUID().toString() + ")" + ext2);
			mf2.transferTo(serverfile2);			
		}
		
		return "ch28_upload/uploadresult";
	}
}
