package org.sid.dao;

import org.sid.reverse.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface paiementRepository extends JpaRepository<Paiement, Integer> {

}
