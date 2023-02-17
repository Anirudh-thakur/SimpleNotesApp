SQL Tables 
CREATE TABLE notes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE notes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    description TEXT NOT NULL);
END Points 
curl http://localhost:8080/notes

References 
    https://www.springboottutorial.com/spring-boot-with-mysql-and-oracle

    https://www.baeldung.com/spring-boot-react-crud

