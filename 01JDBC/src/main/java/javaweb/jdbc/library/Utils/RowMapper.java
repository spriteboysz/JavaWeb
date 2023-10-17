package javaweb.jdbc.library.Utils;

import java.sql.ResultSet;

public interface RowMapper<T> {
    T getRow(ResultSet resultSet);
}
