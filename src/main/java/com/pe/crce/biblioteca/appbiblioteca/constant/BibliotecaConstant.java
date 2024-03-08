package com.pe.crce.biblioteca.appbiblioteca.constant;

public final class BibliotecaConstant {
    // CLIENT ERRORS
    public static final String BAD_REQUEST = "400";
    public static final String UNAUTHORIZED = "401";
    public static final String FORBIDDEN = "403";
    public static final String NOT_FOUND = "404";
    public static final String METHOD_NOT_ALLOWED = "405";
    public static final String NOT_ACCEPTABLE = "406";
    public static final String CONFLICT = "409";
    public static final String UNPROCESSABLE_ENTITY = "422";
    public static final String EXPECTATION_FAILED = "417";
    public static final Float NR_VUELTO_DEFAULT = (float) 0;

    // SERVER ERRORS
    public static final String INTERNAL_SERVER_ERROR = "500";
    public static final String NOT_IMPLEMENTED = "501";
    public static final String BAD_GATEWAY = "503";
    public static final String SERVICE_UNAVAILABLE = "504";
    public static final String GATEWAY_TIMEOUT = "505";
    public static final String NOT_VALIDATED = "506";

    // ERRORS
    public static final String PREFIX_SERVER_ERROR = "SRV";
    public static final String PREFIX_CLIENT_ERROR = "CLI";
    // STATE
    public static final String STATE_ACTIVE = "1";
    public static final String STATE_DESABLE = "0";
    // API VERSION
    public static final String API_VERSION = "/V1";

    // PATH DEL SISTEMA
    public static final String RESOURCE_GENERIC = API_VERSION + "/app-biblioteca";
    public static final String RESOUCER_EDITORIALS = "/editorials";
    public static final String RESOURCE_EDITORIALS_EDITORIAL = "/editorial";
    public static final String RESOUCER_AUTHORS = "/authors";
    public static final String RESOUCER_AUTHORS_AUTHOR = "/author";
    public static final String RESOURCE_GENERID_ID = "/{id}";
    public static final String CLIENT_FRONTEND = "*";
    public static final String RESOURCE_AREAS = "/areas";
    public static final String RESOURCE_AREAS_AREA = "/area";
    public static final String RESOURCE_SUBAREAS = "/sub-areas";
    public static final String RESOURCE_SUBAREAS_SUBAREA = "/sub-area";
    public static final String RESOURCE_BOOKS = "/books";
    public static final String RESOURCE_BOOKS_BOOK = "/book";
    public static final String RESOURCE_EXPORT_EXCEL = "/export-excel";

    // NOMBRES DE TABLAS
    public static final String TAB_NAME_AUTHOR = "t_author";
    public static final String TAB_NAME_EDITORIAL = "t_editorial";
    public static final String TAB_NAME_LIBRARY = "t_library";
    public static final String TAB_NAME_AREA = "t_area";
    public static final String TAB_NAME_SUB_AREA = "t_sub_area";
    public static final String TAB_NAME_ZONA = "t_zone";
    public static final String TAB_NAME_BOOK_AUTHOR = "t_book_author";
    public static final String TAB_NAME_SPECIMEN_STATE = "t_specimen_state";
    public static final String TAB_NAME_SPECIMEN = "t_specimen";
    public static final String TAB_NAME_BOOK = "t_book";

    // ESQUEMA
    public static final String SEC_NAME_DBO = "dbo";

    // FUNCIONES
    public static final String FN_SEARCH_AUTHOR = "SELECT * FROM dbo.fn_search_author(?1,?2)";
    public static final String FN_SAVE_AUTHOR = "SELECT * FROM dbo.fn_save_author(?1,?2)";

    /** FORMATO_ARCHIVOS */
    public static final String FORMATO_EXCEL = ".xlsx";
    public static final String FORMATO_PDF = ".pdf";

    /** ERROR_REPORTE */
    public static final String ERROR_REPORTE = "Ocurrió un error al generar el reporte";

    /** FORMATO_ARCHIVOS */
    public static final String SHEET_AREA = "Lista-Area";
    public static final String SHEET_BOOK = "Lista-Book";

    public static final String VC_EMTY = "-";

    public static final String REPORT_NAME_AREA_PAGINABLE = "report-area";
    public static final String REPORT_NAME_BOOK_PAGINABLE = "report-book";

}
