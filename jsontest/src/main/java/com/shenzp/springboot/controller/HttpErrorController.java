package com.shenzp.springboot.controller;

import com.shenzp.springboot.domain.Resp;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class HttpErrorController implements ErrorController {

    private final static String ERROR_PATH = "/error";

    @RequestMapping(ERROR_PATH)
    public Resp getPath(HttpServletRequest request, HttpServletResponse response) {
        Resp resp = new Resp("http error:"+response.getStatus());
        return resp;
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}
