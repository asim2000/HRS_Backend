package com.company.hrs.service.dtos.hotel.response;

import com.company.hrs.service.dtos.address.responses.GetAddressResponse;
import com.company.hrs.service.dtos.contact.responses.GetContactResponse;
import com.company.hrs.service.dtos.hotelImage.responses.GetHotelImageResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetHomeHotelsResponse {
    private Long id;
    private String name;
    private Byte star;
    private Float rating;
    private Integer reviewCount;
    private GetAddressResponse address;
    private GetContactResponse contact;
    private String mainImageName;
    private List<GetHotelImageResponse> images;
    private Float minimumPrice;

}
