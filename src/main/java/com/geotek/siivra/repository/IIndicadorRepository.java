package com.geotek.siivra.repository;

import com.geotek.siivra.dto.response.IndicadorCgResponseDTO;
import com.geotek.siivra.dto.response.IndicadorIndVarResponseDTO;
import com.geotek.siivra.dto.response.IndicadorResponseDTO;
import com.geotek.siivra.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IIndicadorRepository extends JpaRepository<Indicador, Long> {
        // ,IIndicadorCustomRepository, JpaSpecificationExecutor<Indicador> {

    // String REPLACE_BEFORE = "regexp_replace(regexp_replace(regexp_replace(regexp_replace(regexp_replace(regexp_replace(regexp_replace(";
    // String REPLACE_AFTER = ",'[Áá]+','a','g'),'[éÉ]+','e','g'),'[íÍ]+','i','g'),'[óÓ]+','o','g'),'[úÚ]+','u','g'),'[ñÑ]+','n','g'), '[^\\[a-zA-Z0-9]+','','g')";

    String REPLACE_BEFORE = "regexp_replace(regexp_replace(regexp_replace(regexp_replace(regexp_replace(regexp_replace(regexp_replace(";
    String REPLACE_AFTER = ",'[Áá]+','a','g'),'[éÉ]+','e','g'),'[íÍ]+','i','g'),'[óÓ]+','o','g'),'[úÚ]+','u','g'),'[ñÑ]+','n','g'), '[^\\[a-zA-Z0-9_%]+','','g')";

    String QUERY_INDICADOR = "select ind.id id," +
            " ind.id_rutina idRutina," +
            " rut.nombre nombreRutina, " +
            " ind.id_comp_desagregacion idCompDesagregacion," +
            " cd.nombre nombreCompDesagregacion," +
            " ind.id_adaptacion_nivel idAdaptacionNivel," +
            " an.nombre nombreAdaptacionNivel," +
            " ind.id_dimension idDimension," +
            " dim.nombre nombreDimension, " +
            " ind.id_clasificacion_adap idClasificacionAdap," +
            " ca.nombre nombreClasificacionAdap, " +
            " ind.id_indicador_subindice idIndicadorSubindice," +
            " isub.nombre nombreIndicadorSubindice," +
            " ind.id_indicador_indice idIndicadorIndice," +
            " iind.nombre nombreIndicadorIndice," +
            " ind.id_modelo_compone idModeloCompone," +
            " null nombreModeloCompone," + //" modc.nombre nombreModeloCompone," +
            " ind.id_indicador_seccion idIndicadorSeccion," +
            " isec.nombre nombreIndicadorSeccion," +
            " ind.id_unidad_medida idUnidadMedida," +
            " um.nombre nombreUnidadMedida," +
            " ind.id_tipo_salida_geografica idTipoSalidaGeografica," +
            " tsg.nombre nombreTipoSalidaGeografica," +
            " ind.id_indicador_tipo idIndicadorTipo," +
            " it.nombre nombreIndicadorTipo," +
            " ind.id_alcance_informacion idAlcanceInformacion," +
            " ai.nombre nombreAlcanceInformacion," +
            " ind.id_periodicidad idPeriodicidad," +
            " per.nombre nonbrePeriodicidad," +
            " ind.id_plan_adaptacion idPlanAdaptacion," +
            " pa.nombre nombrePlanAdaptacion," +
            " ind.id_estado idEstado," +
            " est.nombre nombreEstado," +
            " ind.nombre nombre," +
            " ind.codigo codigo," +
            " ind.fecha_publicacion fechaPublicacion," +
            " ind.descripcion descripcion," +
            " ind.archivo_ficha archivoFicha," +
            " ind.url_ficha urlFicha," +
            " ind.url_publicacion urlPublicacion," +
            " ind.observaciones observaciones," +
            " ind.fecha_plazo_meta fechaPlazoMeta," +
            " ind.etiquetas_publicacion etiquetasPublicacion," +
            " ind.calcular_valores_jerarquia calcularValoresJerarquia," +
            " ind.necesita_validar necesitaValidar," +
            " ind.necesita_aprobar necesitaAprobar," +
            " ind.id_forma_almacenar_info idFormaAlmacenarInfo," +
            " fai.nombre nombreFormaAlmacenarInfo," +
            " ind.id_disposicion_info idDisposicionInfo," +
            " di.nombre nombreDisposicionInfo," +
            " ind.id_formato_origen_datos idFormatoOrigenDatos," +
            " fod.nombre nombreFormatoOrigenDatos, " +
            " ind.almacenar_geografia almacenarGeografia, " +
            " (select count(1) from siivrat_indicador_x_var_ind where id_indicador_calculo = ind.id) asociada, " +
            " (select auditoria from siivra_conf.siivrat_indicador_v where id_indicador = ind.id order by id desc limit 1) auditoria " +
            " from siivrat_indicador ind " +
            " left outer join siivrat_rutina rut on ind.id_rutina = rut.id  " +
            " left outer join siivrat_comp_desagregacion cd on ind.id_comp_desagregacion = cd.id  " +
            " left outer join siivrat_adaptacion_nivel an on ind.id_adaptacion_nivel = an.id " +
            " left outer join siivrat_dimension dim on ind.id_dimension = dim.id " +
            " left outer join siivrat_clasificacion_adap ca on ind.id_clasificacion_adap = ca.id " +
            " left outer join siivrat_indicador_subindice isub on ind.id_indicador_subindice = isub.id " +
            " left outer join siivrat_indicador_indice iind on ind.id_indicador_indice = iind.id " +
            // " left outer join siivrat_modelo_componente modc on ind.id_modelo_compone = modc.id " +
            " left outer join siivrat_indicador_seccion isec on ind.id_indicador_seccion = isec.id " +
            " left outer join siivrat_unidad_medida um on ind.id_unidad_medida = um.id " +
            " left outer join siivrat_tipo_salida_geografica tsg on ind.id_tipo_salida_geografica = tsg.id " +
            " left outer join siivrat_indicador_tipo it on ind.id_indicador_tipo = it.id " +
            " left outer join siivrat_alcance_informacion ai on ind.id_alcance_informacion = ai.id " +
            " left outer join siivrat_periodicidad per on ind.id_periodicidad = per.id " +
            " left outer join siivrat_plan_adaptacion pa on ind.id_plan_adaptacion = pa.id " +
            " left outer join siivrat_estado est on ind.id_estado = est.id " +
            " left outer join siivrat_forma_almacenar_info fai on ind.id_forma_almacenar_info = fai.id " +
            " left outer join siivrat_disposicion_info di on ind.id_disposicion_info = di.id " +
            " left outer join siivrat_formato_origen_datos fod on ind.id_formato_origen_datos = fod.id ";

    String QUERY_INDICADOR_VAR_IND = "select vi.id id," +
            " vi.id_indicador_calculo idIndicadorCalculo," +
            " ind_c.nombre nombreIndicadorCalculo," +
            " vi.id_variable_calculo idVariableCalculo," +
            " v.nombre nombreVariableCalculo" +
            " from siivrat_indicador_x_var_ind vi " +
            " left outer join siivrat_indicador ind_c on vi.id_indicador_calculo = ind_c.id" +
            " left outer join siivrat_variable v on vi.id_variable_calculo = v.id";

    String QUERY_INDICADOR_CG = "select c.id id," +
            " c.id_comp_desagregacion idCompDesagregacion," +
            " scd.nombre nombreCompDesagregacion," +
            " c.id_capa_geografica idCapaGeografica," +
            " scg.nombre nombreCapaGeografica" +
            " from siivrat_indicador_x_capa c " +
            " left outer join siivrat_indicador ind on c.id_indicador = ind.id" +
            " left outer join siivrat_capa_geografica scg on c.id_capa_geografica = scg.id " +
            " left outer join siivrat_comp_desagregacion scd on c.id_comp_desagregacion = scd.id";

    @Query(value = QUERY_INDICADOR, nativeQuery = true)
    List<IndicadorResponseDTO> obtenerTodos();

    @Query(value = QUERY_INDICADOR + " limit :rows offset :page*:rows", nativeQuery = true)
    List<IndicadorResponseDTO> obtenerTodos(@Param("rows")Integer rows, @Param("page")Integer page);

    @Query(value = QUERY_INDICADOR + " where ind\\:\\:text like :condicion " + " limit :rows offset :page*:rows", nativeQuery = true)
    List<IndicadorResponseDTO> obtenerTodos(@Param("rows")Integer rows, @Param("page")Integer page, @Param("condicion") String condicion);

    @Query(value = QUERY_INDICADOR + " where ind.id = :id", nativeQuery = true)
    List<IndicadorResponseDTO> obtenerById(@Param("id") Long id);

    @Query(value = QUERY_INDICADOR + " where ind\\:\\:text like :condicion ", nativeQuery = true)
    List<IndicadorResponseDTO> obtenerByAny(@Param("condicion") String condicion);

    @Query(value = "select count(1) duplicado from siivrat_indicador where "+REPLACE_BEFORE+"lower(nombre)"+REPLACE_AFTER+" = "+REPLACE_BEFORE+"lower(:nombre)"+REPLACE_AFTER, nativeQuery = true)
    Integer comprobarNombre(@Param("nombre") String nombre);

    @Query(value = "select count(1) duplicado from siivrat_indicador where "+REPLACE_BEFORE+"lower(nombre)"+REPLACE_AFTER+" = "+REPLACE_BEFORE+"lower(:nombre)"+REPLACE_AFTER+" and id != :id", nativeQuery = true)
    Integer comprobarNombre(@Param("nombre") String nombre, @Param("id") Long id);

    @Query(value = "select count(1) duplicado from siivrat_indicador where "+REPLACE_BEFORE+"lower(codigo)"+REPLACE_AFTER+" = "+REPLACE_BEFORE+"lower(:codigo)"+REPLACE_AFTER, nativeQuery = true)
    Integer comprobarCodigo(@Param("codigo") String codigo);

    @Query(value = "select count(1) duplicado from siivrat_indicador where "+REPLACE_BEFORE+"lower(codigo)"+REPLACE_AFTER+" = "+REPLACE_BEFORE+"lower(:codigo)"+REPLACE_AFTER+" and id != :id", nativeQuery = true)
    Integer comprobarCodigo(@Param("codigo") String codigo, @Param("id") Long id);

    @Query(value = "select (count(1)/:rows)+1 pages from siivrat_indicador", nativeQuery = true)
    Integer obtenerPaginas(@Param("rows")Integer rows);

    @Query(value = "select (count(1)/:rows)+1 pages from siivrat_indicador ind " + " where ind\\:\\:text like :condicion ", nativeQuery = true)
    Integer obtenerPaginas(@Param("rows")Integer rows, @Param("condicion") String condicion);

    @Query(value = QUERY_INDICADOR_VAR_IND + " where id_indicador = :idIndicador", nativeQuery = true)
    List<IndicadorIndVarResponseDTO> obtenerVarIndDeIndicador(@Param("idIndicador") Long idIndicador);

    @Query(value = QUERY_INDICADOR_CG + " where id_indicador = :idIndicador", nativeQuery = true)
    List<IndicadorCgResponseDTO> obtenerCapasDeIndicador(@Param("idIndicador") Long idIndicador);

}
