package spring.springstudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello") // Get 방식으로 '/hello' 요청이 들어오면 아래 메서드와 mapping된다.
    public String hello(Model model) { // Model은 MVC의 Model이 맞다.
        // model의 attribute는 "key: value" 형태이다. (data: "spring!")
        model.addAttribute("data", "spring!");
        return "hello"; // templates/hello.html을 찾아가서 렌더링한다.
    }

    @GetMapping("hello-mvc")
    // Get방식으로 요청을 보내야 한다. (ex. localhost:8080/hello-mvc?name=springNoBase)
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // HTTP의 Body에 문자열을 그대로 전달한다.(HTML 아님)
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello; // JSON 형태로 반환
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
