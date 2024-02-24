package com.yunuspektas.springcoredemo.rest;


import com.yunuspektas.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
//  define a private field for the dependency
    private Coach myCoach;
    private Coach anotherCoach;

//    define a constructor for dependency injection
    @Autowired
    public DemoController(
            @Qualifier("cricketCoach") Coach theCoach,
            @Qualifier("cricketCoach") Coach theAnotherCoach){
        System.out.println("In constructor : " + getClass().getSimpleName());
        myCoach = theCoach;
        anotherCoach = theAnotherCoach;
    }

@GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
}

@GetMapping("/check")
    public  String check(){
        return  "Comparing beans: myCoach == anotherCoach , " + (myCoach == anotherCoach);
}


}
