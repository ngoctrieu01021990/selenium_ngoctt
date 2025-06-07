package Java_basic;

public class Topic_09_getter_setter {
    private String carName;
    private String carType;
    private String carColor;

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getCarMachine() {
        return carMachine;
    }

    public void setCarMachine(String carMachine) {
        this.carMachine = carMachine;
    }

    private String carMachine;

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }
}
