package nl.homecooked.chatapp.repository;

import nl.homecooked.chatapp.domain.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessageRepository extends MongoRepository<Message, String> {
}
