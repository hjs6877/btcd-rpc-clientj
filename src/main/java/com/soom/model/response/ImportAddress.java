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

    public class Error {
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
}
