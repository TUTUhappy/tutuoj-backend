package tu.tutu.tutuojbackend.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;
import tu.tutu.tutuojbackend.model.dto.question.QuestionCase;
import tu.tutu.tutuojbackend.model.dto.question.QuestionConfig;

/**
 * 题目表
 * @TableName question
 */
@TableName(value ="question")
@Data
public class Question implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 题目标签
     */
    private String tags;

    /**
     * 题目描述
     */
    private String description;

    /**
     * 答案
     */
    private String answer;

    /**
     * 题目输入用例和输出用例
     */
    private String questionCase;

    /**
     * 题目限制
     */
    private String questionConfig;

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

    /**
     * 是否删除(0- 未删除，1-已删除)
     */
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Question other = (Question) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getTags() == null ? other.getTags() == null : this.getTags().equals(other.getTags()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getAnswer() == null ? other.getAnswer() == null : this.getAnswer().equals(other.getAnswer()))
            && (this.getQuestionCase() == null ? other.getQuestionCase() == null : this.getQuestionCase().equals(other.getQuestionCase()))
            && (this.getQuestionConfig() == null ? other.getQuestionConfig() == null : this.getQuestionConfig().equals(other.getQuestionConfig()))
            && (this.getSubmitNum() == null ? other.getSubmitNum() == null : this.getSubmitNum().equals(other.getSubmitNum()))
            && (this.getAcceptNum() == null ? other.getAcceptNum() == null : this.getAcceptNum().equals(other.getAcceptNum()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getTags() == null) ? 0 : getTags().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getAnswer() == null) ? 0 : getAnswer().hashCode());
        result = prime * result + ((getQuestionCase() == null) ? 0 : getQuestionCase().hashCode());
        result = prime * result + ((getQuestionConfig() == null) ? 0 : getQuestionConfig().hashCode());
        result = prime * result + ((getSubmitNum() == null) ? 0 : getSubmitNum().hashCode());
        result = prime * result + ((getAcceptNum() == null) ? 0 : getAcceptNum().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", tags=").append(tags);
        sb.append(", description=").append(description);
        sb.append(", answer=").append(answer);
        sb.append(", QuestionCase=").append(questionCase);
        sb.append(", QuestionConfig=").append(questionConfig);
        sb.append(", submitNum=").append(submitNum);
        sb.append(", acceptNum=").append(acceptNum);
        sb.append(", userId=").append(userId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}