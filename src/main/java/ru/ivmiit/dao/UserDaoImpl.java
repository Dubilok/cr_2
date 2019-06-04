package ru.ivmiit.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.ivmiit.models.User;

import javax.sql.DataSource;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;

    //language=SQL
    private final String SQL_SELECT_ALL_USER = "SELECT * FROM vebinar.user";

    //language=SQL
    private final String SQL_SAVE_USER = "INSERT INTO user (name, email, age) VALUES (?,?,?)";

    //language=SQL
    private final String SQL_GET_USER_BY_ID = "SELECT * FROM user WHERE id = ?";

    //language=SQL
    private final String SQL_UPDATE_USER = "UPDATE user SET name = ?, email = ?, age = ? WHERE id = ?";

    //language=SQL
    private final String SQL_DELETE_USER = "DELETE FROM user WHERE id = ?";

    @Autowired
    public UserDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    private RowMapper<User> rowMapper = (resultSet, i) -> new User(
            resultSet.getInt("id"),
            resultSet.getString("name"),
            resultSet.getString("email"),
            resultSet.getInt("age")
    );

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL_USER, rowMapper);
    }

    @Override
    public void save(User user) {
        jdbcTemplate.update(SQL_SAVE_USER, user.getName(), user.getEmail(), user.getAge());
    }

    @Override
    public User getById(Integer id) {
        return jdbcTemplate.queryForObject(SQL_GET_USER_BY_ID, rowMapper, id);
    }

    @Override
    public void delete(Integer id) {
        jdbcTemplate.update(SQL_DELETE_USER, id);
    }

    @Override
    public void update(User user) {
        jdbcTemplate.update(SQL_UPDATE_USER, user.getName(), user.getEmail(), user.getAge(), user.getId());
    }
}
