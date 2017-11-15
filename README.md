# suunta
Ohjelmistoprojekti I, feedback-kysely


## Suunniteludokumentit

* [Käsitekaavio](documents/SWD4TN022-4_Suunta_kasitekaavio.vsdx) *Päivitetty 6.11.2017 (Kaikki)*
* [Luokkakaavio (Java-kaavio)](documents/SWD4TN022-4_Suunta_luokkakaavio.vsdx) *Päivitetty 15.11.2017 (Marion)*
* [Relaatiokaavio](documents/SWD4TN022-4_Suunta_relaatiokaavio.vsdx) *Päivitetty 8.11.2017 (Mikko)*

## Sprint 1
[Backlog](documents/Suunta_Sprint1_Backlog.xlsx) *Päivitetty 15.11.2017 (Mikko)*

# Rest API

Versio 0.2
Päivitetty 15.11.2017 (Mikko)



## Sisältö

[1. Resurssit](https://github.com/welski/suunta#1-resurssit-resouces)<br/>
[2. Resurssien esitys JSON-muodossa](https://github.com/welski/suunta#2-resurssien-esitys-json-muodossa-resource-representations)<br/>
[3. Resurssien osoitteet/URIt](https://github.com/welski/suunta#3-resurssien-osoitteeturit-endpoints-of-resources)<br/>
[4. Resurssien toiminnot](https://github.com/welski/suunta#4-resurssien-toiminnot-actions-of-resources)<br/>

## 1. Resurssit (Resouces)

Resurssi | Selitys
-------- | -------
Kysely | Singleton, yksi Kysely
Kyselyt | Collection, kokoelma Kyselyitä
Kysymys | Singleton, yksi Kysymys
Kysymykset | Collection, kokoelma Kysymyksiä


## 2. Resurssien esitys JSON-muodossa (Resource Representations)

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


## 3. Resurssien osoitteet/URIt (EndPoints of Resources)

### Kysely
http://proto331.haaga-helia.fi:8080/backend/kyselyt<br/>
http://proto331.haaga-helia.fi:8080/backend/kyselyt/{kyselyId}

### Kysymys
http://proto331.haaga-helia.fi:8080/backend/kyselyt/{kyselyId}/kysymykset/<br/>
http://proto331.haaga-helia.fi:8080/backend/kyselyt/{kyselyId}/kysymykset/{kysymysId}


## 4. Resurssien toiminnot (Actions of Resources)

Http-pyyntö | Resurssin osoite (EndPoint) | Input | Onnistunut vastaus (Success Response) | Virhevastaus (Error Response) | Selitys
----------- | --------------------------- | ----- | ------------------------------------- | ----------------------------- | -------
GET | /kyselyt| Body: tyhjä | Status: 200<br/>Body: Lista Kyselyistä | Status: 500 | Hakee kaikkien Kyselyiden nimen ja kuvauksen
POST | /kyselyt | - | - | Status: 400 | Toiminto ei käytössä
PUT | /kyselyt | - | - | Status: 400 | Toiminto ei käytössä
DELETE | /kyselyt | - | - | Status: 400 | Toiminto ei käytössä
GET | /kysymykset/{kyselyId} | Body: tyhjä | Status: 200<br/>Body: Lista kysymyksistä| Status: 500 | Hakee tietyn kyselyn kaikki kysymykset
POST | /kysymykset/{kyselyId} | - | - | Status: 400 | Toiminto ei käytössä
PUT | /kysymykset/{kyselyId} | - | - | Status: 400 | Toiminto ei käytössä
DELETE | /kysymykset/{kyselyId} | - | - | Status: 400 | Toiminto ei käytössä
GET | /kysymykset/{kysymysId} | Body: tyhjä | Status: 200<br/>Body: Yhden kysymyksen tiedot | Status: 500 | Hakee tietyn kysymyksen tiedot
POST | /kysymykset/{kysymysId} | - | - | Status: 400 | Toiminto ei käytössä
PUT | /kysymykset/{kysymysId} | - | - | Status: 400 | Toiminto ei käytössä
DELETE | /kysymykset/{kysymysId} | - | - | Status: 400 | Toiminto ei käytössä
