# core-api

## Getting started for Developer

- Install JDK 17 (use jenv)
- Install Intellij
- Install PostgreSQL

```bash
$ brew update
$ brew install postgresql@11
$ brew services start postgres
$ createuser -s postgres
$ psql -U postgres
postgres=# create database coreapi;
postgres=# create user mycoreapiuser with encrypted password 'mypassword';
postgres=# grant all privileges on database coreapi to mycoreapiuser;
```

```
./gradlew -x webapp
npm start
```

### Debugging
