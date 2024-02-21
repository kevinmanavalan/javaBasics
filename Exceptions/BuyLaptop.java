package Exceptions;

class Laptop {
    int price;
    String details;

    public Laptop(int price, String details) {
        this.price = price;
        this.details = details;
    }
}

class Afford {
    public static String checkConfig(Laptop laptop) throws LaptopException {
        int price = laptop.price;
        String[] details = laptop.details.split("/");
        int ram = Integer.parseInt(details[0]);
        int storage = Integer.parseInt(details[1]);
        String type = details[2];
        if (price > 70000) {
            throw new LaptopException("too costly");
        } else if (ram < 8) {
            throw new LaptopException("ram too low");
        } else if (storage < 512) {
            throw new LaptopException("storage too low");
        } else if (type == "HDD") {
            throw new LaptopException("SSD required");
        } else {
            return "Config seems ok";
        }
    }

    public static String purchase(Laptop laptop) {
        try {
            checkConfig(laptop);
        } catch (LaptopException le) {
            System.out.println("Laptop Exception");
        } catch (Exception e) {
            System.out.println("Other Exception");
        }
        return "Perfect config";
    }
}

class LaptopException extends Throwable {

    public LaptopException(String message) {
        System.out.println(message);
    }
}

public class BuyLaptop {
    public static void main(String args[]) {
        Laptop laptop = new Laptop(70000, "7/256/SSD");
        Afford.purchase(laptop);
    }
}
