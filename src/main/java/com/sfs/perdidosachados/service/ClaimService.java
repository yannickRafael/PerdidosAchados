package com.sfs.perdidosachados.service;

import com.sfs.perdidosachados.repository.ClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClaimService {

    @Autowired
    private ClaimRepository claimRepository;
}
