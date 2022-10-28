package transport;

public abstract class Transport {
    private final String brand;
    private final String model;
    private double engineVolume;

    public Transport(String brand,
                     String model,
                     Double engineVolume) {

        this.brand = parse(brand);
        this.model = parse(model);
        setEngineVolume(engineVolume);
    }

    public abstract void startMoving();

    public abstract void stopMoving();

    public abstract void doCheckup() throws FailedCheckupException;

    public static String parse(String value){
        return value != null && !value.isEmpty() && !value.isBlank() &&
                !value.equals("null") ? value : "(информация не указана)";
    }

    @Override
    public String toString() {
        return brand + " " + model +
                " с объёмом двигателя в " +
                engineVolume + " литров";
    }

    public final String getBrand() {
        return brand;
    }

    public final String getModel() {
        return model;
    }

    public final double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(Double engineVolume) {
        this.engineVolume = engineVolume != null && engineVolume > 0 ? engineVolume : 1.5;
    }
}
