SELECT
       SUBSTR(PRODUCT_CODE,1,2)     "상품카테고리코드"
     , COUNT(PRODUCT_ID)            "상품개수"
  FROM
       PRODUCT
 WHERE 1=1
 GROUP BY SUBSTR(PRODUCT_CODE,1,2)
 ORDER BY 상품카테고리코드 ASC