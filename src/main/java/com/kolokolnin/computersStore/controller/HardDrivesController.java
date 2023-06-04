package com.kolokolnin.computersStore.controller;

import com.kolokolnin.computersStore.entity.HardDrives;
import com.kolokolnin.computersStore.service.HardDrivesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//TODO: лучше добавить версионирование:
// /api/v1/hd
@RequestMapping("/api/hd")
public class HardDrivesController extends AbstractProductRestController<HardDrives, HardDrivesService> {
    //TODO: лучше убрать аннотацию  @Autowired (использовать либу Lombok)
    // private final HardDrivesService hardDrivesService;
    @Autowired
    private HardDrivesService hardDrivesService;

    //TODO: нужно выпилить то, что не используется
    @Autowired
    public HardDrivesController(HardDrivesService hardDrivesService) {
        super(hardDrivesService);
        this.hardDrivesService = hardDrivesService;
    }

    @Override
    public List<HardDrives> getProductsByProperty(@RequestBody HardDrives hardDrive) {
        if (hardDrive.getCapacity() != null) {
            return hardDrivesService.readByCapacity(hardDrive.getCapacity());
        }
        return getProductsByDefaultProperty(hardDrive);
    }

    @Override
    public boolean setProduct(@RequestBody HardDrives requestedHardDrive) {
        if (requestedHardDrive.getSerialNumber() != null) {
            return hardDrivesService.updateBySerialNumber(requestedHardDrive);
        }
        return false;
    }
}
