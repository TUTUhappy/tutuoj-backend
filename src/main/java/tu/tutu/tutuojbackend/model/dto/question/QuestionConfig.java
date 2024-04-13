package tu.tutu.tutuojbackend.model.dto.question;


import lombok.Data;

import java.io.Serializable;

@Data
public class QuestionConfig implements Serializable {
    private static final long serialVersionUID = -2261529508211375652L;

    /**
     * 时间限制（ms）
     */
    private Long timeLimit;

    /**
     * 内存限制（KB）
     */
    private Long memoryLimit;

}
