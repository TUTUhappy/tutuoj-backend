package tu.tutu.tutuojbackend.common;


public enum ErrorCode {
    SUCCESS(0,"OK","请求成功"),
    NO_LOGIN(40000,"未登录",null),
    PARAMS_NULL(40001,"请求参数为空",null),
    PARAMS_ILLEGAL(40002,"参数不符合要求",null),
    NO_AUTH(40003,"无权限",null),
    RUN_ERROR(40004,"运行时异常",null);

    private  Integer  code;
   private  String message;
   private  String description;

    ErrorCode(Integer code) {
        this.code = code;
    }

    ErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    ErrorCode(Integer code, String message, String description) {
        this.code = code;
        this.message = message;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }
}
