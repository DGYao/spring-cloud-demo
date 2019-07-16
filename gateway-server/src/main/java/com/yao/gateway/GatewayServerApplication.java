package com.yao.gateway;

import com.yao.gateway.filter.RequestTimeGatewayFilterFactory;
import com.yao.gateway.filter.TokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class GatewayServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServerApplication.class, args);
    }

//    自定义Filter
//    @Bean
//    public RouteLocator customerRouteLocator(RouteLocatorBuilder builder) {
//        // @formatter:off
//        return builder.routes()
//                .route(r -> r.path("/customer/**")
//                        .filters(f -> f.filter(new RequestTimeFilter())
//                                .addResponseHeader("X-Response-Default-Foo", "Default-Bar"))
//                        .uri("http://httpbin.org:80/get")
//                        .order(0)
//                        .id("customer_filter_router")
//                )
//                .build();
//        // @formatter:on
//    }

//    自定义GatewayFilterFactory
//    @Bean
//    public RequestTimeGatewayFilterFactory elapsedGatewayFilterFactory() {
//        return new RequestTimeGatewayFilterFactory();
//    }

//    全局过滤器
    @Bean
    public TokenFilter tokenFilter(){
        return new TokenFilter();
    }

    /**
     * 用户限流
     * @return
     */
    @Bean
    KeyResolver userKeyResolver(){
        return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("user"));
    }

    /**
     * url限流
     * @return
     */
    @Bean
    KeyResolver uriKeyResolver(){
        return exchange ->Mono.just(exchange.getRequest().getURI().getPath());
    }

    /**
     * 域名限流
     * @return
     */
    @Primary
    @Bean
    KeyResolver hostAddrKeyResolver(){
        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
    }
}
