package tu.tutu.tutuojbackend.model.dto.questionSubmit;


import java.io.Serializable;

public class AnswerResult implements Serializable {
    private static final long serialVersionUID = -3130707793449608749L;

    private  String message;

    private Long timeCost;

    /**
     * 内存限制（KB）
     */
    private Long memoryCost;

}
