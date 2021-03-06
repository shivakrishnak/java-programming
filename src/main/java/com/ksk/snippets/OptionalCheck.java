package com.ksk.snippets;

import org.apache.commons.lang3.StringUtils;

import java.math.BigInteger;
import java.util.Optional;

public class OptionalCheck {
    public static void main(String[] args) {
        checkIfPresent();
    }

    private static void checkIfPresent() {
        String issueId = "123";
        Integer id = Optional.ofNullable(issueId).filter(StringUtils::isNotBlank).map(Integer::valueOf).orElse(null);
        System.out.println(id);

        String matId = "212";
        BigInteger maturityId = Optional.ofNullable(matId).filter(StringUtils::isNotBlank).map(BigInteger::new).orElse(null);
        System.out.println(maturityId);
    }
}
