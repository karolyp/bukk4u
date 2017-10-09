package hu.rendszerfejlesztes.bookshopbackend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class TestController {

    private static final AtomicInteger counter = new AtomicInteger();

    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    public String sayHello(HttpServletRequest request){
        String externalIP = request.getRemoteAddr();
        return "Hello " + externalIP + " for the " + counter.incrementAndGet() + ". time!";
    }

}
