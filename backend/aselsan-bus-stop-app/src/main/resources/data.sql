INSERT INTO bus_entity (id,no,name) VALUES
                                   (nextval('bus_sequence'),'B9','Aselsan Gölbaşı Tesisleri ⇄ Basınevleri-İncirli');


INSERT INTO stop_entity (id, no, stop_name, geometry) VALUES
                                                          (nextval('stop_sequence'), '5000', 'Aselsan Gölbaşı Tesisleri Otobüs Toplanma Alanı', 'POINT(32.81527595300261 39.71809809301061)'),
                                                          (nextval('stop_sequence'), '5001', 'Akköprü ', 'POINT(32.83507325561155 39.95120645256165)'),
                                                          (nextval('stop_sequence'), '5002', 'Varlık Toki', 'POINT(32.83801006877974 39.95716707892828)'),
                                                          (nextval('stop_sequence'), '5003', 'Gülhane Ortaokulu', 'POINT(32.85362081397503 39.96857263342855)'),
                                                          (nextval('stop_sequence'), '5004', 'İncirli', 'POINT(32.84743978676053 39.978469288331866)'),
                                                          (nextval('stop_sequence'), '5005', 'Faik Erbağı', 'POINT(32.85043739035399 39.981350499912196)'),
                                                          (nextval('stop_sequence'), '5006', 'Karaelmas Durağı', 'POINT(32.849659772465344 39.98338951907692)'),
                                                          (nextval('stop_sequence'), '5007', 'Danışment Taksi', 'POINT(32.853007282646075 39.984648136608286)');

INSERT INTO bus_stops (bus_id, stop_id)  VALUES
                                                                                                     (106,1007),
                                                                                                     (106,1008),
                                                                                                     (106,1009),
                                                                                                     (106,1010),
                                                                                                     (106,1011),
                                                                                                     (106,1012),
                                                                                                     (106,1013),
                                                                                                     (106,1014);