package ch32.ajax;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AjaxController1 {


@RequestMapping("/helloajax1")
public MemberDTO test() {
   return new MemberDTO("ID","PASSWORD");//json자동변환(스프링부트내장)
}
}
