public abstract class MessageNotification extends Notification {
    protected String senderNumber;

    public MessageNotification(String recipientId, String senderNumber) {
        super(recipientId);
        this.senderNumber = senderNumber;
    }
}