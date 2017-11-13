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
'Mitkä olivat 3 tärkeintä asiaa jotka opit ohjelmistoprojektin kurssilta?',
 false,
 1
);

INSERT INTO kysymys (
teksti,
monivalinta,
kysely_id
) VALUES (
'Mistä kuulit kurssista? Valitse alla olevista vaihtoehdoista',
 true,
 1
);

INSERT INTO vaihtoehto (
teksti,
kysymys_id
) VALUES (
'MyNetistä',
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


