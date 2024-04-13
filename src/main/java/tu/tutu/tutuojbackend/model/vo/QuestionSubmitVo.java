package tu.tutu.tutuojbackend.model.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import tu.tutu.tutuojbackend.model.dto.questionSubmit.AnswerResult;

import java.io.Serializable;
import java.util.Date;


@Data
public class QuestionSubmitVo implements Serializable {
    private static final long serialVersionUID = -4823451421362359312L;


    private Long id;

    /**
     * 题目Id
     */
    private Long questionId;

    /**
     * 提交人id
     */
    private Long userId;

    /**
     * 语言
     */
    private String language;

    /**
     * 答案
     */
    private String answer;

    /**
     * 0-待判题，1-正在判题，2-成功，3-失败
     */
    private Integer status;

    /**
     * 答案消耗时间空间以及返回结果
     */
    private AnswerResult answerResult;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

   private   QuestionVO questionVO;
   private   UserVO userVO;


}
