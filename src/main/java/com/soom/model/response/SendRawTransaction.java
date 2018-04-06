package com.soom.model.response;

import com.google.gson.annotations.SerializedName;

public class SendRawTransaction {
    @SerializedName("result")
    String txid;

    @SerializedName("errorData")
    Error error;

    @SerializedName("id")
    String id;

    public String getTxid() {
        return txid;
    }

    public Error getError() {
        return error;
    }

    public String getId() {
        return id;
    }

    public class Error {
        @SerializedName("name")
        String name;

        @SerializedName("code")
        int code;

        @SerializedName("message")
        String message;

        @SerializedName("errorData")
        String error;

        public String getName() {
            return name;
        }

        public int getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }

        public String getError() {
            return error;
        }
    }
}
