package com.bm.test.bm_test.model.dto;

// vendors
import com.bm.test.bm_test.model.dto.ResponseData;

import java.util.HashMap;

public class SuccessResponseData extends ResponseData {
    public SuccessResponseData(HashMap dataMap) {
        super();
        this.data = dataMap;
    }

    public SuccessResponseData() {
        super();
    }
}
