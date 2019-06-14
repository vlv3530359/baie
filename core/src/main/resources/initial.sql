CREATE TABLE CAR(
ID Integer NOT NULL AUTO_INCREMENT PRIMARY KEY,
PRODUCT_ID Integer NOT NULL,
price Integer,
count Integer,
USER_ID VARCHAR(256),
CREATED_BY VARCHAR(256),
UPDATE_BY VARCHAR(256),
CREATION_DATE TIMESTAMP,
LAST_MOD_DATE TIMESTAMP,
VERSION Integer
);



CREATE TABLE PRODUCT(
PRODUCT_ID Integer NOT NULL auto_increment,
PRODUCT_NAME VARCHAR(512),
LONG_DESCRIPTION VARCHAR(1024),
CATEGORY_ID Integer,
PRODUCT_PRICE Integer,
PRODUCT_IMAGE VARCHAR(256),
CREATED_BY VARCHAR(256),
UPDATE_BY VARCHAR(256),
CREATION_DATE TIMESTAMP,
LAST_MOD_DATE TIMESTAMP,
VERSION Integer,
primary key(PRODUCT_ID)
);

CREATE TABLE SKU (
ID Integer NOT NULL AUTO_INCREMENT PRIMARY KEY,
DISPLAY_NAME VARCHAR(256),
LONG_DESCRIPTION VARCHAR(1024),
PRODUCT_ID Integer,
CREATED_BY VARCHAR(256),
UPDATE_BY VARCHAR(256),
CREATION_DATE TIMESTAMP,
LAST_MOD_DATE TIMESTAMP,
VERSION Integer
);

CREATE TABLE USER(
USER_ID Integer NOT NULL AUTO_INCREMENT PRIMARY KEY,
FIRST_NAME VARCHAR(512),
LAST_NAME VARCHAR(512),
ADDRESS VARCHAR(1024),
PHONE_NUMBER VARCHAR(1024),
GENDER VARCHAR(8),
USER_NAME VARCHAR(64),
PASSWORD VARCHAR(64),
CREATED_BY VARCHAR(256),
UPDATE_BY VARCHAR(256),
CREATION_DATE TIMESTAMP,
LAST_MOD_DATE TIMESTAMP,
VERSION Integer
);