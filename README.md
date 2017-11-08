# suunta
Ohjelmistoprojekti I, feedback-kysely

# Rest API

Versio 0.1
Päivitetty 8.11.2017 (Mikko, Marion)

## Sisältö

1. Resurssit
2. Resurssien esitys JSON-muodossa
3. Resurssien osoitteet/URIt 
4. Resurssien toiminnot

## 1. Resurssit (Resouces)

Resurssi | Selitys
-------- | -------
Kysely | Singleton, yksi Kysely
Kyselyt | Collection, kokoelma Kyselyitä
Kysymys | Singleton, yksi Kysymys
Kysymykset | Collection, kokoelma Kysymyksiä


## 2. Resurssien esitys JSON-muodossa (Resource Representations)



## 3. Resurssien osoitteet/URIt (EndPoints of Resources)

### Kysely
http://proto331.haaga-helia.fi:8080/backend/kyselyt
http://proto331.haaga-helia.fi:8080/backend/kyselyt/{kyselyId}

### Kysymys
http://proto331.haaga-helia.fi:8080/backend/kyselyt/{kyselyId}/kysymykset/
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

# Suunniteludokumentit

* [Käsitekaavio](documents/SWD4TN022-4_Suunta_kasitekaavio.vsdx) *Päivitetty 6.11.2017 (Kaikki)*
* [Luokkakaavio (Java-kaavio)](documents/SWD4TN022-4_Suunta_luokkakaavio.vsdx) *Päivitetty 8.11.2017 (Mikko)*
* [Relaatiokaavio](documents/SWD4TN022-4_Suunta_relaatiokaavio.vsdx) *Päivitetty 6.11.2017 (Kaikki)* !!! vaatii muokkausta