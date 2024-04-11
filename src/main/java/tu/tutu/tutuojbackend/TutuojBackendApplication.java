package tu.tutu.tutuojbackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@MapperScan("tu.tutu.tutuojbackend.mapper")

public class TutuojBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(TutuojBackendApplication.class, args);
    }

}
