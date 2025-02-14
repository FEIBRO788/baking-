package cn.tedu.baking;

import cn.tedu.baking.mapper.BannerMapper;
import cn.tedu.baking.pojo.VO.BannerAdminVO;
import cn.tedu.baking.pojo.VO.BannerVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BannerTest {
    @Autowired
    BannerMapper bannerMapper;
    @Test
    public void testSelectBannerAll(){
        List<BannerVO> bannerVOS = bannerMapper.selectBannerAll();
        for (BannerVO bannerVO:bannerVOS){
            System.out.println(bannerVO);
        }
    }
    //管理员查看轮播图
    @Test
    public void testAdmin(){
        List<BannerAdminVO> bannerAdminVOS = bannerMapper.selectBannerAdmin();
        for (BannerAdminVO bannerAdminVO:bannerAdminVOS){
            System.out.println(bannerAdminVO);
        }
    }
    //管理员删除轮播图
    @Test
    public void deleteBannerByAdmin(){
        int i = bannerMapper.deleteBannerById(3l);
        System.out.println(i>0?"delete succeed":"delete fail");
    }

}
