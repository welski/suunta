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

INSERT INTO
rooli
VALUES
(2,'ROLE_ADMIN'),
(1,'ROLE_USER');
);

INSERT INTO
kayttaja
VALUES
(1,'andromeda','9ad2c637b12b58b58cfec466c87cec4e0d62fbc04e2a5b9e10f65d0c3b91e4bd6c9eeedc98929627'),
(2,'suunta','26c69ab8404e8f4f305be385a9bac79f75f8adcecd7d960252c07086a74758d431ae840493eea83e');

	
INSERT INTO
kayttaja_rooli
VALUES
(1,1,1),
(2,2,2);


 