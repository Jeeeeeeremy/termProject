package ui.CDC;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DAO {
    private QueryRunner queryRunner= new QueryRunner();



//    public int deleteBookById(Integer id) {
//        String sql = "delete from t_book where id = ?";
//        return update(sql, id);
//    }


    public <T> List<T> queryForList(Class<T> type, String sql, Object...args ){
        Connection conn = JDBCUtil.getConnection();
        try {
            return queryRunner.query(conn,sql, new BeanListHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn);
        }
        return null;
    }

    public int update(String sql, Object...args){
        Connection conn = JDBCUtil.getConnection();
        try {
            return queryRunner.update(conn,sql,args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn);
        }
        return -1;
    }

    public int addWarning(Warning warning) {

        String sql = "insert into warning(disease,date,case_number,status) values(?,?,?,?)";

        return update(sql, warning.getDisease(),warning.getDate(),warning.getCase_number(),warning.getStatus());

    }


    public int updateReport(int id) {
        String sql = "update hospital set `reportToCDC`=1 where id = ?";
        return update(sql,id);
    }
    public int updateWarning(int id) {
        String sql = "update warning set `status`=1 where id = ?";
        return update(sql,id);
    }
    public int updateAgreement(int id) {
        String sql = "update hospital set `CDCResponse`=? where id = ?";
        return update(sql,1,id);
    }

    public int updateIgnore(int id) {
        String sql = "update hospital set `CDCResponse`=? where id = ?";
        return update(sql,0,id);
    }

    public int updateIgnoreAdmin(int id) {
        String sql = "update hospital set `CDCResponse`=0, `reportToCDC`=0 where id = ?";
        return update(sql,id);
    }

    public int updateAgreementAdmin(int id) {
        String sql = "update hospital set `CDCResponse`=? where id = ?";
        return update(sql,2,id);
    }


    public <T> T queryForOne(Class<T> type, String sql, Object...args ){
        Connection conn = JDBCUtil.getConnection();
        try {
            return queryRunner.query(conn,sql,new BeanHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn);
        }
        return null;
    }

    public User queryCDCbyEmail(String email,String password) {
        String sql = "select * from population where email = ? and password = ? and type = ?";
        return queryForOne(User.class, sql,email,password,"CDCstaff");
    }

    public User queryHospitalCDCbyEmail(String email,String password) {
        String sql = "select * from population where email = ? and password = ? and type = ?";
        return queryForOne(User.class, sql,email,password,"hospitalCDC");
    }

    public User queryCDCAdminbyEmail(String email,String password) {
        String sql = "select * from population where email = ? and password = ? and type = ?";
        return queryForOne(User.class, sql,email,password,"CDCAdmin");
    }

    public User queryGov(String email,String password) {
        String sql = "select * from population where email = ? and password = ? and type = ?";
        return queryForOne(User.class, sql,email,password,"Gov");
    }

    public User queryGovPre(String email,String password) {
        String sql = "select * from population where email = ? and password = ? and type = ?";
        return queryForOne(User.class, sql,email,password,"GovPre");
    }

    public List<Record> queryRecords() {
        String sql = "select * from hospital where reportToCDC = ? and status = 0 and CDCResponse is null";
        return queryForList(Record.class, sql,1);
    }

    public List<Record> queryReportedRecords() {
        String sql = "select * from hospital where reportToCDC = ? and CDCResponse = 1 and status = 0";
        return queryForList(Record.class, sql,1);
    }

    public List<Warning> queryReportedWarnings() {
        String sql = "select * from warning where status = 0";
        return queryForList(Warning.class, sql);
    }

    public List<Record> queryRecordsWithFilter(String item, String value) {
        String sql = "select * from hospital where reportToCDC = ? and status = 0 and CDCResponse is null and "+item+" = ?";
        return queryForList(Record.class, sql,1,value);
    }

    public List<Record> queryRecordsByStatus(String value) {
        String sql = "select * from hospital where reportToCDC = ? and CDCResponse is null ";
        return queryForList(Record.class, sql,value);
    }

    public List<Record> queryRecordsByStatus( String value,String value2) {
        String sql = "select * from hospital where reportToCDC = ? and CDCResponse =?";
        return queryForList(Record.class, sql,value,value2);
    }

    public List<Record> queryRawRecords() {
        String sql = "select * from hospital";
        return queryForList(Record.class, sql);
    }


    public Object queryForSingleValue(String sql, Object...args){
        Connection conn = JDBCUtil.getConnection();
        try {
            return queryRunner.query(conn,sql,new ScalarHandler(),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn);
        }
        return null;
    }
    public List<Stats> queryStats() {
        String sql = "select distinct diagnosis as name, count(*) AS count from hospital where reportToCDC = ? and status = 0 and CDCResponse = ? group by diagnosis order by count DESC LIMIT 5";
        return queryForList(Stats.class, sql,1,1);
    }
//    public Integer queryForTotalCount(String value) {
//        String sql = "select count(*) from hospital where diagnosis = ?";
//        Number count = (Number) queryForSingleValue(sql,value);
//        return count.intValue();
//
//    }
//
//    public List<Book> queryForPageItems(int begin, int pageSize) {
//        String sql = "select `id` , `name` , `author` , `price` , `sales` , `stock` , `img_path` imgPath from t_book limit ?,?";
//
//        return queryForList(Book.class,sql,begin,pageSize);
//    }
}
