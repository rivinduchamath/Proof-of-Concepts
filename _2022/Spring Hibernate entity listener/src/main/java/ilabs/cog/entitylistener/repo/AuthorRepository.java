package ilabs.cog.entitylistener.repo;

import ilabs.cog.entitylistener.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Transactional(readOnly=true)
    Author findByName(String name);
}