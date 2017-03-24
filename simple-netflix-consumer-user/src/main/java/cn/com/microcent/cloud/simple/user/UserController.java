package cn.com.microcent.cloud.simple.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/3/24.
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/calc/{a}/{b}", method = RequestMethod.GET)
    public Integer calc(@PathVariable("a") Integer a, @PathVariable("b") Integer b) {
        return this.userService.calc(a, b);
    }
}
