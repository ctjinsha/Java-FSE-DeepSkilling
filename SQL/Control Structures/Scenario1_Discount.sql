SET SERVEROUTPUT ON;

DECLARE
BEGIN
    FOR rec IN (
        SELECT c.CustomerID, c.DOB, l.InterestRate
        FROM Customers c
        JOIN Loans l ON c.CustomerID = l.CustomerID
    ) LOOP

        IF MONTHS_BETWEEN(SYSDATE, rec.DOB)/12 > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = rec.CustomerID;

            DBMS_OUTPUT.PUT_LINE('Discount applied to Customer ID: ' || rec.CustomerID);
        END IF;

    END LOOP;

    COMMIT;
END;
/