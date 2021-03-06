package com.ksk.snippets.groupby;

import java.util.*;
import java.util.stream.Collectors;

public class MergeErrorMsgs {
    public static void main(String[] args) {
        FromResponse fr = new FromResponse("from", Arrays.asList(
                new FromErrorMessage("S0", "AAAA"),
                new FromErrorMessage("S0", "BBBB"),
                new FromErrorMessage("S0", "CCCC"),
                new FromErrorMessage("S1", "XXXX"),
                new FromErrorMessage("S2", "ZZZZ")));
        MergeErrorMsgs mr = new MergeErrorMsgs();
        System.out.println(mr.toErrorMessage(fr));
        //System.out.println(mr.fetch(fr.getErrorMsgs()));
    }

    private List<ToResponse.ToErrorMessage> toErrorMessage(FromResponse fr) {
        return Optional.ofNullable(fr.getErrorMsgs())
                .orElse(Collections.emptyList())
                .stream()
                .collect(Collectors.groupingBy(err -> err.getErrCode(), Collectors.mapping(err -> err.getErrMsg(), Collectors.toList())))
                .entrySet().stream()
                .map(e -> new ToResponse.ToErrorMessage().setErrCode(e.getKey()).setErrMsg(e.getValue()))
                .collect(Collectors.toList());
    }

    public List<ToResponse.ToErrorMessage> fetch(List<FromErrorMessage> errorMsgs) {
        return errorMsgs.stream()
                .collect(Collectors.groupingBy(x -> x.getErrCode(), Collectors.mapping(x -> x.getErrMsg(), Collectors.toList())))
                .entrySet().stream()
                .map(e -> new ToResponse.ToErrorMessage().setErrCode(e.getKey()).setErrMsg(e.getValue()))
                .collect(Collectors.toList());
    }
    /*
    public Map<String, List<String>> fetch(List<FromErrorMessage> errorMsgs) {
        return errorMsgs.stream()
                .collect(Collectors.groupingBy(x -> x.getErrCode(), Collectors.mapping(x -> x.getErrMsg(), Collectors.toList())));
    }*/
}
