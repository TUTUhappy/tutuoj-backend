package tu.tutu.tutuojbackend.service.impl;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.hutool.crypto.digest.DigestUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import sun.misc.MessageUtils;
import tu.tutu.tutuojbackend.common.ErrorCode;
import tu.tutu.tutuojbackend.exception.CommonException;
import tu.tutu.tutuojbackend.model.domain.User;
import tu.tutu.tutuojbackend.model.request.UserLoginRequest;
import tu.tutu.tutuojbackend.model.request.UserRegisterRequest;
import tu.tutu.tutuojbackend.service.UserService;
import tu.tutu.tutuojbackend.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author tfh
 * @description 针对表【user(用户表)】的数据库操作Service实现
 * @createDate 2024-04-10 14:50:40
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

    final String Salt = "tutuOj";
    final  String USER_LOGIN_STATE="LOGIN";

    /**
     *  用户注册
     *
     * @param registerRequest
     * @return
     */
    @Override
    public Boolean userRegister(UserRegisterRequest registerRequest) {
        if (registerRequest == null) {
            throw new CommonException(ErrorCode.PARAMS_NULL);
        }
        String userAccount = registerRequest.getUserAccount();
        if (StringUtils.isBlank(userAccount) || userAccount.length() > 12) {
            throw new CommonException(ErrorCode.PARAMS_ILLEGAL, "账号不能为空，且长度不能大于12位");
        }
        String validPattern = "[ _`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";
        Matcher matcher = Pattern.compile(validPattern).matcher(userAccount);
        if (matcher.find()) {
            throw new CommonException(ErrorCode.PARAMS_ILLEGAL, "账户不能包含特殊字符");
        }
        String userPassword = registerRequest.getUserPassword();
        if (StringUtils.isBlank(userPassword) || userPassword.length() < 8) {
            throw new CommonException(ErrorCode.PARAMS_ILLEGAL, "密码不能为空，且长度应该大于8位");
        }
        String checkPassword = registerRequest.getCheckPassword();
        if (StringUtils.isBlank(checkPassword) || !userPassword.equals(checkPassword)) {
            throw new CommonException(ErrorCode.PARAMS_ILLEGAL, "检验密码与输入密码不一致");
        }
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("user_account", userAccount);
        long count = this.count(userQueryWrapper);
        if (count > 0) {
            throw new CommonException(ErrorCode.PARAMS_ILLEGAL, "账户已经存在");
        }
        String newUserPassword = DigestUtil.bcrypt(userPassword + Salt);
        User user = new User();
        user.setUserAccount(userAccount);
        user.setUserPassword(newUserPassword);
        return this.save(user);

    }

    /**
     *
     *   用户登陆
     * @param loginRequest
     * @param httpServletRequest
     * @return
     */

    @Override
    public User userLogin(UserLoginRequest loginRequest, HttpServletRequest httpServletRequest) {
        if (loginRequest == null) {
            throw new CommonException(ErrorCode.PARAMS_NULL);
        }
        String userAccount = loginRequest.getUserAccount();
        if (StringUtils.isBlank(userAccount) || userAccount.length() > 12) {
            throw new CommonException(ErrorCode.PARAMS_ILLEGAL, "账号不能为空，且长度不能大于12位");
        }
        String validPattern = "[ _`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";
        Matcher matcher = Pattern.compile(validPattern).matcher(userAccount);
        if (matcher.find()) {
            throw new CommonException(ErrorCode.PARAMS_ILLEGAL, "账户不能包含特殊字符");
        }
        String userPassword = loginRequest.getUserPassword();
        if (StringUtils.isBlank(userPassword) || userPassword.length() < 8) {
            throw new CommonException(ErrorCode.PARAMS_ILLEGAL, "密码不能为空，且长度应该大于8位");
        }

        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("user_account",userAccount);
        User user = this.getOne(userQueryWrapper);
        if (user==null){
            throw new CommonException(ErrorCode.PARAMS_ILLEGAL,"账户不存在");

        }
        if (!DigestUtil.bcryptCheck(userPassword+Salt,user.getUserPassword())){
            throw new CommonException(ErrorCode.PARAMS_ILLEGAL,"密码不正确");
        }
        User safeUser = getSafeUser(user);
        httpServletRequest.getSession().setAttribute(USER_LOGIN_STATE,safeUser);
        return  safeUser;

    }

    /**
     *  用户信息脱敏
     *
     * @param user
     * @return
     */

    @Override
    public User getSafeUser(User user) {
        User safeUser = new User();
        safeUser.setId(user.getId());
        safeUser.setUserName(user.getUserName());
        safeUser.setUserAccount(user.getUserAccount());
        safeUser.setAvatarUrl(user.getAvatarUrl());
        safeUser.setGender(user.getGender());
        safeUser.setEmail(user.getEmail());
        safeUser.setUserRole(user.getUserRole());

        return  safeUser;


    }

    /**
     *
     * 获取当前登陆用户
     * @param request
     * @return
     */

    @Override
    public User getCurrentLoginUser(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute(USER_LOGIN_STATE);
        if (user==null){
            throw  new CommonException(ErrorCode.NO_LOGIN);
        }
        return  user;

    }

    /**
     *  用户注销
     *
     * @param request
     * @return
     */
    @Override
    public Boolean userLoginOut(HttpServletRequest request) {
        if (request==null){
            return  null;
        }
        request.getSession().removeAttribute(USER_LOGIN_STATE);
         return  true;
    }
}




