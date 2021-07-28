package com.sample.Mytest.mapper;


import com.test.gen.Request.TrackingRequest;
import com.test.gen.Response.TrackingResponse;
import org.mapstruct.*;

import java.util.ArrayList;
import java.util.List;

import static org.mapstruct.NullValueMappingStrategy.RETURN_DEFAULT;
import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(implementationName = "TrackingMapper",
        unmappedTargetPolicy = IGNORE,
        nullValueMappingStrategy = RETURN_DEFAULT)
public interface ITrackingMapper {

    @Mappings
    ({
    @Mapping(source = "trackingRequest.orderNumber",target = "data.trackingNumber"),
    @Mapping(target = "data.carrier.carrier",constant ="UPS SurePost" ),
    @Mapping(target = "data.carrier.carrierCode",constant = "098"),
    @Mapping(target = "data.carrier.code",constant = "098"),
    @Mapping(target = "data.carrier.description",constant = "UPS"),
    @Mapping(target = "data.carrier.name",constant = "UPS"),
            @Mapping(source="trackingRequest.origin.city",target = "data.shipment.shipper.city"),
            @Mapping(source="trackingRequest.origin.state",target = "data.shipment.shipper.state"),
            @Mapping(source="trackingRequest.origin.postalCode",target = "data.shipment.shipper.postalCode"),
            @Mapping(target ="data.shipment.shipper.country",constant = "US"),
            @Mapping(source="dWeight", target = "data.shipment.package.weight.weight"),
            @Mapping(target = "data.shipment.package.weight.unit",constant = "LBS"),

    })
    TrackingResponse trackingMapper(TrackingRequest trackingRequest,Double dWeight);

    @AfterMapping
    static void addressLineMapping(TrackingRequest trackingRequest,
                                   @MappingTarget TrackingResponse trackingResponse){

        List<String> address=new ArrayList<String>();
        address.add(trackingRequest.getOrigin().getCity());
        trackingResponse.getData().getShipment().getShipper().setAddressLines(address);


    }
}
