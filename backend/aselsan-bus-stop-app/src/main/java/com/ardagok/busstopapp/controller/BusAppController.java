package com.ardagok.busstopapp.controller;

import com.ardagok.busstopapp.entity.BusEntity;
import com.ardagok.busstopapp.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/buses")
public class BusAppController {
    @Autowired
    public final BusService busService;

    public BusAppController(BusService busService) {
        this.busService = busService;
    }

    @GetMapping
    public List<BusEntity> getBuses() {
        return busService.getBuses();

    }

    @PostMapping
    public void registerNewBus(@RequestBody BusEntity busEntity) {
        busService.addNewBus(busEntity);

    }
}
