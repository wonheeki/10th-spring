package codingon.codingonspringboot.controller._00_practice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

// 실습
@Controller
public class PracticeController {

    @GetMapping("practice")
    public String getPractice(Model model) {
        return "_00_practice/req";
    }
    @GetMapping("practice/thymeleaf1")
    public String getThymeleaf1(Model model) {
        model.addAttribute("age", 18);
        return "_00_practice/thymeleaf1";
    }

    @GetMapping("practice/thymeleaf2")
    public String getThymeleaf2(Model model) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("홍길동", 10));
        persons.add(new Person("성춘향", 11));
        persons.add(new Person("김민지", 12));
        persons.add(new Person("강해린", 13));

        model.addAttribute("persons", persons);
        return "_00_practice/thymeleaf2";
    }

    @GetMapping("practice/introduce/{param1}")
    public String getIntroduce(@PathVariable String param1, Model model) {

        model.addAttribute("name", param1);
        return "_00_practice/res";
    }

    @GetMapping("practice/introduce2")
    public String getIntroduce2(@RequestParam (value="name") String name, @RequestParam (value="age") int age, Model model) {

        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "_00_practice/res";
    }

    @PostMapping("practice/register1")
    public String getRegister1(@RequestParam String name, @RequestParam String gender,
                               @RequestParam int year, @RequestParam int month,
                               @RequestParam int day, @RequestParam String[] interest ,Model model) {

        model.addAttribute("name", name);
        model.addAttribute("gender", gender);
        model.addAttribute("birthday", year+"-"+month+"-"+day);
        model.addAttribute("interest", interest);

        return "_00_practice/res";
    }

    

}

@AllArgsConstructor // 모든 필드 값을 매개변수로 받는 생성자
@Getter
@Setter
class Person {
    private String name;
    private int age;

}