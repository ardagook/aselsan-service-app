package com.ardagok.busstopapp.controller;

import com.ardagok.busstopapp.entity.BusEntity;
import com.ardagok.busstopapp.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/buses")
public class BusController {
    @Autowired
    public final BusService busService;

    public BusController(BusService busService) {
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

  /* @GetMapping(path = "/min")
    public HashMap<String, LinkedList> getStopsMin() {
        return busService.getStopsMin();
    } */

    @GetMapping(path = "/{id}")
    public Optional<BusEntity> getBusById(@PathVariable Long id) {
        return busService.getBusById(id);
    }

}
