SELECT ID, 
        (
            SELECT COUNT(e2.PARENT_ID)
            FROM ECOLI_DATA e2
            WHERE e1.ID = e2.PARENT_ID
        )
        AS 'CHILD_COUNT'
        FROM ECOLI_DATA e1