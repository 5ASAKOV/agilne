INSERT INTO "course"("id", "capacity", "date_of_start","course_type_id")
VALUES (12, 60, '2021-04-30',1);
INSERT INTO "course"("id", "capacity", "date_of_start")
VALUES (22, 20, '2021-05-10');
INSERT INTO "course"("id", "capacity", "date_of_start")
VALUES (32, 30, '2021-03-30');

INSERT INTO "language"("id", "language")
VALUES (1, 'German');

INSERT INTO "intensity"("id", "name")
VALUES (1, 'Intense');

INSERT INTO "level"("id", "label", "description")
VALUES (1, 'C1', 'Fast c1');

INSERT INTO "course_type"("id", "name", "price", "number_of_classes","intensity_id","language_id","level_id")
VALUES (1, 'German', 100, 20, 1,1,1);
