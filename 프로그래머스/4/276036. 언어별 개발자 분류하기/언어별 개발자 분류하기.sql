SELECT d.GRADE, d.ID, d.EMAIL
FROM (
    SELECT 
        dev.ID,
        dev.EMAIL,
        CASE
            WHEN EXISTS (
                SELECT 1
                FROM SKILLCODES s1
                WHERE s1.CATEGORY = 'Front End'
                AND (dev.SKILL_CODE & s1.CODE) = s1.CODE
            )
            AND EXISTS (
                SELECT 1
                FROM SKILLCODES s2
                WHERE s2.NAME = 'Python'
                AND (dev.SKILL_CODE & s2.CODE) = s2.CODE
            )
            THEN 'A'

            WHEN EXISTS (
                SELECT 1
                FROM SKILLCODES s3
                WHERE s3.NAME = 'C#'
                AND (dev.SKILL_CODE & s3.CODE) = s3.CODE
            )
            THEN 'B'

            WHEN EXISTS (
                SELECT 1
                FROM SKILLCODES s4
                WHERE s4.CATEGORY = 'Front End'
                AND (dev.SKILL_CODE & s4.CODE) = s4.CODE
            )
            AND NOT EXISTS (
                SELECT 1
                FROM SKILLCODES s5
                WHERE s5.NAME IN ('Python', 'C#')
                AND (dev.SKILL_CODE & s5.CODE) = s5.CODE
            )
            THEN 'C'
        END AS GRADE
    FROM DEVELOPERS dev
) d
WHERE d.GRADE IS NOT NULL
ORDER BY d.GRADE, d.ID;
