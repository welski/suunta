# suunta
Ohjelmistoprojekti I, feedback-kysely


## Suunniteludokumentit

* [Käsitekaavio](documents/SWD4TN022-4_Suunta_kasitekaavio.vsdx) *Päivitetty 20.11.2017 (Kaikki)*
* [Luokkakaavio (Java-kaavio)](documents/SWD4TN022-4_Suunta_luokkakaavio.vsdx) *Päivitetty 27.11.2017 (Kaikki)*
* [Relaatiokaavio](documents/SWD4TN022-4_Suunta_relaatiokaavio.vsdx) *Päivitetty 20.11.2017 (Kaikki)*

## Sprint 1
[Backlog](documents/Suunta_Sprint1_Backlog.xlsx) *Päivitetty 28.11.2017 (Mikko)*

# Rest API

Versio 0.5
Päivitetty 27.11.2017 (Mikko)

## Sisältö

[1. Kaikki kyselyt](https://github.com/welski/suunta#kaikki-kyselyt)<br/>
[2. Yksi kysely](https://github.com/welski/suunta#yksi-kysely)<br/>
[3. Yhden kyselyn kaikki kysymykset](https://github.com/welski/suunta#yhden-kyselyn-kaikki-kysymykset)<br/>
[4. Yhden kyselyn yksi kysymys](https://github.com/welski/suunta#yhden-kyselyn-yksi-kysymys)<br/>
[5. Yhden kyselyn kaikkien kysymysten vastausten tallentaminen](https://github.com/welski/suunta#yhden-kyselyn-kaikkien-kysymysten-vastausten-tallentaminen)

### Kaikki kyselyt
API-osoite: http://proto331.haaga-helia.fi:8080/backend/kyselyt

Metodi: GET

Vastaus:
```
[
  {
	"id": 1,
	"nimi": "Kurssipalaute kurssilta SWD4TN022-5",
	"kuvaus": "Anna kurssipalautetta opettajalle kurssilta SWD4TN022-5 vastaamalla annettuihin kysymyksiin.",
	"kysymykset": [] *Tämä pitäisi ehkä poistaa?*
  },
	"id": 2,
	"nimi": "Esimerkkikysely vihanneksista",
	"kuvaus": "Tämä toimii esimerkkinä",
	"kysymykset": [] *Tämä pitäisi ehkä poistaa?*
  }
]
```

### Yksi kysely
API-osoite: http://proto331.haaga-helia.fi:8080/backend/kyselyt/{kyselyId}

Metodi: GET

Vastaus:
```
{
	"id": 2,
	"nimi": "Esimerkkikysely vihanneksista",
	"kuvaus": "Tämä toimii esimerkkinä",
	"kysymykset": [] *Tämä pitäisi ehkä poistaa?*
}

```

### Yhden kyselyn kaikki kysymykset
API-osoite: http://proto331.haaga-helia.fi:8080/backend/kyselyt/{kyselyId}/kysymykset

Metodi: GET

Vastaus:
```
[
  {
	"id": 5,
	"teksti": "Tämä on monivalintakysymys",
	"monivalinta": true,
	"vaihtoehdot": 
	[
	  {
		"id": 4,
		"teksti": "Päärynä"
	  },
	  {
		"id": 5,
		"teksti": "Omena"
	  }
	]
  },
  {
	"id": 6,
	"teksti": "Tämä on tekstikysymys"
  }
]
```

### Yhden kyselyn yksi kysymys
API-osoite: http://proto331.haaga-helia.fi:8080/backend/kyselyt/{kyselyId}/kysymykset/{kysymysId}

Metodi: GET

Vastaus:
```
{
	"id": 5,
	"teksti": "Tämä on monivalintakysymys",
	"monivalinta": true,
	"vaihtoehdot":
	[
	  {
	    "id": 4,
		"teksti": "Päärynä"
	  },
	  {
	    "id": 5,
		"teksti": "Omena"
	  }
	]
}

```

### Yhden kyselyn kaikkien kysymysten vastausten tallentaminen
API-osoite: http://proto331.haaga-helia.fi:8080/backend/kyselyt/{kyselyId}/vastaukset

Metodi: POST

Pyyntö:

```
[
	{
		"teksti" : "MyNet",
		"kysymysId" : 0
	},
	{
		"teksti" : "Google",
		"kysymysId" : 1
		}
	
]
```

Vastaus:
```
[
    {
        "id": 8,
        "teksti": "MyNet"
    },
    {
        "id": 9,
        "teksti": "Google"
    }
]
```
