package com.freetirage.apitirage.repository;


import com.freetirage.apitirage.model.PostulantTrie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.List;
@Repository
public interface PostulantTrieRepo extends JpaRepository<PostulantTrie, Long> {


    //requete permettant d'inserer les postulant trié
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO postulant_trie(idpostulant,nompostulant,prenompostulant,numeropostulant,email,idtirage_id) VALUES(?,?,?,?,?,?);",nativeQuery = true)
    public int INSERTPOSTTIRE(Long idpostulant, String nom, String prenom, String numero, String email, Long idtirage_id );

    /*@Modifying
    @Transactional
    @Query(value = "insert into postulanttrie(idpostulant,nompostulant,prenompostulant,numeropostulant,email, idtirage) values (:idpostulant,:nompostulant,prenompostulant,:numeropostulant,:email, :idtirage);", nativeQuery = true)
    public int INSERTPOSTTIRE(@Param("idpostulant") long idpostulant, @Param("nompostulant") String nompostulant, @Param("prenompostulant") String prenompostulant, @Param("numeropostulant") long numeropostulant,@Param("email") String email,@Param("idtirage") long idtirage);
*/

    //requette permettant de retourner les postulants triés lors d'un
    @Modifying
    @Transactional
    @Query(value = "SELECT * FROM postulant_trie where idtirage_id = idtirage_id",nativeQuery = true)
    public List<PostulantTrie> FINDALLPOSTULANTTRIEPARID(@PathVariable Long  idtirage_id);
}
