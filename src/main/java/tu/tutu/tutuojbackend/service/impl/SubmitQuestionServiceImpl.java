package tu.tutu.tutuojbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import tu.tutu.tutuojbackend.model.domain.SubmitQuestion;
import tu.tutu.tutuojbackend.service.SubmitQuestionService;
import tu.tutu.tutuojbackend.mapper.SubmitQuestionMapper;
import org.springframework.stereotype.Service;

/**
* @author tfh
* @description 针对表【submit_question(题目提交表)】的数据库操作Service实现
* @createDate 2024-04-13 15:40:46
*/
@Service
public class SubmitQuestionServiceImpl extends ServiceImpl<SubmitQuestionMapper, SubmitQuestion>
    implements SubmitQuestionService{

}




