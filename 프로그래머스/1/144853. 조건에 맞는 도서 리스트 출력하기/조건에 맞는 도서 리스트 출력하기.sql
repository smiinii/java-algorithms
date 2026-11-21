-- BOOK 테이블에서 2021년에 출판된
-- 인문 카테고리에서 속하는 도서 리스트를 찾아서
-- 도서 ID, 출판일을 출력
-- 출판일 기준으로 오름차순
SELECT   BOOK_ID, PUBLISHED_DATE
FROM     BOOK
WHERE    PUBLISHED_DATE LIKE '2021%' AND CATEGORY LIKE '인문'
ORDER BY PUBLISHED_DATE ASC;