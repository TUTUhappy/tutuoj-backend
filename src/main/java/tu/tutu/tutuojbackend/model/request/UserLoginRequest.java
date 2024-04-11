package tu.tutu.tutuojbackend.model.request;


import lombok.Data;

import java.io.Serializable;


@Data
public class UserLoginRequest implements Serializable {

    private static final long serialVersionUID = 454506974291476711L;
    private  String userAccount;

    private  String userPassword;




}
