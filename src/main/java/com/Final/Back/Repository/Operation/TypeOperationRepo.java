    package com.Final.Back.Repository.Operation;

    import com.Final.Back.Modles.Operation.TypeOperation;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.stereotype.Repository;

    @Repository
    public interface TypeOperationRepo extends JpaRepository<TypeOperation,Integer> {
    }
