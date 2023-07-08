package com.company.hrs.service.dtos.hotel.requests;

import com.company.hrs.entities.Service;
import com.company.hrs.service.dtos.service.requests.CreateServiceRequest;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateHotelRequest {
    private String name;
    private Long cityId;
    @Column(name = "address_line")
    private String addressLine;
    private String phone;
    private String description;
    private List<Long> serviceIds;
    private MultipartFile[] images;
}
