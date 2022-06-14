package main;

import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Logger;

public class PlainJdbcDemo {
    private static SingerDAO singerDao = new PlainSingerDao();
    private static Logger logger =
            Logger.getLogger(String.valueOf(PlainJdbcDemo.class));

    public static void main(String[] args) {

        logger.info("Listing initial singer data:");
        listAllSingers();
        logger.info("-------------");
        logger.info("Insert а new singer");
        Singer singer = new Singer();
        singer.setFirstName("Ed");
        singer.setLastName("Sheeran");
        singer.setBirthDate(new Date
                ((new GregorianCalendar(1991, 2, 1991))
                        .getTime().getTime()));
        singerDao.insert(singer);
        logger.info("Listing singer data "
                + "after new singer created:");
        listAllSingers();
        logger.info("-------------");
        logger.info("Deleting the previous created singer");
        singerDao.delete(singer.getId());
        logger.info("Listing singer data "
                + "after new singer deleted:");

        listAllSingers();
    }
        private static void listAllSingers () {
            List<Singer> singers = singerDao.findAll();
            for (Singer singer : singers) {
                logger.info(singer.toString());
            }
        }

}
