package tn.esprit.nejd_bedoui_project_4twin7.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.nejd_bedoui_project_4twin7.Models.*;

import java.util.List;

public interface IChambreRepository extends JpaRepository<Chambre,Long> {
    List<Chambre> findByTypeCAndBlocChambreAndReservations(TypeChambre type, Bloc bloc, Reservation reservation);

    Chambre findChambreByReservations(Reservation re);
    @Query("SELECT c FROM Chambre c WHERE c.blocChambre = :bloc AND c.typeC = :type")
    List<Chambre> findByBlocAndTypeChambre(@Param("bloc") Bloc bloc, @Param("type") TypeChambre type);

    List<Chambre> findByBlocChambreAndTypeC(Bloc b,TypeChambre t);
}
