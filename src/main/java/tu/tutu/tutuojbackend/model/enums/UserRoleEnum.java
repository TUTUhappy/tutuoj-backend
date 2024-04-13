package tu.tutu.tutuojbackend.model.enums;


import lombok.Data;

public enum UserRoleEnum {

    USER("user","用户"),
    ADMIN("admin","管理员");
    private final String value;
    private final String  role;
    UserRoleEnum(String value, String role) {
        this.value = value;
        this.role = role;
    }


    public String getValue() {
        return value;
    }

    public String getRole() {
        return role;
    }


}
