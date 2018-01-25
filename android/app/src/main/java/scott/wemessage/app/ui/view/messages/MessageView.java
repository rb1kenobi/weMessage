package scott.wemessage.app.ui.view.messages;

import com.stfalcon.chatkit.commons.models.IMessage;

import java.util.Calendar;
import java.util.Date;

import scott.wemessage.app.messages.models.Message;
import scott.wemessage.commons.utils.StringUtils;

public class MessageView implements IMessage {

    private Message message;

    public MessageView(Message message){
        this.message = message;
    }

    public Message getMessage(){
        return message;
    }

    @Override
    public String getId() {
        return message.getUuid().toString();
    }

    @Override
    public String getText() {
        try {
            return StringUtils.trimORC(message.getText());
        }catch(Exception ex){
            return null;
        }
    }

    @Override
    public UserView getUser() {
        try {
            return new UserView(message.getSender());
        }catch (Exception ex){
            return new UserView(null);
        }
    }

    @Override
    public Date getCreatedAt() {
        try {
            return message.getModernDateSent();
        }catch(Exception ex){
            return Calendar.getInstance().getTime();
        }
    }

    public boolean hasErrored(){
        return message.hasErrored();
    }
}