# Architekturdokumentation

# 1. Einführung und Ziele
     Dieser Abschnitt führt in die Aufgabenstellung ein und skizziert die Ziele, die das Team-Projekt 2013 verfolgt.

## 1.1. Aufgabenstellung
        Erstellen Sie eine Swing-Anwendung, um eine Kanban-Board zu verwalten. Diese Anwendung soll die grundlegenden Funktionen für den Kanban-Prozess bieten.
        Wesentliche Features: Create new kanban boards
        - Open board
        - Save board
        - Save as…
        - Export to html
        - Export backlog to csv, pdf
        - Warn user if modifications have not been saved Preferences dialog for colors, name of board, columns, wips
        - CoS (Fixed date, standard, intagible, expedite)
        - Card properties (uuid, headline, description, size, value, created, started, finished)
        - Validate on wip limits
        - Move cards between adjacent columns
        - Full text search backlog and board by headline, description, CoS, size, value
        - Store board as xml
        - Tests for all major parts of the application
        - Edit dialog for card
        - Backlogs displays cards in 3 columns grid

# 2. Randbedingungen
     Beim Lösungsentwurf sind verschiedene Randbedingungen zu beachten. Dieser Abschnitt stellt sie diese dar.

## 2.1. Technische Randbedingungen
        Die Implementierung des Porgammes soll in Java erfolgen.
        Die Datenspeicherung erfolgt anhand auf dem System liegender XML Dateien. 
        Zur Standartisierung des Programmes wurde das Build-Management Tool "Maven" verwendet. 
        Als Layoutgrundlage wurde JGoodies verwendet.

## 2.2. Organisatorische Randbedingungen
        Team: Barbara Ploschka, Maxim Moshkov, Lorenz Gaßmann, Malte Tönjes, David Fahr
        Alle Entscheidungen für die Realisierung des Projektes wurden gemeinsam beschlossen.

#Zeitplan: Beginn der Entwicklung 01.07.2013, Fertigstellung 11.08.2013

#Konfigurations- und Versionsverwaltung: GitHub

#Entwicklungswerkzeuge: Java-Quelltexte werden in Eclipse oder NetBeans erstellt

#Testwerkzeuge und -prozesse: JUnit, Travis CI

## 2.3. Konventionen
        Architekturdokumentation: Gliederung nach dem deutschen arc42-Template
        Sprache: Im Java-Quelltext werden englische Bezeichner für Klassen, Methoden etc. verwendet.

# 3. Kontextabgrenzung
     Dieser Abschnitt stellt das Umfeld vom Team-Projekt 2013 dar. Für welche Benutzer ist es da, und mit welchen Fremdsystemen interagiert es?
     Entfällt, da keine Nachbarsysteme vorhanden.

## 3.1. Fachlicher Kontext
        siehe Diagramme (von Lorenz G. erstellt)

## 3.2. Technischer Kontext
--

## 3.3. Externe Schnittstellen
--

# 4. Lösungsstrategie

     Das Team-Projekt 2013 ist ein Java-Programm mit main-Routine, das grob in folgende Teile zerfällt:
     Zugrunde liegt das MVC-Modell

     - DAO Package: stellt die Grundlage der zu benutzenden Daten dar. Bsp. einlesen und schreiben in XML Dateien
     - Data Package: ##
     - Controller Package: wertet Benutzeraktionen aus und agiert entsprechend. Zu jeder View existiert ein Controller
     - View Package: enthält alle grafischen Oberflächen die zum Einsatz kommen
     - Die Anbindung an eine grafische Benutzeroberfläche mittels Swing

# 5. Bausteinsicht
     Statische Zerlegung des Systems in Bausteine (Module, Komponenten, Klassen, Interfaces, Pakete, Bibliotheken, Frameworks, Schichten,           Funktionen, Datenstrukturen) sowie deren Beziehungen.

     siehe Diagramme (von Lorenz G. erstellt)

# 6. Laufzeitsicht
     siehe Diagramme (von Lorenz G. erstellt)

# 7. Konzepte
     Dieser Abschnitt beschreibt allgemeine Strukturen und Aspekte, die systemweit gelten. Darüber hinaus stellt er verschiedene technische Lösungskonzepte vor.

## 7.1 Fachliche Strukturen

### 7.1.1 Card
          # Attribute:
          - ID: Integer
          - Aufwand: Integer  
          - Beschreibung: String
          - Blocker: Boolean
          - Wert: Integer
          - Created: Date
          - Started: Date
          - Done: Date
          - Headline: String
          - Background: Color

+### 7.1.2 CardController
           Der CardController ist von der klasse Controller und dient zur Kommunikation. 

+### 7.1.3 Controller

## 7.2 Typische Muster und Strukturen

## 7.3. Ausnahme- und Fehlerbehandlung Exception Handling.

## 7.4. Bedienoberfläche
        Grafische Benutzeroberflächen mittels Swing

