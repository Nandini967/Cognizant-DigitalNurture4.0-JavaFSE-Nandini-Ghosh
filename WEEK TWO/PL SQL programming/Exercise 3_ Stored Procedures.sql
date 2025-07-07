
SET SERVEROUTPUT ON;

BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE accounts';
  EXECUTE IMMEDIATE 'DROP TABLE employees';
EXCEPTION
  WHEN OTHERS THEN NULL;
END;
/

CREATE TABLE accounts (
  account_id NUMBER PRIMARY KEY,
  customer_id NUMBER,
  account_type VARCHAR2(20),
  balance NUMBER
);

CREATE TABLE employees (
  employee_id NUMBER PRIMARY KEY,
  department_id NUMBER,
  salary NUMBER
);

BEGIN
  INSERT INTO accounts VALUES (101, 1, 'savings', 10000);
  INSERT INTO accounts VALUES (102, 2, 'current', 5000);
  INSERT INTO accounts VALUES (103, 1, 'savings', 20000);
  COMMIT;
END;
/

BEGIN
  INSERT INTO employees VALUES (1, 10, 50000);
  INSERT INTO employees VALUES (2, 10, 55000);
  INSERT INTO employees VALUES (3, 20, 60000);
  COMMIT;
END;
/
--SCENARIO 1
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
  FOR rec IN (SELECT account_id, balance
              FROM accounts
              WHERE account_type = 'savings') LOOP
    UPDATE accounts
    SET balance = balance + (rec.balance * 0.01)
    WHERE account_id = rec.account_id;

    DBMS_OUTPUT.PUT_LINE('Interest added to account ID ' || rec.account_id ||
                         '. New balance: ' || TO_CHAR(rec.balance + (rec.balance * 0.01)));
  END LOOP;
  COMMIT;
END;
/

-- SCENARIO 2
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
  p_dept_id IN NUMBER,
  p_bonus_percent IN NUMBER
) AS
BEGIN
  FOR rec IN (SELECT employee_id, salary
              FROM employees
              WHERE department_id = p_dept_id) LOOP
    UPDATE employees
    SET salary = salary + (rec.salary * p_bonus_percent / 100)
    WHERE employee_id = rec.employee_id;

    DBMS_OUTPUT.PUT_LINE('Bonus added to employee ID ' || rec.employee_id ||
                         '. New salary: ' || TO_CHAR(rec.salary + (rec.salary * p_bonus_percent / 100)));
  END LOOP;
  COMMIT;
END;
/

-- SCENARIO 3
CREATE OR REPLACE PROCEDURE TransferFunds(
  p_from_acc_id IN NUMBER,
  p_to_acc_id IN NUMBER,
  p_amount IN NUMBER
) AS
  v_from_balance NUMBER;
BEGIN
  SELECT balance INTO v_from_balance
  FROM accounts
  WHERE account_id = p_from_acc_id FOR UPDATE;

  IF v_from_balance < p_amount THEN
    DBMS_OUTPUT.PUT_LINE('Transfer failed: Insufficient balance in source account.');
  ELSE
    UPDATE accounts
    SET balance = balance - p_amount
    WHERE account_id = p_from_acc_id;

    UPDATE accounts
    SET balance = balance + p_amount
    WHERE account_id = p_to_acc_id;

    DBMS_OUTPUT.PUT_LINE('Transfer of ' || p_amount || ' successful from account ' ||
                         p_from_acc_id || ' to account ' || p_to_acc_id);
  END IF;
  COMMIT;
END;
/

EXEC ProcessMonthlyInterest;
EXEC UpdateEmployeeBonus(10, 10);
EXEC TransferFunds(101, 102, 2000);

