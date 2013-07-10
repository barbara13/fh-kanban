# Architekturdokumentation

# 1. Einführung und Ziele
Im Rahmen der Veranstaltung "Erstellung eines Informationssystems im Team" haben wir die Aufgabe erhalten, ein KanbanBoard zu erstellen.

## 1.1. Aufgabenstellung

Es soll ein KanbanBoard erstellt werden. Dieses soll neu erstellt werden können, indem man bei den "BoardPreferences" den Boardnamen, es erteilt wird, welche Farben auf dem Board zugelassen sind, es können maximal 10 Spalten erstellt werden. Jede Spalte hat seinen eigenen Spaltennamen, und seine Wip. Sollte der User Eingaben vergessen haben, so wird dieser durch eine Fehlermeldung gewarnt.

Nachdem dieses erstellt wurde, soll es geöffnet und gespeichert werden können. Ebenso soll es als "html" exportiert werden können.

Der Backlog kann als csv oder pdf Datei angezeigt werden. Die Backlogausgabe der Karten soll in drei Columnsgitter angezeigt werden. Ebenso kann der Backlog sortiert werden können nach der Zeit, dem Titel, den Aufwand und dem Wert. Es gibt eine Suchfunktion, indem der Backlog und das Baord durchsucht werden kann.

Alle Eingaben sollen als XML gespeichert werden.

Es ist möglich eine Karten zu erstellen. Hierzu muss der Kartenname, der Aufwand, der Wert, die Farbe sowie die Beschreibung eingetragen werden. Alle Parameter der Karte können editiert werden. Eine erstellte Karte kann gelöscht, editiert oder auf das Board verschoben werden.


# 2. Randbedingungen
Als Softwarearchitektur wurde das "MVC Modell" genutzt. Diese ermöglicht, eine klare Trennung zwischen der Ansicht, dem Modell und den dahinter liegenden Funktionen.

## 2.1. Technische Randbedingungen
Die Programmiersprache "JAVA" wurde benutzt um das Projekt zu realisieren. Die Datenspeicherung erfolgt in einer "XML-Tabellenstruktur". Zur Standartisierung der Software wurde die "Mavenstruktur" verwendet. Als Versionsverwaltung des Projektes wird "GitHub" verwendet. Als Layoutgrundlage wurde JGoodies verwendet.


## 2.2. Organisatorische Randbedingungen

Es gab eine Zeitvorgabe, dass das Projekt in 14 Tagen erstellt werden soll.
Alle Entscheidungen für die Realisierung des Projektes wurde gemeinsam beschlossen.

Um das Programm zu Testen wurde JUnit-Framework verwendet.

## 2.3. Konventionen

Die Aufgaben für die Realisierung des Projektes wurde in der Gruppe aufgeteilt.

# 3. Kontextabgrenzung

Im Bereich der Schnittstellenbereitstellung zu Nachbarsystemen, ist es möglich das Board in "csv" oder "pdf" zu exportieren und diesen bereit zu stellen.

## 3.1. Fachlicher Kontext
## 3.2. Technischer Kontext
## 3.3. Externe Schnittstellen

# 4. Lösungsstrategie

Die komplette Gruppe hat sich zusammen gesetzt und die Aufgaben verteilt. Es wurde gemeinsam überlegt, wie man das Kanban-Projekt am sinnvollsten realisieren kann, und welche der Anforderungen in diesem Projekt am besten zu dem jeweiligen Teammitglied verteilt werden konnte. Jede Klasse, welche angelegt sollte, wurde vorweg im Team besprochen um effizient zu arbeiten.

# 5. Bausteinsicht

Die Klasse "Kanban" beinhaltet die mainfunktion, diese Initialisiert das Hauptfenster zur Programsteuerung.

Das Interface "View" stellt eine initMethode zu Verfügung um eine JFrame zu initialisieren.

In der Klasse "BacklogView" werden alle Karten angezeigt. Diese referenziert auf den BacklogController.

Die Klasse "BoardView" implementiert die View und erbt von JPanel. Diese beinhaltet das erstellte Board, hier werden die Karten mithilfe des BoardControllers durch drag & drop zwischen den Spalten verschoben.

Die Klasse "BoardPreferencesView" implementiert die View und erbt von JFrame. Diese beinhaltet alle Einstellung zur Erstellung eines Boards. Durch die Referenzierung auf die Klasse "BoardPreferencesController" wird das Board in XML-Tabellenstruktur gespeichert.

Die Klasse "CardCreateView" implementiert die View und erbt von JFrame. Diese beinhaltet alle Komponenten zur Erstellung einer Karte. Durch die Referenzierung auf die Klasse "CardCreateController" wird die Karte in die XML-Tabellenstruktur gespeichert.

Die Klasse "CardEditView" implementiert die View und erbt von JFrame. Diese beinhaltet alle Komponenten zur Editierung einer bereits erstellten Karte. Durch die Referenzierung auf die Klasse "CardEditController" wird die Karte in die XML-Tabellenstruktur geändert.

Die Klasse "CardView" implementiert die View und erbt von JFrame. Diese zeigt einer aus dem Backlog selektierte Karte mit all ihren Parametern und bietet durch die Referenzierung auf den "CardController" diese Karte zu editieren, auf das Board zu verschieben oder diese zu löschen.


# 6. Laufzeitsicht

Zunächst wird das Programm gestartet. Da noch kein Board und auch keine Karten ersttellt sind, sollte der Benutzer sich zunächst einen Plan machen, was er mithilfe des Programms verwirklichen möchte. Dazu muss er die Arbeitsschritte kennen, die er dem KanbanBoard in den BoardPreferences erstellt. Hier sollte er bei den Abteilungsschritten nicht zu detailiert sein, da es höchstens 10 Abteilungsschritte geben darf. Nachdem erscheint das erstellte leere Board im BoardTab. Nun sollten die Arbeitsschritte mithilfe der Karten erstellt werden. Bei Erstellung der Karten, muss kleinlichst festgelegt werden, welche Priorität dieser Arbeitsschritt hat. Es sollten mehrere Karten erstellt werden. All diese Karten erscheinen im Backlog. Von dort aus können diese auf das Board verschoben werden. Diese Arbeitsschritte werden auf dem Board durch die Abteilungen abgearbeitet und an die nächste Abteilung weitergereicht. Das Board kann in jedem Zustand exportiert und als pdf oder csv gespeichert werden. Zudem ist es auch möglich, das Board intern zu speichern und zwischen verschiedene Boards zu laden.

# 7. Konzepte
## 7.1 Fachliche Strukturen
## 7.2 Typische Muster und Strukturen
## 7.3. Ausnahme- und Fehlerbehandlung
## 7.4. Bedienoberfläche
## 7.5. Ergonomie
## 7.6. Geschäftsregeln
## 7.7. Konfiguration
## 7.8. Logging, Protokollierung
## 7.9. Management und Administrierbarkeit
## 7.10. Persistenz
## 7.11. Plausibilisierung und Validierung
## 7.12. Transaktionsbehandlung