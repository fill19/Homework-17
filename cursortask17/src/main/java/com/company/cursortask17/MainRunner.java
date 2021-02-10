package com.company.cursortask17;

import com.company.cursortask17.generator.LaptopGenerator;
import com.company.cursortask17.model.Laptop;
import com.company.cursortask17.repositroy.LaptopRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MainRunner implements CommandLineRunner {
    LaptopGenerator laptopGenerator;
    LaptopRepository laptopRepository;

    public MainRunner(LaptopGenerator laptopGenerator,
                      LaptopRepository laptopRepository) {
        this.laptopGenerator = laptopGenerator;
        this.laptopRepository = laptopRepository;
    }

    @Override
    public void run(String... args) {
        Laptop laptop;

        System.out.println("Generating laptops values...");
        for (int i = 0; i < 20; i++) {
            laptop = laptopGenerator.getLaptop();

            laptopRepository.save(laptop);
        }

        System.out.println("\nAll amount of Laptops: ");
        laptopRepository.findAll().forEach(System.out::println);

        List<Laptop> getAll = laptopRepository.findAllByOrderByBrandDesc();
        System.out.println("Sorting of Laptops: ");
        for (Laptop c : getAll) {
            System.out.println(c);
        }
        System.out.println("\n--------------------------");

        List<Laptop> getListWithStrongMemory = laptopRepository.findAllByRamGreaterThan(16);
        System.out.println("The Laptops with ram more than 16 GB: ");
        for (Laptop c : getListWithStrongMemory) {
            System.out.println(c);
            System.out.println("\n--------------------------");
        }
        System.out.println("*************************");

        List<Laptop> usedComputers = laptopRepository.findAllBySecondaryMarketIsTrue();
        System.out.println("The used before Laptops");
        for (Laptop c : usedComputers) {
            System.out.println(c);
            System.out.println("\n--------------------------");
        }
    }
}