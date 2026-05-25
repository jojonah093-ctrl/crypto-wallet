package com.example.wallet.controller;

import com.example.wallet.model.Wallet;
import com.example.wallet.service.WalletService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WalletController {

    @Autowired
    private WalletService walletService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/create-wallet")
    public String createWallet(Model model) {

        try {

            Wallet wallet = walletService.createWallet();

            model.addAttribute("wallet", wallet);

        } catch (Exception e) {

            model.addAttribute("error", e.getMessage());
        }

        return "index";
    }
}