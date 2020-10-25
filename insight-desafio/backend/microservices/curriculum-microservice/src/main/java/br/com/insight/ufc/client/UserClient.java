package br.com.insight.ufc.client;

import br.com.insight.ufc.client.response.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-ws")
public interface UserClient {

    @GetMapping("/v1/users/{id}")
    public UserDTO getUser(@PathVariable Long id);

}