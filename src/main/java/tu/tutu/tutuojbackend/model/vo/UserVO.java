package tu.tutu.tutuojbackend.model.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserVO implements Serializable {
    private static final long serialVersionUID = 549017308172031876L;

    /**
     * id
     */
    private Long id;

    /**
     * 昵称
     */
    private String userName;

    /**
     * 账号
     */
    private String userAccount;

    /**
     * 头像
     */
    private String avatarUrl;

    /**
     * 性别
     */
    private Integer gender;



    /**
     * 邮箱
     */
    private String email;

    /**
     * 用户身份
     */
    private String userRole;

}
