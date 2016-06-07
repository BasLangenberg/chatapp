package nl.homecooked;

import nl.homecooked.chatapp.repository.MessageRepository;
import nl.homecooked.chatapp.usecase.api.Message;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ChatappApplication.class)
@WebAppConfiguration
public class ChatappApplicationTests {

    @Autowired
    private MessageRepository messageRepository;

    @After
    public void Teardown() throws Exception {
        if (messageRepository != null){
            messageRepository.deleteAll();
        }
    }

}
