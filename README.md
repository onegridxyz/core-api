# core-api

```bash
$ brew update
$ brew install postgresql@11
$ brew services start postgres
$ createuser -s postgres
$ psql -U postgres
postgres=# create database coreapi;
postgres=# create user mycoreapiuser with encrypted password 'mypassword';
postgres=# grant all privileges on database mycoreapiuser to coreapi;
```
