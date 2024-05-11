package com.Final.Back.OperationFraisInitiesCtx;

import java.time.LocalDate;
import java.util.List;

public interface OperationFraisInitiesCtxService {
    OperationFraisInitiesCTX saveOperation(OperationFraisInitiesCTX operation);
    OperationFraisInitiesCTX getOperationById(Long id);
    OperationFraisInitiesCTX updateOperationFraisGenraux(Long id, String matriculeValidateur, LocalDate dateValidation, String etatOperation);
    void deleteOperation(Long id);
    List<OperationFraisInitiesCTX> getOperationsSansMatriculeValidateur();

}
