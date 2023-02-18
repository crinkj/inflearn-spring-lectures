package inflearn.springmvc2.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/*
뻘짓에 작성해야할것 무조건 테스트는 접근제한자가 public class에 해야한다. 아니면 null로뜸
 */
@SpringBootTest
@AutoConfigureMockMvc
public class ValidationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("아이템 등록 검증 테스트")
    public void validationTest() throws Exception {
        /*
                나중에 작성해야할것 modelAttribute 은 form-data로 받기때문에 string으로 requestbody처럼 감싸면안되고 param으로정의해서 테스트해야한다.

         */
         mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/v1/items")
                        .param("itemName", "test")
                        .param("price", "800")
                        .param("quantity", "1500")
                        .accept(MediaType.APPLICATION_JSON)
        ).andDo(print());
    }

    @Test
    @DisplayName("아이템 리스트 조회 테스트")
    public void getItemsTest() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/v1/items")
        ).andDo(print());
    }

}