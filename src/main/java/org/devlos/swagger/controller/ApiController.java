package org.devlos.swagger.controller;

import io.swagger.annotations.*;
import org.devlos.swagger.dto.UserReq;
import org.devlos.swagger.dto.UserRes;
import org.springframework.web.bind.annotation.*;

@Api(tags= {"API 정보를 제공하는 Controller"})
@RestController
@RequestMapping("/api")
public class ApiController {
    @GetMapping("/hello")
    // http://localhost:8080/swagger-ui/
    public String hello() {
        return "hello";
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "x", value = "x 값", required = true, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "y", value = "x 값", required = true, dataType = "int", paramType = "query")
    })
    @GetMapping("/plus/{x}")
    public int plus(
//            @ApiParam(value = "x값")
            @PathVariable int x,

//            @ApiParam(value = "y값")
            @RequestParam int y) {
        return x+y;
    }

    @ApiResponse(code =502 ,message = "사용자의 나이가 10살 이하일 때")
    @ApiOperation(value = "사용자의 이름과 나이를 리턴 하는 메소드")
    @GetMapping("/user")
    public UserRes user(UserReq userReq) {
        return new UserRes(userReq.getName(), userReq.getAge());
    }

    @PostMapping("/user")
    public UserRes userPost(@RequestBody UserReq req) {
        return new UserRes(req.getName(), req.getAge());
    }
}
