# Spring Boot Practice
Currently, this is a *very simple* REST API built with Spring Boot to return a User's 
name, username, and `Base64` encoded password.

## Functions
- `/user` : You have to give a password to have the API search through the SQLite
database to see if there is a match

## Plans
Right now the database is initialized through the command line, but want to add
a way for users to "sign up" and create their own logins.