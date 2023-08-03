package com.ardagok.busstopapp.service;

import com.ardagok.busstopapp.entity.BusEntity;
import com.ardagok.busstopapp.entity.RouteEntity;
import com.ardagok.busstopapp.entity.StopEntity;
import com.ardagok.busstopapp.repository.BusRepository;
import com.ardagok.busstopapp.util.MapBoxUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BusService {
    @Autowired
    private final BusRepository busRepository;

    @Autowired
    public BusService(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    public List<BusEntity> getBuses() {
        return busRepository.findAll();
    }

    public void addNewBus(BusEntity busEntity) {
        busRepository.save(busEntity);
    }

    public Optional<BusEntity> getBusById(long id) {
        return busRepository.findById(id);
    }

    public HashMap<String, HashMap<String, Object>> getBusesMin() {
        HashMap<String, HashMap<String, Object>> busMinHashMap = new HashMap<>();
        for (BusEntity entity : busRepository.findAll()) {
            HashMap<String, Object> busData = new HashMap<>();
            busData.put("name", entity.getName());

            List<String> stops = new LinkedList<>();
            for (StopEntity entity2 : entity.getBusStop()) {
                stops.add(entity2.getNo());
            }
            List<String> stops2 = new LinkedList<>();
            for (StopEntity entity3 : entity.getBusStop2()) {
                stops2.add(entity3.getNo());
            }
            Collections.sort(stops);
            Collections.sort(stops2);
            List<List<String>> allStops = new LinkedList<>();
            allStops.add(stops);
            allStops.add(stops2);
            if (!allStops.get(0).isEmpty()) {
                busData.put("routes", allStops);
                busMinHashMap.put(String.valueOf(entity.getNo()), busData);
            }
        }
        return busMinHashMap;
    }

    public HashMap<String, Object> getRoutesMin() {
        HashMap<String, Object> routesMin = new HashMap<>();
        for (BusEntity entity : busRepository.findAll()) {
            LinkedList<String> routes = new LinkedList();
            for (RouteEntity entity2 : entity.getRoutes()) {
                routes.add(MapBoxUtils.encode(List.of(entity2.getLineString().getCoordinates()), 5));
            }
            routesMin.put(entity.getNo(), routes);
        }
        return routesMin;
    }
}






