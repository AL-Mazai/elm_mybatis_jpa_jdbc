import com.elm.mapper.BusinessMapper;
import com.elm.mapper.impl.BusinessMapperImpl;
import com.elm.pojo.Business;
import com.elm.view.BusinessView;
import com.elm.view.impl.BusinessViewImpl;
import org.junit.Test;

import java.util.Scanner;

public class MybatisBusinessTest {
    BusinessView businessView = new BusinessViewImpl();
    BusinessMapper businessMapper = new BusinessMapperImpl();
    @Test
    public  void getBusinessById() {
        Business business = businessMapper.getBusinessById(10005);
        System.out.println(business);
    }
    @Test
    public  void getBusinessList() {
        String name = "饭";
        String address = "沈阳";
        businessView.listBusinessAll();
        System.out.println();
    }
    @Test
    public  void deleteBusinessById() {
        boolean isDel = businessMapper.removeBusiness(100017);
        System.out.println(isDel);
    }
    @Test
    public void updateBusinessById() {
        Business business = new Business();
        business.setBusinessId(10002);
        business.setDeliveryPrice(14.5);
        boolean b = businessMapper.updateBusiness(business);
        System.out.println(b);
    }
    @Test
    public void addBusiness() {
//        Business business = new Business();
////        business.setBusinessId(10011);
//        business.setBusinessName("1111");
//        business.setBusinessAddress("222");
//        business.setBusinessExplain("33333");
//        business.setPassword("123");
//        business.setStarPrice(10.5);
//        business.setDeliveryPrice(14.5);
//        int id = businessMapper.saveBusiness(business);
//        System.out.println(id);
//        businessView.saveBusiness();
        Scanner scanner = new Scanner(System.in);
        Business business = new Business();
        business.setBusinessName(scanner.next());
        System.out.println(business.getBusinessName());
    }
    @Test
    public void updateBusinessPasswordById() {
        Business business = new Business();
        int id = 10003;
        String password = "12345678";
        boolean b = businessMapper.updateBusinessPasswordById(id, password);
        System.out.println(b);
    }
}
