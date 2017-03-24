package cn.com.microcent.cloud.simple.user;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/3/24.
 */
@RestController
public class UserController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/calc/{a}/{b}", method = RequestMethod.GET)
    public Integer calc(@PathVariable("a") Integer a, @PathVariable("b") Integer b) {
        ServiceInstance instance = this.client.getLocalServiceInstance();
        Integer r = a + b;
        logger.info("/calc, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r);
        return r;
    }

}
