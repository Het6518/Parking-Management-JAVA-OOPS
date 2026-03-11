# Parking-Management-JAVA-OOPS


<div align="center">

![Java](https://img.shields.io/badge/Java-17%2B-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![OOP](https://img.shields.io/badge/Paradigm-OOP-blue?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-green?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Active-brightgreen?style=for-the-badge)

**A console-based Parking Lot Management System built in Java, demonstrating core Object-Oriented Programming principles through a real-world simulation.**

</div>

---

## 📸 System Preview

<!-- PLACEHOLDER: Replace with a screenshot of the console menu in action -->
> **[<img width="588" height="441" alt="image" src="https://github.com/user-attachments/assets/5d11c258-a1ce-4383-8da9-af6365e0ab24" />
]** — Console menu walkthrough showing vehicle entry, ticket generation, and exit flow.
> *(Replace this with an actual screenshot: e.g., `![Console Preview](assets/console-preview.png)`)*
<!-- PLACEHOLDER: Replace with a UML class diagram or architecture diagram -->
> **[<img width="301" height="184" alt="image" src="https://github.com/user-attachments/assets/bed967cd-cc22-4b97-892d-ccc9c0468b9b" />
]** — UML Class Diagram showing relationships between `Vehicle`, `ParkingLot`, `ParkingSpot`, and `Ticket`.
> *(Replace this with an actual diagram: e.g., `![UML Diagram](assets/uml-diagram.png)`)*

---

## 📐 System Architecture



```
ParkingLotSystem
│
├── Vehicle (abstract)
│      ├── Car
│      ├── Bike
│      └── Truck
│
├── ParkingLot
│      ├── ParkingSpot
│      └── Ticket
│
└── Main Application
```

---

## ✨ Features

- 🚘 Park multiple vehicle types — Car, Bike, Truck
- 🎫 Auto-generate unique parking tickets on entry
- 🅿️ Real-time tracking of available and occupied spots
- 💰 Automatic fee calculation based on vehicle type and duration
- 📋 Live parking status dashboard
- 🖥️ Simple, menu-driven console interface

---

## 🧠 OOP Concepts Demonstrated

| Concept | Implementation |
|---|---|
| **Encapsulation** | Data hidden within `ParkingSpot` and `Ticket` classes via private fields |
| **Inheritance** | `Vehicle` → `Car`, `Bike`, `Truck` |
| **Polymorphism** | Overridden `getType()` method in each vehicle subclass |
| **Abstraction** | `abstract class Vehicle` enforces a contract for all vehicle types |
| **Composition** | `ParkingLot` owns and manages `ParkingSpot` and `Ticket` objects |
| **Data Structures** | `ArrayList` and `HashMap` used for efficient spot and ticket storage |

---

## 📁 Project Structure

```
parking-lot-system/
│
├── Main.java                  # Entry point, menu loop
│
├── vehicle/
│   ├── Vehicle.java           # Abstract base class
│   ├── Car.java
│   ├── Bike.java
│   └── Truck.java
│
├── lot/
│   ├── ParkingLot.java        # Core system logic
│   ├── ParkingSpot.java       # Spot state management
│   └── Ticket.java            # Ticket and fee tracking
│
└── README.md
```

---

## ⚙️ How It Works

### 🔵 Vehicle Entry
1. User selects vehicle type — Car, Bike, or Truck
2. System scans for an available parking spot
3. On availability:
   - A unique ticket is generated with timestamp and spot number
   - The spot is marked as **Occupied**

### 🔴 Vehicle Exit
1. User enters their Ticket ID
2. System calculates total parking duration
3. Fee is computed based on vehicle type and hours parked
4. Spot is freed and marked **Available**

---

## 💵 Parking Fee Structure

| Vehicle Type | Rate |
|---|---|
| 🛵 Bike | ₹10 / hour |
| 🚗 Car | ₹30 / hour |
| 🚛 Truck | ₹50 / hour |

---

## 🖥️ Sample Interaction

```
---- Parking Lot Menu ----

1. Park Vehicle
2. Exit Vehicle
3. Show Parking Status
0. Exit

Enter choice: 1

Select Vehicle Type:
1. Car   2. Bike   3. Truck
Enter vehicle number: GJ01AB1234

✅ Vehicle parked successfully!

----- Ticket -----
Ticket ID  : 1
Vehicle    : GJ01AB1234
Type       : Car
Spot No.   : 3
Entry Time : 10:30 AM
------------------
```

---

## 🚀 Getting Started

### Prerequisites

- Java 17 or higher
- Any terminal / command prompt

### Compile

```bash
javac -d out src/**/*.java
```

### Run

```bash
java -cp out Main
```

---

## 🔮 Possible Future Improvements

- Multi-floor parking support
- Database integration (MySQL / PostgreSQL)
- REST APIs using Spring Boot
- Payment gateway simulation
- Real-time web dashboard
- Slot reservation and pre-booking system

---

## 🛠️ Tech Stack

- **Language:** Java 17+
- **Paradigm:** Object-Oriented Programming (OOP)
- **Collections:** `ArrayList`, `HashMap`
- **Interface:** Console / CLI

---

## 📄 License

This project is open-source and available under the [MIT License](LICENSE).

---

<div align="center">
Made with ☕ and Java
</div>
