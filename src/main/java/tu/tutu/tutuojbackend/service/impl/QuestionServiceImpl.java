package tu.tutu.tutuojbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import tu.tutu.tutuojbackend.model.domain.Question;
import tu.tutu.tutuojbackend.service.QuestionService;
import tu.tutu.tutuojbackend.mapper.QuestionMapper;
import org.springframework.stereotype.Service;
import tu.tutu.tutuojbackend.model.domain.User;

/**
* @author tfh
* @description 针对表【question(题目表)】的数据库操作Service实现
* @createDate 2024-04-13 15:31:24
*/
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question>
    implements QuestionService{

}




