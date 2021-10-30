CREATE TABLE recipe(
   id          INTEGER  NOT NULL PRIMARY KEY
  ,name        VARCHAR(30) NOT NULL
  ,image       VARCHAR(31) NOT NULL
  ,category    VARCHAR(9) NOT NULL
  ,label       VARCHAR(5)
  ,price       NUMERIC(4,2) NOT NULL
  ,description VARCHAR(113) NOT NULL
);