package com.example.LimitedTimeDeals.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BaseResponse<R> {

    String responseMsg;

    Date timeStamp;

    String requestId;

    R response;
}
