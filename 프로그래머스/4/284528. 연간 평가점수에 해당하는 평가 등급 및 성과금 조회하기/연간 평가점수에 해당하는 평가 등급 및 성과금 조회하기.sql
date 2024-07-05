# SELECT emp.EMP_NO, emp.EMP_NAME, 
    # (
    #     CASE
    #         WHEN gr.SCORE BETWEEN 96 AND 100 THEN 'S'
    #         WHEN gr.SCORE BETWEEN 90 AND 96 THEN 'A'
    #         WHEN gr.SCORE BETWEEN 80 AND 90 THEN 'B'
    #         ELSE 'C'
    #     END
    # ) AS 'GRADE'
#     , emp.SAL AS 'BONUS'
#     FROM HR_EMPLOYEES emp, HR_GRADE gr
#     WHERE emp.EMP_NO = gr.EMP_NO
#     ORDER BY emp.EMP_NO
#     # GROUP BY gr.SCORE
#     # HAVING emp.EMP_NO = gr.EMP_NO;


    
SELECT emp.EMP_NO, emp.EMP_NAME, 
    (
        CASE
            WHEN gr.AVG_SCORE BETWEEN 96 AND 100 THEN 'S'
            WHEN gr.AVG_SCORE BETWEEN 90 AND 96 THEN 'A'
            WHEN gr.AVG_SCORE BETWEEN 80 AND 90 THEN 'B'
            ELSE 'C'
        END
    ) AS 'GRADE', 
    (
        CASE
            WHEN gr.AVG_SCORE BETWEEN 96 AND 100 THEN emp.SAL*0.2
            WHEN gr.AVG_SCORE BETWEEN 90 AND 96 THEN emp.SAL*0.15
            WHEN gr.AVG_SCORE BETWEEN 80 AND 90 THEN emp.SAL*0.1
            ELSE 0
        END
    ) AS 'BONUS'
    FROM HR_EMPLOYEES emp, 
        ( 
            SELECT EMP_NO, AVG(SCORE) AS 'AVG_SCORE'
                FROM HR_GRADE
                GROUP BY EMP_NO 
        ) gr
    WHERE emp.EMP_NO = gr.EMP_NO
    ORDER BY emp.EMP_NO