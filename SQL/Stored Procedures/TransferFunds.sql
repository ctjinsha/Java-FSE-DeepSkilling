CREATE OR REPLACE PROCEDURE TransferFunds(
    fromAccount IN NUMBER,
    toAccount IN NUMBER,
    amount IN NUMBER
)
IS
    balance NUMBER;
BEGIN

    SELECT Balance
    INTO balance
    FROM Accounts
    WHERE AccountID=fromAccount;

    IF balance>=amount THEN

        UPDATE Accounts
        SET Balance=Balance-amount
        WHERE AccountID=fromAccount;

        UPDATE Accounts
        SET Balance=Balance+amount
        WHERE AccountID=toAccount;

        COMMIT;

        DBMS_OUTPUT.PUT_LINE('Transfer Successful');

    ELSE

        DBMS_OUTPUT.PUT_LINE('Insufficient Balance');

    END IF;

END;
/
BEGIN
    TransferFunds(1,2,500);
END;
/