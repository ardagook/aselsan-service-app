package com.ardagok.busstopapp.controller;


import com.ardagok.busstopapp.entity.StopEntity;
import com.ardagok.busstopapp.service.StopService;
import com.ardagok.busstopapp.util.MapBoxUtils;
import org.locationtech.jts.geom.Coordinate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/bus/stops", produces = "application/json")
public class StopController {

    @Autowired
    private final StopService stopService;

    public StopController(StopService stopService) {
        this.stopService = stopService;
    }

    @GetMapping
    public List<StopEntity> getBusStops() {

       // String test = "ykgGwllyRbAfAoAfA{@L?fErKHt@c@L]AgMUyB_@kAiAcBeC_Bq@S}BUgG?A_HlG?|Cl@`B?v@MlBgAb@iA?}IYmBaAkB~BwAfFwAcAyDq@sAqCoCkCeBuB_AoHcBoJMEqFe@uBs@mAeg@{f@}@Ao@RaI|HqGqGcJnImYW{@t@u@lEsJyAeAvKMrIN~GrB`^AbCk@zEeAzD|EbB~FJhEpBkK~]s@bB{BhDxHtCa@fEkHdFoHnLwGkEyIlM?lBtK|GlJbDHbCYhBsFnLaGx^w@`DsDbKqEpHgCvCsOdO_{@vr@cGzG{H`PsTmI|CgFvg@wp@Ho@SiAkMqIoCX_l@x}@{FrKKx@^lAxDpBkAfCu@J";
       // List<Coordinate> s = MapBoxUtils.decode(test, 5);

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
    public Optional<StopEntity> findStopById(@PathVariable long id) {
        return stopService.findStopById(id);
    }

}
