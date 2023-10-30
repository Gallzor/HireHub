# (Team Naam)
## _(Project Titel)_
### Software Ontwerp Document SL3
##### Studenten:
##### Opleiding:
##### Uitgave:
##### Datum: (dd/mm/jjjj)
##### Versie:
________

## (Inhoudsopgave)
____________
# 1. Introductie
#### Scope
HireHub is een applicatie ontwikkelt door Faissal en Gallyon voor het fictieve bedrijf "HireHub Resources".
De specialisatie van HireHub Resources is HR Recruitment. Hierdoor is er een vraag naar een platform waarbij sollicitanten een profiel kunnen aanmaken en delen met een recruiter.
De recruiter kan vervolgens de profiel aanpassen naar wens. Hierbij is het belangrijk dat de profiel in de huisstijl van HireHub wordt gemaakt. Ook kan de sollicitant de profielen van andere gebruikers zien.
HireHub applicatie is een pilot om te kijken of het plan realistisch is voordat er een multiplatform systeem wordt uitgerold.

#### Overzicht
**Het Fictieve project**: _ontwikkeling van een recruitment applicatie voor de HR Recruitment Company genaamd HireHub Resources “HR”._

Enkele belangrijke aspecten van het project zijn:
* **Zakelijke doelstellingen**: 
_Het fictieve bedrijf "HireHub Resources" wil het proces van HR Recruitment verbeteren. Ze willen een app genaamd "HireHub" ontwikkelen waarmee sollicitanten profielen kunnen maken en delen met recruiters. Het uiteindelijke doel is om deze profielen aan opdrachtgevers te presenteren in de huisstijl van HireHub Resources. Dit zal wervingsprocessen efficiënter maken en op maat gemaakte profielen aanbieden aan opdrachtgevers._
* **Complexiteit**:
_Dit project omvat de ontwikkeling van een Android-app met functies voor profielbeheer. Daarnaast is er een database nodig voor gegevensopslag. De app moet voldoen aan privacy- en beveiligingsnormen vanwege gevoelige informatie_
* **Technologieën**: 
_Dit project maakt gebruik van moderne technologieën, waaronder: De HireHub-app wordt geschreven in de programmeertaal Kotlin voor Android-telefoons. Gegevens worden opgeslagen en beheerd in databases. Er worden beveiligingsmaatregelen geïmplementeerd om gegevens te beschermen en privacy te waarborgen._
___________
# 2. Systeem overview

#### **Zakelijke doelstellingen:** 
Verbeterde HR Recruitment: HireHubs streeft naar verbeteringen in het HR Recruitment-proces om de efficiëntie te verhogen en de werving van geschikte kandidaten te vergemakkelijken.
Betere Profielcreatie: HireHubs streeft ernaar om de creatie en beheer van profielen te verbeteren, waardoor recruiters snel toegang hebben tot relevante informatie.

#### **Doelstelling en functionaliteiten**
Om deze doelstellingen te bereiken, moeten bepaalde functionaliteiten in het systeem worden geïmplementeerd. Dit omvat onder andere zaken zoals profielbeheer, gebruikersbeheer, accountbeheer, database-opslag, gegevensbeveiliging en privacybescherming.

#### **Context van project én stakeholders**
HireHub wordt ontwikkeld in de context van HR Recruitment. Het project moet niet alleen voldoen aan de verwachtingen van sollicitanten en recruiters, maar ook concurreren met andere systemen in de HR-markt. 
De belangrijkste stakeholders zijn de ontwikkelaars, de beoordelende docenten, sollicitanten, recruiters, admins, het managementteam van HireHub Resources en mogelijk derde partijen zoals databasebeheerders en beveiligingsdeskundigen.

