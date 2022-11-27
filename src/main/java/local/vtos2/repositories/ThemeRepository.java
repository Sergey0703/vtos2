package local.vtos2.repositories;

import local.vtos2.models.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ThemeRepository extends JpaRepository<Theme, Integer> {
   // @Query("SELECT u FROM User u WHERE u.status = ?1 and u.name = ?2")
   // Theme findThemesByItem(Integer status, String name);

     @Query("SELECT th FROM Theme th WHERE th.item.id = ?1 ")
     List<Theme> findThemesByItem(Integer item_id);

   // @Query("DELETE FROM Theme WHERE Theme.id = ?1 ")
   // void deleteThemesById(Integer id);
}
