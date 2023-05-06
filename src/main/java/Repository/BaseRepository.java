package Repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BaseRepository<T,ID> extends CrudRepository<T,ID>, PagingAndSortingRepository<T,ID>, JpaSpecificationExecutor<T> {

}
