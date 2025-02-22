package cn.tedu.baking.mapper;

import cn.tedu.baking.pojo.vo.BannerAdminVO;
import cn.tedu.baking.pojo.vo.BannerVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BannerMapper {
    /**
     * 首页查询所有轮播图
     *
     * @return 轮播图页面
     */
    List<BannerVO> selectAll();

    /**
     * 管理员页面查询轮播图
     *
     * @return 轮播图页面
     */
    List<BannerAdminVO> selectForAdmin();


    /**
     * 删除轮播图
     *
     * @param id 轮播图id
     * @return 影响的记录数
     */
    int deleteById(Long id);
}
