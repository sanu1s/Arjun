package com.sample.Mytest.Services;

import com.sample.Mytest.configuration.ConfigurationFile;
import com.sample.Mytest.mapper.ITrackingMapper;
import com.sample.Mytest.mapper.TrackingMapper;
import com.test.gen.Request.Piece;
import com.test.gen.Request.TrackingRequest;
import com.test.gen.Response.TrackingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

//import com.sample.Mytest.mapper.TrackingMapper;

@Component
public class TrackingService {

    @Autowired
    ConfigurationFile configurationFile;

    ITrackingMapper iTrackingMapper
           =new TrackingMapper();
    public TrackingResponse trackingServiceImpl(TrackingRequest trackingRequest){

       List<Piece> lPiece=trackingRequest.getPieces();
       Double dWeight= lPiece.stream().map(a->a.getWeight()).findFirst().get();
       System.out.println("Weight==>"+dWeight);
       System.out.println("CarrierScan==>"+configurationFile.getCarrierscan());

       List<String> lEventTypes= trackingRequest.getEvents().stream()
                .map(a->a.getEventType()+"_"+a.getEventModifier())
                .collect(Collectors.toList());
       System.out.println("lEventTypes==>"+lEventTypes);
       List<Boolean> str=lEventTypes.stream()
               .map(a->a.equalsIgnoreCase(configurationFile.getCarrierscan())

       System.out.println("lEventTypes"+lEventTypes);

       return iTrackingMapper.trackingMapper(trackingRequest,dWeight);

    }
}
