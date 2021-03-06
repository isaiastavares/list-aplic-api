package br.com.ufg.listaplic.repository;

import br.com.ufg.listaplic.model.ApplicationListStatus;
import br.com.ufg.listaplic.model.Classroom;
import br.com.ufg.listaplic.model.ListApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ListApplicationJpaRepository extends JpaRepository<ListApplication, UUID> {

    List<ListApplication> findByClassroomAndStatus(Classroom classroom, ApplicationListStatus status);

    List<ListApplication> findByClassroomAndStatusNot(Classroom classroom, ApplicationListStatus status);

    List<ListApplication> findByClassroom(Classroom classroom);

    Integer countByClassroomId(UUID classroomId);

}
