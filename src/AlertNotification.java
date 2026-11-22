public abstract class AlertNotification extends Notification {
    protected String appName;

    public AlertNotification(String recipientId, String appName) {
        super(recipientId);
        this.appName = appName;
    }
}