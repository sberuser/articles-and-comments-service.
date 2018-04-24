DROP TABLE IF EXISTS comments;
DROP TABLE IF EXISTS articles;

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
  dateTime   TIMESTAMP DEFAULT now()
);

DELETE FROM comments;
DELETE FROM articles;
ALTER SEQUENCE global_seq RESTART WITH 100000;
INSERT INTO articles (name, text, userId, dateTime) VALUES
  ('Article1', 'The first test',101 ,'2018-04-09 00:00:00'),
  ('Article2', 'The two test',101 ,'2018-04-08 00:00:00');

INSERT INTO comments (userId, articleId, text, dateTime) VALUES
  (101, 100, 'The first test comment', '2018-04-12 00:00:00'),
  (102, 100, 'The two test comment', '2018-04-11 00:00:00');