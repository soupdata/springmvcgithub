package zqr.com.springdao.controller;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import zqr.com.springdao.User;
import zqr.com.springdao.db.DbConnection;
import zqr.com.springdao.entitys.InfoEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPBinding;
import java.util.List;

@Controller
@RequestMapping("/")
public class InfoController {

    @RequestMapping(value = "/infos",method = RequestMethod.GET)

        public String listinfo(ModelMap map){
        Session session= DbConnection.getSession();
        //查询出的结果根据id列进行反序排列
        List<InfoEntity> infolist=session.createCriteria(InfoEntity.class).addOrder(Order.desc("id")).list();
        map.addAttribute("infos",infolist);
        session.close();
        return "infos";
        }

    @RequestMapping(value = "/result",method = RequestMethod.POST)
    public String rusult(ModelMap map, @RequestParam String name, @RequestParam int age, HttpServletRequest request, HttpServletResponse response) {
        map.addAttribute("name",name);
        map.addAttribute("age",age);
        //将获取到的数据保存到数据库
        //打开会话
        Session session=DbConnection.getSession();
       //打开一个事务
        Transaction transaction=session.beginTransaction();
       //实例infoEntitys对象
        InfoEntity info=new InfoEntity();
        info.setAge((byte)age);
        info.setName(name);
        session.save(info);
        transaction.commit();
        session.close();
        return "result";
    }


    @RequestMapping(value = "/adduser",method = RequestMethod.GET)
    public String adduser(ModelMap map) {
//        InfoEntity info=new InfoEntity();
//        info.setAge(20);
//        info.setName("zyb");
//        //排除为空，空报异常
//        map.addAttribute("info",info);
        User user=new User();
        user.setAge(20);
        user.setName("zyb");
        //排除为空，空报异常
        map.addAttribute("user",user);
        return "add_user";
    }
    }

