package kido.example.hystrix.hystrixservice;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HystrixDemoClient {

    @Autowired
    FeignServiceClient feignServiceClient;

    @GetMapping("/hystrix/greeting/{username}")
    public String greeting(@PathVariable("username") String userName) {
        return "Hello " + userName + " I'm Hystrix Demo Controller.\n\n";
    }

    @GetMapping("/hystrix/greeting/error/{username}")
    @HystrixCommand(fallbackMethod = "defaultFallBackGreeting")
    public String greetingError(@PathVariable("username") String userName) {
        throw new RuntimeException("Error occured. When you call greeting.");
    }

    private String defaultFallBackGreeting(String userName, Throwable e) {
        return "Hello XXX I'm Fallback Method. When you are faced error \n\n " + e.getMessage() + "\n\n";
    }

    @GetMapping("/hystrix/greeting/feign/{userId}")
    public String feignDemo(@PathVariable("userId") String userId) {
        return feignServiceClient.getUserInfoById(userId);
    }

    @GetMapping("/hystrix/greeting/feign/error/{userId}")
    public String feignDemoError(@PathVariable("userId") String userId) {
        return feignServiceClient.getUserInfoByIdError(userId);
    }

}
