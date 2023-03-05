package edu.cuhk.advisor.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestProp {

    @Value("${test.accounts}")
    private List<String> accounts;

    public List<String> getAccounts() {
        System.out.println(accounts);
        return accounts;
    }
}
