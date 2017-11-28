DELETE FROM vastaus;
DELETE FROM vaihtoehto;
DELETE FROM kysymys;
DELETE FROM kysely;

INSERT INTO kysely (
nimi,
kuvaus
) VALUES (
'Informaation l�yt�minen Haaga-Helian kursseista',
'J�senet: Calle Korrem�ki, S�de Jalonen, Laura-Maaria Penttil�, Samuli Kinnunen');

/* Kysymys 1
 * 
 */

INSERT INTO kysymys (
teksti,
monivalinta,
kysely_id
) VALUES (
'Opiskelumuoto',
 false,
 1
);

INSERT INTO vaihtoehto (
teksti,
kysymys_id
) VALUES (
'P�iv�toteutus',
 1);

INSERT INTO vaihtoehto (
teksti,
kysymys_id
) VALUES (
'Monimuoto',
 1);
 
 INSERT INTO vaihtoehto (
teksti,
kysymys_id
) VALUES (
'Hakija',
 1);
 
 INSERT INTO vaihtoehto (
teksti,
kysymys_id
) VALUES (
'Jokin muu',
 1);

 
/* Kysymys 2
 * 
 */

INSERT INTO kysymys (
teksti,
monivalinta,
kysely_id
) VALUES (
'Mist� olet l�yt�nyt tietoa Haaga-Helian kursseista?',
 true,
 1
);

INSERT INTO vaihtoehto (
teksti,
kysymys_id
) VALUES (
'Mynet',
 2);

INSERT INTO vaihtoehto (
teksti,
kysymys_id
) VALUES (
'Haaga-Helian sivut',
 2);
 
 INSERT INTO vaihtoehto (
teksti,
kysymys_id
) VALUES (
'Google',
 2);
 
INSERT INTO vaihtoehto (
teksti,
kysymys_id
) VALUES (
'Excel',
 2);
 
INSERT INTO vaihtoehto (
teksti,
kysymys_id
) VALUES (
'Muu henkil�',
 2);
 
INSERT INTO vaihtoehto (
teksti,
kysymys_id
) VALUES (
'Muualta, mist�?',
 2);

 
 /* Kysymys 3
 * 
 */

INSERT INTO kysymys (
teksti,
monivalinta,
kysely_id
) VALUES (
'Kuinka helpoksi koet tiedon etsimisen?',
 false,
 1
);

INSERT INTO vaihtoehto (
teksti,
kysymys_id
) VALUES (
'1',
 3);

INSERT INTO vaihtoehto (
teksti,
kysymys_id
) VALUES (
'2',
 3);
 
 INSERT INTO vaihtoehto (
teksti,
kysymys_id
) VALUES (
'3',
 3);
 
INSERT INTO vaihtoehto (
teksti,
kysymys_id
) VALUES (
'4',
 3);
 
INSERT INTO vaihtoehto (
teksti,
kysymys_id
) VALUES (
'5',
 3);
 
INSERT INTO vaihtoehto (
teksti,
kysymys_id
) VALUES (
'en osaa sanoa',
 3);
 
 
 /* Kysymys 4
 * 
 */

INSERT INTO kysymys (
teksti,
monivalinta,
kysely_id
) VALUES (
'L�ytyyk� kurssi-informaatio yhdest� paikasta?',
 false,
 1
);

INSERT INTO vaihtoehto (
teksti,
kysymys_id
) VALUES (
'Kyll�',
 4);

INSERT INTO vaihtoehto (
teksti,
kysymys_id
) VALUES (
'Ei',
 4);
 
 INSERT INTO vaihtoehto (
teksti,
kysymys_id
) VALUES (
'En osaa sanoa',
 4);
 

 
/* Kysymys 5
 * 
 */

INSERT INTO kysymys (
teksti,
monivalinta,
kysely_id
) VALUES (
'Mink� kanavan kautta haluaisit kurssi-informaation l�ytyv�n?',
 true,
 1
);

INSERT INTO vaihtoehto (
teksti,
kysymys_id
) VALUES (
'MyNet',
 5);

INSERT INTO vaihtoehto (
teksti,
kysymys_id
) VALUES (
'Excel',
 5);
 
INSERT INTO vaihtoehto (
teksti,
kysymys_id
) VALUES (
'Haaga-Helian sivut',
 5);


INSERT INTO vaihtoehto (
teksti,
kysymys_id
) VALUES (
'Muualta?',
 5);
 
/* Kysymys 6
 * 
 */

INSERT INTO kysymys (
teksti,
monivalinta,
kysely_id
) VALUES (
'Yleinen arvosana t�m�nhetkisest� toimintamallista?',
 false,
 1
);

INSERT INTO vaihtoehto (
teksti,
kysymys_id
) VALUES (
'1',
 6);

INSERT INTO vaihtoehto (
teksti,
kysymys_id
) VALUES (
'2',
 6);
 
 INSERT INTO vaihtoehto (
teksti,
kysymys_id
) VALUES (
'3',
 6);
 
INSERT INTO vaihtoehto (
teksti,
kysymys_id
) VALUES (
'4',
 6);
 
INSERT INTO vaihtoehto (
teksti,
kysymys_id
) VALUES (
'5',
 6);
 
INSERT INTO vaihtoehto (
teksti,
kysymys_id
) VALUES (
'en osaa sanoa',
 6);
 
 