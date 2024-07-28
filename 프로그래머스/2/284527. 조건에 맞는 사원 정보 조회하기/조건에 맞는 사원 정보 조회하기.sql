SELECT SUM(SCORE) AS SCORE, 
       HE.EMP_NO, 
       HE.EMP_NAME, 
       HE.POSITION, 
       HE.EMAIL 
FROM HR_EMPLOYEES HE 
JOIN HR_DEPARTMENT HD 
    ON HE.DEPT_ID = HD.DEPT_ID
JOIN HR_GRADE HG
    ON HE.EMP_NO = HG.EMP_NO
GROUP BY HE.EMP_NO
ORDER BY SCORE DESC LIMIT 1;