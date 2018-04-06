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

    public class Error extends JsonRpcErrorResponse {}
}
