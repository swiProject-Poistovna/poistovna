package haha.meme.haha;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduktRepository extends CrudRepository<Produkt, Integer> {

	Page<Produkt> findAll(Pageable pageable);
	
}