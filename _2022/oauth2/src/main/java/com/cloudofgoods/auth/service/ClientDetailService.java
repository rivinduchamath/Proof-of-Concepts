package com.cloudofgoods.auth.service;

import com.cloudofgoods.auth.dto.ClientDTO;

public interface ClientDetailService {
    ClientDTO saveClient(ClientDTO clientDTO);
}
