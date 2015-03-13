/**
 * 
 */
package info.pello.spring.mongo;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * @author Pello Altadill
 *
 */
public class MessageDAO {
	
	protected MongoTemplate mongoTemplate;

    public void setMongoTemplate(MongoTemplate template) {
        this.mongoTemplate = template;
    }

    public MongoTemplate getMongoTemplate() {
        return this.mongoTemplate;
    }
    
    public MessageDAO () {}
    
    public Message selectByPk(ObjectId id) {
        return (Message)mongoTemplate.findById(id, Message.class);
    }
    
    public List<Message> select() {
        return mongoTemplate.findAll(Message.class);
    }
    
    public ObjectId insert(Message message) {
    	mongoTemplate.insert(message);
        return message.getId();
    }
}
