DROP TABLE if exists comments ;
DROP SEQUENCE  if exists global_seq_two;
CREATE SEQUENCE global_seq_two START 1;

CREATE TABLE comments (
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  userId            INTEGER   NOT NULL,
  articleId         INTEGER   NOT NULL,
  text              TEXT      NOT NULL,
  dateTime          TIMESTAMP NOT NULL
);

INSERT INTO comments (userId, articleId, text, dateTime) VALUES
  (11, 1, 'good', '1999-01-08 04:05:06'),
  (22, 2,  'very boring', '1999-01-08 04:05:06'),
  (23, 12, 'it is about my life', '1999-01-08 04:05:06'),
  (45, 11, 'do you know the way?', '1999-01-08 04:05:06'),
  (51, 1, 'emmm..', '1999-01-08 04:05:06');