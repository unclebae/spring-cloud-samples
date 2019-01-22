package kido.example.hystrix.hystrixservice;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class FeignServiceClientFallback implements FeignServiceClient{

    @Override
    public String getUserInfoById(String userName) {
        return "getUserInfoById error. This is Feign Fallback\n\n";
    }

    @Override
    public String getUserInfoByIdError(String id) {
        return "getUserInfoByIdError " + id;
    }
}
