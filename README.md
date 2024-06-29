# AMECA: Symmetric Cryptography Encryptor & Decryptor

**Group 8 | 4 ISA 3 | CRUD Project**

## Team Members

- **Riki Awal Syahputra** (2120010136)
- **Faza Rama Nugraha** (2120010291)

![image](https://github.com/Qyuzet/Symmetric-Cryptography-Encryptor-Decryptor--AMECA/assets/93258081/67ccc285-81a8-42d2-9486-edd4b2980e92)


## Table of Contents

1. [Project Overview](#project-overview)
2. [System Analysis](#system-analysis)
3. [Design Interface](#design-interface)
4. [Database Design](#database-design)
5. [Table Design](#table-design)
6. [Flow Diagram](#flow-diagram)
7. [Code Configuration](#code-configuration)
8. [Installation](#installation)
9. [Usage](#usage)
10. [Minimum Configuration](#minimum-configuration)
11. [Contribution Guidelines](#contribution-guidelines)
12. [License](#license)
13. [Acknowledgements](#acknowledgements)

## Project Overview

AMECA is a Java-based desktop application designed to introduce and demonstrate symmetric encryption using the Advanced Encryption Standard (AES). The application utilizes a single key for both encryption and decryption, ensuring secure communication and data protection.

![image](https://github.com/Qyuzet/Symmetric-Cryptography-Encryptor-Decryptor--AMECA/assets/93258081/867ad90c-4e85-4f15-bd6e-b24531abf137)

## System Analysis

### Overview

AMECA is developed to provide a practical implementation of symmetric encryption. Key features include:

- **Java-based Desktop Application:** Built with Java, making it cross-platform and robust.
- **Symmetric Encryption:** Uses a single key for both encryption and decryption.
- **Powered by AES:** Implements Advanced Encryption Standard for strong encryption.

## Design Interface

![image](https://github.com/Qyuzet/Symmetric-Cryptography-Encryptor-Decryptor--AMECA/assets/93258081/7fbdce62-5377-43c1-8a2f-d6eaf7836f2e)

### User Interface

AMECA's user interface is designed with simplicity and usability in mind. It features:

- **FlatLightLaf UI:** A modern and clean look for ease of use.
- **User-Friendly Controls:** Easy input for plaintext and encryption keys, and clear display of ciphertext.

## Database Design

### Structure

The database is structured to store encrypted messages along with the corresponding encryption keys and original plaintext. This design facilitates easy retrieval and management of encrypted data.

## Table Design

The table design is as follows:

| NO | Field Name | Data Type | Length | Description                      |
|----|-------------|-----------|--------|----------------------------------|
| 1  | sender      | varchar   | 50     | Sender name (cryptographer)      |
| 2  | enKey       | varchar   | 32     | Encryption key                   |
| 3  | plain       | varchar   | 2000   | Original plaintext               |
| 4  | cipher      | varchar   | 2000   | Encrypted ciphertext             |

## Flow Diagram

![image](https://github.com/Qyuzet/Symmetric-Cryptography-Encryptor-Decryptor--AMECA/assets/93258081/a9d9174f-7132-4bd4-9afb-e3ab745527d8)

### General Flowchart

The general flowchart outlines the high-level processes of AMECA, including message input, encryption, decryption, and output.

### Detailed Flowchart

The detailed flowchart breaks down each step of the process, including:

1. **Message Input:** User inputs plaintext and encryption key.
2. **Encryption Process:** The system encrypts the plaintext using the provided key.
3. **Decryption Process:** The system decrypts the ciphertext using the provided key.
4. **Message Output:** The decrypted plaintext is displayed to the user.

## Code Configuration

### Java Code

Key components of the Java code include:

#### Set UI Style

- **FlatLightLaf UI:** Sets the UI to a modern and clean look.

#### Koneksi Package

- **Database Connection:** Handles the connection to the local database.
- **Connection Snippet:** Code to establish a connection to the database.

#### Cryptography Class Code

- **Check Key Function:** Verifies the provided encryption key.
- **Show Data Function:** Displays stored data from the database.
- **Find Data Function:** Searches for specific data in the database.
- **Main Process:** Handles the main CRUD operations (create, read, update/change).
- **Delete Process:** Handles the deletion of records.

## Installation

### Prerequisites

- **Java Development Kit (JDK):** Ensure JDK is installed on your computer.
- **XAMPP:** Install XAMPP for local database management.
- **NetBeans IDE:** (Optional) Install NetBeans for a better development experience.

### Steps

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/yourusername/AMECA.git
   ```
2. **Open the Project in NetBeans:**
   - Navigate to the cloned repository and open the project in NetBeans.
3. **Configure the Database:**
   - Set up a local database using XAMPP as per the instructions in the `database/` directory.
4. **Build and Run the Project:**
   - Build the project in NetBeans and run it.

## Usage

1. **Launch the Application:**
   - Open the AMECA application on your desktop.
2. **Input Plaintext and Key:**
   - Enter the plaintext and encryption key in the provided fields.
3. **Encrypt the Message:**
   - Click the 'Encrypt' button to encrypt the plaintext.
4. **Decrypt the Message:**
   - Enter the ciphertext and encryption key, then click the 'Decrypt' button to decrypt the message.

## Minimum Configuration

### Hardware

- **Computer:** Minimum specifications include 8GB RAM, 512GB ROM, and an Intel i5 processor.

### Operating System

- **Windows:** The application is compatible with Windows 10.

### Software

- **XAMPP v3.3.0:** For local database management.
- **NetBeans IDE 13:** (Optional) For development and code management.

## Contribution Guidelines

We welcome contributions from the community! To contribute:

1. **Fork the Repository:**
   - Click the 'Fork' button on the top right of the repository page.
2. **Clone Your Fork:**
   ```bash
   git clone https://github.com/yourusername/AMECA.git
   ```
3. **Create a Branch:**
   ```bash
   git checkout -b feature-branch
   ```
4. **Make Your Changes:**
   - Implement your feature or fix.
5. **Commit Your Changes:**
   ```bash
   git commit -m "Description of changes"
   ```
6. **Push to Your Fork:**
   ```bash
   git push origin feature-branch
   ```
7. **Create a Pull Request:**
   - Go to the original repository and create a pull request from your fork.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Acknowledgements

We would like to thank our team members and supporters who contributed to the development of AMECA. Special thanks to our instructors and peers who provided valuable feedback and guidance throughout the project.
