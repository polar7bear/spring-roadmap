package com.hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "제 이름은 손승기입니다.");
        return "hello";
    }

    @GetMapping("hello-template")      //required 속성은 default값이 true 이고 false를 기입해주면 URL에 parameter를 넘겨주지 않아도 에러가 발생하지 않음.(name이 null값으로 전달됨)
    public String helloMvc(@RequestParam(value="name", required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-api")
    @ResponseBody   //데이터를 뷰로 전달시키는것이 아니라 데이터를 HTTP의 BODY에 담아 그대로 브라우저에 전달함
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;   //객체를 전달. 전달된 객체는 JSON형식의 데이터로 변환됨.
    }
    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
