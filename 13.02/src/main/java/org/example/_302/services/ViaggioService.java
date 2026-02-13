package org.example._302.services;

import org.example._302.repositories.ViaggioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViaggioService {
    private final ViaggioRepo vr;

    @Autowired
    public ViaggioService(ViaggioRepo vr) {
        this.vr = vr;
    }
}
