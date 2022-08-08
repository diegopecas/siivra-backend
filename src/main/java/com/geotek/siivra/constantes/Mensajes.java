package com.geotek.siivra.constantes;

public interface Mensajes {

    /* GENERALES */
    String ERROR_COMUNICACION_BD = "Existe un error de comunicación con la base de datos, por favor intente nuevamente en un instante.";
    String ERROR_GENERAL_SERVICIO = "Se generó un error en el servicio al intentar procesar la petición.";
    String VALOR_NO_NUMERICO = "El valor no corresponde a un número.";
    String VALOR_META_NO_NUMERICO = "El valor de la meta no corresponde a un número.";
    /* VARIABLES */
    String EXISTE_VARIABLE_NOMBRE = "El nombre de la variable ya existe. Por favor cambiarlo.";
    String EXISTE_VARIABLE_CODIGO = "Ya existe una variable con el mismo código.";
    String NO_EXISTE_VARIABLE_X_ID = "No existe variable con el id solicitado.";
    String NO_ADD_VARIABLE = "Se presentó un error en el servicio y no fue posible crear la variable.";
    String NO_UPDATE_VARIABLE = "Se presentó un error en el servicio y no fue posible actualizar la variable.";
    String NO_DELETE_VARIABLE = "Se presentó un error en el servicio y no fue posible eliminar la variable.";
    String VARIABLE_ADD_OK = "Se creó la variable correctamente.";
    String VARIABLE_CREADA = "La variable se ha creado correctamente.";
    String VARIABLE_ACTUALIZADA = "La variable se ha actualizado correctamente.";
    String VARIABLE_ELIMINADA = "La variable se ha eliminado correctamente.";
    String VARIABLE_ELIMINADA_CON_DATOS = "La variable y sus datos asociados se han eliminado correctamente.";
    String VARIABLE_ERROR_GENERAL = "Se presentó un error con los servicios de Variable y no se puede realizar la operación en este momento.";
    String VARIABLE_ASOCIADO_INDICADOR = "La variable está asociada a un indicador y NO puede ser eliminada.";

    /* DATOS DE VARIABLE*/
    String EXISTE_DATO_VARIABLE_X_PERIODO = "Ya existe un dato para el periodo solicitado.";
    String DATO_VARIABLE_ADD_NO_DATA = "No se actualizaron o agregaron nuevos periodos de datos.";
    String DATO_VARIABLE_ADD_MANTENER = "Se agregaron los datos para periodos no existentes.";
    String DATO_VARIABLE_ADD_REEMPLAZAR = "Se agregaron los datos para periodos no existentes y se actualizaron los existentes.";
    String DATO_VARIABLE_REEMPLAZAR = "El dato de la variable se actualizó de forma exitosa.";
    String DATO_VARIABLE_NUEVO = "El dato de la variable se guardó de forma exitosa.";
    String NO_EXISTE_COMP_DESAGREGACION = "El identificador del componente de desagregación no existe.";

    String DATO_ELIMINADO = "Se eliminó registro solicitado.";
    String NO_DELETE_DATO = "Se presentó un error en el servicio y no fue posible eliminar el dato.";

    /* INDICADORES */
    String EXISTE_INDICADOR_NOMBRE = "El nombre del indicador ya existe. Por favor cambiarlo.";
    String EXISTE_INDICADOR_CODIGO = "El código del indicador ya existe. Por favor cambiarlo.";
    String NO_EXISTE_INDICADOR_X_ID = "No existe indicador con el id solicitado.";
    String NO_ADD_INDICADOR = "Se presentó un error en el servicio y no fue posible crear el indicador.";
    String NO_UPDATE_INDICADOR = "Se presentó un error en el servicio y no fue posible actualizar el indicador.";
    String NO_DELETE_INDICADOR = "Se presentó un error en el servicio y no fue posible eliminar el indicador.";
    String INDICADOR_CREADO_SIN_VARIND = "Se creó el indicador; sin embargo, no se han podido asociar las variables y/o indicadores.";
    String INDICADOR_CREADO_SIN_CAPA = "Se creó el indicador; sin embargo, no se han podido asociar las capas geográficas.";
    String INDICADOR_CREADO = "El indicador se ha creado correctamente.";
    String INDICADOR_ACTUALIZADO = "El indicador se ha actualizado correctamente.";
    String INDICADOR_ELIMINADO_CON_DATOS = "El indicador y sus datos asociados se han eliminado correctamente.";
    String INDICADOR_ELIMINADO = "El indicador se ha eliminado correctamente.";
    String INDICADOR_ERROR_GENERAL = "Se presentó un error con los servicios de Indicador y no se puede realizar la operación en este momento.";
    String INDICADOR_ASOCIADO_INDICADOR = "El indicador está asociado a otro indicador y NO puede ser eliminado.";
    String INDICADOR_TIENE_ASOCIADOS = "El indicador tiene variables y/o indicadores asociados y NO puede ser eliminado. Por favor elimine primero estas asociaciones.";

    /* DATOS DE VARIABLE*/
    String EXISTE_DATO_INDICADOR_X_PERIODO = "Ya existe un dato para el periodo solicitado.";
    String DATO_INDICADOR_ADD_NO_DATA = "No se actualizaron o agregaron nuevos periodos de datos.";
    String DATO_INDICADOR_ADD_MANTENER = "Se agregaron los datos para periodos no existentes.";
    String DATO_INDICADOR_ADD_REEMPLAZAR = "Se agregaron los datos para periodos no existentes y se actualizaron los existentes.";
    String DATO_INDICADOR_REEMPLAZAR = "El dato del indicador se actualizó de forma exitosa.";
    String DATO_INDICADOR_NUEVO = "El dato del indicador se guardó de forma exitosa.";


    /* MODELOS */
    String TEXTO_MENSAJE_EXISTE_MODELO = "Ya existe un modelo con el nombre ";
    String TEXTO_MENSAJE_NO_EXISTE_MODELO = "No existe modelo con id ";

    /* GENERALES */
    String ELEMENTO_ASOCIADO_INDICADOR = "El elemento se encuentra asociado a un indicador.";
    String ELEMENTO_ASOCIADO_MODELO = "El elemento se encuentra asociado a un modelo.";
    String ELEMENTO_ASOCIADO_GENERAL = "No se puede realizar la operación porque se encuentra asociado a otro elemento.";
    String CAMBIO_ESTADO_OK = "Se realizó el cambio de estado correctamente.";
    String ERROR_UNICO_TIPO_CAMBIO_ESTADO = "No coinciden los tipos de estado en los registros enviados.";
    String ERROR_NUEVO_CAMBIO_ESTADO = "El nuevo estado no es permitido para el estado actual.";
    String ERROR_CAMBIO_ESTADO = "Ocurrió un error en el cambio de estado.";
    String ERROR_GLOBAL_CAMBIO_ESTADO = "Ocurrió un error general en la ejecución del cambio de estado. Por favor intente nuevamente.";
    String PERIODO_INICIAL_NO_VALIDO = "El periodo inicial no es un periodo válido.";
    String PERIODO_FINAL_NO_VALIDO = "El periodo final no es un periodo válido.";
    String PERIODOS_NO_VALIDO = "El periodo inicial es mayor al periodo final.";
}
