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
    String instanceIndex;
    String instanceAddress;

    public EnvController(@Value("${port:NOT SET}") String port,
                         @Value("${memory.limit:NOT SET}") String memoryLimit,
                         @Value("${cf.instance.index:NOT SET}") String instanceIndex,
                         @Value("${cf.instance.addr:NOT SET}") String instanceAddress){
        this.port=port;
        this.memoryLimit=memoryLimit;
        this.instanceIndex=instanceIndex;
        this.instanceAddress=instanceAddress;
    }

    @GetMapping("/env")
    public Map<String, String> getEnv(){
        Map<String, String> env = new HashMap<String, String>();
        env.put("PORT", port);
        env.put("MEMORY_LIMIT", memoryLimit);
        env.put("CF_INSTANCE_INDEX", instanceIndex);
        env.put("CF_INSTANCE_ADDR", instanceAddress);
        return env;
    }
}
