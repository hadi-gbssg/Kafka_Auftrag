# Anleitung Applikation starten

## Docker Desktop starten

1. Starte auf Windows zuerst Docker Desktop.
2. In Intellij Terminal öffnen Docker Version prüfen:

- "docker --version"

## Kafka starten
1. Im Terminal in Intellij docker ausführen

- "docker compose up -d"

- "docker ps"

## Prüfen, ob Kafka Fehler hat
- "docker compose logs kafka"

## Order Service starten



1. Main.java öffnen

- "public static void main(String[] args)" ausführen





Dannach kommt:

"Tomcat started on port 8080"

Das bedeutet:

Order Service läuft:
http://localhost:8080