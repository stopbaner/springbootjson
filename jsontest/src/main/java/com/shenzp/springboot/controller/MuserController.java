package com.shenzp.springboot.controller;

import com.shenzp.springboot.domain.Muser;
import com.shenzp.springboot.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @描述
 * @创建人 szp
 * @修改人和其它信息
 */
@Slf4j
@RestController
public class MuserController {
    //参数手动封装为对象，类似springboot的initBinder
    //通过自定义modelAttribute可以解决，属性名称一定要一致的问题
//    @ModelAttribute("createU")
    //modelAttribute最好是属性名称跟对象名称一致
    //@requestParam默认required为true
    @RequestMapping("/")
    public Muser createMuser(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "age", required = false, defaultValue = "0") int age) {
        Muser muser = new Muser();
        muser.setUsername(name);
        muser.setAge(age);

        log.info("run here createMuser...");
        return muser;
    }

    @GetMapping("/jsonuser")
    public ResponseEntity<User> showUser() {
        return ResponseEntity.ok(User.buildOne());
    }
}
