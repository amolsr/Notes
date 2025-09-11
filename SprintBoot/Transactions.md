Transactions

It is used to maintain the ACID properties of the database. 

Atomicity: Every transaction is atomic. It either executes completely or does not execute at all.
Consistency: After a transaction, the database must transition from one valid state to another, preserving integrity constraints.
Isolation: Concurrent transactions must not interfere with each other, and the final outcome should be as if they executed sequentially.
Durability: Once a transaction is committed, its results are permanently recorded in non-volatile storage and survive system crashes.

In spring boot transactions are achived by @Transactional annotation. 
It allows us to set propagation, isolation, timeout, read-only, and rollback conditions for our transaction. We can also specify the transaction manager. 


Transaction Propogation: 

REQUIRED Propagation
REQUIRED is the default propagation. Spring checks if there is an active transaction, and if nothing exists, it creates a new one. Otherwise, the business logic appends to the currently active transaction.

SUPPORTS Propagation
For SUPPORTS, Spring first checks if an active transaction exists. If a transaction exists, then the existing transaction will be used. If there isn’t a transaction, it is executed non-transactional.

MANDATORY Propagation
When the propagation is MANDATORY, if there is an active transaction, then it will be used. If there isn’t an active transaction, then Spring throws an exception.

NEVER Propagation
For transactional logic with NEVER propagation, Spring throws an exception if there’s an active transaction.

NOT_SUPPORTED Propagation
If a current transaction exists, first Spring suspends it, and then the business logic is executed without a transaction.

REQUIRES_NEW Propagation
When the propagation is REQUIRES_NEW, Spring suspends the current transaction if it exists, and then creates a new one.

NESTED Propagation
For NESTED propagation, Spring checks if a transaction exists, and if so, it marks a save point. This means that if our business logic execution throws an exception, then the transaction rollbacks to this save point. If there’s no active transaction, it works like REQUIRED.

Transaction Isolation:

