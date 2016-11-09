package haha.meme.haha;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface PoistovnaRepository extends CrudRepository<Poistovna, Integer> {

	Page<Poistovna> findAll(Pageable pageable);
}