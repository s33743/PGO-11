public class CameraKit extends Equipment {

    private int lensCount;
    private boolean hasTripod;

    public CameraKit(
            String id,
            String name,
            double dailyPrice,
            int lensCount,
            boolean hasTripod) {

        super(id, name, dailyPrice);
        this.lensCount = lensCount;
        this.hasTripod = hasTripod;
    }

    @Override
    public double calculateDailyPrice() {

        double price = dailyPrice;

        price += lensCount * 5;

        if (hasTripod) {
            price += 10;
        }

        return price;
    }

    @Override
    public String getDisplayText() {
        return String.format(
                "CameraKit [%s] %s | Obiektywy: %d | Statyw: %s | %.2f PLN/dzień",
                id,
                name,
                lensCount,
                hasTripod ? "TAK" : "NIE",
                calculateDailyPrice()
        );
    }
}
