package com.codeblocks.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(
        name = "Customer Details",
        description = "Schema to hold Customer, Accounts, Cards and Loans Information"
)
public class CustomerDetailsDto {

    @Schema(
            description = "Name of the customer",example = "Rahul Kumar"
    )
    @NotEmpty(message = "Name can not be a null or empty")
    @Size(min = 5,max = 30,message = "The length of the customer name should be between 5 and 30")
    private String name;

    @Schema(
            description = "Email Address of the customer",example = "rahulkumar123@gmail.com"
    )
    @NotEmpty(message = "Email address can not be a null or empty")
    @Email(message = "Email address must be a valid value")
    private String email;

    @Schema(
            description = "Mobile Number of the customer",example = "9124567509"
    )
    @Pattern(regexp = "(^$|[0-9]{10})" , message= "Mobile number must be 10 digits")
    private String mobileNumber;

    @Schema(
            description = "Account details of the customer"
    )
    private AccountsDto accountsDto;

    @Schema(
            description = "Card details of the customer"
    )
    private CardsDto cardsDto;

    @Schema(
            description = "Loan details of the customer"
    )
    private LoansDto loansDto;
}