package cn.tedu.baking;

import cn.tedu.baking.config.Tool;
import cn.tedu.baking.mapper.LoginrecordMapper;
import cn.tedu.baking.pojo.entity.Loginrecord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@SpringBootTest
@AutoConfigureMockMvc
class BakingApplicationTests {

    @Autowired
    LoginrecordMapper loginrecordMapper;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    Tool tool;
    @Test
    public void trrrrdf(){
        Loginrecord loginrecord = new Loginrecord();
        loginrecord.setLogtime(new Date());
        loginrecord.setUserId(1l);
        int insert = loginrecordMapper.insert(loginrecord);
        System.out.println(insert);

    }
    @Test
    public void insertSession() {
        MockHttpSession session = new MockHttpSession();

        tool.createSesson(session);
    }

}
