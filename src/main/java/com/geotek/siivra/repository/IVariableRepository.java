package com.geotek.siivra.repository;

import com.geotek.siivra.dto.response.VariableResponseDTO;
import com.geotek.siivra.entity.DataVariable;
import com.geotek.siivra.entity.Variable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.geotek.siivra.entity.common.IndicadorXVarInd;
import com.geotek.siivra.entity.common.AccesoVariableXUsu;
import com.geotek.siivra.entity.common.UsuRespXVariable;
import com.geotek.siivra.entity.common.VariableInfoArchivo;
import com.geotek.siivra.entity.common.ProcesoVariable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IVariableRepository extends JpaRepository<Variable, Long> {

	String REPLACE_BEFORE = "regexp_replace(regexp_replace(regexp_replace(regexp_replace(regexp_replace(regexp_replace(regexp_replace(";
	String REPLACE_AFTER = ",'[Áá]+','a','g'),'[éÉ]+','e','g'),'[íÍ]+','i','g'),'[óÓ]+','o','g'),'[úÚ]+','u','g'),'[ñÑ]+','n','g'), '[^\\[a-zA-Z0-9_%]+','','g')";

	public static String QUERY_VARIABLE = "select ind.id id," +
			" ind.id_rutina idRutina," +
			" rut.nombre nombreRutina," +
			" ind.id_forma_almacenar_info idFormaAlmacenarInfo," +
			" fai.nombre nombreFormaAlmacenarInfo," +
			" ind.id_tipo_ubicacion_info idTipoUbicacionInfo," +
			" tui.nombre nombreTipoUbicacionInfo," +
			" ind.id_formato_origen_datos idFormatoOrigenDatos," +
			" fod.nombre nombreFormatoOrigenDatos," +
			" ind.id_comp_desagregacion idCompDesagregacion," +
			" cd.nombre nombreCompDesagregacion," +
			" ind.id_disposicion_info idDisposicionInfo," +
			" di.nombre nombreDisposicionInfo," +
			" ind.id_unidad_medida idUnidadMedida," +
			" um.nombre nombreUnidadMedida," +
			" ind.id_periodicidad idPeriodicidad," +
			" per.nombre nonbrePeriodicidad," +
			" ind.id_entidad idEntidad," +
			" ent.nombre nonbreEntidad," +
			" ind.id_estado idEstado," +
			" est.nombre nombreEstado," +
			" ind.id_proyecto idProyecto," +
			" pro.nombre nombreProyecto," +
			" ind.id_capa_geografica_referencia idCapaGeograficaReferencia," +
			" cgr.nombre nombreCapaGeograficaReferencia," +
			" ind.nombre nombre," +
			" ind.archivo_definicion archivoDefinicion," +
			" ind.dependencia dependencia," +
			" ind.contacto_nombre contactoNombre," +
			" ind.contacto_cargo contactoCargo," +
			" ind.contacto_correo contactoCorreo," +
			" ind.contacto_telefono contactoTelefono," +
			" ind.datos_ubicacion datosUbicacion," +
			" ind.observaciones observaciones," +
			" ind.calcular_valores_jerarquia calcularValoresJerarquia," +
			" ind.url_ficha urlFicha," +
			" ind.id_tipo_variable idTipoVariable," +
			" it.nombre nombreTipoVariable," +
			" ind.fecha_creacion fechaCreacion," +
			" ind.almacenar_geografia almacenarGeografia," +
			" ind.necesita_validar necesitaValidar," +
			" ind.necesita_aprobar necesitaAprobar," +
			" ind.usuario usuario," +
			" ind.contrasenia contrasenia, " +
			" (select count(1) from siivrat_indicador_x_var_ind where id_variable_calculo = ind.id) asociada, " +
			" (select auditoria from siivra_conf.siivrat_variable_v where id_variable = ind.id order by id desc limit 1) auditoria " +
			" from siivrat_variable ind" +
			" left outer join siivrat_rutina rut on ind.id_rutina = rut.id" +
			" left outer join siivrat_comp_desagregacion cd on ind.id_comp_desagregacion = cd.id" +
			" left outer join siivrat_unidad_medida um on ind.id_unidad_medida = um.id" +
			" left outer join siivrat_periodicidad per on ind.id_periodicidad = per.id" +
			" left outer join siivrat_estado est on ind.id_estado = est.id" +
			" left outer join siivrat_forma_almacenar_info fai on ind.id_forma_almacenar_info = fai.id" +
			" left outer join siivrat_disposicion_info di on ind.id_disposicion_info = di.id" +
			" left outer join siivrat_tipo_variable it on ind.id_tipo_variable = it.id" +
			" left outer join siivrat_tipo_ubicacion_info tui on ind.id_tipo_ubicacion_info = tui.id" +
			" left outer join siivrat_formato_origen_datos fod on ind.id_formato_origen_datos = fod.id" +
			" left outer join siivrat_entidad ent on ind.id_entidad = ent.id" +
			" left outer join siivrat_proyecto pro on ind.id_proyecto = pro.id" +
			" left outer join siivrat_capa_geografica cgr on ind.id_capa_geografica_referencia = cgr.id";


	@Query(value = QUERY_VARIABLE, nativeQuery = true)
	List<VariableResponseDTO> obtenerTodos();

	@Query(value = QUERY_VARIABLE + " limit :rows offset :page*:rows", nativeQuery = true)
	List<VariableResponseDTO> obtenerTodos(@Param("rows")Integer rows, @Param("page")Integer page);

	@Query(value = QUERY_VARIABLE + " where ind.id = :id", nativeQuery = true)
	List<VariableResponseDTO> obtenerById(@Param("id") Long id);

	@Query(value = QUERY_VARIABLE + " where :condicion ", nativeQuery = true)
	List<VariableResponseDTO> obtenerByAny(@Param("condicion") String condicion);

	@Query(value = "select count(1) duplicado from siivrat_variable where "+REPLACE_BEFORE+"lower(nombre)"+REPLACE_AFTER+" = "+REPLACE_BEFORE+"lower(:nombre)"+REPLACE_AFTER, nativeQuery = true)
	Integer comprobarNombre(@Param("nombre") String nombre);

	@Query(value = "select count(1) duplicado from siivrat_variable where "+REPLACE_BEFORE+"lower(nombre)"+REPLACE_AFTER+" = "+REPLACE_BEFORE+"lower(:nombre)"+REPLACE_AFTER+" and id != :id", nativeQuery = true)
	Integer comprobarNombre(@Param("nombre") String nombre, @Param("id") Long id);

	@Query(value = "select (count(1)/:rows)+1 pages from siivrat_variable", nativeQuery = true)
	Integer obtenerPaginas(@Param("rows")Integer rows);

	@Query(value="{call siivra_pr_auditoria(:registro, :justificacion)}", nativeQuery = true)
	void getProcedimiento(@Param("registro") String registro, @Param("justificacion") String justificacion);

	@Query(value = "SELECT iv FROM IndicadorXVarInd iv " +
			" WHERE iv.idVariableCalculo = :keyword")
	List<IndicadorXVarInd> findByIdIndicadorXVarInd(@Param("keyword")Integer keyword);

	@Query(value = "SELECT iv FROM AccesoVariableXUsu iv " +
			" WHERE iv.idVariable = :keyword")
	List<AccesoVariableXUsu> findByIdAccesoVariableXUsu(@Param("keyword")Integer keyword);

	@Query(value = "SELECT iv FROM UsuRespXVariable iv " +
			" WHERE iv.idVariable = :keyword")
	List<UsuRespXVariable> findByIdUsuRespXVariable(@Param("keyword")Integer keyword);

	@Query(value = "SELECT iv FROM VariableInfoArchivo iv " +
			" WHERE iv.idVariable = :keyword")
	List<VariableInfoArchivo> findByIdVariableInfoArchivo(@Param("keyword")Integer keyword);

	@Query(value = "SELECT iv FROM ProcesoVariable iv " +
			" WHERE iv.idVariable = :keyword")
	List<ProcesoVariable> findByIdProcesoVariable(@Param("keyword")Integer keyword);

	@Query(value = "SELECT iv FROM DataVariable iv " +
			" WHERE iv.idVariable = :keyword")
	List<DataVariable> findByIdVariableInfoAlfa(@Param("keyword")Integer keyword);

	@Transactional
	@Modifying
	@Query(value = "DELETE FROM AccesoVariableXUsu" +
			" WHERE idVariable = :keyword")
	boolean deleteByIdAccesoVariableXUsu(@Param("keyword")Integer keyword);

	@Transactional
	@Modifying
	@Query(value = "DELETE FROM UsuRespXVariable" +
			" WHERE idVariable = :keyword")
	boolean deleteByIdUsuRespXVariable(@Param("keyword")Integer keyword);

	@Transactional
	@Modifying
	@Query(value = "DELETE FROM VariableInfoArchivo" +
			" WHERE idVariable = :keyword")
	boolean deleteByIdVariableInfoArchivo(@Param("keyword")Integer keyword);

	@Transactional
	@Modifying
	@Query(value = "DELETE FROM ProcesoVariable" +
			" WHERE idVariable = :keyword")
	boolean deleteByIdProcesoVariable(@Param("keyword")Integer keyword);

	@Transactional
	@Modifying
	@Query(value = "DELETE FROM DataVariable" +
			" WHERE idVariable = :keyword")
	boolean deleteByIdVariableInfoAlfa(@Param("keyword")Integer keyword);

}
