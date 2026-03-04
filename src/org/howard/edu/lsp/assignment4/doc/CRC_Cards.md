# Name: Zamijah Shakeur-Tompkins

## Class: Transponder

Responsibilities:

- Broadcasts aircraft type & flight data in a high‑density packet format

Collaborators (none)

Assumptions:

- Assumes all aircraft are equipped with a functioning high-density packet transponder

## Class: GroundStation

Responsibilities:

- Receives high-density packets from Transponder
- Unpacks flight data and sends data to AircraftDatabase

Collaborators:

- Transponder
- AircraftDatabase

Assumptions (none)

## Class: AircraftDatabase

Responsibilities:

- Stores and organizes aircraft flight data

Collaborators (none)

Assumptions (none)

## Class: GraphicsDisplay

Responsibilities:

- Retrieves data from the database
- Updates the visual display every 10 seconds

Collaborators:

- AircraftDatabase
- Controller

Assumptions:

- Assumes a refresh rate of 10 seconds is sufficient for real-time monitoring

## Class: ConflictDetector

Responsibilities:

- Analyzes aircraft data to detect dangerous situations
- Notifies the Controller of potential conflicts

Collaborators:

- AircraftDatabase
- Controller

Assumptions:

- Assumes the database provides real-time GPS coordinates and altitude for all active aircraft

## Class: Controller

Responsibilities:

- Queries the database for details about any plane on screen

Collaborators:

- AircraftDatabase
- GraphicsDisplay
- ConflictDetector

Assumptions (none)
