package kido.example.hystrix.hystrixservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(
        value = "user-service",
        fallback = FeignServiceClientFallback.class

)
public interface FeignServiceClient {

    @RequestMapping(method = RequestMethod.GET, value = "/users/{id}")
    String getUserInfoById(@PathVariable("id") String id);

    @RequestMapping(method = RequestMethod.GET, value = "/users/error/{id}")
    String getUserInfoByIdError(@PathVariable("id") String id);
}
