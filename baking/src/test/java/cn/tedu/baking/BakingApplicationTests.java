package cn.tedu.baking;

import cn.tedu.baking.mapper.CategoryMapper;
import cn.tedu.baking.mapper.ContentMapper;
import cn.tedu.baking.mapper.UserMapper;
import cn.tedu.baking.pojo.DOT.UserDOT;
import cn.tedu.baking.pojo.VO.CategoryVO;
import cn.tedu.baking.pojo.VO.ContentManagementVO;
import cn.tedu.baking.pojo.VO.UserVO;
import cn.tedu.baking.pojo.VO.userAdminVO;
import cn.tedu.baking.pojo.entity.Content;
import cn.tedu.baking.pojo.entity.User;
import com.sun.media.jfxmediaimpl.HostUtils;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class BakingApplicationTests {
    @Autowired
    UserMapper userMapper;

    @Test
    public void testInsert(){
        User user = new User();
        user.setUserName("老王");
        user.setNickName("王王");
        user.setPassword("woshilaowang");
        user.setCreateTime(new Date());
        int insert = userMapper.insert(user);
        System.out.println(insert>0?"insert succeed":"insert fail");
    }
    //查询用户名信息
    @Test
    public void testSelectByUserName(){

        UserVO tom = userMapper.selectByUserName("tom");
        System.out.println(tom);
    }
    //优化注册,模拟用户名存在的情况
    @Test
    public void testInsert1(){
        User user = new User();
        user.setUserName("小明1");
        user.setNickName("明明");
        user.setPassword("123456");
        user.setCreateTime(new Date());
        String userName = user.getUserName();
        UserVO userVO = userMapper.selectByUserName(userName);
        if (userVO==null){
            int insert = userMapper.insert(user);
            System.out.println(insert>0?"insert succeed":"insert fail");
        }else {
            System.out.println("user already exist");
        }


    }
    //测试修改用户信息
    @Test
    public void testUpdateUserMessage(){
        UserDOT userDOT = new UserDOT();
        userDOT.setId(7);
        userDOT.setNickName("我才是老王");
        int i = userMapper.updateUserMessage(userDOT);
        System.out.println(i>0?"update succeed":"update fail");
    }
    //模拟通过id查询头像路径
    @Test
    public void testselectImgUrlById(){
        String s = userMapper.selectImgUrlById(3);
        System.out.println(s);
    }
    //模拟新建头像或者更换头像
    @Test
    public void updateImlUrl(){
        int id=2;
        String imgPath = "./pic/1.jpg";
        String s = userMapper.selectImgUrlById(id);
        if (s!=null){
            System.out.println("The old alrealy deletes");

        }
        int i = userMapper.updateUserUrlImg(imgPath, id);
        System.out.println(i>0?"update succeed":"update fail");
    }
    //管理员查询用户信息
    @Test
    public void testAdminSelectUserMessage(){
        List<userAdminVO> userAdminVOS = userMapper.adminSelectUserMessage();
        for (userAdminVO userAdminVO:userAdminVOS){
            System.out.println(userAdminVO);
        }
    }
    //管理员通过id删除用户
    @Test
    public void testAdminDeleteUserById(){
        int i = userMapper.adminDeleteUserById(7);
        System.out.println(i>0?"delete succeed":"delete fail");

    }
    @Autowired
    CategoryMapper categoryMapper;
    //测试查询二级类别名称
    @Test
    public void testSelectNameByType(){
        int type=2;
        List<CategoryVO> categoryVOS = categoryMapper.selectByType(type);
        for (CategoryVO categoryVO:categoryVOS){
            System.out.println(categoryVO);
        }

    }
    //测试发布稿件
    @Autowired
    ContentMapper contentMapper;
    @Test
    public void testInsertContent(){
        Content content = new Content();
        content.setTitle("测试文章");     //稿件标题
        content.setImgUrl("./1.jpg");   //稿件封面(存储的是图片的路径)
        content.setVideoUrl("./2.mp4"); // 视频(存储的是视频的路径)
        content.setContent("文章正文内容");//稿件正文
        content.setType(1L);     //稿件的一级分类 1 → 食谱、2 → 视频、3 → 咨询
        content.setCreateBy(4L);  //稿件作者编号(取自于t_user表id)
        content.setCreateTime(new Date()); //创建时间
        content.setBrief("文章正文的前50个字");  //摘要
        content.setCategoryId(1L);          //稿件的二级类别
        int rows = contentMapper.insertContent(content);
        System.out.println(rows > 0 ? "发布成功!" : "发布失败!");
    }
    //测试根据分类查询稿件
    @Test
    public void testSelectMessageBySort(){
        List<ContentManagementVO> contentManagementVOS = contentMapper.selectMessageById(1, 1);
        for (ContentManagementVO contentManagementVO:contentManagementVOS){
            System.out.println(contentManagementVO);
        }
    }
    //测试更新稿件
    @Test
    public void testUpdateMessage(){
        Content content = new Content();
        content.setId(11l);

        content.setTitle("不买亏死的花生酱酥饼");
        int i = contentMapper.updateMessage(content);
        System.out.println(i);
    }

}
