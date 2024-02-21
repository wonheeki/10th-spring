package codingon.codingonspringboot.controller._01_thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class HelloController {
    @GetMapping("/hi")
    public String getHi(Model model) {
        // Model model : Controller 클래스 안의 메서드가 파라미터로 받을 수 있는 객체
        // - 정보를 담아서 view에게 넘겨줄 때 사용하는 친구
        // - 개발자가 직접 model을 생성할 필요 없이, 파라미터로 선언만 해주면 Spring이 알아서 만들어 준다.
        model.addAttribute("msg","HI!");

        // Thymeleaf 표현식과 문법

        model.addAttribute("uText","<strong>Hello</strong>");
        model.addAttribute("value","이름을 입력하세요");
        model.addAttribute("withValue","hello");
        model.addAttribute("link","hi");
        model.addAttribute("imgSrc","image.png");
        model.addAttribute("userRole","admin");
        model.addAttribute("isAdmin","false");

        List<String> names = Arrays.asList("kim","Lee","Hong","Park");
        model.addAttribute("names",names);

        Hello hello = new Hello(25);
        model.addAttribute("classHello",hello);
        return "_01_thymeleaf/hi";
    }

    @GetMapping("/people")
    public String getPeople(Model model){
        model.addAttribute("age",19);

        ArrayList<Person> people = new ArrayList<Person>();
        people.add(new Person("kim",10));
        people.add(new Person("lee",20));
        people.add(new Person("hong",30));
        people.add(new Person("park",40));
        people.add(new Person("shin",50));
        model.addAttribute("people",people);

        return "_01_thymeleaf/example";
    }
}

class Hello{
    private int age;
    public Hello(int age){
        this.age = age;
    }

    public int getAge(){
        return age;
    }
}

class Person{
    private String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }


}

