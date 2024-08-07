SELECT ID,
    (
        CASE 
            WHEN '0' < SIZE_OF_COLONY AND SIZE_OF_COLONY <= '100' THEN 'LOW'
            WHEN '101' < SIZE_OF_COLONY AND SIZE_OF_COLONY <= '1000' THEN'MEDIUM'
            ELSE 'HIGH'
        END
    ) AS SIZE
    FROM ECOLI_DATA
    ORDER BY ID ASC; 