package FraisNonAuxiliaire;

import com.Final.Back.OperationFraisGeneraux.OperationFraisGeneraux;
import com.Final.Back.OperationCtx.OperationCtx;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class FraisNonAuxiliaire extends OperationFraisGeneraux {

    @Column(name ="typePiece")
    private String typePiece;
    @Column(name = "numeroPiece")
    private Long numeroPiece;


}
