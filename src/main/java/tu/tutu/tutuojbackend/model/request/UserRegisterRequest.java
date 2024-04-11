package tu.tutu.tutuojbackend.model.request;

import lombok.Data;

import java.io.Serializable;


@Data
public class UserRegisterRequest implements Serializable {


    private static final long serialVersionUID = -3183002075658259857L;
    private  String  userAccount;
    private  String userPassword;
    private  String checkPassword;
}
