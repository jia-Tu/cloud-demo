package cn.itcast.order.clients;

import cn.itcast.order.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

//@FeignClient("userservice")
//@RequestMapping("/user")
//public interface FeignClent {
//    @PostMapping
//    public User getUser(@RequestBody User user);
//
//    @GetMapping("{id}")
//    public User findUserById(@PathVariable Long id);
//}
