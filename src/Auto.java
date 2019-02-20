public class Auto {
    static String[] brands = {"Audi", "Mazda", "Kia", "Toyota", "Honda"};
    static String[] colours = {"White", "Red", "Blue", "Orange", "Black"};
    static boolean[] transmissions = {true, false};
    static boolean[] trailers = {true, false, false, false}; //фолсы что бы реже попадались авто с прицепами

    String brand, colour;
    boolean transmission, trailer;
    int weight;

    public Auto(String brand, String colour, boolean transmission, boolean trailer, int weight) {
        if (trailer || weight >= 3000) {
            System.out.println("Автомобиль " + brand + " " + colour + ", кпп " + transmission + ", прицеп "
                    + trailer + ", масса " + weight + " не может посетить парковку т к имеет не " +
                    "подходящую массу и имеет прицеп");
            this.brand = "qwerty";


        } else {
            this.brand = brand;
            this.colour = colour;
            this.transmission = transmission;
            this.trailer = trailer;
            this.weight = weight;
            System.out.println("Автомобиль " + brand + " " + colour + ", кпп " + transmission +
                    ", прицеп " + trailer + ", масса " + weight + " приехал на парковку. Свободных мест : ");
        }
        Parking.deleteNull();
    }

    @Override
    public String toString() {
        return brand + " " + colour + ", кпп " + transmission + ", прицеп " + trailer + ", масса " + weight;
    }


}
