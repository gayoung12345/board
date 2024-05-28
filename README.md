CREATE TABLE IF NOT EXISTS board ( id INT AUTO_INCREMENT PRIMARY KEY, title VARCHAR(255) NOT NULL, content TEXT NOT NULL,
created_at DATETIME DEFAULT CURRENT_TIMESTAMP);  

-- 프로시저 생성
DELIMITER //

CREATE PROCEDURE InsertTestData()
BEGIN
    DECLARE i INT DEFAULT 1;
    
    WHILE i <= 10 DO
        INSERT INTO board (title, content) VALUES (CONCAT('Title ', i), CONCAT('Content ', i));
        SET i = i + 1;
    END WHILE;
END //

DELIMITER ;

CALL InsertTestData();

select * from board.board;
