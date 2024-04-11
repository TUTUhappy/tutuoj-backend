package tu.tutu.tutuojbackend.exception;


import tu.tutu.tutuojbackend.common.ErrorCode;


public class CommonException extends RuntimeException{
       private  Integer code;

       private  String description;

    public CommonException(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public CommonException(String message, Integer code, String description) {
        super(message);
        this.code = code;
        this.description = description;
    }

   public  CommonException(ErrorCode code){
        super(code.getMessage());
        this.code=code.getCode();
        this.description=code.getDescription();

   }
    public  CommonException(ErrorCode code,String description){
        super(code.getMessage());
        this.code=code.getCode();
        this.description=description;

    }


    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
