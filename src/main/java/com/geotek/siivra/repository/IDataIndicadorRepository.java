package com.geotek.siivra.repository;

import com.geotek.siivra.dto.response.DataIndicadorResponseDTO;
import com.geotek.siivra.dto.response.ValidarAprobarDataIndicadorResponseDTO;
import com.geotek.siivra.entity.DataIndicador;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public interface IDataIndicadorRepository extends JpaRepository<DataIndicador, Long> {

    String QUERY_DATA_INDICADOR = "select ind.id id," +
            " ind.id_indicador idIndicador," +
            " var.nombre nombreIndicador," +
            " ind.id_proceso_indicador idProcesoIndicador," +
            " ind.id_componente_desagrega_item idComponenteDesagregaItem," +
            " cd.nombre nombreComponenteDesagregaItem," +
            " comp.id idTipoCompDesagregacion, " +
            " comp.nombre nombreTipoCompDesagregacion, " +
            " ind.valor valor," +
            " substring(ind.periodo_inicial_validez,1,6) periodoInicialValidez," +
            " substring(ind.periodo_final_validez,1,6) periodoFinalValidez," +
            " ind.valor_meta valorMeta," +
            " ind.id_tipo_estado idTipoEstado," +
            " te.nombre nombreTipoEstado," +
            " ind.motivo motivo," +
            " ind.motivo motivoComplementario," +
            " (select auditoria from siivra_conf.siivrat_indicador_info_alfa_v where id_indicador_info_alfa = ind.id order by id desc limit 1) auditoria " +
            " from siivrat_indicador_info_alfa ind" +
            " left outer join siivrat_indicador var on ind.id_indicador = var.id" +
            // " left outer join siivrat_proceso_indicador pro on ind.id_proceso_indicador = pro.id" +
            " left outer join siivrat_comp_desagregacion_item cd on ind.id_componente_desagrega_item = cd.id" +
            " left outer join siivrat_comp_desagregacion comp on cd.id_comp_desagregacion = comp.id " +
            " left outer join siivrat_tipo_estado te on ind.id_tipo_estado = te.id";


    @Query(value = QUERY_DATA_INDICADOR, nativeQuery = true)
    List<DataIndicadorResponseDTO> obtenerTodos();

    @Query(value = QUERY_DATA_INDICADOR + " limit :rows offset :page*:rows", nativeQuery = true)
    List<DataIndicadorResponseDTO> obtenerTodos(@Param("rows")Integer rows, @Param("page")Integer page);

    @Query(value = QUERY_DATA_INDICADOR + " where ind.id = :id", nativeQuery = true)
    List<DataIndicadorResponseDTO> obtenerById(@Param("id") Long id);

    @Query(value = QUERY_DATA_INDICADOR + " where :condicion ", nativeQuery = true)
    List<DataIndicadorResponseDTO> obtenerByAny(@Param("condicion") String condicion);

    @Query(value = "select (count(1)/:rows)+1 pages from siivrat_indicador_info_alfa", nativeQuery = true)
    Integer obtenerPaginas(@Param("rows")Integer rows);

    @Query(value = "SELECT dv FROM DataIndicador dv " +
            " WHERE dv.idIndicador = :keyword")
    List<DataIndicador> findByIdIndicador(@Param("keyword")Long keyword);

    @Query(value = "SELECT di FROM DataIndicador di " +
            " WHERE di.idIndicador = :pIdIndicador and di.idComponenteDesagregaItem = :pIdComponenteDesagregaItem and di.periodoInicialValidez = :pInicial and di.periodoFinalValidez = :pFinal")
    List<DataIndicador> findByPeriodo(@Param("pIdIndicador")Long pIdIndicador, @Param("pIdComponenteDesagregaItem")Long pIdComponenteDesagregaItem, @Param("pInicial")String pInicial, @Param("pFinal")String pFinal);

    @Query(value = QUERY_DATA_INDICADOR + " where ind.id_indicador = :id ", nativeQuery = true)
    List<DataIndicadorResponseDTO> buscarPorIndicador(@Param("id")Long id);

    @Query(value = "SELECT infoalfa.* as DataIndicador " +
            " FROM  siivrat_indicador_info_alfa infoalfa " +
            " WHERE infoalfa.id_indicador = :idIndicador ",nativeQuery = true )
    Object[][] findAllDataIndicadorByIdIndicador(@Param("idIndicador")Long idIndicador );

    @Query(value = "SELECT infoalfa.* as DataIndicador " +
            " FROM  siivrat_indicador_info_alfa infoalfa " +
            " WHERE infoalfa.id_indicador = :idIndicador limit 10 offset :offset ",nativeQuery = true )
    Object[][] findAllDataIndicadorByIdIndicadorPag(@Param("idIndicador")Long idIndicador,
                                                    @Param("offset") Integer offset);

    @Transactional
    @Modifying
    @Query("delete from DataIndicador dv where dv.id in ?1")
    void deleteDataIndicadorWithIds(List<Long> ids);

    @Transactional
    @Modifying
    @Query("delete from DataIndicador dv where dv.id = :id")
    void deleteById(@Param("id")Long id);

    @Transactional
    @Modifying
    @Query("delete from DataIndicador dv where dv.idIndicador = :id")
    void deleteByIdIndicador(@Param("id")Long id);

    @Query(value = "update siivrat_indicador_info_alfa set id_tipo_estado= :estado " +
            " WHERE id = :id",nativeQuery = true)
    List<ValidarAprobarDataIndicadorResponseDTO> updateDataIndicadorWithIds(@Param("id")Long id, @Param("estado")Long estado);

    @Transactional
    @Modifying
    @Query(value = "update DataIndicador dv set dv.idTipoEstado = :estado " +
            " where dv.id = :id")
    void updateEstadoDataIndicador(@Param("id")Long id, @Param("estado")Long estado);

    @Query("SELECT COUNT(u) FROM DataIndicador u WHERE u.idIndicador=:idIndicador")
    long getCountOfDataByIndicador(@Param("idIndicador") long idIndicador);

    @Query(value = "SELECT auditoria FROM siivra_conf.siivrat_indicador_info_alfa_v where id_indicador_info_alfa = :idDataIndicador and auditoria is not null ORDER BY id DESC LIMIT 1", nativeQuery = true)
    Object getLastAuditoria(@Param("idDataIndicador") long idDataIndicador);
}


