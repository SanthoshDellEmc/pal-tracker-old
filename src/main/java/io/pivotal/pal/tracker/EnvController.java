package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    String port;
    String memoryLimit;
    String cfInstanceIndex;
    String cfInstanceAddr;

    public EnvController(@Value("${port:NOT_SET}") String port,
                         @Value("${memoryLimit:NOT_SET}") String memoryLimit,
                         @Value("${cfInstanceIndex:NOT_SET}") String cfInstanceIndex,
                         @Value("${cfInstanceAddr:NOT_SET}") String cfInstanceAddr) {
        this.port=port;
        this.memoryLimit=memoryLimit;
        this.cfInstanceIndex=cfInstanceIndex;
        this.cfInstanceAddr=cfInstanceAddr;
    }
    @GetMapping("/env")
    public Map<String,String> getEnv(){

        HashMap<String,String> env = new HashMap<String,String>();

        env.put("PORT",port);
        env.put("MEMORY_LIMIT",memoryLimit);
        env.put("CF_INSTANCE_INDEX",cfInstanceIndex);
        env.put("CF_INSTANCE_ADDR",cfInstanceAddr);

        return env;

    }
}
