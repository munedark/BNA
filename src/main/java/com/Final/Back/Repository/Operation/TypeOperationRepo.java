    package com.Final.Back.Repository.Operation;

    import com.Final.Back.Modles.Operation.TypeOperation;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.data.jpa.repository.Query;
    import org.springframework.stereotype.Repository;

    import java.util.Optional;

    @Repository
    public interface TypeOperationRepo extends JpaRepository<TypeOperation,Integer> {
        Optional<TypeOperation> findByLibelleOperation(String libelleOperation);
        Optional<TypeOperation> findByNumeroType(String numero);
    }
