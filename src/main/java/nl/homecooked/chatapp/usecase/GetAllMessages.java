package nl.homecooked.chatapp.usecase;

import nl.homecooked.chatapp.repository.MessageRepository;
import nl.homecooked.chatapp.usecase.api.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class GetAllMessages {

    @Autowired
    private MessageRepository messageRepository;

    public Collection<Message> getAllMessages() {
        return messageRepository.findAll()
                .stream()
                .map(m -> new Message(m.getDateTime(), m.getUser(), m.getValue()))
                .collect(Collectors.toList());
    }
}
