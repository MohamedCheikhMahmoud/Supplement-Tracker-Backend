package de.htw_berlin.mysupps.repository;

import de.htw_berlin.mysupps.model.Supplement;
import org.springframework.data.repository.CrudRepository;

public interface SupplementRepository extends CrudRepository<Supplement, Long> {
}
