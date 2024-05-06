package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// 경로만 변경시키는 컨트롤러
@Controller
public class RouteController {

    // 책 리스트 보기
    @GetMapping("/restList")
    public String restList() {
        // 책 리스트를 가져와야 한다.
        // 날씨 정보를 Open API
        return "restList";
    }

    // 책 등록하러 가기
    @GetMapping("/restRegister")
    public String restRegister(){
        return "restRegister";
    }
}
