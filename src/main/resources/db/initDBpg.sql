DROP TABLE IF EXISTS comments;
DROP TABLE IF EXISTS articles;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START 100000;

CREATE TABLE articles (
  id          INTEGER   PRIMARY KEY DEFAULT nextval('global_seq'),
  userId     INTEGER   NOT NULL,
  name        TEXT      NOT NULL,
  text        TEXT      NOT NULL,
  dateTime   TIMESTAMP DEFAULT now()
);

CREATE TABLE comments (
  id          INTEGER   PRIMARY KEY DEFAULT nextval('global_seq'),
  userId     INTEGER   NOT NULL,
  articleId  INTEGER   NOT NULL,
  text        TEXT      NOT NULL,
  dateTime   TIMESTAMP DEFAULT now(),
  FOREIGN KEY (articleId) REFERENCES articles (id) ON DELETE CASCADE
);