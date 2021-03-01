package springboot.web;

import com.edu.book.springboot.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
/*
* 테스트 진행시, JUnit에 내장된 실행자 외 다른 실행자(SpringRunner) 실행
* 스프링부트 테스트와 JUnit 사이 연결자 역할
* */
@RunWith(SpringRunner.class)
/*
* Spring MVC 에 집중할 수 있는 어노테이션
* @Controller, @ControllerAdvice 사용 가능
* 단, @Service, @Component, @Repository 사용 불가
* Controller만 사용하기 때문에 선언
* */
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    /*
    * Spring이 관리하는 bean 주입 받음
    * */
    @Autowired
    private MockMvc mvc;//웹 API 테스트시 사용

    @Test
    public String hello() throws Exception {
        String hello = "hello";
        mvc.perform(MockMvcRequestBuilders.get("/hello"))//여러 검증기능을 이어서 선언 가능
                .andExpect(MockMvcResultMatchers.status().isOk())//perform 결과 검증 -> HTTP Header status(200,404.500 등) 상태 검증
                .andExpect(MockMvcResultMatchers.content().string(hello));//본문 내용 검증 -> return 값 검증
        return hello;
    }
}
