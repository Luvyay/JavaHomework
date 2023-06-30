package lesson6;

import lombok.Data;

import java.util.Random;
@Data
public class Laptop {
    private static int count;
    private int id;
    private int price;
    private String brand;
    private int ram;
    private String cpu;
    private String color;
    private String name;

    public Laptop(int price, String brand, int ram, String cpu, String color) {
        this.price = price;
        this.brand = brand;
        this.ram = ram;
        this.cpu = cpu;
        this.color = color;

        count++;

        this.id = count;

        this.name = "Ноутбук " + brand + " " + color + " [" + cpu + ", RAM " + ram + " ГБ]";
    }

    public Laptop(){
        this.price = randomPrice();
        this.brand = randomBrand();
        this.ram = randomRAM();
        this.cpu = randomCPU();
        this.color = randomColor();

        count++;

        this.id = count;

        this.name = "Ноутбук " + brand + " " + color + " [" + cpu + ", RAM " + ram + " ГБ]";
    }

    public void setName(String name) {
        this.name = name;
    }

    private int randomPrice(){
        Random random = new Random();
        int randPrice = random.nextInt(1000000);

        return randPrice;
    }

    private String randomBrand(){
        String[] randBrand = new String[]{"Acer", "ASUS", "Lenovo", "MSI", "Apple", "Samsung"};
        Random random = new Random();
        int randIndex = random.nextInt(randBrand.length);

        return randBrand[randIndex];
    }

    private int randomRAM(){
        Random random = new Random();
        int randRAM = random.nextInt(2,256);
        while (randRAM % 2 != 0){
            randRAM = random.nextInt(2,256);
        }

        return randRAM;
    }

    private String randomCPU(){
        Random random = new Random();

        if (this.brand == "Apple"){
            String[] randCPU = new String[]{"Apple M1", "Apple M2"};
            int randIndex = random.nextInt(randCPU.length);

            return randCPU[randIndex];
        } else {
            String[] randCPU = new String[]{"Intel Core i9", "Intel Core i7", "Intel Core i5", "Intel Core i3",
                    "AMD Ryzen 9", "AMD Ryzen 7", "AMD Ryzen 5"};
            int randIndex = random.nextInt(randCPU.length);

            return randCPU[randIndex];
        }
    }

    private String randomColor(){
        String[] randColor = new String[]{"black", "white", "blue", "gray"};
        Random random = new Random();
        int randIndex = random.nextInt(randColor.length);

        return randColor[randIndex];
    }
}
