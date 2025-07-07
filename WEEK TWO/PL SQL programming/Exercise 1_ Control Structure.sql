
SET SERVEROUTPUT ON;

CREATE TABLE customers (
  customer_id NUMBER PRIMARY KEY,
  name VARCHAR2(100),
  age NUMBER,
  balance NUMBER,
  isVIP CHAR(1) DEFAULT 'N'
);

CREATE TABLE loans (
  loan_id NUMBER PRIMARY KEY,
  customer_id NUMBER,
  interest_rate NUMBER,
  due_date DATE,
  FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);


BEGIN
  INSERT INTO customers VALUES (1, 'Amit', 65, 15000, 'N');
  INSERT INTO customers VALUES (2, 'Sara', 45, 8000, 'N');
  INSERT INTO customers VALUES (3, 'Raj', 70, 12000, 'N');
  INSERT INTO customers VALUES (4, 'Priya', 30, 9500, 'N');

  INSERT INTO loans VALUES (101, 1, 9.5, SYSDATE + 10);
  INSERT INTO loans VALUES (102, 2, 10.0, SYSDATE + 40);
  INSERT INTO loans VALUES (103, 3, 8.5, SYSDATE + 25);
  INSERT INTO loans VALUES (104, 4, 11.0, SYSDATE + 5);
  COMMIT;
END;
/
-- SCENARIO 1

BEGIN
  FOR rec IN (
    SELECT l.loan_id, l.interest_rate, c.name
    FROM loans l
    JOIN customers c ON l.customer_id = c.customer_id
    WHERE c.age > 60
  )
  LOOP
    UPDATE loans
    SET interest_rate = rec.interest_rate - 1
    WHERE loan_id = rec.loan_id;

    DBMS_OUTPUT.PUT_LINE('Applied 1% discount for ' || rec.name || 
                         ' on loan ID ' || rec.loan_id || 
                         '. New interest rate: ' || TO_CHAR(rec.interest_rate - 1));
  END LOOP;
  COMMIT;
END;
/

-- SCENARIO 2
BEGIN
  FOR rec IN (
    SELECT customer_id, name, balance 
    FROM customers 
    WHERE balance > 10000
  )
  LOOP
    UPDATE customers
    SET isVIP = 'Y'
    WHERE customer_id = rec.customer_id;

    DBMS_OUTPUT.PUT_LINE('Marked customer ' || rec.name || ' as VIP (balance: ' || rec.balance || ')');
  END LOOP;
  COMMIT;
END;
/

-- SCENARIO 3
BEGIN
  FOR rec IN (
    SELECT l.loan_id, l.due_date, c.name
    FROM loans l
    JOIN customers c ON l.customer_id = c.customer_id
    WHERE l.due_date <= SYSDATE + 30
  )
  LOOP
    DBMS_OUTPUT.PUT_LINE(
      'Reminder: Dear ' || rec.name ||
      ', your loan (ID: ' || rec.loan_id || 
      ') is due on ' || TO_CHAR(rec.due_date, 'DD-MON-YYYY')
    );
  END LOOP;
END;
/

