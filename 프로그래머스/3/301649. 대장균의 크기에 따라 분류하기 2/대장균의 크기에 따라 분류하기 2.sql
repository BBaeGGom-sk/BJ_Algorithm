      
SELECT A.ID,
    (
        CASE
            WHEN B.RANK = 4 THEN 'CRITICAL'
            WHEN B.RANK = 3 THEN 'HIGH'
            WHEN B.RANK = 2 THEN 'MEDIUM'
            WHEN B.RANK = 1 THEN 'LOW'
        END
    ) AS 'COLONY_NAME'
FROM ECOLI_DATA A, 
    (
        SELECT ID, ( NTILE(4) OVER(ORDER BY SIZE_OF_COLONY) )
            AS 'RANK'
        FROM ECOLI_DATA
        ORDER BY ID
    ) B
WHERE A.ID = B.ID;

