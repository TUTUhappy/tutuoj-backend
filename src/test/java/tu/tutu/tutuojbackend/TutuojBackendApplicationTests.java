package tu.tutu.tutuojbackend;

import cn.hutool.crypto.digest.DigestUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TutuojBackendApplicationTests {

    @Test
    void contextLoads() {
        String tut= "12345678";
       String SALT="tutuOj";
        System.out.println(DigestUtil.bcrypt(tut + SALT));
    }

}
