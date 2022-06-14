CREATE TABLE SINGER (
                    ID INT NOT NULL AUTO_INCREMENT
                    , FIRST_NAМE VARCHAR(60) NOT NULL
                    , LAST_NAМE VARCHAR(40) NOT NULL
                    , BIRTH_DATE DATE
                    , UNIQUE UQ_SINGER_l (FIRST_NAМE, LAST_NAМE)
                    , PRIMARY KEY (ID) );
CREATE TABLE ALBUМ (
                    ID INT NOT NULL AUTO INCREMENT
                , SINGER_ID INT NOT NULL
                , TITLE VARCHAR(l00) NOT NULL
                , RELEASE_DATE DATE
                , UNIQUE UQ_SINGER_ALBUM_l (SINGER_ID, TITLE)
                , PRIМARY КЕУ (ID)
                , CONSTRAINT FK_ALBUM FOREIGN КЕУ (SINGER_ID)
                REFERENCES SINGER (ID) );