package nl.homecooked.chatapp.controller;

import nl.homecooked.chatapp.usecase.AddMessage;
import nl.homecooked.chatapp.usecase.GetAllMessages;
import nl.homecooked.chatapp.usecase.api.AddMessageRequest;
import nl.homecooked.chatapp.usecase.api.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

@Controller
public class MessageRestController {

    @Autowired
    private GetAllMessages getAllMessages;

    @Autowired
    private AddMessage addMessage;

    @RequestMapping(path = "/message", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Collection<Message> getMessages(){
        return getAllMessages.getAllMessages();
    }

    @RequestMapping(path = "/message", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Void> addMessage(@RequestBody AddMessageRequest request){
        addMessage.addMessage(request);
        return ResponseEntity.ok().build();
    }


}
