package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RecoveryRoomRepository extends  CrudRepository<RecoveryRoom, Integer>{
    List<RecoveryRoom> findAll();
    @Query("SELECT recoveryRoomType FROM RecoveryRoomType recoveryRoomType")
    List<RecoveryRoomType> findAllRecoveryRoomTypes();
    Optional<RecoveryRoom> findById(int id);
    @Query("SELECT DISTINCT recoveryRoomType FROM RecoveryRoomType recoveryRoomType WHERE recoveryRoomType.name LIKE :name%")
    RecoveryRoomType getRecoveryRoomType(String name);
    @Query("SELECT DISTINCT recoveryRoom FROM RecoveryRoom recoveryRoom WHERE recoveryRoom.size > :size")
    List<RecoveryRoom> findBySizeMoreThan(double size);
    RecoveryRoom save(RecoveryRoom p);
    //RecoveryRoomType getRecoveryRoomType(String name);
    //List<RecoveryRoom> findBySizeMoreThan(double size);
}
