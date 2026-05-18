# Supplement-Tracker

## Team-Mitglieder
- Mohammad Cheikh Mahmoud

## Übungsgruppe / Dozent
Zug 1, Gruppe 1  
Dozent: Prof. Dr. Arif Wider

## Projektbeschreibung
Supplement-Tracker ist eine Webanwendung zur Verwaltung von Nahrungsergänzungsmitteln. Nutzer sollen Supplements anlegen, verwalten und später auch speichern, bearbeiten und auswerten können.

## Aktueller Stand (Milestone 1)
- Spring-Boot-Projekt erstellt
- Erste Entity-Klasse `Supplement` definiert
- REST-Controller erstellt
- GET-Route `/supplements` implementiert
- Ausgabe einer Liste von Beispiel-Supplements

## Test-Endpunkte

### Startseite
`http://localhost:8080/`

Antwort:
`MySupps läuft!`

### Supplement-Liste
`http://localhost:8080/supplements`

Beispielausgabe:
```json
[
  {
    "category": "Vitamin",
    "dosage": 1000.0,
    "id": null,
    "intakeTime": "Morgens",
    "name": "Vitamin D",
    "notes": "Täglich einnehmen",
    "stock": 30
  }
]
