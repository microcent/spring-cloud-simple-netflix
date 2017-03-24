package cn.com.microcent.cloud.simple.user;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2017/3/24.
 */
@Service
public class UserService {
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 使用@HystrixCommand注解指定当该方法发生异常时调用的方法
     */
    @HystrixCommand(fallbackMethod = "fallback")
    public Integer calc(Integer a, Integer b) {
        return this.restTemplate.getForObject("http://provider-user/calc/" + a + "/" + b, Integer.class);
    }

    /**
     * hystrix fallback方法
     */
    public Integer fallback(Integer a, Integer b) {
        return a * b;
    }

}
