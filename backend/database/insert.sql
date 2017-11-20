INSERT INTO kysely (
nimi,
kuvaus
) VALUES (
'Esimerkkikysely 1',
'Kyselyn kuvaus.');


INSERT INTO kysymys (
teksti,
monivalinta,
kysely_id
) VALUES (
'Mitk‰ olivat 3 t‰rkeint‰ asiaa jotka opit ohjelmistoprojektin kurssilta?',
 true,
 1
);

INSERT INTO kysymys (
teksti,
monivalinta,
kysely_id
) VALUES (
'Kuvaile kurssin onnistumista omin sanoin',
 false,
 1
);


INSERT INTO vaihtoehto (
teksti,
kysymys_id
) VALUES (
'MyNetist‰',
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
'Opinto-oppasta',
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
 3);

INSERT INTO vaihtoehto (
teksti,
kysymys_id
) VALUES (
'Omena',
 3);

 
INSERT INTO vastaus (
teksti,
kysymys_id
) VALUES (
'Kaikki meni hyvin ja oli mukavaa',
2
);

INSERT INTO vastaus (
teksti,
kysymys_id
) VALUES (
'MyNetist‰',
1
);

INSERT INTO vastaus (
teksti,
kysymys_id
) VALUES (
'Kaverilta',
1
);

INSERT INTO vastaus (
teksti,
kysymys_id
) VALUES (
'MyNetist‰',
1
);
INSERT INTO vastaus (
teksti,
kysymys_id
) VALUES (
'MyNetist‰',
1
);
INSERT INTO vastaus (
teksti,
kysymys_id
) VALUES (
'Opinto-oppaasta',
1
);


INSERT INTO vastaus (
teksti,
kysymys_id
) VALUES (
'Omena',
3
);
INSERT INTO vastaus (
teksti,
kysymys_id
) VALUES (
'Omena',
3
);
INSERT INTO vastaus (
teksti,
kysymys_id
) VALUES (
'Omena',
3
);


INSERT INTO vastaus (
teksti,
kysymys_id
) VALUES (
'P‰‰ryn‰',
3
);

INSERT INTO vastaus (
teksti,
kysymys_id
) VALUES (
'Banaani',
3
);
INSERT INTO vastaus (
teksti,
kysymys_id
) VALUES (
'Banaani',
3
);


 