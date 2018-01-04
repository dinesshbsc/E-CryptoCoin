
package dto.koinex;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "BTC",
    "XRP",
    "ETH",
    "BCH",
    "LTC",
    "MIOTA",
    "OMG",
    "GNT"
})
public class Prices {

    @JsonProperty("BTC")
    private String bTC;
    @JsonProperty("XRP")
    private String xRP;
    @JsonProperty("ETH")
    private String eTH;
    @JsonProperty("BCH")
    private String bCH;
    @JsonProperty("LTC")
    private String lTC;
    @JsonProperty("MIOTA")
    private Double mIOTA;
    @JsonProperty("OMG")
    private Double oMG;
    @JsonProperty("GNT")
    private Double gNT;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("BTC")
    public String getBTC() {
        return bTC;
    }

    @JsonProperty("BTC")
    public void setBTC(String bTC) {
        this.bTC = bTC;
    }

    @JsonProperty("XRP")
    public String getXRP() {
        return xRP;
    }

    @JsonProperty("XRP")
    public void setXRP(String xRP) {
        this.xRP = xRP;
    }

    @JsonProperty("ETH")
    public String getETH() {
        return eTH;
    }

    @JsonProperty("ETH")
    public void setETH(String eTH) {
        this.eTH = eTH;
    }

    @JsonProperty("BCH")
    public String getBCH() {
        return bCH;
    }

    @JsonProperty("BCH")
    public void setBCH(String bCH) {
        this.bCH = bCH;
    }

    @JsonProperty("LTC")
    public String getLTC() {
        return lTC;
    }

    @JsonProperty("LTC")
    public void setLTC(String lTC) {
        this.lTC = lTC;
    }

    @JsonProperty("MIOTA")
    public Double getMIOTA() {
        return mIOTA;
    }

    @JsonProperty("MIOTA")
    public void setMIOTA(Double mIOTA) {
        this.mIOTA = mIOTA;
    }

    @JsonProperty("OMG")
    public Double getOMG() {
        return oMG;
    }

    @JsonProperty("OMG")
    public void setOMG(Double oMG) {
        this.oMG = oMG;
    }

    @JsonProperty("GNT")
    public Double getGNT() {
        return gNT;
    }

    @JsonProperty("GNT")
    public void setGNT(Double gNT) {
        this.gNT = gNT;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
