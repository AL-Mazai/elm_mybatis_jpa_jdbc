import com.elm.dao.AdminDao;
import com.elm.dao.impl.AdminDaoImpl;
import com.elm.pojo.Admin;
import org.junit.Test;

public class JDBCAdminTest {
    AdminDao adminDao = new AdminDaoImpl();
    @Test
    public void getAdminTest(){
        String name = "王磊";
        String password = "123456";
        Admin admin = adminDao.getAdminByNameAndByPassword(name, password);
        System.out.println(admin);
    }
    @Test
    public void updateAdminPasswordTest(){
        Integer id = 1;
        String password = "1234";
        boolean b = adminDao.updateAdminPasswordById(id, password);
        System.out.println(b);
    }
}
