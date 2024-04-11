package tu.tutu.tutuojbackend.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse<T> implements Serializable {


    private  T data;
    private  String message;

    private  String description;

    private  Integer code;

    public BaseResponse(T data, ErrorCode code) {
        this.data = data;
        this.code = code.getCode();
    }

    public BaseResponse(T data, String message, ErrorCode code) {
        this.data = data;
        this.message = message;
        this.code = code.getCode();
    }

    public BaseResponse(T data, String message, String description) {
        this.data = data;
        this.message = message;
        this.description = description;
    }

    public BaseResponse(T data, String message) {
        this.data = data;
        this.message = message;
    }


}
