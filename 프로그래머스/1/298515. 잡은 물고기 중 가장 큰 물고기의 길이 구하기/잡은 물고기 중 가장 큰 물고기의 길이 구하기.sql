SELECT
    CONCAT(LENGTH, "cm") MAX_LENGTH
FROM
    FISH_INFO
ORDER BY
    LENGTH DESC
LIMIT 1;