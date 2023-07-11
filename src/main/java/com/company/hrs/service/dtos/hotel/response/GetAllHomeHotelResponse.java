package com.company.hrs.service.dtos.hotel.response;

import com.company.hrs.entities.Address;
import com.company.hrs.entities.Contact;
import com.company.hrs.entities.HotelImage;
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
    private Address address;
    private Contact contact;
    private List<HotelImage> images;

}
