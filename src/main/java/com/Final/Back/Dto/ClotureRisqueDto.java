package com.Final.Back.Dto;

import com.Final.Back.Modles.Risques.Risque;
import com.Final.Back.Operations.OperationCtx.OperationCtx;
import lombok.Data;

@Data
public class ClotureRisqueDto {
    OperationCtx operation;
    Risque risque;
}
