# De Appartners
## _HireHub_
### Software Ontwerp Document SL3
##### Studenten:
* _Faissal Koulej_
* _S1184579_
  &
* _Gallyon Rozenkamp_
* _s1181531_
##### Opleiding:
Windesheim Software Developer
##### Uitgave:
1
##### Datum:
30-10-2023
##### Versie:
2
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

Wij hebben een paar diagrammen gemaakt die een beeld geven van hoe de componenten met elkaar of de gebruiker werken:

Componenten voor anonieme gebruikers:

![Use case 1 anoniem](https://i.imgur.com/QgENlio.png)

Componenten voor ingelogde gebruikers/sollicitanten:

![Use case 1 sollicitant](https://i.imgur.com/kV99SFE.png)

Componenten voor recruiters:

![Use case 1 recruiter](https://i.imgur.com/x4fYFHx.png)

Componenten voor admins:

![Use case 1 admin](https://i.imgur.com/cUdvHXo.png)

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
* Laadtijden van alle profielen op de homepagina moet minimaal zijn.
* Het aanmaken van een profiel moet een laagdrempelig zijn voor gebruikers, zodat er in eerste instantie geen hulp-pagina nodig is.
* De applicatie heeft een gebruiksvriendelijke interface die gemakkelijk te begrijpen is, voor alle soorten gebruikers.
* De app moet compatibel zijn met meerdere Androidversies, schermformaten of resoluties.
* De admin heeft een duidelijke dashboard omgeving waarbij de mogelijkheid wordt gegeven om op een vlotte manier data te beheren.
* De applicatie moet geen memory-leak veroorzaken wanneer een gebruiker het in pauze zet.
* De backend kan een groot aantal gebruiker gegevens verwerken, zodat gebruikers in de toekomst meer dan 1 portfolio kan toevoegen aan zijn/haar account
* Gegevens van de gebruiker worden veilig opgeslagen in een Room database, zodat alleen zij met hun eigen gegevens kunnen inloggen.
* De applicatie heeft zo veel mogelijk foutmelding pagina's, zodat wanneer er iets fout gaat bij een gebruiker, de gebruiker voldoende wordt geïnformeerd.
* De code moet testbaar zijn en er worden voldoende tests uitgevoerd om de kwaliteit te waarborgen.
* De code volgt de coding-conventies en vermijd magicnumbers zodat het voor andere developers duidelijke taal is.

Voor de requirements zijn vervolgens User stories gemaakt.
User story 1

| Title:                | Description                                                                                       | Acceptance Criteria                                                                                                                                                                                                                                                                                                                      |  
|-----------------------|---------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Gebruikersnaam kiezen | Als een gebruiker wil ik een gebruikersnaam kunnen kiezen, zodat ik een account kan samenstellen. | - Er moet een knop aanwezig zijn om te registreren. - Er moet een veld aanwezig zijn om de gebruikersnaam in te vullen. - Een gebruiker kan terug naar de beginpagina.  - De gebruikersnaam wordt gecheckt op duplicaten. - De gebruikersnaam wordt gecheckt op spellingseisen. - De gebruikersnaam wordt gecheckt op beveiligingseisen. | 
|

User story 2

| Title:    |Description        | Acceptance Criteria                                                                                                                                                                                                                                                         |  
|-------------|-----------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Wachtwoord kiezen  |Als een gebruiker wil ik een wachtwoord kunnen kiezen, zodat ik een account kan samenstellen.  | - Er moet een knop aanwezig zijn om te registreren. - Er moet een veld aanwezig zijn om een wachtwoord in te vullen. - Een gebruiker kan terug naar de beginpagina. - Het wachtwoord wordt gecheckt op spellingseisen. - Het wachtwoord wordt gecheckt op beveiligingseisen | 

User story 3

| Title:    |Description        | Acceptance Criteria                                                                                                                                                                                                                                                                                                                                                                                          |  
|-------------|-----------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
|Account aanmaken   | Als een gebruiker wil ik een account hebben, zodat ik mijn gegevens kan beheren. | Er is een knop op de registratie pagina om de gegevens op te slaan. - Na het invullen en goedkeuring van de gegevens wordt de gebruiker na het klikken van de knop doorgestuurd naar de beginpagina. - Na het klikken worden de gegevens opgeslagen en de gebruiker ingelogd. - De gebruiker kan naar zijn accountpagina om de gegevens te bekijken. - De gebruiker wordt na de registratie een sollicitant. | 


User story 4

| Title:    |Description        | Acceptance Criteria                                                                                                                                                                                                                                                                                                                                                                                                                             |  
|-------------|-----------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Login  |Als gebruiker wil ik graag kunnen inloggen, zodat ik de applicatie kan gebruiken wanneer ik dat wil.  | Er is een knop om in te loggen zichtbaar op de homepagina. - Er is een invulveld beschikbaar op de inlog pagina waar het wachtwoord kan worden ingevuld. - Na het invullen van de gegevens wordt er gecheckt of ze bij elkaar horen in het systeem. - Na het invullen van de gegevens wordt er gecheckt of de gebruiker bestaat in de database. - De gebruiker krijgt een melding als er na het invullen van zijn gegevens iets is fout gegaan. | 


User story 5

| Title:    |Description        | Acceptance Criteria                                                                                                                                                                                                                                                         |  
|-------------|-----------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
|  Login, gebruikersnaam |Als gebruiker wil ik graag kunnen inloggen met een gebruikersnaam, zodat ik de applicatie kan gebruiken wanneer ik dat wil.  | Er is een invulveld beschikbaar op de inlog pagina waar de gebruikersnaam kan worden ingevuld. - Na het invullen van de gebruikersnaam wordt er gecheckt of er een correcte gebruikersnaam is ingevuld. - Er wordt gecontroleerd of de gebruikersnaam aan de eisen voldoet. | 


User story 6

| Title:    |Description        | Acceptance Criteria                                                                                                                                                                                                                                            |  
|-------------|-----------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
|Login, wachtwoord   |Als gebruiker wil ik graag kunnen inloggen met een wachtwoord, zodat ik de applicatie kan gebruiken wanneer ik dat wil.  | Er is een invulveld beschikbaar op de inlog pagina waar het wachtwoord kan worden ingevuld. - Na het invullen van een wachtwoord, wordt er gecheckt of er een correct wachtwoord is ingevuld. - Er wordt gecontroleerd of het wachtwoord aan de eisen voldoet. | 

User story 7

| Title:    |Description        | Acceptance Criteria                                                                                                                                                                                                                                       |  
|-------------|-----------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
|Profiel aanmaken   | Als gebruiker wil ik een profiel kunnen aanmaken, zodat de recruiter mij kan koppelen aan een bedrijf. | Er moet een knop zijn om de profielen aan te maken. - Er is voor elk stuk informatie een invul veld. - Voor elk ingevuld veld is er een opslaan knop. - Er is een knop om een profiel te verwijderen. - De gebruiker kan een plaatje kiezen of aanpassen. | 

User story 8

| Title:    |Description        | Acceptance Criteria                                                                                                                                                                                                                                                                                                                                                                                        |  
|-------------|-----------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
|Dashboard Profielen   |Als recruiter wil ik graag alle profielen kunnen bekijken en aanpassen, zodat ik de sollicitanten kan helpen met het vinden van een baan.  | Er moet een pagina zijn waarin de profielen zichtbaar worden. - Er is een knop waarbij een profiel kan worden toegevoegd. - Er is een knop waarbij een profiel kan worden aangepast. - Er is een knop waarbij een profiel kan worden verwijdert. - Er is een knop waarbij een profiel kan worden bekeken. - De gebruiker van het profiel krijgt een melding wanneer er iets wordt aangepast of verwijdert. | 

User story 9

| Title:    |Description        | Acceptance Criteria                                                                                                                                                                                                                                                                                                                                                          |  
|-------------|-----------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Dashboard Accounts  |Als admin wil ik graag alle accounts kunnen bewerken of verwijderen, zodat ik het databeheer op orde kan houden.  | Er is een knop een gebruiker aan te passen. - Er is een knop om een gebruiker te verwijderen. - Er is een knop om een gebruiker aan te maken. - Er is een knop om een gebruikers account te bekijken. - Er is een knop om een gebruiker tijdelijk te blokkeren. - De admin kan terug naar de beginpagina. - De admin kan alle accounts in een lijst overzichtelijk bekijken. | 

User story 10

| Title:    |Description        | Acceptance Criteria                                                                                                                                                                                                                             |  
|-------------|-----------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Account verwijderen (Gebruiker)  | Als gebruiker wil ik mijn account kunnen verwijderen, zodat er geen gegevens achterblijven wanneer ik stop met het gebruik van de app. | Er moet een knop aanwezig zijn om mijn account te verwijderen. - Er wordt een bevestiging melding met een pop-up getoond wanneer er op de knop wordt gedrukt. - Wanneer een admin de gebruiker verwijdert, dan krijgt de gebruiker een melding. | 

User story 11

| Title:    |Description        | Acceptance Criteria                                                                                                                                                                                                                            |  
|-------------|-----------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
|Account verwijderen (Admin)   |Als admin wil ik een account kunnen verwijderen, zodat er geen gegevens achterblijven van de gebruiker die verwijderd is.  | Er moet een knop aanwezig zijn om een account te verwijderen. - Er wordt een bevestiging melding met een pop-up getoond wanneer er op de knop wordt gedrukt. - Wanneer een admin de gebruiker verwijdert, dan krijgt de gebruiker een melding. | 

User story 12

| Title:    |Description        | Acceptance Criteria                                                                                                                                                                                                                                   |  
|-------------|-----------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
|Profielen overzicht   |Als gebruiker wil ik alle profielen bekijken, zodat ik ze kan vergelijken en informatie kan vergaren.  | Een gebruiker kan op een individueel profiel klikken om het te bekijken. - Een gebruiker kan alle profielen in een lijst overzichtelijk bekijken. - De profielplaatjes van de profielen zijn zichtbaar. - Informatie van de profielen zijn zichtbaar. | 

User story 13

| Title:    |Description        | Acceptance Criteria                                                                                                                                                                                            |  
|-------------|-----------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Individuele profiel bekijken  | Als gebruiker wil ik een profiel van een sollicitant bekijken, zodat ik weet wat zijn kwaliteiten zijn. | Er moet een pagina zijn waarin alle profielen zitten. - Er moet een mogelijkheid zijn om op de profielen te kunnen klikken. - Er moet een mogelijkheid zijn om de profielen te kunnen bekijken na het klikken. | 

User story 15

| Title:    |Description        | Acceptance Criteria                                                                                                           |  
|-------------|-----------------|-------------------------------------------------------------------------------------------------------------------------------|
| Uitloggen  | Als gebruiker wil ik dat ik kan uitloggen, zodat ik de applicatie als anoniem kan bekijken. | Er is een knop op de accountpagina om uit te loggen. - De gebruiker krijgt een bevestiging melding na het klikken van de knop | 

User story 16

| Title:    |Description        | Acceptance Criteria                                                                                                                                                                                                                                                                                                                                                                                                                                                                    |  
|-------------|-----------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Profiel aanpassen  | Als gebruiker of recruiter wil ik een profiel aanpassen, zodat ik het kan verbeteren voordat het wordt opgestuurd naar een bedrijf. | Als er op de knop aanpassen wordt gedrukt vanuit de dashboard of profiel pagina, dan kan het profiel worden aangepast. - Na het klikken op de aanpassen knop wordt er doorgestuurd naar het aanpas profiel pagina. - Voor elke gegeven is er een invulveld met het huidige gegeven aangetoond. - Elk gegeven kan individueel worden aangepast. - Er is een knop om een aangepast veld op te slaan. - Na het klikken op de opslaan knop wordt er gecheckt of een veld goed is ingevuld. | 

User story 17

| Title:    |Description        | Acceptance Criteria                                                                                                                                                                                                                                                        |  
|-------------|-----------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Profiel verwijderen (Recruiter)  | Als recruiter wil ik een profiel kunnen verwijderen, zodat er geen gegevens achterblijven. | Er moet een knop aanwezig zijn om een profiel te verwijderen op de recruiter dashboard. - Er wordt een bevestiging melding met een pop-up getoond wanneer er op de knop wordt gedrukt. - Wanneer de recruiter een profiel verwijdert, dan krijgt de gebruiker een melding. | 

User story 18

| Title:    |Description        | Acceptance Criteria                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   |  
|-------------|-----------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Accountpagina  |Als gebruiker wil ik mijn gegevens kunnen beheren op een plek, zodat ik kan aanpassen of verwijderen wanneer nodig.  | Er is een knop op de pagina's waar ik op kan klikken om naar de accountpagina te gaan. - De accountpagina bevat al mijn gegevens. - Er zijn meerdere knoppen om al mijn gegevens te kunnen inzien. - Ik kan al mijn gegevens aanpassen. - Er zijn invulvelden met het huidige gegeven om aan te passen. - Na het invullen van het invulveld kunnen de nieuwe gegevens worden opgeslagen met een opslaan knop. - Er komt een bevestiging pagina na het klikken op de opslaan knop. - Ik kan al mijn gegevens verwijderen met een knop. - Ik kan mijn account verwijderen met een knop. | 

User story 19

| Title:    |Description        | Acceptance Criteria                                                                                                                                                                                                                                                                                                                                                                                         |  
|-------------|-----------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
|Profiel zichtbaarheid   |Als sollicitant of recruiter wil ik de zichtbaarheid van mijn profiel kunnen aanpassen, zodat ik privacy kan behouden.  | Er is een knop aanwezig op mijn profiel pagina om de zichtbaarheid aan of uit te zetten. - Er is een knop aanwezig op de recruiter dashboard op alle profielen om de zichtbaarheid van een profiel aan of uit te zetten. - De profielen die worden getoond op de beginpagina worden gesorteerd op zichtbaarheid. - Er wordt een bevestiging melding gestuurd als er op de zichtbaarheid knop wordt gedrukt. | 


# 8. Bijlagen
* [Requirement bestand met User Stories](https://liveadminwindesheim.sharepoint.com/:w:/r/sites/O365-DeAppartners/Gedeelde%20documenten/General/SL3/Requirements.docx?d=w07c72e4ff6114baea3d968c125927f21&csf=1&web=1&e=ITdL3j)
* [Figma met Wireframes, Design en Use Cases](https://www.figma.com/file/mA4CJnph0LpLMlgcGTUEn4/Nav-Graph-SL3?type=design&node-id=0%3A1&mode=design&t=AtKw31JeMXiWsxmy-1)
