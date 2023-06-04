package com.kolokolnin.computersStore.controller;

import com.kolokolnin.computersStore.entity.Laptops;
import com.kolokolnin.computersStore.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//TODO: лучше добавить версионирование:
// /api/v1/laptop
@RequestMapping("/api/laptop")
public class LaptopController extends AbstractProductRestController<Laptops, LaptopService> {
    //TODO: лучше убрать аннотацию  @Autowired (использовать либу Lombok)
    // private final LaptopService laptopService;
    @Autowired
    private LaptopService laptopService;

    //TODO: нужно выпилить то, что не используется
    @Autowired
    public LaptopController(LaptopService laptopService) {
        super(laptopService);
        this.laptopService = laptopService;
    }

    @Override
    public List<Laptops> getProductsByProperty(@RequestBody Laptops laptop) {
        if (laptop.getScreenInch() != null) {
            return laptopService.readByScreenDiagonal(laptop.getScreenInch());
        }
        return getProductsByDefaultProperty(laptop);
    }

    @Override
    public boolean setProduct(@RequestBody Laptops requestedLaptop) {
        if (requestedLaptop.getSerialNumber() != null) {
            return laptopService.updateBySerialNumber(requestedLaptop);
        }
        return false;
    }

}
