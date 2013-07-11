# Architekturdokumentation

# 1. Einführung und Ziele
Dieser Abschnitt führt in die Aufgabenstellung ein und skizziert die Ziele, die das Team-Projekt 2013 verfolgt.

## 1.1. Aufgabenstellung
Erstellen Sie eine Swing-Anwendung, um eine Kanban-Board zu verwalten. Diese Anwendung soll die grundlegenden Funktionen für den Kanban-Prozess bieten.
Wesentliche Features: 	Create new kanban boards
			Open board
			Save board
			Save as…
			Export to html
			Export backlog to csv, pdf
			Warn user if modifications have not been saved
			Preferences dialog for colors, name of board, columns, wips
			CoS (Fixed date, standard, intagible, expedite)
			Card properties (uuid, headline, description, size, value, created, started, finished)
			Validate on wip limits
			Move cards between adjacent columns
			Full text search backlog and board by headline, description, CoS, size, value
			Store board as xml
			Tests for all major parts of the application
			Edit dialog for card
			Backlogs displays cards in 3 columns grid

# 2. Randbedingungen
Beim Lösungsentwurf sind verschiedene Randbedingungen zu beachten. Dieser Abschnitt stellt sie diese dar.

## 2.1. Technische Randbedingungen
Die Implementierung des Porgammes soll in Java erfolgen.
Die Datenspeicherung erfolgt anhand auf dem System liegender XML Dateien. 
Zur Standartisierung des Programmes wurde das Build-Management Tool "Maven" verwendet. 
Als Layoutgrundlage wurde JGoodies verwendet.


## 2.2. Organisatorische Randbedingungen
Team: Barbara Ploschka, Maxim Moshkov, Lorenz Gaßmann, Malte Tönjes, David Fahr
Zeitplan: Beginn der Entwicklung 01.07.2013, Fertigstellung 14.07.2013 (Gesamtzeit 14 Tage)
Konfigurations- und Versionsverwaltung: GitHub
Entwicklungswerkzeuge: Java-Quelltexte werden in Eclipse oder NetBeans erstellt.
Testwerkzeuge und -prozesse: JUnit

Alle Entscheidungen für die Realisierung des Projektes wurden gemeinsam beschlossen.

## 2.3. Konventionen
Architekturdokumentation: Gliederung nach dem deutschen arc42-Template
Sprache: Im Java-Quelltext werden englische Bezeichner für Klassen, Methoden etc. verwendet.

# 3. Kontextabgrenzung
Dieser Abschnitt stellt das Umfeld vom Team-Projekt 2013 dar. Für welche Benutzer ist es da, und mit welchen Fremdsystemen interagiert es?

## 3.1. Fachlicher Kontext

-> Festlegung aller1 Nachbarsysteme des betrachteten Systems mit Spezifikation aller fachlichen Daten, die mit diesen ausgetauscht werden. Zusätzlich evtl. Datenformate und Protokolle der Kommunikation mit Nachbarsystemen und der Umwelt (falls diese nicht erst bei den spezifischen Bausteinen präzisiert wird.

## 3.2. Technischer Kontext

-> Festlegung der Kanäle zwischen Ihrem System, den Nachbarsystemen und der Umwelt

## 3.3. Externe Schnittstellen

-> 

# 4. Lösungsstrategie

Das Team-Projekt 2013 ist ein Java-Programm mit main-Routine, das grob in folgende Teile zerfällt:
Zugrunde liegt das MVC-Modell

- DAO Package: stellt die Grundlage der zu benutzenden Daten dar. Bsp. einlesen und schreiben in XML Dateien
- Data Package: ##
- Controller Package: wertet Benutzeraktionen aus und agiert entsprechend. Zu jeder View existiert ein Controller
- View Package: enthält alle grafischen Oberflächen die zum Einsatz kommen
- die Anbindung an eine grafische Benutzeroberfläche mittels Swing

# 5. Bausteinsicht
Statische Zerlegung des Systems in Bausteine (Module, Komponenten, Subsysteme, Teilsysteme, Klassen, Interfaces, Pakete, Bibliotheken, Frameworks, Schichten, Partitionen, Tiers, Funktionen, Makros, Operationen, Datenstrukturen...) sowie deren Beziehungen.



Die Klasse "Kanban" beinhaltet die mainfunktion, diese Initialisiert das Hauptfenster zur Programmsteuerung.

Das Interface "View" stellt eine initMethode zu Verfügung um eine JFrame zu initialisieren.

In der Klasse "BacklogView" werden alle Karten angezeigt. Diese referenziert auf den BacklogController.

Die Klasse "BoardView" implementiert die View und erbt von JPanel. Diese beinhaltet das erstellte Board, hier werden die Karten mithilfe des BoardControllers durch drag & drop zwischen den Spalten verschoben.

Die Klasse "BoardPreferencesView" implementiert die View und erbt von JFrame. Diese beinhaltet alle Einstellung zur Erstellung eines Boards. Durch die Referenzierung auf die Klasse "BoardPreferencesController" wird das Board in XML-Tabellenstruktur gespeichert.

Die Klasse "CardCreateView" implementiert die View und erbt von JFrame. Diese beinhaltet alle Komponenten zur Erstellung einer Karte. Durch die Referenzierung auf die Klasse "CardCreateController" wird die Karte in die XML-Tabellenstruktur gespeichert.

Die Klasse "CardEditView" implementiert die View und erbt von JFrame. Diese beinhaltet alle Komponenten zur Editierung einer bereits erstellten Karte. Durch die Referenzierung auf die Klasse "CardEditController" wird die Karte in die XML-Tabellenstruktur geändert.

Die Klasse "CardView" implementiert die View und erbt von JFrame. Diese zeigt einer aus dem Backlog selektierte Karte mit all ihren Parametern und bietet durch die Referenzierung auf den "CardController" diese Karte zu editieren, auf das Board zu verschieben oder diese zu löschen.


# 6. Laufzeitsicht

	-- hier nicht zu gebrauchen, da Grafik benötigt wird --

# 7. Konzepte
Dieser Abschnitt beschreibt allgemeine Strukturen und Aspekte, die systemweit gelten. Darüber hinaus stellt er verschiedene technische Lösungskonzepte vor.

## 7.1 Fachliche Strukturen

## 7.2 Typische Muster und Strukturen

## 7.3. Ausnahme- und Fehlerbehandlung
Exception Handling.

## 7.4. Bedienoberfläche
Grafische Benutzeroberfläche mittels Swing

## 7.5. Ergonomie

## 7.6. Geschäftsregeln

## 7.7. Konfiguration

## 7.8. Logging, Protokollierung
Auftretende Exceptions werden in einer Log File gespeichert.

## 7.9. Management und Administrierbarkeit

## 7.10. Persistenz
Speicherung aller relevanten Daten in XML Dateien.

## 7.11. Plausibilisierung und Validierung

## 7.12. Transaktionsbehandlung