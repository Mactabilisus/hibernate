
public class Message {
  private Message() {
  }
  
  public Message(String messageText) {
  this.messageText = messageText;
  }
  
  public String getMessageText() {
  return messageText;
  }
  
  public void setMessageText(String messageText){
  this.messageText = messageText;
  }
  
  private String message;
  
}


