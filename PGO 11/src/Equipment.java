public abstract class Equipment implements Displayable {

    protected String id;
    protected String name;
    protected double dailyPrice;

    public Equipment(String id, String name, double dailyPrice) {
        this.id = id;
        this.name = name;
        this.dailyPrice = dailyPrice;
    }

    public String getId() {
        return id;
    }

    public abstract double calculateDailyPrice();
}