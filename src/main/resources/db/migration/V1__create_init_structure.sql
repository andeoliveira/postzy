CREATE TABLE post (
 id VARBINARY(36) PRIMARY KEY,
 title VARCHAR(100),
 slug VARCHAR(120),
 created_at DATETIME,
 updated_at DATETIME,
 published_at DATETIME,
 content TEXT
);