package com.codeblocks.accounts.service;

import com.codeblocks.accounts.dto.CustomerDetailsDto;

public interface ICustomerService {

    /**
     *
     * @param mobileNumber - Input Mobile Number
     * @return - Customer Details based on mobileNumber
     */
    CustomerDetailsDto fetchCustomerDetails(String mobileNumber);
}