package ui.CDC;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DAO {
    private QueryRunner queryRunner= new QueryRunner();
//    public int addBook(Book book) {
//
//        String sql = "insert into t_book(`name`,`author`,`price`,`sales`,`stock`,`img_path`) values(?,?,?,?,?,?)";
//
//        return update(sql, book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath());
//
//    }


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

    public int updateAgreement(int id) {
        String sql = "update hospital set `CDCResponse`=? where id = ?";
        return update(sql,1,id);
    }

    public int updateIgnore(int id) {
        String sql = "update hospital set `CDCResponse`=? where id = ?";
        return update(sql,0,id);
    }


//    public Book queryBookById(Integer id) {
//        String sql = "select `id` , `name` , `author` , `price` , `sales` , `stock` , `img_path` imgPath from t_book where id = ?";
//        return queryForOne(Book.class, sql,id);
//    }


    public List<Record> queryRecords() {
        String sql = "select * from hospital where reportToCDC = ?";
        return queryForList(Record.class, sql,1);
    }





//    public Integer queryForPageTotalCount() {
//        String sql = "select count(*) from t_book";
//        Number count = (Number) queryForSingleValue(sql);
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
