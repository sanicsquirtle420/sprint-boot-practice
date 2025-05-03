# Spring Boot Practice
This is a *very simple* REST API built with Java's Spring Boot framework to manage users
in a SQLite database. As of right now, everytime the app runs the database is reset.

## Functions
- `/user` : The user gives a password, and then there will be a search to see if there is
a match with a password in the database. If there is a match then text is returned saying
that you have successfully signed in
- `/add` : Takes in the parameters from the User class (in json format) through post
and if the username is not taken it will add it to the database. If the username is
taken then an error will be returned
- `/db` : Returns the current users in the database (see sample below) with the
passwords hashed.

### `/db` Sample Result
```
*** Users ***
name=Diego, username=raccoon, password=$2a$10$p3Mmr4uanIdC5gEMYho9ou7WDVxd81F3CIBekgANWAFjg/DUHKHRi
name=Luna Snow, username=luna, password=$2a$10$othgMGwGQc/ggtgiihQwaOWQ3ejmLeb/D7k.Nb/S8G1v/w8n9ty/W
name=Kiriko, username=kitsunee, password=$2a$10$kcPaJCkhu.TpXomIFI4sTuAshQsRv0CayZumwPMPsZ6zAadbDQyRa
name=Juno, username=martian, password=$2a$10$jZaUSChFpVl7qp3rA7r3KuzLYgs7LCK4fkgLBRAnQxv/L.ySok2dm
name=Jake, username=yaboijaek, password=$2a$10$XLX9xhFqy64KTC0bDWSKGOtzvR44g4JJedZQihxZXztZTqXJ7BKBm
name=Bradley, username=justanothadude, password=$2a$10$0ZbdspSQdUoC.ZxEmgy/sOhlzV2mlXEM9A6b0mOtO3goesFYLztoW
*** End of Table ***
```

## Updates
It's finished! Might add more to this in the future, but I am happy with how it is right now.