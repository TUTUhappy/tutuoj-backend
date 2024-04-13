package tu.tutu.tutuojbackend.model.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import tu.tutu.tutuojbackend.model.dto.question.QuestionConfig;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class QuestionVO implements Serializable {
    private static final long serialVersionUID = -8566968974087523924L;

    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 题目标签
     */
    private List<String> tags;

    /**
     * 题目描述
     */
    private String description;




    /**
     * 题目限制
     */
    private QuestionConfig questionConfig;

    /**
     * 提交数
     */
    private Long submitNum;

    /**
     * 通过数
     */
    private Long acceptNum;

    /**
     * 创建人
     */
    private Long userId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    private  UserVO userVO;


}
