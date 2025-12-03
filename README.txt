This project is implemented by Sedat Çoban (60545) - COMP430 - Project

	In the main, there is a class called loginPage. This class is constructed in order to visualize
	the login page for the user. There are 2 labels, 2 text fields and 2 buttons. Labels are for username 
	and password. Text fields are for entering the username and the password. Buttons are for logining to
	system and resetting the written texts in the text fields. When the user writes the username and the 
	password, Authentication class' hashingPassword method will be called in order to checks whether the 
	password and the username are correct. If they are correct, second thread will be started.

	In the Authentication class, there are two methods. One is hashingPassword and readPasswords. readPassword 
	reads a text file which contains the username, salt value and the hashed value of password+salt. It reads
	all of the users' username, salt and hashed value of salt+password value and returns them inside a HashMap.
	For this method, I constructed User.java class in order to records the username, salt and hashed values. 
	Then, hashingPassword method, will take the username and password that user entered in the login page. 
	It checks whether there is a user that has the same username and if there is one hashes the password with
	saved salt value. Then, it checks whether the hashed passwords are same or not. If they are same, 
	the method will return true. 

	In the screen.java class, there is another class called screen. This class is constructed in order to
	visualize the entering the file name and password for decryption. There are 2 labels, 2 text fields and 1
	button. Labels are for file name and password. Text fields are for entering the file name and the password.
	Button is for entering the file name and the password to the system. 

	In encryption class, there are 3 methods which are generateSecretKey, encrypt and decrypt. generateSecretKey
	method wil generate specific key for encrypt and decryption of the datasets according to the private key 
	that user entered in screen.java. In encrypt method, the data will be encrypted row by row according to the
	key. In decrypt method, the data will be decrypted row by row according to the key.

	In applications class, there will be methods for applications for user to perform. 