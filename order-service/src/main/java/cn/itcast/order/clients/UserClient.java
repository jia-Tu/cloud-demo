package cn.itcast.order.clients;

import com.jiatu.pojo.User;
import com.jiatu.userApi.UserAPI;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("userservice")
public interface UserClient extends UserAPI {
    @Override
    @GetMapping("/user/{id}")
    User findById(@PathVariable Long id);
}
