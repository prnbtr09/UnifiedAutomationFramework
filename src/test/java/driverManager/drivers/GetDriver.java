package driverManager.drivers;

public class GetDriver {

    public Driver getDriver(String driverName) {
        switch (driverName.toLowerCase()) {
            case "chrome":
                return new GetChromeDriver();
            case "firefox":
                return new GetFirefoxDriver();
            default:
                throw new IllegalArgumentException("Driver name is incorrect");
        }


    }

}
