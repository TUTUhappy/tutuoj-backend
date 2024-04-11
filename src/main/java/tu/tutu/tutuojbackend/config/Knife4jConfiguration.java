package tu.tutu.tutuojbackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@Configuration
@EnableSwagger2WebMvc
public class Knife4jConfiguration {

    @Bean(value = "defaultApi2")
    public Docket defaultApi2(){
        Docket docket=new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("测试api文档")
                        .description("描述")
                        .termsOfServiceUrl("http://www.baidu.com")
//                        .contact("abc@qq.com")
                        .version("1.0")
                        .build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("tu.tutu.tutuojbackend.controller"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }
}
