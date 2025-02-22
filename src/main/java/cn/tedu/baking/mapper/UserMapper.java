package cn.tedu.baking.mapper;

import cn.tedu.baking.pojo.entity.User;
import cn.tedu.baking.pojo.vo.UserAdminVO;
import cn.tedu.baking.pojo.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     *
     * @param user 需要传入一个User对象
     * @return 返回受影响的行数
     */
    int insertUser(User user);

    /**
     *  根据传入的用户名找 表中是否存在该记录,如果存在 返回 一个对象
     *  如果不存在 返回为null
     *  返回的信息包含 用户id,用户名,用户昵称,用户是否是管理员,用户头像路径
     * @param username
     */
    UserVO selectUserByUserName(String username);

    /**
     *   更新用户 根据用户的id进行更新
     * @param user
     * @return
     */
    int updateUserById(User user);

    /**
     *  查找指定用户id下的图片资源路径并返回
     * @param id
     * @return
     */
    String selectImgUrlById(Long id);

    /**
     * 查找user表中所有的用户记录,并将一个个的用户记录信息封装到一个个的UserAdminVO对象中
     * 最终返回一个集合
     * @return
     */
    List<UserAdminVO> selectAllUser();

    /**练习：
     *  根据传入的id 删除用户的接口方法和sql
     *  需要自行实现xml中的删除sql 根据id删除
     *  然后自行测试,没问题扣666
     */
    int deleteUserById(Long id);
    Long selectIdByUsername(String username);
    String selectUsernameById(Long id);
}
