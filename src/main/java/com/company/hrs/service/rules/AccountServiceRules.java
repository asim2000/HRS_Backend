package com.company.hrs.service.rules;

import com.company.hrs.service.abstracts.ContactService;
import com.company.hrs.service.abstracts.PersonService;
import com.company.hrs.service.constant.Message;
import com.company.hrs.service.constant.StatusCode;
import com.company.hrs.service.dtos.account.requests.LoginRequest;
import com.company.hrs.service.result.DataResult;
import com.company.hrs.utils.exceptions.ServiceException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import java.util.Base64;

@Service
@RequiredArgsConstructor
public class AccountServiceRules {
    private final ContactService contactService;
    private final PersonService personService;
    private final PasswordEncoder passwordEncoder;

    public void checkIfPersonEmailExists(String email){
        DataResult<Boolean> response = contactService.existsContactByEmail(email);
        if(response.getCode() == 200 && response.getData()){
            throw new ServiceException(StatusCode.EMAIL_EXISTS,Message.EMAIL_EXISTS);
        }
    }
    public void checkIfPersonEmailNotExists(String email){
        DataResult<Boolean> response = contactService.existsContactByEmail(email);
        if(response.getCode() == 200 && !response.getData()){
            throw new ServiceException(StatusCode.EMAIL_IS_NOT_AVAILABLE,Message.EMAIL_IS_NOT_AVAILABLE);
        }
    }
    public static String decrypt(String encryptedText, SecretKey secretKey)
            throws Exception {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] encryptedTextByte = decoder.decode(encryptedText);
        Cipher.getInstance("AES").init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedByte = Cipher.getInstance("AES").doFinal(encryptedTextByte);
        String decryptedText = new String(decryptedByte);
        return decryptedText;
    }
    public void checkIfPersonPasswordConfirm(LoginRequest loginRequest){

    }
}
