package com.cloudofgoods.auth.service.impl;


import com.cloudofgoods.auth.dao.ClientDetailsRepository;
import com.cloudofgoods.auth.dto.ClientDTO;
import com.cloudofgoods.auth.entity.OauthClientDetails;
import com.cloudofgoods.auth.service.ClientDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientDetailsServiceImpl implements ClientDetailService {

    final ClientDetailsRepository clientDetailsRepository;

    @Override
    public ClientDTO saveClient(ClientDTO clientDTO) {
        OauthClientDetails oauthClientDetails = new OauthClientDetails(clientDTO.getClientId(), clientDTO.getClientSecret(), clientDTO.getWebServerRedirectUri(), clientDTO.getScope(), clientDTO.getAccessTokenValidity(), clientDTO.getRefreshTokenValidity(), clientDTO.getResourceIds(), clientDTO.getAuthorizedGrantTypes(), clientDTO.getAuthorities(), clientDTO.getAdditionalInformation(), clientDTO.getAutoApprove());
        clientDetailsRepository.save(oauthClientDetails);
        return clientDTO;
    }
}
