package uas.pe.edu.pucp.newuas.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by Marshall on 10/11/2016.
 */

@DatabaseTable(tableName = "actionfile")
public class ActionFile implements Serializable {
    @SerializedName("IdArchivoEntrada")
    @Expose
    @DatabaseField(id=true)
    private Integer idArchivoEntrada;
    @SerializedName("filename")
    @Expose
    @DatabaseField
    private String filename;
    @SerializedName("mime")
    @Expose
    @DatabaseField
    private String mime;
    @SerializedName("original_filename")
    @Expose
    @DatabaseField
    private String originalFilename;
    @SerializedName("deleted_at")
    @Expose
    private Object deletedAt;
    @SerializedName("created_at")
    @Expose
    @DatabaseField
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    @DatabaseField
    private String updatedAt;

    /**
     * No args constructor for use in serialization
     *
     */
    public ActionFile() {
    }

    /**
     *
     * @param updatedAt
     * @param idArchivoEntrada
     * @param createdAt
     * @param deletedAt
     * @param filename
     * @param originalFilename
     * @param mime
     */
    public ActionFile(Integer idArchivoEntrada, String filename, String mime, String originalFilename, Object deletedAt, String createdAt, String updatedAt) {
        this.idArchivoEntrada = idArchivoEntrada;
        this.filename = filename;
        this.mime = mime;
        this.originalFilename = originalFilename;
        this.deletedAt = deletedAt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    /**
     *
     * @return
     * The idArchivoEntrada
     */
    public Integer getIdArchivoEntrada() {
        return idArchivoEntrada;
    }

    /**
     *
     * @param idArchivoEntrada
     * The IdArchivoEntrada
     */
    public void setIdArchivoEntrada(Integer idArchivoEntrada) {
        this.idArchivoEntrada = idArchivoEntrada;
    }

    /**
     *
     * @return
     * The filename
     */
    public String getFilename() {
        return filename;
    }

    /**
     *
     * @param filename
     * The filename
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     *
     * @return
     * The mime
     */
    public String getMime() {
        return mime;
    }

    /**
     *
     * @param mime
     * The mime
     */
    public void setMime(String mime) {
        this.mime = mime;
    }

    /**
     *
     * @return
     * The originalFilename
     */
    public String getOriginalFilename() {
        return originalFilename;
    }

    /**
     *
     * @param originalFilename
     * The original_filename
     */
    public void setOriginalFilename(String originalFilename) {
        this.originalFilename = originalFilename;
    }

    /**
     *
     * @return
     * The deletedAt
     */
    public Object getDeletedAt() {
        return deletedAt;
    }

    /**
     *
     * @param deletedAt
     * The deleted_at
     */
    public void setDeletedAt(Object deletedAt) {
        this.deletedAt = deletedAt;
    }

    /**
     *
     * @return
     * The createdAt
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     *
     * @param createdAt
     * The created_at
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     *
     * @return
     * The updatedAt
     */
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     *
     * @param updatedAt
     * The updated_at
     */
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
