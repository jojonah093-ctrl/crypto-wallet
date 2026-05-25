package com.example.wallet.service;

import com.example.wallet.model.Wallet;
import com.example.wallet.repository.WalletRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.Keys;

@Service
public class WalletService {

    @Autowired
    private WalletRepository repository;

    public Wallet createWallet() throws Exception {

        ECKeyPair keyPair = Keys.createEcKeyPair();

        Credentials credentials = Credentials.create(keyPair);

        Wallet wallet = new Wallet();

        wallet.setAddress(credentials.getAddress());

        wallet.setPrivateKey(
                keyPair.getPrivateKey().toString(16)
        );

        return repository.save(wallet);
    }
}