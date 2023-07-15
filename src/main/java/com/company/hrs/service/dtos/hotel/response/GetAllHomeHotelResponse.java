package com.company.hrs.service.dtos.hotel.response;

import com.company.hrs.entities.Address;
import com.company.hrs.entities.Contact;
import com.company.hrs.entities.HotelImage;
import com.company.hrs.service.dtos.address.responses.GetAddressResponse;
import com.company.hrs.service.dtos.contact.responses.GetContactResponse;
import com.company.hrs.service.dtos.hotelImage.responses.GetHotelImageResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllHomeHotelResponse {
    private Long id;
    private String name;
    private Float rating;
    private Integer reviewCount;
    private GetAddressResponse address;
    private GetContactResponse contact;
    private List<GetHotelImageResponse> images;

}
