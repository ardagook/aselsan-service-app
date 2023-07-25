package com.ardagok.busstopapp.config;

import com.ardagok.busstopapp.entity.BusEntity;
import com.ardagok.busstopapp.entity.StopEntity;
import com.ardagok.busstopapp.repository.BusRepository;
import com.ardagok.busstopapp.repository.BusStopRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BusConfig {
@Bean
    CommandLineRunner commandLineRunner(BusRepository busRepository, BusStopRepository busStopRepository){
        return ags-> {
            BusEntity incirli = new BusEntity(2,"289");
            busRepository.save(incirli);
            BusEntity incirli2 = new BusEntity(3,"203");
            busRepository.save(incirli2);
            StopEntity durak1 = new StopEntity("285");
            busStopRepository.save(durak1);
            StopEntity durak2 = new StopEntity("2897");
            busStopRepository.save(durak2);

        };
    }
}
