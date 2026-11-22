import java.io.Serializable;

public abstract class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    protected String id;
    protected String name;
    protected String phone; // Для відправки SMS

    public Person(String id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public String getName() { return name; }
    public String getPhone() { return phone; }

    public abstract String getRole();
}