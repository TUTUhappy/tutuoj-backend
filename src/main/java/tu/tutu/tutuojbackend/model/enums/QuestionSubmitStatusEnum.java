package tu.tutu.tutuojbackend.model.enums;

public enum QuestionSubmitStatusEnum {

    WAITING(0,"等待判题"),
    RUNNING(1,"正在判题"),
    ACCEPT(2,"成功"),
    FAILED(3,"失败");



    QuestionSubmitStatusEnum(Integer value, String status) {
        this.value = value;
        this.status = status;
    }

    private  Integer  value;
    private  String  status;

    public Integer getValue() {
        return value;
    }

    public String getStatus() {
        return status;
    }
}
