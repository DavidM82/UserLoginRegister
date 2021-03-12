use example;
create user 'newuser'@'%' identified by 'GoodPassword'; -- Creates the user newuser
grant all on example.* to 'newuser'@'%'; -- Gives all privileges to the new user on the database


	CREATE TABLE example.users (
	id  int(11) AUTO_INCREMENT,
	username VARCHAR(256),
    email VARCHAR(256),
	password VARCHAR(256),
	PRIMARY KEY (`id`)
	);
    
   -- drop table example.users;
    
    Select * from users;