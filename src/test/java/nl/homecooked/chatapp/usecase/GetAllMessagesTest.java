package nl.homecooked.chatapp.usecase;

import com.sun.org.apache.regexp.internal.RE;
import nl.homecooked.ChatappApplicationTests;
import nl.homecooked.chatapp.repository.MessageRepository;
import nl.homecooked.chatapp.usecase.api.Message;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

public class GetAllMessagesTest extends ChatappApplicationTests {

    @Autowired
    private GetAllMessages getAllMessages;

    @Autowired
    private MessageRepository messageRepository;

    @Test
    public void given5ChatMessages_thenGetAllMessagesReturnsAllMessages() throws Exception {
        // given
        messageRepository.save(createMessage("Bas", "hello java"));
        messageRepository.save(createMessage("Kris", "hello Bas"));
        messageRepository.save(createMessage("Bas", "show me spring"));
        messageRepository.save(createMessage("Kris", "okay"));
        messageRepository.save(createMessage("Bas", "kewl"));

        // when
        Collection<Message> messages = getAllMessages.getAllMessages();

        // then
        assertThat(messages).hasSize(5);

    }

    private nl.homecooked.chatapp.domain.Message createMessage(String user, String value) {
        return new nl.homecooked.chatapp.domain.Message(user, value);
    }
}