-- 코드를 작성해주세요
WITH GRADE_CTE AS (
SELECT EMP_NO, (CASE
                WHEN AVG(SCORE) >= 96 THEN 'S'
                WHEN AVG(SCORE) >= 90 THEN 'A'
                WHEN AVG(SCORE) >= 80 THEN 'B'
                ELSE 'C'
                END) AS GRADE, (CASE
                WHEN AVG(SCORE) >= 96 THEN 0.20
                WHEN AVG(SCORE) >= 90 THEN 0.15
                WHEN AVG(SCORE) >= 80 THEN 0.10
                ELSE 0
                END )AS PTG
FROM HR_GRADE
GROUP BY EMP_NO
)

SELECT e.EMP_NO, e.EMP_NAME, g.GRADE, (e.SAL * g.PTG) AS BONUS
FROM HR_EMPLOYEES e JOIN GRADE_CTE g
ON e.EMP_NO = g.EMP_NO
ORDER BY e.EMP_NO ASC