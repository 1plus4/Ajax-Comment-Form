# --- !Ups

CREATE SEQUENCE comment_id_seq;
CREATE TABLE comment (
    id integer NOT NULL DEFAULT nextval('comment_id_seq'),
    comment text,
);

# --- !Downs

DROP TABLE comment;
DROP SEQUENCE comment_id_seq;