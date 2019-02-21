public class Auto {
    static String[] brands = {"Audi", "Mazda", "Kia", "Toyota", "Honda"};
    static String[] colours = {"White", "Red", "Blue", "Orange", "Black"};
    static boolean[] isAutomats = {true, false};
    static boolean[] trailers = {true, false, false, false}; //фолсы что бы реже попадались авто с прицепами

    String brand, colour;
    boolean isAutomat, trailer;
    int weight;

    public Auto(String brand, String colour, boolean isAutomat, boolean trailer, int weight) {
        if (trailer || weight >= 3000 || Parking.place <= 0) {
            System.out.println("Автомобиль " + brand + " " + colour + ", кпп " + isAutomat + ", прицеп "
                    + trailer + ", масса " + weight + " не может посетить парковку т к имеет имеет прицеп, " +
                    "имеет слишком большую массу, либо нет мест");

        } else {
            this.brand = brand;
            this.colour = colour;
            this.isAutomat = isAutomat;
            this.trailer = trailer;
            this.weight = weight;
            Parking.place--;
            System.out.println("Автомобиль " + brand + " " + colour + ", кпп " + isAutomat +
                    ", прицеп " + trailer + ", масса " + weight + " приехал на парковку. Свободных мест : " + Parking.place);

        }
    }


    @Override
    public String toString() {
        return brand + " " + colour + ", кпп " + isAutomat + ", прицеп " + trailer + ", масса " + weight;
    }


}
