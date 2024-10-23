-- CREATE TABLE perdidosachados;
-- USE perdidosachados;

CREATE TABLE category(
	category_id INT PRIMARY KEY AUTO_INCREMENT,
    category_name VARCHAR(50) NOT NULL,
    category_description VARCHAR(255)
);

CREATE TABLE status(
	status_id INT PRIMARY KEY AUTO_INCREMENT,
    status_name VARCHAR(50) NOT NULL,
    status_description VARCHAR(255)
);

CREATE TABLE local(
	local_id INT PRIMARY KEY AUTO_INCREMENT,
    local_name VARCHAR(50) NOT NULL,
    local_description VARCHAR(255),
    local_link VARCHAR(255)
);

CREATE TABLE ROLE(
	role_id INT PRIMARY KEY AUTO_INCREMENT,
    role_name VARCHAR(50) NOT NULL,
    role_description VARCHAR(255)
);

CREATE TABLE user(
	user_id INT PRIMARY KEY AUTO_INCREMENT,
    user_name VARCHAR(50) NOT NULL,
    user_email VARCHAR(50) NOT NULL,
    user_password VARCHAR(255) NOT NULL
);

CREATE TABLE phone(
	phone_nr VARCHAR(30) PRIMARY KEY UNIQUE,
    id_user INT,
    CONSTRAINT FK_phone_user FOREIGN KEY (id_user) REFERENCES user(user_id)
);

CREATE TABLE user_role(
	user_role_id INT PRIMARY KEY AUTO_INCREMENT,
	id_user INT NOT NULL,
    id_role INT NOT NULL,
    CONSTRAINT FK_userrole_user FOREIGN KEY (id_user) REFERENCES user(user_id),
    CONSTRAINT FK_userrole_role FOREIGN KEY (id_role) REFERENCES role(role_id)
);

CREATE TABLE item(
	item_id INT PRIMARY KEY AUTO_INCREMENT,
    item_name VARCHAR(50),
    item_description VARCHAR(255),
    id_category INT,
    id_status INT,
    id_local INT,
    id_user INT,
    CONSTRAINT FK_item_user FOREIGN KEY (id_user) REFERENCES user(user_id),
    CONSTRAINT FK_item_local FOREIGN KEY (id_local) REFERENCES local(local_id),
    CONSTRAINT FK_item_status FOREIGN KEY (id_status) REFERENCES status(status_id),
    CONSTRAINT FK_item_category FOREIGN KEY (id_category) REFERENCES category(category_id)
);

CREATE TABLE CLAIM(
	claim_id INT PRIMARY KEY AUTO_INCREMENT,
    id_user INT,
    id_item INT,
    claim_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    claim_accepted BOOLEAN DEFAULT FALSE,
    CONSTRAINT FK_claim_user FOREIGN KEY (id_user) REFERENCES user(user_id),
    CONSTRAINT FK_claim_item FOREIGN KEY (id_item) REFERENCES item(item_id)
);


CREATE TABLE session(
	session_id INT PRIMARY KEY AUTO_INCREMENT,
    session_token VARCHAR(255) UNIQUE,
    session_start DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
    session_end DATETIME NOT NULL,
    id_user INT,
    CONSTRAINT FK_session_user FOREIGN KEY (id_user) REFERENCES user(user_id)
);