![Stakeholder Diagram](https://i.imgur.com/chMAw35.png)

#### **Technische vereisten**
De technische vereisten omvatten zaken zoals de ontwikkeling van een Android-applicatie in Kotlin, databasebeheer voor gegevensopslag en implementatie van beveiligingsmaatregelen voor gegevensbescherming. 
Dit omvat aspecten zoals privacybescherming en gegevensbeveiliging volgens relevante normen zoals ISO 25010.
___________
# 3. Systeemarchitectuur

In ons project voor HireHub resources omvat de systeemarchitectuur componenten zoals het apk bestand, database, gebruikersinterface, admininterface en een recruiterinterface._
We hebben gekozen voor room database vanwege de gebruiksvriendelijkheid en sneller verbinding doordat het lokaal staat. Er is gebruik gemaakt van recyclerviews omdat het op een vlotte manier alle gegevens toont.

Wij hebben de applicatie zo gemaakt dat het eenvoudig is in gebruik. Geen extra rommel of tierelantijntjes. Hierdoor is het voor elke gebruiker duidelijk in gebruik en voor HireHub's recruiters scheelt het tijd.
Door het gebruik van room kan er veel nieuwe gebruikersdata worden verwerkt in piek uren als dat nodig is.

Door het beschermen van bepaalde gebruikers gegevens bij anonieme gebruikers en duidelijke beheerplatformen aan de admin te bieden, zorgt het voor een overzichtelijke gegevens bescherming.
De gegevens zijn bij het aanmaken versleutelt en worden gecontroleerd met opvang van foutmeldingen. De gebruiker kan zijn account verwijderen wanneer dat nodig is wat toebrengt aan de regelmatige beveiligingsaudits.

# 4. Data Design

In ons project, HireHub, hebben we gegevens nodig voor klantprofielen en data voor de CV profielen.
Hiervoor gebruiken we een relationele database voor klantgegevens en een database voor de profielen die de gebruikers aanmaken.
Het is belangrijk dat de gebruiker een profiel kan aanmaken, en de profiel gekoppeld wordt aan de gebruiker.
Verder is het belangrijk dat iedere gebruiker een bepaalde type rol heeft, zoals een sollicitant, recruiter en admin.

![ERD](https://i.imgur.com/uHJJZI9.png)

# 5. Component Design

Componenten van HireHub zijn bijvoorbeeld waar mensen zich registreren, mensen zich inloggen, waar we sollicitanten en profielen beheren, en de database.
Een voorbeeld van hoe deze onderdelen samenwerken is dat het deel waar mensen zich registreren hun informatie verzamelt en bewaart. De delen voor sollicitanten en profielen gebruiken de database om informatie op te slaan en te veranderen. 
Het deel voor profielbeheer laat ons de informatie aanpassen en beslissen wie die kan zien. 

Als we kijken naar het registratiecomponent, moeten we voor technische eisen er voor zorgen dat het in staat is om gebruikersinformatie te verzamelen en op te slaan op een veilige manier. Voor de database moeten we ervoor zorgen dat deze de gegevens van sollicitanten en profielen kan beheren en bijwerken. 
Het profielbeheercomponent moet ons de mogelijkheid bieden om profielen aan te passen en te beheren, en te beslissen wie deze kan zien. 
Elke component heeft zijn eigen technische vereisten om ervoor te zorgen dat HireHub goed functioneert.

# 6. Human Interface Design

Voor de design van de applicatie hebben we een mock-up met wireframes gemaakt. Hierdoor konden wij kijken hoe de gebruiker door applicatie heen gaat.
De mockup en wireframes zijn gemaakt in figma. Er is voor blauw en paarse kleuren gekozen als de huisstijl met een passende achtergrond.
Voor de dag stand is er gekozen voor zwarte tekst met witte blokken en voor de nachtstand is er gekozen voor donkere blokken met witte tekst.

![Mock-ups](https://i.imgur.com/hUf8VJA.png)

De applicatie zou starten met een mooie splashscreen in de huisstijl kleuren en logo.

![Splash screen](https://i.imgur.com/rYomWmU.png)

Het is de bedoeling dat er één homepage of landing page is, waar alle profielen verzameld op een oogopslag toonbaar is. Verder een knop om naar de andere componenten te gaan en een knop voor inloggen en uitloggen.

![Homepage](https://i.imgur.com/78YO077.png)

De inlog pagina moest gemakkelijk naar registratie gaan en omgekeerd. Op de accountpagina moest er een knop zijn om uit te loggen en om de wachtwoord te veranderen.

![Inlog](https://i.imgur.com/dIMrvuH.png)

![Registratie](https://i.imgur.com/eYiw3lZ.png)

De profielen moesten op een gemakkelijke plek worden beheerd door de admin en recruiter en dit geldt ook voor alle gebruikers. 

![Beheerprofiel](https://i.imgur.com/jkMA1NL.png)

Op beide beheer omgevingen moest een item worden aangemaakt, aangepast, verwijdert en de zichtbaarheid moest aanpasbaar zijn.
Voor de gebruiker moest er een mogelijkheid zijn om een profiel aan te maken en in te delen.

![Profielpagina](https://i.imgur.com/2nzSvLL.png)

En de accountpagina te bekijken om gegevens aan te passen.

![Accountpagina](https://i.imgur.com/iIa75af.png)

Zoals het wijzigen van zijn of haar wachtwoord.

![wachtwoord veranderen](https://i.imgur.com/Hc2hzXB.png)

# 7. Requirement Matrix

Voor de applicatie hebben wij meerdere non- en functionele requirements gekozen en gemaakt.
Dit is omdat het als opdracht werd gegeven in de les, maar ook omdat het ons uiteindelijk zal helpen met het uitvoeren van testen.

## De functionele requirements zijn als volgt:

* _Een gebruiker kan een account aanmaken._
* Een gebruiker kan inloggen met zijn gebruikersnaam.
* Een gebruiker kan inloggen met zijn wachtwoord. 
* Een gebruiker heeft een accountpagina.
* Een gebruiker kan een profiel/portfolio van een individuele sollicitant bekijken.
* Een Sollicitant kan zijn wachtwoord wijzigen op de accountpagina.
* Een sollicitant kan zijn account verwijderen.
* Een sollicitant kan uitloggen.
* Een sollicitant kan een profiel/portfolio aanmaken of veranderen.
* Een sollicitant kan zijn profiel/portfolio's zichtbaarheid aanpassen. 
* Een recruiter kan alle bestaande profielen/portfolio's aanpassen of verwijderen.
* Een recruiter kan van alle profielen/portfolio's de zichtbaarheid aanpassen.
* Een admin kan alle accounts bekijken, aanpassen, aanmaken of verwijderen.
* De gegevens worden opgeslagen in een (Firebase/Room) database.
* Alle gebruikers kunnen alle bestaande zichtbare profielen bekijken op de landingspagina.

### En de non-functionele requirements zijn:
Laadtijden van alle profielen op de homepagina moet minimaal zijn.
Het aanmaken van een profiel moet een laagdrempelig zijn voor gebruikers, zodat er in eerste instantie geen hulp-pagina nodig is.
De applicatie heeft een gebruiksvriendelijke interface die gemakkelijk te begrijpen is, voor alle soorten gebruikers.
De app moet compatibel zijn met meerdere Androidversies, schermformaten of resoluties.
De admin heeft een duidelijke dashboard omgeving waarbij de mogelijkheid wordt gegeven om op een vlotte manier data te beheren.
De applicatie moet geen memory-leak veroorzaken wanneer een gebruiker het in pauze zet.
De backend kan een groot aantal gebruiker gegevens verwerken, zodat gebruikers in de toekomst meer dan 1 portfolio kan toevoegen aan zijn/haar account
Gegevens van de gebruiker worden veilig opgeslagen in een Room database, zodat alleen zij met hun eigen gegevens kunnen inloggen.
De applicatie heeft zo veel mogelijk foutmelding pagina's, zodat wanneer er iets fout gaat bij een gebruiker, de gebruiker voldoende wordt geïnformeerd.
De code moet testbaar zijn en er worden voldoende tests uitgevoerd om de kwaliteit te waarborgen.
De code volgt de coding-conventies en vermijd magicnumbers zodat het voor andere developers duidelijke taal is.

Voor de requirements zijn vervolgens User stories gemaakt.
User story 1

| Title:                | Description                                                                                       | Acceptance Criteria                                                                                                                                                                                                                                                                                                                  |  
|-----------------------|---------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Gebruikersnaam kiezen | Als een gebruiker wil ik een gebruikersnaam kunnen kiezen, zodat ik een account kan samenstellen. | - Er moet een knop aanwezig zijn om te registreren. - Er moet een veld aanwezig zijn om de gebruikersnaam in te vullenEen gebruiker kan terug naar de beginpagina.  - De gebruikersnaam wordt gecheckt op duplicaten. - De gebruikersnaam wordt gecheckt op spellingseisen. - De gebruikersnaam wordt gecheckt op beveiligingseisen. | 
                                                                                                                                                                                                                                                                                                                                    |

User story 2

| Title:    |Description        | Acceptance Criteria  |  
|-------------|-----------------|------|
|  | |  | 

User story 3

| Title:    |Description        | Acceptance Criteria  |  
|-------------|-----------------|------|
|  | |  | 


User story 4

| Title:    |Description        | Acceptance Criteria  |  
|-------------|-----------------|------|
|  | |  | 


User story 5

| Title:    |Description        | Acceptance Criteria  |  
|-------------|-----------------|------|
|  | |  | 


User story 6
User story 7
User story 8
User story 9

# 8. Bijlagen
_Optioneel_

