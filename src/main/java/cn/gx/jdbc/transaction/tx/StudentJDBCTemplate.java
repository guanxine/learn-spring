package cn.gx.jdbc.transaction.tx;

import cn.gx.jdbc.transaction.StudentDAO;
import cn.gx.jdbc.transaction.StudentMarks;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by always on 16/3/16.
 */
public class StudentJDBCTemplate implements StudentDAO{

    private JdbcTemplate jdbcTemplateObject;

    private RowMapper studentMarksMap=(rs, i)->{
        StudentMarks studentMarks = new StudentMarks();

        studentMarks.setId(rs.getInt("id"));
        studentMarks.setName(rs.getString("name"));
        studentMarks.setAge(rs.getInt("age"));
        studentMarks.setSid(rs.getInt("sid"));
        studentMarks.setMarks(rs.getInt("marks"));
        studentMarks.setYear(rs.getInt("year"));

        return studentMarks;
    };
    @Override
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplateObject=new JdbcTemplate(dataSource);
    }

    @Override
    public void create(String name, Integer age, Integer marks, Integer year) {
        try {
            String SQL1 = "insert into Student (name, age) values (?, ?)";
            jdbcTemplateObject.update( SQL1, name, age);

            // Get the latest student id to be used in Marks table
            String SQL2 = "select max(id) from Student";
            int sid = jdbcTemplateObject.queryForObject( SQL2,Integer.class);

            String SQL3 = "insert into Marks(sid, marks, year) " +
                    "values (?, ?, ?)";
            jdbcTemplateObject.update( SQL3, sid, marks, year);

            System.out.println("Created Name = " + name + ", Age = " + age);
            // to simulate the exception.
            throw new RuntimeException("simulate Error condition") ;
        } catch (DataAccessException e) {
            System.out.println("Error in creating record, rolling back");
            throw e;
        }
    }

    @Override
    public List<StudentMarks> listStudents() {
        String SQL = "select * from Student JOIN Marks on Student.id=Marks.sid";

        List <StudentMarks> studentMarks=jdbcTemplateObject.query(SQL,studentMarksMap);
        return studentMarks;
    }
}
