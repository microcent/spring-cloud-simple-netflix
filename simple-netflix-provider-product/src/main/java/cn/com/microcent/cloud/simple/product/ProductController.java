package cn.com.microcent.cloud.simple.product;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * Created by Administrator on 2017/3/24.
 */
@RestController
public class ProductController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/price/{id}", method = RequestMethod.GET)
    public String price(@PathVariable("id") Integer id) {
        ServiceInstance instance = this.client.getLocalServiceInstance();
        String r = id + ":" + new Random().nextInt();
        logger.info("/price, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r);
        return r;
    }

}
