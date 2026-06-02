## Day 2
Create a savepoint after updating a student's email address and perform rollback if a later operation fails.

Concepts:
- Transaction Management
- setAutoCommit(false)
- Savepoint
- commit()
- rollback()

Key Learning:
A Savepoint allows partial rollback within a transaction instead of rolling back the entire transaction.
