package main;

import lombok.Data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Data
class PlainSingerDao implements SingerDAO {
    private static Logger logger =
            Logger.getLogger(String.valueOf(PlainSingerDao.class));

    static {
        try {
            System.out.println("LOAD SQL DRIVER");
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ех) {
            logger.info("Problem loading DB dDiver!");
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","alex", "123");
    }

    private void closeConnection(Connection connection)
    {
            if (connection == null) {
                return;
            }
            try {
                connection.close();
            } catch (SQLException ех) {
                logger.info("Problem closing connection to the database!");
            }
    }

    @Override
     public List<Singer> findAll () {
        List<Singer> result = new ArrayList<>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection
                    .prepareStatement("select * from SINGER");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Singer singer = new Singer();
                singer.setId(resultSet.getLong("id"));
                singer.setFirstName(resultSet
                        .getString("first_name"));
                singer.setLastName(resultSet
                        .getString("last_name"));
                singer.setBirthDate(resultSet
                        .getDate("birth_date"));
                result.add(singer);
            }
            statement.close();
        } catch (SQLException ех) {
            logger.info("Problem when executing SELECT!");
        } finally {
            closeConnection(connection);
        }
        return result;
    }

    @Override
    public List<Singer> findByFirstName(String firstName) {
        return null;
    }

    @Override
    public String findLastNameById(Long id) {
        return null;
    }

    @Override
    public String findFirstNameById(Long id) {
        return null;
    }

    @Override
    public void insert(Singer singer) {
        Connection connection = null;
        try {
        connection = getConnection();
        PreparedStatement statement =
                connection.prepareStatement("INSERT INTO SINGER "
                        + "(first_name, last_name, birth_date) + VALUES(?, ?, ?)"
                    , Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, singer.getFirstName());
            statement.setString(2, singer.getLastName());
            statement.setDate(3, singer.getBirthDate());
            statement.execute();
            ResultSet generatedKeys =
                    statement.getGeneratedKeys();
            if ( generatedKeys.next() ) {
                singer.setId(generatedKeys.getLong(1));
            }
                statement.close();
            }
            catch (SQLException ех) {
                logger.info("Problem executing INSERT");
            }
            finally {
            closeConnection(connection);
        }
    }

    @Override
    public void update(Singer singer) {

    }

    @Override
    public void delete(Long singerId) {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement =
                    connection.prepareStatement(
                            "delete from SINGER where id=?");
            statement.setLong(1, singerId);
            statement.execute();
            statement.close();
        } catch (SQLException ех) {
            logger.info("Problem executing DELETE");
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public List<Singer> findAllWithDetail() {
        return null;
    }

    @Override
    public void insertWithDetail(Singer singer) {

    }

}