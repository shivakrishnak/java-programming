package com.ksk.snippets.groupby;

import java.util.List;

public class ToResponse {
    private String errorText;
    private  List<ToErrorMessage> errorMsgs = null;

    public ToResponse() {
    }

    public String getErrorText() {
        return errorText;
    }

    public ToResponse setErrorText(String errorText) {
        this.errorText = errorText;
        return this;
    }

    public List<ToErrorMessage> getErrorMsgs() {
        return errorMsgs;
    }

    public ToResponse setErrorMsgs(List<ToErrorMessage> errorMsgs) {
        this.errorMsgs = errorMsgs;
        return this;
    }

    @Override
    public String toString() {
        return "ToResponse{" +
                "errorText='" + errorText + '\'' +
                ", errorMsgs=" + errorMsgs +
                '}';
    }

    public static class ToErrorMessage {
        private String errCode;
        private List<String> errMsg;

        public ToErrorMessage() {
        }

        public String getErrCode() {
            return errCode;
        }

        public ToErrorMessage setErrCode(String errCode) {
            this.errCode = errCode;
            return this;
        }

        public List<String> getErrMsg() {
            return errMsg;
        }

        public ToErrorMessage setErrMsg(List<String> errMsg) {
            this.errMsg = errMsg;
            return this;
        }

        @Override
        public String toString() {
            return "ToErrorMessage{" +
                    "errCode='" + errCode + '\'' +
                    ", errMsg=" + errMsg +
                    '}';
        }
    }
}
