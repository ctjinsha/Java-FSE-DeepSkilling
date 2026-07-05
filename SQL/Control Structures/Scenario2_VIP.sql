ALTER TABLE Customers ADD IsVIP VARCHAR2(5);
SET SERVEROUTPUT ON;

BEGIN
    FOR rec IN (SELECT CustomerID, Balance FROM Customers) LOOP

        IF rec.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP='TRUE'
            WHERE CustomerID=rec.CustomerID;

            DBMS_OUTPUT.PUT_LINE('Customer '||rec.CustomerID||' promoted to VIP');
        END IF;

    END LOOP;

    COMMIT;
END;
/