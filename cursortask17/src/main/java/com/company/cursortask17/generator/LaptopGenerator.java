package com.company.cursortask17.generator;

import com.company.cursortask17.model.Laptop;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class LaptopGenerator {

    public Laptop getLaptop() {
        Laptop laptop = new Laptop();
        laptop.setModel(getModel());
        laptop.setBrand(getMarkOfLaptops());
        laptop.setProcessor(getProcessor());
        laptop.setRam(getRam());
        laptop.setSecondaryMarket(getUsedBefore());
        laptop.setCaseType(getCaseType());
        laptop.setPrice(getPrice());
        laptop.setDate(getDates());

        return laptop;
    }

    private String getModel() {
        String[] modelsOfLaptops = {
                "MSI GL65 Leopard",
                "Acer Predator Helios 300",
                "Acer Predator Triton 500 PT515-52-73L3",
                "Lenovo Legion 5 Gaming Laptop",
                "ASUS TUF Gaming A15 Gaming Laptop"
        };

        int rand = new Random().nextInt(modelsOfLaptops.length);
        return modelsOfLaptops[rand];
    }

    private String getMarkOfLaptops() {
        String[] brandOfLaptops = {
                "Apple",
                "Microsoft",
                "HP",
                "Lenovo",
                "LG",
                "Acer",
                "ASUS"

        };
        int rand = new Random().nextInt(brandOfLaptops.length);
        return brandOfLaptops[rand];
    }

    private String getProcessor() {
        String[] processorOfLaptops = {
                "Intel core i3",
                "Intel core i5",
                "Intel core i7",
                "Intel core i9",
                "Intel core xeon"
        };
        int rand = new Random().nextInt(processorOfLaptops.length);
        return processorOfLaptops[rand];
    }

    private int getRam() {
        int[] ramOfLaptops = {
                16,
                32,
                64,
                128,
                256
        };
        int rand = new Random().nextInt(ramOfLaptops.length);
        return ramOfLaptops[rand];
    }

    private boolean getUsedBefore() {
        boolean[] isUsedBefore = {true, false};
        int rand = new Random().nextInt(isUsedBefore.length);
        return isUsedBefore[rand];
    }

    private String getCaseType() {
        String[] typeOfCase = {
                "Plastic",
                "Metal",
                "Carbon"
        };
        int rand = new Random().nextInt(typeOfCase.length);
        return typeOfCase[rand];
    }

    private float getPrice() {
        Random random = new Random();
        return random.nextInt(35000) + 26500;
    }

    private LocalDate getDates() {
        long minDay = LocalDate.of(2016, 1, 1).toEpochDay();
        long maxDay = LocalDate.of(2020, 12, 31).toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);

        return LocalDate.ofEpochDay(randomDay);
    }
}
