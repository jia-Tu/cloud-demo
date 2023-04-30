package cn.itcast.order.web;


import cn.itcast.order.clients.UserClient;
import cn.itcast.order.pojo.Order;
import cn.itcast.order.pojo.User;
import cn.itcast.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("order")
@CrossOrigin
public class OrderController {

   @Autowired
   private OrderService orderService;
   @Autowired
   private RestTemplate restTemplate;
//   @Autowired
//   private FeignClent feignClent;
    @Autowired
    private UserClient userClient;
    @GetMapping("{orderId}")
    public Order queryOrderByUserId(@PathVariable("orderId") Long orderId,@RequestHeader(required = false,value = "CHINA-HANGZHOU") String header) {
        // 根据id查询订单并返回
        Order order = orderService.queryOrderById(orderId);
        Long userId = order.getUserId();
//        User user = feignClent.findUserById(userId);
//        order.setUser(user);
        com.jiatu.pojo.User byId = userClient.findById(userId);
        order.setUser(byId);
        System.out.println("CHINA-HANGZHOU:"+header);
        return order;
    }

//    @PostMapping()
//    public User getUser(@RequestBody User user){
//        User userNew = feignClent.getUser(user);
//        return userNew;
//    }
}
