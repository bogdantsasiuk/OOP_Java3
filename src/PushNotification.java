public class PushNotification extends AlertNotification {
    private MessageContent content;

    public PushNotification(String recipientId, String appName, String title, String bodyText) {
        super(recipientId, appName);
        this.content = new MessageContent(title, bodyText);
    }

    @Override
    public String getDisplayText() {
        return "[" + appName + "] " + content.getTitle() + "\n" + content.getBody();
    }

    @Override
    public void deliver() {
        System.out.println("Відправка Push-повідомлення на пристрій: " + recipientId);
    }
}