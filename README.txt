# COMP430 Project

**Author:** Sedat Çoban (60545)

## Table of Contents
- [Overview](#overview)
- [System Architecture](#system-architecture)
- [Class Descriptions](#class-descriptions)
  - [loginPage](#loginpage)
  - [Authentication](#authentication)
  - [screen](#screen)
  - [encryption](#encryption)
  - [applications](#applications)
- [Project Workflow](#project-workflow)
- [File Structure](#file-structure)
- [Future Work](#future-work)

---

## Overview
This project implements a secure login system, encrypted file handling, and application-level operations using Java. The system includes GUI components built with Swing and cryptographic utilities for password verification and dataset encryption/decryption.

---

## System Architecture
The system operates in three main stages:

1. **User Authentication**  
   Validates credentials using salted hashing and stored verification data.

2. **File Access & Decryption**  
   Prompts the user to enter a file name and password, generates a key, and decrypts/encrypts dataset rows.

3. **Application Operations**  
   Provides additional functionality after the user successfully logs in and decrypts a dataset.

---

## Class Descriptions

### loginPage
A Swing-based login interface containing:
- Two labels (Username, Password)
- Two text fields for user input
- Two buttons (Login, Reset)

On submission, the class invokes `Authentication.hashingPassword()` to verify credentials. If authentication is successful, a new thread is started to proceed to the next stage.

---

### Authentication
This class handles credential validation and encrypted password storage.

#### readPasswords()
- Reads a text file containing:
  - Username  
  - Salt  
  - Hashed password (password + salt)
- Stores these values in a `HashMap<String, User>`.
- Uses `User.java` to model each record.

#### hashingPassword(username, password)
- Validates existence of the username.
- Hashes the provided password using the stored salt.
- Compares computed and stored hashes.
- Returns `true` if they match.

---

### screen (screen.java)
Provides the user interface for entering:
- File name  
- Password  

It includes two labels, two input fields, and one button to confirm input and proceed to cryptographic operations.

---

### encryption
Includes three cryptographic methods:

#### generateSecretKey()
Derives a secret key based on the user’s private key input provided in `screen.java`.

#### encrypt()
Encrypts dataset content row-by-row with the generated key.

#### decrypt()
Decrypts dataset content row-by-row using the same key.

---

### applications
Contains the application functionalities available after successful authentication and decryption. Methods within this class support operations the user can perform on the decrypted dataset.

---

## Project Workflow
```
User Login → Authentication → File Input Screen → Generate Key →
Encrypt / Decrypt Data → Application Functions
```

---

## File Structure
```
project/
│── loginPage.java
│── Authentication.java
│── User.java
│── screen.java
│── encryption.java
│── applications.java
│── passwords.txt
│── README.md
```

---

## Future Work
- Improve GUI design using JavaFX
- Replace text-based credential storage with a secure database
- Integrate stronger password hashing algorithms (PBKDF2, bcrypt, scrypt)
- Add error handling, logs, and audit trails
- Support role-based system access
