package cn.tedu.baking.mapper;

import cn.tedu.baking.pojo.VO.BannerAdminVO;
import cn.tedu.baking.pojo.VO.BannerVO;

import java.util.List;

public interface BannerMapper {
    List<BannerVO> selectBannerAll();
    List<BannerAdminVO> selectBannerAdmin();
    int deleteBannerById(Long id);
}
