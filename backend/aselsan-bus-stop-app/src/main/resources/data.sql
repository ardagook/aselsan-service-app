INSERT INTO bus_entity (id,no,name) VALUES
                                   (nextval('bus_sequence'),'C15','Aselsan Gölbaşı Tesisleri ⇄ Kolej-Kurtuluş');


INSERT INTO stop_entity (id, no, stop_name, geometry) VALUES
                                                          (nextval('stop_sequence'), '5006', 'Tren Garı', 'POINT(32.842686377482664 39.93407216301466)'),
                                                          (nextval('stop_sequence'), '5007', 'Sıhıyye Köprüsü', 'POINT(32.854391525964814 39.92881161185775)'),
                                                          (nextval('stop_sequence'), '5008', 'Sıhhıye Alt dörtyol', 'POINT(32.85821716891152 39.92863437723278)'),
                                                          (nextval('stop_sequence'), '5009', 'Kurtuluş Parkı', 'POINT(32.86657491468003 39.92822935865337)'),
                                                          (nextval('stop_sequence'), '5010', 'Kurtuluş Parkı2', 'POINT(32.86809560048184 39.92802718250931)');
INSERT INTO bus_stops (bus_id, stop_id)  VALUES                                                      (107,1007),
                                                                                                     (107,1015),
                                                                                                     (107,1016),
                                                                                                     (107,1017),
                                                                                                     (107,1018),
                                                                                                     (107,1019);