package com.cloudofgoods.auth.controller;

import com.cloudofgoods.auth.dto.ClientDTO;
import com.cloudofgoods.auth.service.ClientDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v5/oauth/client")
public class ClientController {

    final ClientDetailService clientDetailService;

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public ClientDTO registerClient(@RequestBody ClientDTO clientDTO) {
        return clientDetailService.saveClient(clientDTO);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String blockClient() {
        return "client";

    }
}
