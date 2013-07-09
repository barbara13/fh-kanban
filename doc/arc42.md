# Architekturdokumentation

# 1. Einführung und Ziele

## 1.1. Aufgabenstellung
Kanbanerstellung mit folgenden anforderungen:
+ Create new kanban boards
+ Open board
+ Save board
+ Save board as…
+ Export to html
++ Save boards as…
+ Export backlog to csv, pdf
+ Backlogs displays cards in 3 columns grid 
+ Backlog can be sorted by creation time (default), headline, value, size
++ Backlog can be sorted by creation time (default), headline, value, size
+ Full text search backlog and board by headline, description, CoS, size, value
+ Store board as xml
+ Card properties (uuid, headline, description, size, value, created, started, finished)
++ Classes of Service (CoS) (Fixed date, standard, intagible, expedite) 
++ Cards can be created, edited and deleted
+ CoS (Fixed date, standard, intangible, expedite)
+ Classes of Services (CoS) (Fixed date, standard, intangible, expedite) 
++ Move cards between adjacent columns (supress invalid moves (backward, skipping columns,...))
+ Preferences dialog for colors, name of board, columns, wips
+ Validate on wip limits
+ Warn user if modifications have not been saved
+ Edit dialog for card
+ Tests for allmajor parts of the application
## 1.2. Qualitätsziele
## 1.3. Stakeholder


# 2. Randbedingungen

## 2.1. Technische Randbedingungen
## 2.2. Organisatorische Randbedingungen
## 2.3. Konventionen

# 3. Kontextabgrenzung

## 3.1. Fachlicher Kontext
## 3.2. Technischer Kontext
## 3.3. Externe Schnittstellen

# 4. Lösungsstrategie

# 5. Bausteinsicht

# 6. Laufzeitsicht

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