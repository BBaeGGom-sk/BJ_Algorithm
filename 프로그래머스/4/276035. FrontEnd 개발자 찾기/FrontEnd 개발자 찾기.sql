SELECT DISTINCT ID, EMAIL, FIRST_NAME, LAST_NAME
    FROM DEVELOPERS dev 
        RIGHT JOIN 
            (
                SELECT CODE
                    FROM SKILLCODES sc 
                    WHERE sc.CATEGORY = 'Front End'
            ) sc
        ON dev.SKILL_CODE & sc.CODE
    ORDER BY ID
        
        # SELECT DISTINCT ID
        #     FROM DEVELOPERS dev, SKILLCODES sc 
        #     WHERE dev.SKILL_CODE & sc.CODE
        #     ORDER BY ID
        
    