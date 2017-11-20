INSERT INTO kysely (
nimi,
kuvaus
) VALUES (
'Kurssipalaute kurssilta SWD4TN022-5',
'Anna kurssipalautetta opettajalle kurssilta SWD4TN022-5 vastaamalla annettuihin kysymyksiin.');

INSERT INTO kysymys (
teksti,
monivalinta,
kysely_id
) VALUES (
'Mitk√§ olivat 3 t√§rkeint√§ asiaa jotka opit ohjelmistoprojektin kurssilta?',
 false,
 1
);

INSERT INTO kysymys (
teksti,
monivalinta,
kysely_id
) VALUES (
'Mist√§ kuulit kurssista? Valitse alla olevista vaihtoehdoista',
 true,
 1
);

INSERT INTO vaihtoehto (
teksti,
kysymys_id
) VALUES (
'MyNetist√§',
 1);

INSERT INTO vaihtoehto (
teksti,
kysymys_id
) VALUES (
'Kaverilta',
 1);
 
 INSERT INTO vaihtoehto (
teksti,
kysymys_id
) VALUES (
'Opinto-opas',
 1);


INSERT INTO kysely (
nimi,
kuvaus
) VALUES (
'Esimerkkikysely vihanneksista',
'T‰m‰ toimii esimerkkin‰');

INSERT INTO kysymys (
teksti,
monivalinta,
kysely_id
) VALUES (
'T‰m‰ on monivalintakysymys',
 true,
 2
);

INSERT INTO kysymys (
teksti,
monivalinta,
kysely_id
) VALUES (
'T‰m‰ on tekstikysymys',
 false,
 2
);

INSERT INTO vaihtoehto (
teksti,
kysymys_id
) VALUES (
'P‰‰ryn‰',
 5);

INSERT INTO vaihtoehto (
teksti,
kysymys_id
) VALUES (
'Omena',
 5);

INSERT INTO vastaus (
teksti,
kysymys_id
) VALUES (
'DAO, Controller ja Bean',
1
);


 