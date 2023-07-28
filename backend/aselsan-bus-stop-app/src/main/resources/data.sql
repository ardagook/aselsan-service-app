INSERT INTO stop_entity (id,no,stop_name,geometry) VALUES
                                                       (nextval('stop_sequence'),'44','Durak3','POINT(-71.060316 44.432044)'),
                                                       (nextval('stop_sequence'),'44','Durak4','POINT(-72.060316 43.432044)'),
                                                       (nextval('stop_sequence'),'44','Durak5','POINT(-74.060316 42.432044)'),
                                                       (nextval('stop_sequence'),'44','Durak6','POINT(-75.060316 45.432044)'),
                                                       (nextval('stop_sequence'),'44','Durak7','POINT(-76.060316 46.432044)');


INSERT INTO bus_entity (id,no) VALUES
                                   (nextval('bus_sequence'),'11'),
                                   (nextval('bus_sequence'),'15'),
                                   (nextval('bus_sequence'),'15'),
                                   (nextval('bus_sequence'),'13'),
                                   (nextval('bus_sequence'),'14'),
                                   (nextval('bus_sequence'),'48') ;