### 7.4.1 CardView
          Die CardView zeigt die Karten auf der BoardView oder dem Backlog an und bietet die Möglichkeit die Karten zu verändern, zu löschen oder auf dem Board                   hinzuzufügen.

### 7.4.2 CardEditView
          Die Klasse "CardEditView" implementiert die View und erbt von JFrame. Diese beinhaltet alle Komponenten zur Editierung einer bereits erstellten Karte. Wurde
          eine Karte editiert, aber nicht alle Felder ausgefüllt ist die Speicherung nicht möglich. Leere Felder werden rot markieret und es wird eine                            entsprechende Fehlermeldung auf dem Bildschirm ausgegeben. Fehleingaben wie Bsp. die Eingabe von Buchstaben in einem Feld wo Zahlenwerte erwartet werden,               werden durch entsprechende Kontorollalgorithmen abgefangen. Wenn das Fenster während des editierens geschlossen wird, werden alle Änderungen rückgängig                 gemacht und die Karte auf den ursprünglichen Stand zurückgesetzt. Durch die Referenzierung auf die Klasse "CardEditController" wird die Karte in die XML-               Tabellenstruktur geändert. 

### 7.4.3 CardCreateView
          Die Klasse "CardCreateView" implementiert die View und erbt von JFrame. Diese beinhaltet alle Komponenten zur Erstellung einer Karte. Beim Anlegen einer                Karte müssen alle Felder ausgefüllt werden, ansonsten ist eine Speicherung nicht möglich. Felder die nicht ausgefüllt wurden, werden rot markiert und es wird           eine entsprechende Fehlermeldung auf dem Bildschirm ausgegeben. Fehleingaben wie Bsp. die Eingabe von Buchstaben in einem Feld wo Zahlenwerte erwartet                  werden, werden durch entsprechende Kontorollalgorithmen abgefangen. Durch die Referenzierung auf die Klasse "CardCreateController" wird die Karte in die                XML-Tabellenstruktur gespeichert.

### 7.4.4 BoardView
          Die Klasse "BoardView" implementiert die View und erbt von JPanel. Diese beinhaltet das erstellte Board mit den vorher getroffenen Einstellungen und stellt             die vorhandenen Karten in den jeweiligen Spalten da. Darüber hinaus ist es möglich die Karten zwischen den einzelnen Spalten zu verschieben, allerdings                 dürfen Karten nur in eine Richtung verschoben werden.
 
### 7.4.5 BoardPreferencesView
          Die Klasse "BoardPreferencesView" implementiert die View und erbt von JFrame. Hier können sämtliche Einstellungen zur Erstellung eines neuen Boards                     festgelegt werden, wie z.B. die Anzahl und die Namen der Spalten die auf dem neuen Board existieren sollen. Durch die Referenzierung auf die Klasse                     "BoardPreferencesController" wird das Board in XML-Tabellenstruktur gespeichert. 

### 7.4.6 BacklogView
          In der Klasse "BacklogView" werden alle Karten angezeigt.Darüber hinaus verfügt der Backlog über eine Suche und die Möglichkeit Karten nach bestimmten                  Eigenschaften (Creation Time, Value, Size, Headline) sortieren zu lassen. Die Klasse BacklogView referenziert auf den BacklogController.

## 7.5. Ergonomie
        Einsatz einer GUI.

## 7.6. Geschäftsregeln

## 7.7. Konfiguration
        Beim Erstellen eines neuen Boards muss der Benutzer den Namen des zu erstellenden Boards festlegen. Bei den Farben kann nach der Relevanz (entsprechende                Zeitvorgaben) gewählt werden. Als Standart wurde die Farbe "gelb", Expedite"grün", Intangible"rot", Fixed Date"blau" vordefiniert. Der Benutzer hat aber beim           Erstellen des Boards die Möglichkeit, die Farben beliebig zu ändern. Es können höchstens 10 Spalten generiert und maximal 10 Karten für die (wip) gewählt               werden.

## 7.8. Logging, Protokollierung
        Auftretende Exceptions werden in einer Log File gespeichert.

## 7.9. Management und Administrierbarkeit
--

## 7.10. Persistenz
         Speicherung aller Daten in XML Dateien.
         Nachdem ein Board geladen wurde, ist es möglich, dieses als Pdf, Csv oder als HTML zu speichern.
         Ebenso ist es möglich den Backlog mit seinen Cards (Inhalt) als Pdf oder als Csv zu speichern.

## 7.11. Plausibilisierung und Validierung
         Feldeingaben werden durch entsprechende Algorithmen auf Richtigkeit überprüft, bzw. können bsp. in Felder in denen Zahlenwerte gefordert werden, nur                   Zahlenwerte eingegeben werden. Es werden beim Board erstellen überall Eingaben gefordert, wenn dies nicht getan wurde, erscheint eine Fehlermeldung und die             Felder, welche gefüllt werden müssen, werden rot markiert. Wenn eine Card erstellt wird, und eine Texteingabe fehlt, die zwingend notwendig ist, erscheint              eine Fehlermeldung.

## 7.12. Transaktionsbehandlung
--