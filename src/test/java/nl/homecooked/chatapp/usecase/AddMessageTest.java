package nl.homecooked.chatapp.usecase;

import nl.homecooked.ChatappApplicationTests;
import nl.homecooked.chatapp.domain.Message;
import nl.homecooked.chatapp.repository.MessageRepository;
import nl.homecooked.chatapp.usecase.api.AddMessageRequest;
import org.assertj.core.api.Condition;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;


public class AddMessageTest extends ChatappApplicationTests {

    @Autowired
    private AddMessage addMessage;

    @Autowired
    private MessageRepository messageRepository;

    @Test
    public void givenRequestForNewMessage_thenNewMessageIsCreated() throws Exception {
        // given
        AddMessageRequest request = new AddMessageRequest("bas", "new message");

        // when
        addMessage.addMessage(request);

        // then
        assertThat(messageRepository.findAll()).hasSize(1);
        assertThat(messageRepository.findAll().get(0)).has(new Condition<Message>() {
            @Override
            public boolean matches(Message message) {
                return "bas".equals(message.getUser())
                        && "new message".equals(message.getValue());
            }
        });

        // cleanup
        messageRepository.deleteAll();

    }
}