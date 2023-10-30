# README

# Kotlin Mobiel Applicatie gemaakt door:
* _Faissal Koulej_
* _S1184579_
& 
* _Gallyon Rozenkamp_
* _s1181531_

# Gebruikers handleiding voor HireHub

## Inleiding

Beste gebruikers,

HireHub is een applicatie ontwikkelt door Faissal en Gallyon voor het fictieve bedrijf "HireHub Resources".
De specialisatie van HireHub Resources is HR Recruitment. Hierdoor is er een vraag naar een platform waarbij sollicitanten een profiel kunnen aanmaken en delen met een recruiter. 
De recruiter kan vervolgens de profiel aanpassen naar wens. Hierbij is het belangrijk dat de profiel in de huisstijl van HireHub wordt gemaakt. Ook kan de sollicitant de profielen van andere gebruikers zien.
HireHub applicatie is een pilot om te kijken of het plan realistisch is voordat er een multiplatform systeem wordt uitgerold.

## Installatie

Om HireHub op te starten zijn er twee manieren.
1. ### Git + Android Studio
De applicatie opstarten als Android Studio App.
Ga naar de Github Repository van de HireHub Project.

![Repository](https://i.imgur.com/1jQX3Yc.png)

Klik daarna op de groene "Code" knop, er opent een scherm. Klik met de muis op de HTTPS link, of het kopieer knopje.

![HTTP link](https://i.imgur.com/uIRX8sa.png)

Sluit de Github af en open Android Studio.
Klik op de knop rechts bovenin genaamd "Get from VCS",

![VCS](https://i.imgur.com/0618hI2.png)

En plak de link in de URL: vakje. Kies daarna de map waar je de repository in wilt opslaan.
![Url Plak](https://i.imgur.com/5mXOb0B.png)

Vervolgens druk je op de blauwe knop: "Clone"
Wacht nu rustig tot Android Studio de Repository van Git heeft opgehaald.
Als het klaar is, klik dan rechtsbovenin op het blauwe olifantje om Gradle te laten bouwen.
![Gradle sync](https://i.imgur.com/9jOaCue.png)

Gradle zal even zijn tijd nemen met het syncen van alle bestanden.

![Gradle build](https://i.imgur.com/xu5qu5d.png)

Hierna ga je naar Build -> Make Project

![Make Project](https://i.imgur.com/mpTR82z.png)

Als het builden klaar is, dan klik je op het groene pijltje "Build"

![Make Project](https://i.imgur.com/7X05Ekj.png)

Er zal worden gevraagd of je het project vertrouwd. Klik op "Trust Project!"

![Make Project](https://i.imgur.com/DzuisDj.png)

Daarna zie je rechtsonderin dat Android studio op de achtergrond het project aan het verwerken is.
Het kan ook zijn dat Windows Firewall vraagt of je toegang wilt geven tot het project. Mocht dat zo zijn, selecteer "Geef Toegang" of "Allow Acces"
Als het goed is opent er dan een mobiele weergave in het tabje "Runnin devices", met de applicatie gaande.

![Running Devices](https://i.imgur.com/Zs8nhXF.png)

Je kunt nu in de Emulator de applicatie bekijken!

2. ### APK + VM/Mobiel(Android)
(...Vul in/maak af als duidelijk is hoe installatie met APK gaat)

APK, kort voor Android Package Kit, is het bestandsformaat dat Android gebruikt om apps te verdelen of installeren.
Door de APK kan de applicatie op een mobiel worden geopend zonder bijvoorbeeld Google Play Store.

Zet het APK bestand over naar een android mobiel in kwestie via een USB kabel of een cloud, zoals Google drive. 
Zet "Accepteer installaties van buiten af" of "Allow installation from unknown sources" aan.

## Gebruik
Na de installatie en het starten van de applicatie kunnen de functies van HireHub worden gebruikt.
De applicatie heeft twee thema's: Een nacht en dag stand. Afhankelijk van hoe de installatie is gedaan en op welke "Virtual Machine"
de applicatie wordt getoond, kunnen de kleuren verschillen.
Voor de rest van de uitleg zal voor context de voorbeelden van de applicatie in dag-stand zijn.

#### Home
Als eerste kom je op de begin pagina terecht, waar alle profielen van de gebruikers worden getoond.
Er kan op iedere profiel worden geklikt en de gegevens van de profiel zijn te zien.
Een anonieme gebruiker zal niet de telefoonnummers en email van de gebruikers zien. Hiervoor moet de anonieme bezoeker eerst inloggen.
Voor de ongeregistreerde gebruiker is er maar 1 knop beschikbaar in het onderste menu: De homepage knop.
Ook is er een account-knop in de rechter bovenhoek aanwezig. Hier kan een anonieme gebruiker inloggen of zich registreren.
Als de gebruiker al is ingelogd dan wordt de gebruiker via de knop doorgestuurd naar zijn accountpagina.

![Homepage anoniem](https://i.imgur.com/ORSzb0F.png)

Als een gebruiker is ingelogd, dan zal het menu aan de onderkant veranderen en er een profielknop aan de rechterkant bijkomen.
Als een recruiter is ingelogd, dan zal het menu aan de onderkant veranderen en er een profiel overzicht aan de rechterkant bijkomen.

![Homepage Gebruiker en recruiter](https://i.imgur.com/3CUy80w.png)

Als een admin is ingelogd, dan zal het menu aan de onderkant veranderen en er in het midden een gebruiker overzicht komen met een profiel overzicht aan de rechterkant erbij.

![homepage admin](https://i.imgur.com/4s5IuM4.png)


#### Accountpagina
...Vul in als af is

#### Profiel gebruiker
Als de gebruiker is ingelogd dan kan de gebruiker via de profielknop rechtsonderin op de homepagina menu naar zijn profiel pagina gaan.
Hier kan de gebruiker zijn profiel bekijken. Als er nog geen profiel is, dan kan de gebruiker een profiel aanmaken met de "New Profile" knop.
Vervolgens kan de gebruiker zijn profiel invullen en opslaan met de "Save" knop.

![aangemaakte profiel](https://i.imgur.com/LjZJiaZ.png)

De gebruiker kan zijn profiel details bekijken door op de profiel te klikken. De gegevens zijn aanpasbaar en ook weer op te slaan met een "Save" knop.

![profiel aanpassen](https://i.imgur.com/5itdzcu.png)

De profiel kan verwijdert worden met de emmer knop en de gebruiker kan zijn profiel (on)zichtbaar maken met de oog knop.
Met de "Back" knop kan de gebruiker een stap terug.

####  Profielen beheer
Als een admin of recruiter is ingelogd, dan hebben zij beide een overzicht op alle profielen. Zij kunnen de profielen bekijken, aanpassen, verwijderen en de zichtbaarheid veranderen.
Op elk profiel kan worden gedrukt om de gegevens aan te passen.

![profiel beheer](https://i.imgur.com/tbFk6yR.png)

Zij kunnen beide een nieuw profiel aanmaken door de "New profile" knop aan te klikken. Als er dan gegevens worden ingevuld en op de "Save" knop wordt gedrukt, dan is er een aangemaakt.
Met de "Back" knop kan de admin of recruiter een stap terug.
#### Gebruiker beheer
Als een admin is ingelogd, dan heeft hij een overzicht op alle gebruikers. De admin kan de gebruikers bekijken, aanpassen, verwijderen en de zichtbaarheid veranderen.
Op elke gebruiker kan worden gedrukt om de gegevens aan te passen.

![user beheer](https://i.imgur.com/nyeroBU.png)

De admin kan een nieuw profiel aanmaken door de "New User" knop aan te klikken. Als er dan gegevens worden ingevuld en op de "Save" knop wordt gedrukt, dan is er een aangemaakt.
Met de "Back" knop kan de admin een stap terug.

## Rechten
Om een bepaalde type en rol te simuleren is er aan de database een paar voorafgemaakte fictieve gebruikers toegevoegd.
3 Gebruikers voor iedere rol en een handje vol sollicitanten om de pagina's te vullen.
Met deze rollen kan worden ingelogd en de verschillende rechten kan dan worden getest.

De drie rollen zijn als volgt:

| Username    | Password        | Role |  
|-------------|-----------------|------|
| KopjeKoffie | Sollicitant1324 | SOL  | 
| PindaReep   | Recruiter1234   | REC  | 
| Kauwgumpje  | Admin1234       | AD   |

## Gebruiker/Sollicitant
De gebruiker staat bekend in de applicatie als "SOL" of "Sol", een afkorting voor Sollicitant.
## Recruiter
De recruiter staat bekend in de applicatie als "REC" of "Rec", een afkorting voor Recruiter.
## Admin
Een admin staat bekend in de applicatie als "AD" of "Ad", een afkorting voor Admin.

## Comply or complain

#### Profiel opbouw
Omdat er in de eindopdracht niet helder is omschreven hoeveel data er in een profiel moet staan,
is er door de ontwikkelaars gekozen voor een paar basis gegevens. Door de docenten is dit mondeling in de klaslokalen goedgekeurd.
De gegevens in de profielen hoeven dus niet aan een officieel CV of portfolio te voldoen. 
Hierdoor is er ook gekozen om niet met profiel plaatjes te werken, omdat een CV meestal eentonig is.

