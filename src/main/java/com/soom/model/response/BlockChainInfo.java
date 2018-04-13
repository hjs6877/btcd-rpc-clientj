package com.soom.model.response;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO write comment
 */
public class BlockChainInfo {
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
        @SerializedName("chain")
        String chain;

        @SerializedName("blocks")
        long blocks;

        @SerializedName("headers")
        long headers;

        @SerializedName("bestblockhash")
        String bestBlockHash;

        @SerializedName("difficulty")
        BigDecimal difficulty;

        @SerializedName("mediantime")
        long medianTime;

        @SerializedName("verificationprogress")
        long verificationProgress;

        @SerializedName("initialblockdownload")
        boolean initialBlockDownload;

        @SerializedName("chainwork")
        String chainwork;

        @SerializedName("size_on_disk")
        long sizeOnDisk;

        @SerializedName("pruned")
        boolean pruned;

        @SerializedName("softforks")
        List<SoftForks> softforks = new ArrayList<>();

        @SerializedName("bip9_softforks")
        Bip9Softforks bip9Softforks;

        @SerializedName("warnings")
        String warnings;

        public class SoftForks {
            @SerializedName("id")
            String id;

            @SerializedName("version")
            int version;

            @SerializedName("reject")
            Reject reject;

            public class Reject {
                @SerializedName("status")
                boolean status;

                public boolean isStatus() {
                    return status;
                }
            }

            public String getId() {
                return id;
            }

            public int getVersion() {
                return version;
            }

            public Reject getReject() {
                return reject;
            }
        }

        public class Bip9Softforks {
            @SerializedName("csv")
            Csv csv;

            @SerializedName("segwit")
            Segwit segwit;

            public class Csv {
                @SerializedName("status")
                String status;

                @SerializedName("startTime")
                long startTime;

                @SerializedName("timeout")
                long timeOut;

                @SerializedName("since")
                long since;

                public String getStatus() {
                    return status;
                }

                public long getStartTime() {
                    return startTime;
                }

                public long getTimeOut() {
                    return timeOut;
                }

                public long getSince() {
                    return since;
                }
            }

            public class Segwit {
                @SerializedName("status")
                String status;

                @SerializedName("startTime")
                long startTime;

                @SerializedName("timeout")
                long timeOut;

                @SerializedName("since")
                long since;

                public String getStatus() {
                    return status;
                }

                public long getStartTime() {
                    return startTime;
                }

                public long getTimeOut() {
                    return timeOut;
                }

                public long getSince() {
                    return since;
                }
            }

            public Csv getCsv() {
                return csv;
            }

            public Segwit getSegwit() {
                return segwit;
            }
        }

        public String getChain() {
            return chain;
        }

        public long getBlocks() {
            return blocks;
        }

        public long getHeaders() {
            return headers;
        }

        public String getBestBlockHash() {
            return bestBlockHash;
        }

        public BigDecimal getDifficulty() {
            return difficulty;
        }

        public long getMedianTime() {
            return medianTime;
        }

        public long getVerificationProgress() {
            return verificationProgress;
        }

        public boolean isInitialBlockDownload() {
            return initialBlockDownload;
        }

        public String getChainwork() {
            return chainwork;
        }

        public long getSizeOnDisk() {
            return sizeOnDisk;
        }

        public boolean isPruned() {
            return pruned;
        }

        public List<SoftForks> getSoftforks() {
            return softforks;
        }

        public Bip9Softforks getBip9Softforks() {
            return bip9Softforks;
        }

        public String getWarnings(){
            return warnings;
        }
    }

    public class Error extends JsonRpcErrorResponse {}
}
