CREATE TABLE blog (
 id VARBINARY(36) NOT NULL PRIMARY KEY,
 name VARCHAR(80) NOT NULL,
 url VARCHAR(200),
 ipdomain VARCHAR(120),
 description VARCHAR(320),
 meta_keywords VARCHAR(120) NULL DEFAULT NULL,
 meta_description VARCHAR(300) NULL DEFAULT NULL,
 created_at DATETIME NOT NULL
);

CREATE TABLE post (
 id VARBINARY(36) NOT NULL PRIMARY KEY,
 blog_id VARBINARY(36) NOT NULL PRIMARY KEY,
 parentId VARBINARY(36) NULL DEFAULT NULL,
 title VARCHAR(100) NOT NULL,
 slug VARCHAR(120) NOT NULL,
 content TEXT NOT NULL,
 meta_keywords VARCHAR(120) NULL DEFAULT NULL,
 meta_description VARCHAR(300) NULL DEFAULT NULL,
 created_at DATETIME NOT NULL,
 updated_at DATETIME,
 published_at DATETIME,
 CONSTRAINT `fk_blog` FOREIGN KEY (blog_id) REFERENCES blog (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
);

CREATE TABLE category (
 id VARBINARY(36) NOT NULL PRIMARY KEY,
 blog_id VARBINARY(36) NOT NULL,
 parentId VARBINARY(36) NULL DEFAULT NULL,
 title VARCHAR(100) NOT NULL,
 slug VARCHAR(120) NOT NULL,
 content TEXT NULL DEFAULT NULL
 meta_keywords VARCHAR(120) NULL DEFAULT NULL,
 meta_description VARCHAR(300) NULL DEFAULT NULL,
 CONSTRAINT `fk_blog` FOREIGN KEY (blog_id) REFERENCES blog (id) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE post_category (
 id VARBINARY(36) NOT NULL PRIMARY KEY,
 post_id VARBINARY(36) NOT NULL,
 category_id VARBINARY(36) NOT NULL,
 blog_id VARBINARY(36) NOT NULL PRIMARY KEY,
 CONSTRAINT `fk_post` FOREIGN KEY (post_id) REFERENCES post (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
 CONSTRAINT `fk_category` FOREIGN KEY (category_id) REFERENCES category (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
 CONSTRAINT `fk_blog` FOREIGN KEY (blog_id) REFERENCES blog (id) ON DELETE NO ACTION ON UPDATE NO ACTION
);