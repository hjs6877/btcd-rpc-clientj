package com.soom.model.response;

import com.google.gson.annotations.SerializedName;

public class JsonRpcErrorResponse {
    @SerializedName("name")
    String name;

    @SerializedName("code")
    int code;

    @SerializedName("message")
    String message;

    @SerializedName("error")
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
