public class Student {

    private String id;
    private String fullName;
    private String group;
    private int loyaltyPoints;

    public Student(String id, String fullName, String group) {
        this.id = id;
        this.fullName = fullName;
        this.group = group;
        this.loyaltyPoints = 0;
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void addPoints(int points) {
        loyaltyPoints += points;
    }

    @Override
    public String toString() {
        return String.format(
                "[%s] %s | grupa: %s | punkty: %d",
                id,
                fullName,
                group,
                loyaltyPoints
        );
    }
}