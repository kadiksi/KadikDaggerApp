package example.test.kudaybergen.daggerapplicationdefaults.activity.data.api.http.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Kudaybergen on 11.12.2015.
 */
public class Result {

    @SerializedName("Auto")
    String auto;
    @SerializedName("FreeSeats")
    Integer freeSeats;
    @SerializedName("HasConditioner")
    Boolean hasConditioner;
    @SerializedName("ID")
    Integer id;
    @SerializedName("LocalityFromID")
    Integer LocalityFromID;
    @SerializedName("LocalityFromName")
    String localityFromName;
    @SerializedName("LocalityToID")
    Integer localityToID;
    @SerializedName("LocalityToName")
    String localityToName;
    @SerializedName("ParkingFrom")
    String parkingFrom;
    @SerializedName("ParkingTo")
    String parkingTo;
    @SerializedName("PriceLuggage")
    Boolean priceLuggage;
    @SerializedName("PricePlace")
    Boolean pricePlace;
    @SerializedName("Rating")
    Float rating;
    @SerializedName("TravelDateTime")
    String travelDateTime ;

    public String getAuto() {
        return auto;
    }

    public void setAuto(String auto) {
        this.auto = auto;
    }

    public Integer getFreeSeats() {
        return freeSeats;
    }

    public void setFreeSeats(Integer freeSeats) {
        this.freeSeats = freeSeats;
    }

    public Boolean getHasConditioner() {
        return hasConditioner;
    }

    public void setHasConditioner(Boolean hasConditioner) {
        this.hasConditioner = hasConditioner;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLocalityFromID() {
        return LocalityFromID;
    }

    public void setLocalityFromID(Integer localityFromID) {
        LocalityFromID = localityFromID;
    }

    public String getLocalityFromName() {
        return localityFromName;
    }

    public void setLocalityFromName(String localityFromName) {
        this.localityFromName = localityFromName;
    }

    public Integer getLocalityToID() {
        return localityToID;
    }

    public void setLocalityToID(Integer localityToID) {
        this.localityToID = localityToID;
    }

    public String getLocalityToName() {
        return localityToName;
    }

    public void setLocalityToName(String localityToName) {
        this.localityToName = localityToName;
    }

    public String getParkingFrom() {
        return parkingFrom;
    }

    public void setParkingFrom(String parkingFrom) {
        this.parkingFrom = parkingFrom;
    }

    public String getParkingTo() {
        return parkingTo;
    }

    public void setParkingTo(String parkingTo) {
        this.parkingTo = parkingTo;
    }

    public Boolean getPriceLuggage() {
        return priceLuggage;
    }

    public void setPriceLuggage(Boolean priceLuggage) {
        this.priceLuggage = priceLuggage;
    }

    public Boolean getPricePlace() {
        return pricePlace;
    }

    public void setPricePlace(Boolean pricePlace) {
        this.pricePlace = pricePlace;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String getTravelDateTime() {
        return travelDateTime;
    }

    public void setTravelDateTime(String travelDateTime) {
        this.travelDateTime = travelDateTime;
    }
}
