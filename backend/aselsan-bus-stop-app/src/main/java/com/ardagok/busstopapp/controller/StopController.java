package com.ardagok.busstopapp.controller;


import com.ardagok.busstopapp.controller.handler.StopIdNotFoundException;
import com.ardagok.busstopapp.entity.StopEntity;
import com.ardagok.busstopapp.service.StopService;
import org.locationtech.jts.geom.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/stops", produces = "application/json")
public class StopController {

    @Autowired
    private final StopService stopService;

    public StopController(StopService stopService) {
        this.stopService = stopService;
    }

    @GetMapping
    public List<StopEntity> getBusStops() {
        return stopService.getBusStops();
    }

    @GetMapping(path = "/min")
    public HashMap<String, LinkedList> getStopsMin() {
        return stopService.getStopsMin();
    }

    @PostMapping
    public void registerNewStop(@RequestBody StopEntity stopEntity) {
        stopService.addNewBusStops(stopEntity);
    }

    @GetMapping(path = "/{id}")
    public StopEntity findStopById(@PathVariable long id) {
        return stopService.findStopById(id).orElseThrow(() -> new StopIdNotFoundException("Stop id: "+ id + " is not Found" ));
    }
    @GetMapping(path = "/dijkstra")
    public LinkedList<Point> FindShortestStops(){
        return stopService.getStopsDijkstra();
    }

}
