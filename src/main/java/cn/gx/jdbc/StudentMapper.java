package cn.gx.jdbc;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by always on 16/3/16.
 */
public class StudentMapper implements RowMapper<Student>{
    @Override
    public Student mapRow(ResultSet rs, int i) throws SQLException {

        Student student=new Student();
        student.setId(rs.getInt("id"));
        student.setName(rs.getString("name"));
        student.setAge(rs.getInt("age"));
        return student;
    }
}
