package com.kolokolnin.computersStore.controller;

import com.kolokolnin.computersStore.entity.DesktopComputers;
import com.kolokolnin.computersStore.service.DesktopComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//TODO: лучше добавить версионирование:
// /api/v1/pc
@RequestMapping("/api/pc")
public class DesktopComputerController extends AbstractProductRestController<DesktopComputers, DesktopComputerService> {
    //TODO: лучше убрать аннотацию  @Autowired (использовать либу Lombok)
    // private final DesktopComputerService desktopComputerService;
    @Autowired
    private DesktopComputerService desktopComputerService;

    //TODO: нужно выпилить то, что не используется
    @Autowired
    public DesktopComputerController(DesktopComputerService desktopComputerService) {
        super(desktopComputerService);
        this.desktopComputerService = desktopComputerService;
    }

    @Override
    public List<DesktopComputers> getProductsByProperty(@RequestBody DesktopComputers pc) {
        if (pc.getFormFactor() != null) {
            return desktopComputerService.readDesktopComputerByFormFactor(pc.getFormFactor());
        }
        return getProductsByDefaultProperty(pc);
    }

    @Override
    public boolean setProduct(@RequestBody DesktopComputers requestedPC) {
        if (requestedPC.getSerialNumber() != null) {
            return desktopComputerService.updateBySerialNumber(requestedPC);
        }
        return false;
    }

}
