package com.jiatu;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.lang.annotation.Annotation;

@Order(-1)

public class MyGlobalFilter implements GlobalFilter, Ordered{
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // ...省略逻辑，此类只是为了演示Ordered接口也可以实现过滤器排序问题
        return null;
    }

    @Override
    public int getOrder() {
        return 0; //数字越小，过滤器优先级越高
    }
}
