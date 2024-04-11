package tu.tutu.tutuojbackend.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tu.tutu.tutuojbackend.common.BaseResponse;
import tu.tutu.tutuojbackend.common.ErrorCode;
import tu.tutu.tutuojbackend.exception.CommonException;
import tu.tutu.tutuojbackend.model.domain.User;
import tu.tutu.tutuojbackend.model.request.UserLoginRequest;
import tu.tutu.tutuojbackend.model.request.UserRegisterRequest;
import tu.tutu.tutuojbackend.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:8080/",allowCredentials ="true")
public class UserController {

    @Resource
    private UserService userService;


     @PostMapping("/register")
    public BaseResponse<Boolean> userRegister(UserRegisterRequest request){
        if (request==null){
            throw  new CommonException(ErrorCode.PARAMS_NULL);
        }
         Boolean res = userService.userRegister(request);

        return  new BaseResponse<>(res,ErrorCode.SUCCESS);
     }
    @PostMapping("/login")
    public BaseResponse<User> userLogin(UserLoginRequest loginRequest, HttpServletRequest request){
        if (request==null){
            throw  new CommonException(ErrorCode.PARAMS_NULL);
        }
        User res = userService.userLogin(loginRequest,request);

        return  new BaseResponse<>(res,ErrorCode.SUCCESS);
    }
    @PostMapping("/getCurrentLoginUser")
    public BaseResponse<User> getCurrentLoginUser(HttpServletRequest request){

        User res = userService.getCurrentLoginUser(request);

        return  new BaseResponse<>(res,ErrorCode.SUCCESS);
    }
    @PostMapping("/loginOut")
    public BaseResponse<Boolean> userLoginOut(HttpServletRequest request){

        Boolean res = userService.userLoginOut(request);

        return  new BaseResponse<>(res,ErrorCode.SUCCESS);
    }
}
