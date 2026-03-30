# Travel Agency System - Collections & Persistence

## What This Project Does
This project manages travel bookings by storing data in Java Collections (`HashMap`, `HashSet`, `ArrayList`) and persisting that data to a local text file (`agency_data.txt`).

### 1. Advanced Collections
* **HashMap**: Used to store `TourPackage` objects. The key is the Package ID, allowing for lightning-fast `O(1)` lookups.
* **HashSet**: Used to store `Customer` objects. By overriding `equals()` and `hashCode()`, the system automatically rejects duplicate users.

### 2. File Persistence (Serialization & Parsing)
* **Saving**: The `FileManager` takes string representations of objects and writes them to disk using `PrintWriter`.
* **Loading**: When the system starts, it reads `agency_data.txt`. The `fromFileString()` factory methods split the CSV data and rebuild the `TourPackage` and `Customer` objects into memory.