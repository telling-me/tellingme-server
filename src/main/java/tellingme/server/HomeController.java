package tellingme.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = {"테스트 API"})
public class HomeController {

    @GetMapping("/")
    @ApiOperation(value = "배포 확인용 API")
    public String serverTest(){
        return "Hello Telling-Me";
    }
}
