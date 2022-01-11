package com.shenzp.springboot.controller;

import com.shenzp.springboot.config.ApiErrorResult;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

//全局处理filter自定义异常
@RestController
public class MyErrorController extends BasicErrorController {

    public MyErrorController() {
        super(new DefaultErrorAttributes(), new ErrorProperties());
    }

    @Override
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
        Map<String, Object> errorAttributes = getErrorAttributes(request, ErrorAttributeOptions.of(ErrorAttributeOptions.Include.EXCEPTION,ErrorAttributeOptions.Include.MESSAGE,ErrorAttributeOptions.Include.STACK_TRACE,ErrorAttributeOptions.Include.BINDING_ERRORS));
        HttpStatus status = getStatus(request);
        // 获取错误信息
        String code = errorAttributes.get("status").toString();
        String message = errorAttributes.get("message").toString();

        ApiErrorResult apiErrorResult = new ApiErrorResult(false,code,message);

        return new ResponseEntity<>(apiErrorResult,status);
    }
}
