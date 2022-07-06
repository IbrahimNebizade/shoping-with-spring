package com.company.shoping.service;

import com.company.shoping.dto.CheckOtpRequest;
import com.company.shoping.dto.CreateOtpResponse;

public interface OtpService {
CreateOtpResponse createOtp(String mail);
void checkOtp(CheckOtpRequest request);
}
