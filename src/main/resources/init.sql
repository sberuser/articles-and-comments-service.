DROP TABLE if exists articles ;
DROP SEQUENCE  if exists global_seq;
CREATE SEQUENCE global_seq START 1;

CREATE TABLE articles (
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name        TEXT      NOT NULL,
  text        TEXT      NOT NULL,
  userid        INTEGER   NOT NULL,
  date        TIMESTAMP NOT NULL
);

INSERT INTO articles (name, text, userid, date) VALUES
  ('Articles1', 'Fghdg ssgejhjjsgs', 11, '1999-01-08 04:05:06'),
  ('Articles2', 'Fghdsdg ssgesgfjhjjsgs', 35, '1999-01-08 04:05:06'),
  ('Articles3', 'Fghdddg ssgejsfgdshjjsgs', 30, '1999-01-08 04:05:06'),
  ('Articles4', 'Fghsdgdg sdgsdssgejhjjsgs', 13, '1999-01-08 04:05:06'),
  ('Articles5', 'Fghdsdgsdg ssgejhjjsgs', 99, '1999-01-08 04:05:06');