public abstract class Notification implements Deliverable, Displayable {
    protected String recipientId;
    protected long timestamp;

    public Notification(String recipientId) {
        this.recipientId = recipientId;
        this.timestamp = System.currentTimeMillis();
    }

    public String getRecipientId() {
        return recipientId;
    }
}