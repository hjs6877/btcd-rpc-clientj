package com.soom.model.response;

import com.google.gson.annotations.SerializedName;

public class ImportAddress {
    @SerializedName("result")
    Result result;

    @SerializedName("error")
    Error error;

    @SerializedName("id")
    String id;

    public Result getResult() {
        return result;
    }

    public Error getError() {
        return error;
    }

    public String getId() {
        return id;
    }

    public class Result {

    }

    public class Error extends JsonRpcErrorResponse {}
}
