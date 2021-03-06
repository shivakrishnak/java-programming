package com.ksk.snippets.groupby;

import java.util.List;

public class FromResponse {
    String errorText;
    List<FromErrorMessage> errorMsgs;

    public FromResponse(String errorText, List<FromErrorMessage> errorMsgs) {
        this.errorText = errorText;
        this.errorMsgs = errorMsgs;
    }

    public String getErrorText() {
        return errorText;
    }

    public void setErrorText(String errorText) {
        this.errorText = errorText;
    }

    public List<FromErrorMessage> getErrorMsgs() {
        return errorMsgs;
    }

    public void setErrorMsgs(List<FromErrorMessage> errorMsgs) {
        this.errorMsgs = errorMsgs;
    }
}
