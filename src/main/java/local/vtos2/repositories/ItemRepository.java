package local.vtos2.repositories;

import local.vtos2.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ItemRepository extends JpaRepository<Item, Integer> {

}
