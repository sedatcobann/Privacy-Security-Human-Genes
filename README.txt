# COMP430 Project  
**Implemented by:** **Sedat Çoban (60545)**  

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![GUI](https://img.shields.io/badge/GUI-Swing-blue?style=for-the-badge)
![Encryption](https://img.shields.io/badge/Encryption-AES-green?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Completed-brightgreen?style=for-the-badge)

## 📑 Table of Contents
- [Overview](#overview)  
- [Project Flow](#project-flow)  
- [Classes](#classes)  
  - [loginPage](#1-loginpage-class)  
  - [Authentication](#2-authentication-class)  
  - [screen](#3-screen-class-screenjava)  
  - [encryption](#4-encryption-class)  
  - [applications](#5-applications-class)  
- [How It Works](#how-it-works)  
- [File Structure](#file-structure)  
- [Future Improvements](#future-improvements)

## 🔍 Overview
This project implements a secure login system, file decryption workflow, and application operations using Java Swing for the UI and cryptographic functions for secure data handling.

The system performs:
- User authentication with salted hashing  
- Secure encryption/decryption of dataset files  
- GUI pages for login and file access  
- Application operations after successful authentication  

## 🔁 Project Flow
```
Start → Login Page → Authentication → File Screen → Generate Key → Encrypt/Decrypt → Application Page
```

## 🧩 Classes

### 1. `loginPage` Class
Displays the **login interface** with:
- 2 Labels (Username, Password)
- 2 TextFields for input
- 2 Buttons (Login, Reset)

### 2. `Authentication` Class
Handles **user verification**.

#### `readPasswords()`
- Reads stored user info from a text file:
  - Username  
  - Salt  
  - Hashed (password + salt)  
- Saves results in a **HashMap**
- Uses `User.java` to structure user records

#### `hashingPassword(username, password)`
- Verifies if username exists  
- Hashes provided password with stored salt  
- Compares hashes  
- Returns **true** if they match  

### 3. `screen` Class (`screen.java`)
GUI for **file name + password** entry used for decryption.

Includes:
- 2 Labels (File Name, Password)
- 2 Input TextFields
- 1 Button to proceed

### 4. `encryption` Class
Implements cryptographic functions.

#### `generateSecretKey()`
Generates a key based on the private key entered in `screen.java`.

#### `encrypt()`
Encrypts the dataset **row by row** using the generated key.

#### `decrypt()`
Decrypts the dataset **row by row** using the same key.

### 5. `applications` Class
Contains the operations available to the user after successful authentication and file processing.

## ⚙️ How It Works
1. User logs in → hashed + salted verification  
2. User enters file + key → system generates cryptographic key  
3. User decrypts/encrypts target data  
4. Application features become accessible  

## 📁 File Structure
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

## 🚀 Future Improvements
- Add multi-user role support  
- Convert Swing UI to JavaFX for modern design  
- Store user credentials in a secure database  
- Integrate stronger hashing (e.g., PBKDF2, bcrypt, scrypt)  
- Add logs and error handling  
