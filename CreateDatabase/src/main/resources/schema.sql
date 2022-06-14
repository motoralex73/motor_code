CREATE TABLE SINGER (
                    ID INT NOT NULL AUTO_INCREMENT
                    , FIRST_NAМE VARCHAR(60) NOT NULL
                    , LAST_NAМE VARCHAR(40) NOT NULL
                    , BIRTH_DATE DATE
                    , UNIQUE UQ_SINGER_1 (FIRST_NAМE, LAST_NAМE)
                    , PRIMARY KEY (ID) );
CREATE TABLE ALBUМ (
                    ID INT NOT NULL AUTO INCREMENT
                , SINGER_ID INT NOT NULL
                , TITLE VARCHAR(100) NOT NULL
                , RELEASE_DATE DATE
                , UNIQUE UQ_SINGER_ALBUM_1 (SINGER_ID, TITLE)
                , PRIMARY KEY (ID)
                , CONSTRAINT FK_ALBUM FOREIGN КЕУ (SINGER_ID)
                REFERENCES SINGER (ID) );