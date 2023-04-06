package xyz.onegrid.coreapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.onegrid.coreapi.domain.Authority;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {}
