package tu.tutu.tutuojbackend.model.dto.question;


import lombok.Data;

import java.io.Serializable;

@Data
public class QuestionCase implements Serializable {
    private static final long serialVersionUID = -8456378757999768434L;


    private  String  input;
    private  String output;
}
