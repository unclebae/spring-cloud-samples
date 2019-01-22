package kido.example.hystrix.hystrixservice;

import feign.hystrix.FallbackFactory;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class FeignServiceClientFactory implements FallbackFactory<FeignServiceClient> {

    @Autowired
    FeignServiceClientFallback feignServiceClientFallback;

    @Override
    public FeignServiceClient create(Throwable cause) {
        System.out.println(cause.getMessage());
        return feignServiceClientFallback;
    }
}
