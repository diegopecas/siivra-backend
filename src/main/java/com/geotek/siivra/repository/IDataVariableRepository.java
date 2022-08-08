package com.geotek.siivra.repository;

import com.geotek.siivra.dto.response.DataVariableResponseDTO;
import com.geotek.siivra.dto.response.ValidarAprobarDataVariableResponseDTO;
import com.geotek.siivra.entity.DataVariable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IDataVariableRepository  extends JpaRepository<DataVariable, Long> {

    public static String QUERY_DATA_VARIABLE = "select ind.id id," +
            " ind.id_variable idVariable," +
            " var.nombre nombreVariable," +
            " ind.id_proceso_variable idProcesoVariable," +
            " ind.id_componente_desagrega_item idComponenteDesagregaItem," +
            " cd.nombre nombreComponenteDesagregaItem," +
            " comp.id idTipoCompDesagregacion, " +
            " comp.nombre nombreTipoCompDesagregacion, " +
            " ind.valor valor," +
            " substring(ind.periodo_inicial_validez,1,6) periodoInicialValidez," +
            " substring(ind.periodo_final_validez,1,6) periodoFinalValidez," +
            " ind.id_tipo_estado idTipoEstado," +
            " te.nombre nombreTipoEstado," +
            " ind.motivo motivo," +
            " ind.motivo motivoComplementario," +
            " (select auditoria from siivra_conf.siivrat_variable_info_alfa_v where id_variable_info_alfa = ind.id order by id desc limit 1) auditoria " +
            " from siivrat_variable_info_alfa ind" +
            " left outer join siivrat_variable var on ind.id_variable = var.id" +
            // " left outer join siivrat_proceso_variable pro on ind.id_proceso_variable = pro.id" +
            " left outer join siivrat_comp_desagregacion_item cd on ind.id_componente_desagrega_item = cd.id" +
            " left outer join siivrat_comp_desagregacion comp on cd.id_comp_desagregacion = comp.id " +
            " left outer join siivrat_tipo_estado te on ind.id_tipo_estado = te.id";

    @Query(value = QUERY_DATA_VARIABLE, nativeQuery = true)
    List<DataVariableResponseDTO> obtenerTodos();

    @Query(value = QUERY_DATA_VARIABLE + " limit :rows offset :page*:rows", nativeQuery = true)
    List<DataVariableResponseDTO> obtenerTodos(@Param("rows")Integer rows, @Param("page")Integer page);

    @Query(value = QUERY_DATA_VARIABLE + " where ind.id = :id", nativeQuery = true)
    List<DataVariableResponseDTO> obtenerById(@Param("id") Long id);

    @Query(value = QUERY_DATA_VARIABLE + " where ind.id_variable = :id", nativeQuery = true)
    List<DataVariableResponseDTO> obtenerByIdVariable(@Param("id") Long id);

    @Query(value = QUERY_DATA_VARIABLE + " where :condicion ", nativeQuery = true)
    List<DataVariableResponseDTO> obtenerByAny(@Param("condicion") String condicion);

    @Query(value = "select (count(1)/:rows)+1 pages from siivrat_variable_info_alfa", nativeQuery = true)
    Integer obtenerPaginas(@Param("rows")Integer rows);

    @Query(value = "SELECT dv FROM DataVariable dv " +
            " WHERE dv.idVariable = :keyword")
    List<DataVariable> findByIdVariable(@Param("keyword")Long keyword);

    @Query(value = "SELECT dv FROM DataVariable dv " +
            " WHERE dv.idVariable = :pIdVariable and dv.idComponenteDesagregaItem = :pIdComponenteDesagregaItem and dv.periodoInicialValidez = :pInicial and dv.periodoFinalValidez = :pFinal")
    List<DataVariable> findByPeriodo(@Param("pIdVariable")Long pIdVariable, @Param("pIdComponenteDesagregaItem")Long pIdComponenteDesagregaItem, @Param("pInicial")String pInicial, @Param("pFinal")String pFinal);

    @Query(value = "SELECT dv.id, " +
            "            CONCAT(COALESCE(dv.periodo_inicial_validez,''),' - ',COALESCE(dv.periodo_final_validez,'')) as intervaloPeriodo, " +
            "            cd.id as idTipoDesagregacion, " +
            "            cd.nombre as tipoDesagregacion, " +
            "            cdi.id as id_componente_desagrega_item, " +
            "            cdi.nombre as desagregacion, " +
            "            dv.valor, " +
            "            dv.id_tipo_estado as idTipoEstado, " +
            "            v.observaciones as observacion, " +
            "            v.id_unidad_medida as unidad " +
            "            FROM siivrat_variable_info_alfa dv " +
            "            inner join siivrat_variable v  on v.id = dv.id_variable " +
            "            left outer join siivrat_comp_desagregacion_item cdi on dv.id_componente_desagrega_item = cdi.id " +
            "            inner join siivrat_comp_desagregacion cd on cdi.id_comp_desagregacion = cd.id " +
            "            WHERE dv.id_variable= :keyword",nativeQuery = true)
    List<DataVariableResponseDTO> buscarPorVariable(@Param("keyword")Long keyword);


    @Transactional
    @Modifying
    @Query("delete from DataVariable dv where dv.id in ?1")
    void deleteDataVariableWithIds(List<Long> ids);

    @Query(value = "update siivrat_variable_info_alfa set id_tipo_estado= :estado " +
                   " WHERE id = :id",nativeQuery = true)
    List<ValidarAprobarDataVariableResponseDTO> updateDataVariableWithIds(@Param("id")Long id, @Param("estado")Long estado);

    @Transactional
    @Modifying
    @Query(value = "update DataVariable dv set dv.idTipoEstado = :estado " +
            " where dv.id = :id")
    void updateEstadoDataVariable(@Param("id")Long id, @Param("estado")Long estado);

    @Query("SELECT COUNT(u) FROM DataVariable u WHERE u.idVariable=:idVariable")
    long getCountOfDataByVariable(@Param("idVariable") long idVariable);
}