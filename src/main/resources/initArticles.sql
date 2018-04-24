DROP TABLE if exists articles ;
DROP SEQUENCE  if exists global_seq;
CREATE SEQUENCE global_seq START 1;

CREATE TABLE articles (
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name        TEXT      NOT NULL,
  text        TEXT      NOT NULL,
  userId      INTEGER   NOT NULL,
  dateTime    TIMESTAMP NOT NULL
);

INSERT INTO articles (name, text, userId, dateTime) VALUES
  ('Articles1', 'Fghdg ssgejhjjsgs', 100000, '1999-01-08 04:05:06'),
  ('Articles2', 'Fghdsdg ssgesgfjhjjsgs', 100000, '1999-01-08 04:05:06'),
  ('Articles3', 'Fghdddg ssgejsfgdshjjsgs', 100000, '1999-01-08 04:05:06'),
  ('Articles4', 'Fghsdgdg sdgsdssgejhjjsgs', 100000, '1999-01-08 04:05:06'),
  ('Articles5', 'Fghdsdgssethdg ssgejhjjsgs', 100000, '1999-01-08 04:05:06'),
  ('Articles6', 'Fghdsdgsdg sehtssgejhjjsgs', 100000, '1999-01-08 04:05:06'),
  ('Articles7', 'Fghsthdsdgsdsethg ssgejhjjsgs', 100000, '1999-01-08 04:05:06'),
  ('Articles8', 'Fghdsrhtsdgsdg ssgejhjjsgs', 100000, '1999-01-08 04:05:06'),
  ('Articles9', 'Fghdsrhtsdgsdg ssgejhjjsgs', 100000, '1999-01-08 04:05:06'),
  ('Articles10', 'Fghdsrhhssdgsdg ssgejhjjsgs', 100000, '1999-01-08 04:05:06'),
  ('Articles11', 'sejtsejFghdejsetjsdgsdg ssgejhjjsgs', 100000, '1999-01-08 04:05:06'),
  ('Articles12', 'Fghsjsetjdsdgsdg ssgejhjjsgs', 100000, '1999-01-08 04:05:06'),
  ('Articles13', 'Fghsejtsedsdgsdg ssgejhjjsgs', 100000, '1999-01-08 04:05:06'),
  ('Articles14', 'Fghdsjsejdgsdg ssgejhjjsgs', 100000, '1999-01-08 04:05:06'),
  ('Articles15', 'Fghdsdsegsdg ssgejhjjsgs', 100000, '1999-01-08 04:05:06'),
  ('Articles16', 'Fghdsdgtjrtsdg htssgejhjjsgs', 100000, '1999-01-08 04:05:06'),
  ('Articles17', 'Fghdsdgjrtsdg ssgejhjjsgs', 100000, '1999-01-08 04:05:06'),
  ('Articles18', 'Fghdsdgjsstsdg ssgejhjjsgs', 100000, '1999-01-08 04:05:06'),
  ('Articles19', 'Fghdsdgsdtjsttjg ssgejhjjsgs', 100000, '1999-01-08 04:05:06'),
  ('Articles21', 'Fghdsdgssesejtjdg ssgejhjjsgs', 100000, '1999-01-08 04:05:06'),
  ('Articles22', 'Fghdsdgssesejtjdg ssgejhjjsgs', 100000, '1999-01-08 04:05:06'),
  ('Articles23', 'Fghdsdgssesejtjdg ssgejhjjsgs', 100000, '1999-01-08 04:05:06'),
  ('Articles24', 'Fghdsdgssesejtjdg ssgejhjjsgs', 100000, '1999-01-08 04:05:06'),
  ('Articles25', 'Fghdsdgssesejtjdg ssgejhjjsgs', 100000, '1999-01-08 04:05:06'),
  ('Articles26', 'Fghdsdgssesejtjdg ssgejhjjsgs', 100000, '1999-01-08 04:05:06');