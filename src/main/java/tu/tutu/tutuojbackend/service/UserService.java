package tu.tutu.tutuojbackend.service;

import tu.tutu.tutuojbackend.model.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
import tu.tutu.tutuojbackend.model.request.user.UserLoginRequest;
import tu.tutu.tutuojbackend.model.request.user.UserRegisterRequest;

import javax.servlet.http.HttpServletRequest;

/**
* @author tfh
* @description 针对表【user(用户表)】的数据库操作Service
* @createDate 2024-04-10 14:50:40
*/
public interface UserService extends IService<User> {

     Boolean  userRegister(UserRegisterRequest registerRequest);

     User userLogin(UserLoginRequest loginRequest, HttpServletRequest httpServletRequest);

     User   getSafeUser(User user);

     User  getCurrentLoginUser(HttpServletRequest request);

     Boolean userLoginOut(HttpServletRequest request);


}
