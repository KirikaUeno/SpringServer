package ServerMain.spring;

import ServerMain.serverData.ServerData;
import org.springframework.web.bind.annotation.*;

@RestController
public class ControllerBase {

    @GetMapping("/")
    public String home() {
        return "Hello, from SanaFan!";
    }

    @GetMapping("/checkstate")
    public String checkState() {
        return "1";
    }

    @CrossOrigin()
    @GetMapping("/cathodeOnCheckBox")
    public int cathodeOnCheckBox() {
        ServerData.cathodeSystemOn=!ServerData.cathodeSystemOn;
        return 1;
    }

    @CrossOrigin()
    @GetMapping("/filamentOnCheckBox")
    public int filamentOnCheckBox() {
        ServerData.filamentSystemOn=!ServerData.filamentSystemOn;
        return 1;
    }

    @CrossOrigin()
    @GetMapping("/cathodeVoltage")
    public int cathodeVoltage(@RequestParam(value = "value", defaultValue = "0") String voltage) {
        ServerData.setCathodeVoltage(Float.parseFloat(voltage));
        return 1;
    }

    @CrossOrigin()
    @GetMapping("/cathodeCurrent")
    public int cathodeCurrent(@RequestParam(value = "value", defaultValue = "0") String current) {
        ServerData.setCathodeCurrent(Float.parseFloat(current));
        return 1;
    }

    @CrossOrigin()
    @GetMapping("/getupdates")
    public String getUpdates() {
        return ServerData.composeUpdates();
    }
}
