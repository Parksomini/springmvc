package me.whiteship.demospringmvc.user;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void hello() throws Exception{
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("hello"));
    }

    @Test
    public void createUser_XML() throws Exception{ //응답을 보내는 구간
        String userJson = "{\"username\":\"somin\",\"password\":\"123\"}"; //요청 보내기 요청은 제이슨으로 보내고 응답은 XML로 받기 오류가나면 converter가 없는것
        mockMvc.perform(post("/users/create")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_XML)//어떠한 타입의 응답을 원한다고 서버한테 알려주는것
                .content(userJson))
                .andExpect(status().isOk())
                .andExpect(xpath("/User/username").string("somin"))
                .andExpect(xpath("/User/password").string("123"));


    }
}
