package com.example.hello;

import com.example.hello.service.MenuService;
import com.example.hello.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloApiController {
    @Autowired
    private MenuService menuService;
    @RequestMapping("/hello")
    String home() {
        return "Hello World!";
    }

    @RequestMapping("/hellokr")
    String hello() {
        return "헬로 월드!";
    }

    @PostMapping("/insert")
    public ResponseEntity<MenuVo> save(MenuVo menu) {
        return new ResponseEntity<MenuVo>(menuService.save(menu), HttpStatus.OK);
    }
    @GetMapping("/menulist")
    public ResponseEntity<List<MenuVo>> getAllMenu() {
        List<MenuVo> list = menuService.findAll();
        return new ResponseEntity<List<MenuVo>>(list, HttpStatus.OK);
    }

}