# Entity Relationship Diagram (ERD) for a Simple Order Manager

## How to Run the SQL Script
- ## Prerequisites
Before running the SQL script, ensure you have the following prerequisites:

Database Management System (`DBMS`): Make sure you have a supported DBMS installed, such as `MySQL`, `PostgreSQL`, `Oracle`, or `SQL Server`.
- SQL Client Tool: You can use any SQL client tool like MySQL Workbench, pgAdmin, SQL*Plus, or even the command line interface that comes with your DBMS.
- Database Access: Ensure you have the necessary credentials (username and password) to access the database where you intend to run the script.
- Database Created: If the script is meant to run on an existing database, ensure that the database is already created.

# Running the SQL Script
## Using a Command Line Interface
Open your `terminal` or `command prompt`.

Navigate to the directory where the `SQL` file is located. For example:

```bash
cd path/to/your/sql-file-directory
```
## Connect to your database. The command will vary depending on your DBMS:

### MySQL:
```bash
mysql -u username -p database_name < your_script.sql
```
### PostgreSQL:
```bash
psql -U username -d database_name -f your_script.sql
```
### Oracle:
```bash
sqlplus username/password@database_name @your_script.sql
```
### SQL Server:
```bash
sqlcmd -S server_name -d database_name -U username -P password -i your_script.sql
```

Enter your password when prompted.
The script will be executed, and you will see the output in the terminal