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

## Overview
This project implements a secure login system, encrypted file access, and application-level operations using Java. It includes Swing-based GUI components and cryptographic utilities for password verification and dataset encryption/decryption.

## System Architecture
The system consists of three main stages:

### 1. User Authentication
Validates user credentials using salted hashing.

### 2. File Access & Decryption
Requests a file name and password, generates a key, and processes dataset encryption or decryption row-by-row.

### 3. Application Operations
Provides functionality to interact with decrypted data.

## Class Descriptions

### loginPage
A Swing-based login UI.

**Components:**
- Username label and text field  
- Password label and text field  
- Login button  
- Reset button  

On submission, invokes `Authentication.hashingPassword()` and proceeds only when credentials are correct.

### Authentication
Handles password validation and secure storage.

#### readPasswords()
- Loads user data from a text file (username, salt, hashed password)
- Stores records in `HashMap<String, User>`

#### hashingPassword(username, password)
- Verifies username exists  
- Hashes the input password with stored salt  
- Compares hashes  
- Returns `true` on match  

### screen (screen.java)
Interface for entering:
- File name  
- Password  

Includes two input fields and one confirmation button.

### encryption
Provides cryptographic operations:

#### generateSecretKey()
Generates a secret key based on the user-provided private key.

#### encrypt()
Encrypts dataset rows.

#### decrypt()
Decrypts dataset rows.

### applications
Contains the operations available after authentication and decryption.

## Project Workflow
```text
User Login → Authentication → File Input Screen → Generate Key →
Encrypt / Decrypt Data → Application Functions
```

## File Structure
```text
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

## Future Work
- Replace Swing UI with JavaFX  
- Use secure DB instead of text file  
- Adopt PBKDF2 / bcrypt / scrypt for hashing  
- Add error handling and logs  
- Implement role-based authentication  
