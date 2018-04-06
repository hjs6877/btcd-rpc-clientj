package com.soom.model.response;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ListUnspent {
    @SerializedName("result")
    public List<ListUnspent> result = new ArrayList<>();

    @SerializedName("error")
    Error error;

    @SerializedName("id")
    String id;

    public List<ListUnspent> getResult() {
        return result;
    }

    public Error getError() {
        return error;
    }

    public String getId() {
        return id;
    }

    public class Result {
        @SerializedName("txid")
        String txid;

        @SerializedName("vout")
        int vout;

        @SerializedName("address")
        String address;

        @SerializedName("account")
        String account;

        @SerializedName("scriptPubKey")
        String scriptPubKey;

        @SerializedName("amount")
        BigDecimal amount;

        @SerializedName("confirmations")
        int confirmations;

        @SerializedName("spendable")
        boolean spendable;

        @SerializedName("solvable")
        boolean solvable;

        @SerializedName("safe")
        boolean safe;

        public String getTxid() {
            return txid;
        }

        public int getVout() {
            return vout;
        }

        public String getAddress() {
            return address;
        }

        public String getAccount() {
            return account;
        }

        public String getScriptPubKey() {
            return scriptPubKey;
        }

        public BigDecimal getAmount() {
            return amount;
        }

        public int getConfirmations() {
            return confirmations;
        }

        public boolean isSpendable() {
            return spendable;
        }

        public boolean isSolvable() {
            return solvable;
        }

        public boolean isSafe() {
            return safe;
        }
    }

    public class Error extends JsonRpcErrorResponse {}
}
