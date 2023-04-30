package cn.itcast.user.web;

import cn.itcast.user.pojo.PatternProperties;
import cn.itcast.user.service.UserService;
import com.jiatu.pojo.User;
import com.jiatu.userApi.UserAPI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Slf4j
@RestController
@RequestMapping("/user")
@RefreshScope
public class UserController implements UserAPI {

    @Autowired
    private UserService userService;
    @Value("${pattern.dateformat}")
    private String dataformat;

    @Autowired
    private PatternProperties patternProperties;

//    @Value("${common.name}")
//    private String commonName;
//    @Value("${extend.name}")
//    private String extendName;

    /**
     * 路径： /user/110
     *
     * @return 用户
     */
    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id,@RequestHeader(required = false,value = "CHINA-HANGZHOU") String header1) {
//        System.out.println("X-Request-red:"+header);
//        ,@RequestHeader(required = false,value = "X-Request-red") String header
        System.out.println("CHINA-HANGZHOU:"+header1);
        return userService.queryById(id);
    }

    @RequestMapping("now")
    public String now(@RequestHeader(required = false,value = "X-Request-red") String header){
        System.out.println("X-Request-red:"+header);
        return LocalDateTime.now().
                format(DateTimeFormatter.ofPattern(patternProperties.getDateformat(), Locale.CHINA));
    }
    @PostMapping()
    public com.jiatu.pojo.User getUser(@RequestBody User user){
        user.setUsername("我来自userservice"+user.getUsername());
        return user;
    }

    @Override
    public com.jiatu.pojo.User findById(@PathVariable Long id) {
        System.out.println("执行了feigncommons接口实现的...");
        return userService.queryById(id);
    }

//    @RequestMapping("name")
//    public String getName(){
//        return commonName+"=>"+extendName;
//    }
}
