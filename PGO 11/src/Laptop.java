public class Laptop extends Equipment {

    private int ramGb;
    private boolean dockingStation;

    public Laptop(
            String id,
            String name,
            double dailyPrice,
            int ramGb,
            boolean dockingStation) {

        super(id, name, dailyPrice);
        this.ramGb = ramGb;
        this.dockingStation = dockingStation;
    }

    @Override
    public double calculateDailyPrice() {

        double price = dailyPrice;

        if (dockingStation) {
            price += 15;
        }

        return price;
    }

    @Override
    public String getDisplayText() {
        return String.format(
                "Laptop [%s] %s | RAM: %d GB | Dock: %s | %.2f PLN/dzień",
                id,
                name,
                ramGb,
                dockingStation ? "TAK" : "NIE",
                calculateDailyPrice()
        );
    }
}