package com.dogo.chat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    MessageRepository dao;
    
    @GetMapping("/chat")
    public List<Message> getMessages(){
        List<Message> foundMessages = dao.findAll();
        return foundMessages;
    }
    
    @GetMapping("/chat/{id}")
    public ResponseEntity<Message> getMessage(@PathVariable(value="id") Integer id){
        Message foundMessage = dao.getOne(id);

        if(foundMessage == null) {
            return ResponseEntity.notFound().header("Message","Nothing found with that id").build();
        }
        return ResponseEntity.ok(foundMessage);
    }
    @PostMapping("/chat")
    public ResponseEntity<Message> postMessage(@RequestBody Message message){

        // Saving to DB using an instance of the repo Interface.
        Message createdMessage = dao.save(message);

        // RespEntity crafts response to include correct status codes.
        return ResponseEntity.ok(createdMessage);
    }
    
    @PutMapping("/chat/{id}")
    public ResponseEntity<Message> putMessage(@PathVariable(value="id") Integer id, @RequestBody Message message ){
        Message foundMessage = dao.getOne(id); 
        
        //check to see if there is content for requested id
        if(foundMessage == null) {
            return ResponseEntity.notFound().header("Message","Nothing found with that id").build();        
        }
        
        //set name and content in foundMessage using setters then use getters
        foundMessage.setName(message.getName());
        foundMessage.setContent(message.getContent());
        
        //create a new message variable and save the foundMessage changes        
        Message updatedMessage = dao.save(foundMessage);
        
        //return the new variable with the saved changes
        return ResponseEntity.ok(updatedMessage);
    }
    
    @DeleteMapping("/chat/{id}")
    public ResponseEntity<Message> deleteMessage(@PathVariable(value="id") Integer id){
        Message foundMessage = dao.getOne(id);

        if(foundMessage == null) {
            return ResponseEntity.notFound().header("Message","Nothing found with that id").build();
        }else {
            dao.delete(foundMessage);
        }
        return ResponseEntity.ok().build();
    }
    

}
