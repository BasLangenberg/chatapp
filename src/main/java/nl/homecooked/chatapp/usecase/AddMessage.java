package nl.homecooked.chatapp.usecase;

import nl.homecooked.chatapp.domain.Message;
import nl.homecooked.chatapp.repository.MessageRepository;
import nl.homecooked.chatapp.usecase.api.AddMessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class AddMessage {

    @Autowired
    private MessageRepository messageRepository;

    public void addMessage(AddMessageRequest request) {
        messageRepository.save(new Message(request.getUser(), request.getValue()));
    }
}
