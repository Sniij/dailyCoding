SELECT
    Extract(Hour from DATETIME) as hour
    , count (DATETIME) as count

FROM 
    ANIMAL_OUTS 
WHERE 
    Extract(Hour from DATETIME) >=9 and Extract(Hour from DATETIME) < 20
GROUP BY 
    Extract(Hour from DATETIME)
ORDER BY 1 asc