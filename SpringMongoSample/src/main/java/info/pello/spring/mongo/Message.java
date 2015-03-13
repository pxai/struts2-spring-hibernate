/**
 * 
 */
package info.pello.spring.mongo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.bson.types.ObjectId;
 
/**
 * Messages object
 * @author Pello Altadill
 */
@Entity
@Table(name = "messages")
public class Message implements Serializable {
 
    @Id
    private ObjectId id;
    private String from;
    private String to;
    private String message;
    private String timestamp;
 
    /**
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * @param from the from to set
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * @return the to
	 */
	public String getTo() {
		return to;
	}

	/**
	 * @param to the to to set
	 */
	public void setTo(String to) {
		this.to = to;
	}

	public ObjectId getId() {
        return id;
    }
 
    public void setId(ObjectId id) {
        this.id = id;
    }
 
    public String getMessage() {
        return message;
    }
 
    public void setMessage(final String message) {
        this.message = message;
    }
 
    public String getTimestamp() {
        return timestamp;
    }
 
    public void setTimestamp(final String timestamp) {
        this.timestamp = timestamp;
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Message [id=" + id + ", from=" + from + ", to=" + to
				+ ", message=" + message + ", timestamp=" + timestamp + "]";
	}

    
}
