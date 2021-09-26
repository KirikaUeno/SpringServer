package com.springProj.demo.spring;

import com.springProj.demo.serverData.ServerData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class ControllerBase {

    private static final String template = "Hello, %s, from SanaFan!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/")
    public String index() {
        return "Hello, from SanaFan!";
    }

    @GetMapping("/checkstate")
    public String checkState() {
        return "1";
    }

    @GetMapping("/sendinput")
    public int sendInput(@RequestParam(value = "name", defaultValue = "none") String name) {
        String[] parts = name.split("-");
        Objects.requireNonNull(ServerData.getPlayer(parts[0])).setStateTimer(Float.parseFloat(parts[1]));
        return 1;
    }

    @GetMapping("/addplayer")
    public int addPlayer(@RequestParam(value = "name", defaultValue = "none") String name) {
        String[] parts = name.split("-");
        ServerData.playerList.add(new Player(parts[0]));
        return 1;
    }

    @GetMapping("/removeplayer")
    public int removePlayer(@RequestParam(value = "name", defaultValue = "none") String name) {
        int indexToRemove = -1;
        for(int i = 0; i < ServerData.playerList.size(); i++){
            if(ServerData.playerList.get(i).getName().equals(name)) indexToRemove = i;
        }
        if(indexToRemove>-1) ServerData.playerList.remove(indexToRemove);
        return 1;
    }
}
