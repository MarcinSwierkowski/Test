package pl.sda.Wzorce;

public class Car {

    private String engine;
    private boolean isElectric;
    private int vin;
    private String owner;
    private int maxSpeed;

    public Car() {
    }


    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public boolean isElectric(boolean isElectric) {
        return this.isElectric;
    }

    public void setElectric(boolean electric) {
        isElectric = electric;
    }

    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public static class CarBuilder {


        private String engine;
        private boolean isElectric;
        private int vin;
        private String owner;
        private int maxSpeed;


        public Car(String engine) {
            this.engine = engine;
        }

        public CarBuilder engine(String engine) {
            this.engine = engine;
            return this;
        }

        public CarBuilder isElectric(boolean isElectric) {
            this.isElectric = isElectric;
            return this;
        }

        public CarBuilder vin(int vin) {
            this.vin = vin;
            return this;
        }

        public CarBuilder owner(String owner) {
            this.owner = owner;
            return this;
        }

        public CarBuilder maxSpeed(int maxSpeed) {
            this.maxSpeed = maxSpeed;
            return this;
        }

        public Car build() {
            Car item = new Car();
            item.setEngine(this.engine);
            item.isElectric(this.isElectric);
            item.setVin(this.vin);
            item.setOwner(this.owner);
            item.setMaxSpeed(this.maxSpeed);

            return item;
        }
    }

}

